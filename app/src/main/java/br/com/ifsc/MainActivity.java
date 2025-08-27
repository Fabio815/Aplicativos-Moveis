package br.com.ifsc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText altura = findViewById(R.id.valorAltura);
        EditText peso = findViewById(R.id.valorPeso);
        TextView resultado = findViewById(R.id.resultado);
        Button btnCalcular = findViewById(R.id.calcular);

        btnCalcular.setOnClickListener(v -> {
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
