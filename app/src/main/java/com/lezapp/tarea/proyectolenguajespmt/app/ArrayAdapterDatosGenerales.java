package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;


public class ArrayAdapterDatosGenerales extends ArrayAdapter {

    Activity context;
    LinkedList<String> datos = new LinkedList();

    public ArrayAdapterDatosGenerales(Activity context, LinkedList datos){

        super(context, R.layout.activity_array_adapter_datos_generales, datos);
        this.datos = datos;
        this.context = context;
    }


    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_array_adapter_datos_generales,null);



        TextView lbldato = (TextView)item.findViewById(R.id.lbldato);
        lbldato.setText(datos.get(position));


        return item;
    }
}
