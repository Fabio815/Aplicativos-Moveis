package br.com.ifsc;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    Context myContext;
    int layoutResourceId;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        this.myContext = context;
    }
}
