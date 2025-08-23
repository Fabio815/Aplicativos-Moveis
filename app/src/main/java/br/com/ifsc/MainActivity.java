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

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView num1 = findViewById(R.id.intervalo1);
        TextView num2 = findViewById(R.id.intervalo2);
        Button btnGerar = findViewById(R.id.btnGerar);
        TextView resultado = findViewById(R.id.resultado);

        btnGerar.setOnClickListener(valor -> {
            int min = Integer.parseInt(num1.getText().toString());
            int max = Integer.parseInt(num2.getText().toString());

            int numAleatorio = numeroAletario(min, max);
            resultado.setText("Numero: " + numAleatorio);
        });
    }

    private static int numeroAletario(int inicio, int fim){
        Random random = new Random();
        return random.nextInt((fim - inicio) + 1) + inicio;
    }
}