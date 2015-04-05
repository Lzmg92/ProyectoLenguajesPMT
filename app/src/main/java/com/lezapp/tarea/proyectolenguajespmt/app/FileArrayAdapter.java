package com.lezapp.tarea.proyectolenguajespmt.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Leslie on 20/09/2014.
 */
public class FileArrayAdapter extends ArrayAdapter<Opcion> {

    private Context c;
    private int id;
    private List<Opcion> items;

    public FileArrayAdapter(Context context, int textViewResourceId, List<Opcion> objects){

        super(context, textViewResourceId, objects);
        c = context;
        id = textViewResourceId;
        items = objects;
    }




    public  Opcion getItem(int i){
        return items.get(i);
    }

    public View getView (int position, View convertView, ViewGroup parent){
        View v = convertView;
        if (v == null){
            LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(id, null);
        }

        final Opcion o = items.get(position);

        if (o != null){
            TextView carpetas = (TextView) v.findViewById(R.id.carpetas);
            TextView archivos = (TextView) v.findViewById(R.id.archivos);

            if(carpetas != null)
                carpetas.setText(o.getNombre());
            if(archivos != null)
                archivos.setText(o.getData());
        }
        return v;
    }
}
