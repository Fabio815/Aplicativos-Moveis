package br.com.ifsc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button btnA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.btnA);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        btnA.setOnClickListener(v -> {
            FramentoA fragmentA = new FramentoA();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentA).commit();
        });
    }
}