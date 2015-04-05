package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;


public class ArrayAdapterVerMultas extends ArrayAdapter {


    Activity context;
    LinkedList<DtsMultas> datos = new LinkedList();

    public ArrayAdapterVerMultas (Activity context, LinkedList datos){

        super(context, R.layout.activity_array_adapter_ver_multas, datos);
        this.datos = datos;
        this.context = context;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_array_adapter_ver_multas,null);



        TextView lblfecha = (TextView)item.findViewById(R.id.lblfecha);
        lblfecha.setText(datos.get(position).getFecha());
        TextView lblubicacion = (TextView)item.findViewById(R.id.lblubicacion);
        lblubicacion.setText(datos.get(position).getDireccion());
        TextView lblcantidad = (TextView)item.findViewById(R.id.lbldenunciante);
      //  lblcantidad.setText("Q.100.00");
        TextView lbltipo = (TextView)item.findViewById(R.id.lbltomadapor);
     //   lbltipo.setText("Exceso Velocidad");




        // lbldato.setText(datos.get(position));


        return item;
    }
}