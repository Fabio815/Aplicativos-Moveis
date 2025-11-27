package br.com.ifsc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArrayAdapterNomes extends ArrayAdapter<Notas> {
    Context mcontext;
    int mResource;
    public ArrayAdapterNomes(@NonNull Context context, int resource, @NonNull List<Notas> objects) {
        super(context, resource, objects);
        mcontext=context;
        mResource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        super.getView(position, convertView, parent);
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        convertView =layoutInflater.inflate(mResource,parent,false);
        Notas n = getItem(position);
        TextView tv=convertView.findViewById(android.R.id.text1);
        tv.setText(n.nome);
        return convertView;
    }
}
