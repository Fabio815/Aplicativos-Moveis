package br.com.ifsc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundActivity extends AppCompatActivity {
    public Button btnVoltar;
    TextView resultado;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segund);

        Bundle bundle = getIntent().getExtras();

        btnVoltar = findViewById(R.id.voltar);
        resultado = findViewById(R.id.resultado);
        img = findViewById(R.id.img);

        btnVoltar.findViewById(R.id.voltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });
        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");

        double imc = peso / Math.pow(altura, 2);

        if (imc < 18.5) {
            resultado.setText("Abaixo do peso: " + Math.round(imc)));
            img.setImageResource(R.drawable.abaixopeso);
        } else if (imc >= 18.5 && imc <= 24.9) {
            resultado.setText("Peso ideal: " + Math.round(imc));
            img.setImageResource(R.drawable.normal);
        } else if (imc > 24.9 && imc <= 29.9) {
            resultado.setText("Sobrepeso: " + Math.round(imc));
            img.setImageResource(R.drawable.sobrepeso);
        } else if (imc > 30 && imc <= 34.9) {
            resultado.setText("Obesidade 1: " + Math.round(imc));
            img.setImageResource(R.drawable.obesidade1);
        } else if (imc > 35 && imc <= 35) {
            resultado.setText("Obesidade 2: " + Math.round(imc));
            img.setImageResource(R.drawable.obesidade2);
        } else {
            resultado.setText("Obesidade 3: " + Math.round(imc));
            img.setImageResource(R.drawable.obesidade3);
        }
    }
}