package br.com.ifsc;

import static java.util.Objects.isNull;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    EditText editText;
    Button botao;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText  = findViewById(R.id.nome);
        botao = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        database = openOrCreateDatabase("app_database", MODE_PRIVATE, null);

        database.execSQL("create table if not exists notas (id integer primary key autoincrement, name varchar, texto varchar)");
        botao.setOnClickListener( v -> {
            String texto = editText.getText().toString();
            if (!texto.isEmpty()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name",  texto);
                contentValues.put("texto", texto);
                database.insert("notas", null, contentValues);
            }
            listarNotas();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Notas n = (Notas) parent.getItemAtPosition(position);
            System.out.println(n.id);
            deletarNotas(n.id);
            return true;
        });

        listarNotas();
    }

    public void listarNotas() {
        //database.rawQuery("select * from notas where id=?", new String[]{"1"});
        //notasList.clear();
        List<Notas> notasList = null;
        Cursor cursor = database.rawQuery("select * from notas", null);
        cursor.moveToFirst();
        if (!isNull(cursor)) {
            notasList = new ArrayList<>();

            while (!cursor.isAfterLast()) {
                int columnIndexId = cursor.getColumnIndex("id");
                int columnIndexName = cursor.getColumnIndex("name");
                int columnIndexText = cursor.getColumnIndex("texto");
                Notas n =new Notas(cursor.getInt(columnIndexId),cursor.getString(columnIndexName),cursor.getString(columnIndexText));
                notasList.add(n);
                cursor.moveToNext();
            }
        }
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notasList);
        ArrayAdapterNomes arrayAdapterNomes= new ArrayAdapterNomes(this, android.R.layout.simple_list_item_1,notasList);
        listView.setAdapter(arrayAdapterNomes);
        cursor.close();
    }

    public void deletarNotas(long idNome) {
        if (idNome > 0) {
            int dr = database.delete("notas", " id = ?", new String[]{ String.valueOf(idNome) });
        }
    }
}