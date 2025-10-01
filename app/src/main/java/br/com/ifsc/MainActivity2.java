package br.com.ifsc;

import android.media.Image;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        nome = findViewById(R.id.nome);
        imcCalculado = findViewById(R.id.imcCalculado);
        img = findViewById(R.id.imagem);

        Bundle bundle = getIntent().getExtras();

        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");
        String nomeTexto = bundle.getString("nome");

        double imc = peso / Math.pow(altura, 2);

        nome.setText("IMC: " + String.valueOf(imc));
        /*btnVoltar.findViewById(R.id.voltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });*/
    }
}