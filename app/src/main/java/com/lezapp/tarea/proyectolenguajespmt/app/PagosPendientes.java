package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;


public class PagosPendientes extends Activity {

    Button btnpagos;
    TextView total;
    ListView lista;
    LinkedList<DtsPagosPendientes> datos = new LinkedList<DtsPagosPendientes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos_pendientes);

        TextView user = (TextView)findViewById(R.id.lblplaca);
        final String temp = getIntent().getExtras().getString("m");
        user.setText(temp);



        btnpagos = (Button) findViewById(R.id.btnpagos);
        btnpagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PagosPendientes.this, RealizarPagos.class);
                intent.putExtra("m", temp);
                startActivity(intent);
            }
        });

        Analizador an = new Analizador();


        total = (TextView)findViewById(R.id.lbltotal);
        total.setText(an.ListaPagosPendientes.get(0).getValor());
        lista = (ListView)findViewById(R.id.listView);

        datos.add(an.ListaPagosPendientes.get(0));

        ArrayAdapterPagosPendientes adap = new ArrayAdapterPagosPendientes(this, datos);
        lista.setAdapter(adap);





    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pagos_pendientes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
