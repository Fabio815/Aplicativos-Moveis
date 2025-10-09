package br.com.ifsc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    Context myContext;
    int layoutResourceId;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        this.myContext = context;
        this.layoutResourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView ds = view.findViewById(R.id.textView);

        return view;
    }
}
