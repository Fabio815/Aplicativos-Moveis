package br.com.ifsc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FramentoA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FramentoA extends Fragment {
    EditText temperaturaC;
    Button btnCalcular;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public FramentoA() {
        // Required empty public constructor
    }
    public static FramentoA newInstance(String param1, String param2) {
        FramentoA fragment = new FramentoA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_framento_a, container, false);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        temperaturaC = view.findViewById(R.id.numC);

        btnCalcular.setOnClickListener(v -> {
            float tempC = Float.parseFloat(temperaturaC.getText().toString());
            float resultado = (tempC * 1.8f) + 32;
            FramentoB fragmentB = new FramentoB();
            Bundle bundle = new Bundle();
            bundle.putFloat("valorEmF", resultado);
            fragmentB.setArguments(bundle);
            getParentFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentB).commit();
        });

        return view;
    }
}