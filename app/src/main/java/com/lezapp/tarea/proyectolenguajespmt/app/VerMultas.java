package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;


public class VerMultas extends Activity {


    ListView lista;

    LinkedList <DtsMultas> datos = new LinkedList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_multas);

        TextView user = (TextView)findViewById(R.id.lblplaca);
        final String temp = getIntent().getExtras().getString("m");
        user.setText(temp);

        Analizador an = new Analizador();


        lista = (ListView)findViewById(R.id.listView);

        datos.add(an.ListaMultas.get(0));

        ArrayAdapterVerMultas adap = new ArrayAdapterVerMultas(this, datos);
        lista.setAdapter(adap);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ver_multas, menu);
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
