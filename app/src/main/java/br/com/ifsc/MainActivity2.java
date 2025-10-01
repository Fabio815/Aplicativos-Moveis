package br.com.ifsc;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        btnVoltar = findViewById(R.id.voltar);
        resultado = findViewById(R.id.resultado);
        img = findViewById(R.id.img);

        btnVoltar.findViewById(R.id.voltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });
    }
}