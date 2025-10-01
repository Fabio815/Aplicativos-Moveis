package br.com.ifsc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FramentoB extends Fragment {
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frament_framento_b, container, false);
        TextView textView = v.findViewById(R.id.resultado);

        float valorEmF = getArguments().getFloat("valorEmF");
        textView.setText(String.valueOf(valorEmF));

        return v;
    }
}
