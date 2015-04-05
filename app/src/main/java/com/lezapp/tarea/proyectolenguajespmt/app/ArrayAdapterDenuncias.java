package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;


public class ArrayAdapterDenuncias extends ArrayAdapter {

    Activity context;
    LinkedList<String> datos = new LinkedList();

    public ArrayAdapterDenuncias (Activity context, LinkedList datos){

        super(context, R.layout.activity_array_adapter_denuncias, datos);
        this.datos = datos;
        this.context = context;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_array_adapter_denuncias,null);



        TextView lblfecha = (TextView)item.findViewById(R.id.lblfecha);
        TextView lblubicacion = (TextView)item.findViewById(R.id.lblubicacion);
        TextView lbldenunciante = (TextView)item.findViewById(R.id.lbldenunciante);
        TextView lbltomadapor = (TextView)item.findViewById(R.id.lbltomadapor);



        // lbldato.setText(datos.get(position));


        return item;
    }
}
