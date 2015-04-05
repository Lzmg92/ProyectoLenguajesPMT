package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;


public class DatosGenerales extends Activity {

    ListView Lista;
    LinkedList datos = new LinkedList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_generales);

        Lista = (ListView)findViewById(R.id.listdatosgenerales);

        TextView user = (TextView)findViewById(R.id.lblplaca);
        final String temp = getIntent().getExtras().getString("m");
        user.setText(temp);

        Analizador an = new Analizador();

     /*   for(int i=0; i< an.ListaDatosGenerales.size();i++){
             if(an.ListaDatosGenerales.get(i).getPlaca().toLowerCase().equals(temp.toLowerCase()) ){
        datos.add("Dueño: " + an.ListaDatosGenerales.get(i).getDueño());
        datos.add("Dirección: " + an.ListaDatosGenerales.get(i).getDireccion());
        datos.add("Departamento: " + an.ListaDatosGenerales.get(i).getDepartamento());
        datos.add("Municipalidad: " + an.ListaDatosGenerales.get(i).getMunicipalidad());
        datos.add("Nit: " + an.ListaDatosGenerales.get(i).getNit());
        datos.add("Poliza: " + an.ListaDatosGenerales.get(i).getPoliza());
        datos.add("Modelo: " + an.ListaDatosGenerales.get(i).getModelo());
        datos.add("Marca: " + an.ListaDatosGenerales.get(i).getMarca());
        datos.add("Motor: " + an.ListaDatosGenerales.get(i).getMotor());
        datos.add("Color: " + an.ListaDatosGenerales.get(i).getColor());
        datos.add("Chasis: " + an.ListaDatosGenerales.get(i).getChasis());
        datos.add("Linea: " + an.ListaDatosGenerales.get(i).getLinea());
        datos.add("Tipo: " + an.ListaDatosGenerales.get(i).getTipo());
        datos.add("Uso: " + an.ListaDatosGenerales.get(i).getUso());
        datos.add("Asientos: " + an.ListaDatosGenerales.get(i).getAsientos());
              }
          } */

        datos.add("Dueño: " + an.ListaDatosGenerales.get(0).getDueño());
        datos.add("Dirección: " + an.ListaDatosGenerales.get(0).getDireccion());
        datos.add("Departamento: " + an.ListaDatosGenerales.get(0).getDepartamento());
        datos.add("Municipalidad: " + an.ListaDatosGenerales.get(0).getMunicipalidad());
        datos.add("Nit: " + an.ListaDatosGenerales.get(0).getNit());
        datos.add("Poliza: " + an.ListaDatosGenerales.get(0).getPoliza());
        datos.add("Modelo: " + an.ListaDatosGenerales.get(0).getModelo());
        datos.add("Marca: " + an.ListaDatosGenerales.get(0).getMarca());
        datos.add("Motor: " + an.ListaDatosGenerales.get(0).getMotor());
        datos.add("Color: " + an.ListaDatosGenerales.get(0).getColor());
        datos.add("Chasis: " + an.ListaDatosGenerales.get(0).getChasis());
        datos.add("Linea: " + an.ListaDatosGenerales.get(0).getLinea());
        datos.add("Tipo: " + an.ListaDatosGenerales.get(0).getTipo());
        datos.add("Uso: " + an.ListaDatosGenerales.get(0).getUso());
        datos.add("Asientos: " + an.ListaDatosGenerales.get(0).getAsientos());


        ArrayAdapterDatosGenerales adap = new ArrayAdapterDatosGenerales(this, datos);
        Lista.setAdapter(adap);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.datos_generales, menu);
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
