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
    TextView tvResutlado;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segund);

        btnVoltar.findViewById(R.id.voltar);
        tvResutlado.findViewById(R.id.resultado);
        img.findViewById(R.id.imageView);

        btnVoltar.findViewById(R.id.voltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        Bundle bundle = getIntent().getExtras();
        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");

        double imc = peso / Math.pow(altura, 2);

        if (imc < 18.5) {
            tvResutlado.setText("Abaixo do peso");
            img.setImageResource(R.drawable.abaixopeso);
        } else if (imc >= 18.5 && imc <= 24.9) {
            tvResutlado.setText("Peso ideal");
            img.setImageResource(R.drawable.normal);
        } else if (imc > 24.9 && imc <= 29.9) {
            tvResutlado.setText("Sobrepeso");
            img.setImageResource(R.drawable.sobrepeso);
        } else {
            tvResutlado.setText("Obesidade");
            img.setImageResource(R.drawable.obesidade1);
        }
    }
}