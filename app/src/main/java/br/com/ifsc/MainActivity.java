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
    Button btnA, btnB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FrameLayout frameLayout;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        btnA.setOnClickListener(v -> {
            FramentoA fragmentA = new FramentoA();

            fragmentTransaction.replace(R.id.frameLayout, fragmentA);
            fragmentTransaction.commit();
        });

        btnB.setOnClickListener(v -> {
            FramentoB framentoB = new FramentoB();
            Bundle bundle = new Bundle();
            bundle.putString("msg", "Olá");
            framentoB.setArguments(bundle);
            fragmentTransaction.replace(R.id.frameLayout, framentoB);
            fragmentTransaction.commit();
        });
        frameLayout=findViewById(R.id.frameLayout);
    }
}