package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;


public class ArrayAdapterPagosPendientes extends ArrayAdapter {

    Activity context;

    LinkedList<DtsPagosPendientes> datos = new LinkedList();

    public ArrayAdapterPagosPendientes (Activity context, LinkedList datos){

        super(context, R.layout.activity_array_adapter_pagos_pendientes, datos);
        this.datos = datos;
        this.context = context;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_array_adapter_pagos_pendientes,null);



        TextView lblfecha = (TextView)item.findViewById(R.id.lblfecha);
        lblfecha.setText(datos.get(position).getFecha());
        TextView lblvalor = (TextView)item.findViewById(R.id.lblvalor);
        lblvalor.setText(datos.get(position).getValor());




        // lbldato.setText(datos.get(position));


        return item;
    }


}