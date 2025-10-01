package br.com.ifsc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText altura;
    EditText peso;
    EditText nome;
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);
        btnCalcular = findViewById(R.id.btnCalcular);
        nome = findViewById(R.id.nome);

        btnCalcular.setOnClickListener(v -> {
            Intent intent = new Intent(this, SegundActivity.class);
            Float p = Float.parseFloat(peso.getText().toString());
            Float a = Float.parseFloat(altura.getText().toString());
            intent.putExtra("peso", p);
            intent.putExtra("altura", a);
            intent.putExtra("nome", nome);
            startActivity(intent);
        });
    }
}