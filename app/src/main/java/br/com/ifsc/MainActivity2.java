package br.com.ifsc;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView nome;
    TextView imcCalculado;
    ImageView img;
    Button btnVoltar;
    TextView ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        nome = findViewById(R.id.nome);
        imcCalculado = findViewById(R.id.imcCalculado);
        img = findViewById(R.id.imagem);
        btnVoltar = findViewById(R.id.voltar);
        ds = findViewById(R.id.ds);

        Bundle bundle = getIntent().getExtras();

        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");
        String nomeTexto = bundle.getString("nome");

        double imc = peso / Math.pow(altura, 2);
        nome.setText("Nome: " + nomeTexto);
        /*imcCalculado.setText("IMC: " + String.valueOf(Math.round(imc)));*/

        if (imc < 18.5) {
            imcCalculado.setText("Abaixo do peso: " + Math.round(imc));
            img.setImageResource(R.drawable.abaixopeso);
        } else if (imc >= 18.5 && imc <= 24.9) {
            imcCalculado.setText("Peso ideal: " + Math.round(imc));
            img.setImageResource(R.drawable.normal);
        } else if (imc > 24.9 && imc <= 29.9) {
            imcCalculado.setText("Sobrepeso: " + Math.round(imc));
            img.setImageResource(R.drawable.sobrepeso);
        } else if (imc > 30 && imc <= 34.9) {
            imcCalculado.setText("Obesidade 1: " + Math.round(imc));
            img.setImageResource(R.drawable.obesidade1);
        } else if (imc > 35 && imc <= 35) {
            imcCalculado.setText("Obesidade 2: " + Math.round(imc));
            img.setImageResource(R.drawable.obesidade2);
        } else {
            imcCalculado.setText("Obesidade 3: " + Math.round(imc));
            img.setImageResource(R.drawable.obesidade3);
        }

        double result;
        if (imc < 20) {
            result = imc / Math.pow(altura, 2) * (20 - imc);
            ds.setText("Precisa ganhar kg: " + Math.floor(result));
        } else if (imc > 25) {
            result = imc / altura;
            ds.setText("Precisa ganhar perder kg: " + Math.floor(result));
        }

        btnVoltar.findViewById(R.id.voltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });
    }
}