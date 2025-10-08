package br.com.ifsc;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<String> nomes;
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomes = new ArrayList<>();
        nomes.add("Rodolfo");
        nomes.add("Pedro");
        nomes.add("Maykon");
        nomes.add("Micael");


        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, nomes
        );
        //Definir um tratamento de click sobre o item da lista.
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(
                    getApplicationContext(),
                    "Item: " + nomes.get(position),
                    Toast.LENGTH_SHORT).show();
        });
        //Excluir se ficar muito tempo pressionado.


        btn.setOnClickListener(e -> {
            nomes.add(String.valueOf(editText.getText()));
            adapter.notifyDataSetChanged();
        });


        listView.setAdapter(adapter);
    }

}