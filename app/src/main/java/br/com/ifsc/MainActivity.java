package br.com.ifsc;

import android.content.Intent;
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
    EditText altura;
    EditText peso;
    TextView resultado;
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altura = altura.findViewById(R.id.valorAltura);
        peso = peso.findViewById(R.id.valorPeso);
        resultado = resultado.findViewById(R.id.resultado);
        btnCalcular = btnCalcular.findViewById(R.id.calcular);

        btnCalcular.setOnClickListener(v -> {
                Intent intent = new Intent(this, SegundActivity.class);
                Float p = Float.parseFloat(peso.getText().toString());
                Float a = Float.parseFloat(altura.getText().toString());
                intent.putExtra("peso", p);
                intent.putExtra("altura", a);
                startActivity(intent);
        });
    }
}
