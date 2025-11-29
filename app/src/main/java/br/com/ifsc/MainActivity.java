package br.com.ifsc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView contadorTextView;
    private Button cliqueBotao;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contadorTextView = findViewById(R.id.contadorTextView);
        cliqueBotao = findViewById(R.id.cliqueBotao);

        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("contador");
            atualizarContador();
        }

        cliqueBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                atualizarContador();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("contador", contador);
        super.onSaveInstanceState(outState);
    }

    private void atualizarContador() {
        contadorTextView.setText(String.valueOf(contador));
    }
}
