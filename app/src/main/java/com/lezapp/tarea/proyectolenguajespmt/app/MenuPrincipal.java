package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MenuPrincipal extends Activity {

    TextView titulo;
    EditText txtplaca;
    Button btnok;
    Button btnconfirmararchivo;
    Button btnbuscararchivo;
    TextView direccion;
    String paraana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        titulo = (TextView)findViewById(R.id.titulo);
        txtplaca = (EditText)findViewById(R.id.txtplaca);
        direccion = (TextView)findViewById(R.id.lbldireccion);

        btnok = (Button) findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Opciones o = new Opciones();
                o.CambiarImagen("foto8.jpg", o.foto);

                Intent intent = new Intent(MenuPrincipal.this, Opciones.class);
                intent.putExtra("Bienvenido", txtplaca.getText().toString());
                startActivity(intent);

            }
        });

        btnconfirmararchivo = (Button) findViewById(R.id.btncargararchivo);
        btnconfirmararchivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paraana = getIntent().getExtras().getString("filec");

                Analizador a = new Analizador();
                a.Analizadorlex(paraana);

                Intent intent = new Intent(MenuPrincipal.this, ResultadoCarga.class);

                intent.putExtra("m", a.resultado);
                startActivity(intent);




            }
        });


        btnbuscararchivo = (Button) findViewById(R.id.btnbuscararchivo);
        btnbuscararchivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuPrincipal.this, FileChooser.class);
                startActivity(intent);

            }
        });




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
