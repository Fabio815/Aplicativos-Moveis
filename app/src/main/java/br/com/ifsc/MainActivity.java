package br.com.ifsc;

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

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    EditText editText;
    Button botao;
    ListView listView;

    ArrayList<String> notasList;
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
            carregarNotas();
        });
        carregarNotas();
    }

    public void carregarNotas() {
        //database.rawQuery("select * from notas where id=?", new String[]{"1"});
        notasList.clear();
        Cursor cursor = database.rawQuery("select * from notas", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int columnIndex = cursor.getColumnIndex("texto");
            String name = cursor.getString(columnIndex);
            notasList.add(name);
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, notasList);
        listView.setAdapter(adapter);
    }
}