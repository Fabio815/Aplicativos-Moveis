package br.com.ifsc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundActivity extends AppCompatActivity {
    private Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segund);

        btnVoltar.findViewById(R.id.voltar);

        btnVoltar.setOnClickListener(t -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}