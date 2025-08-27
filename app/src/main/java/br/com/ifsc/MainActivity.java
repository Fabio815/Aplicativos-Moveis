package br.com.ifsc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText altura = findViewById(R.id.altura);
        EditText peso = findViewById(R.id.peso);
        Button botao = findViewById(R.id.botao);
        TextView resultado = findViewById(R.id.resultado);

        botao.setOnClickListener(v -> {
            double al = Double.parseDouble(altura.getText().toString());
            double pe = Double.parseDouble(peso.getText().toString());

            double imc = pe / Math.pow(al, 2);

            if (imc < 18.5) {
                resultado.setText("Abaixo do peso");
            } else if (imc >= 18.5 && imc <= 24.9) {
                resultado.setText("Peso ideal");
            } else if (imc > 24.9 && imc <= 29.9) {
                resultado.setText("Sobrepeso");
            } else {
                resultado.setText("Obesidade");
            }
        });
    }
}