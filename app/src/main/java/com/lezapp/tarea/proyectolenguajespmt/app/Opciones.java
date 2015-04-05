package com.lezapp.tarea.proyectolenguajespmt.app;

import android.app.Activity;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class Opciones extends Activity {

    Button btndatos;
    Button btnmultas;
    Button btndenuncias;
    Button btnpagospen;
    ImageView foto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        TextView user = (TextView)findViewById(R.id.lblplaca);
        final String temp = getIntent().getExtras().getString("Bienvenido");
        user.setText(temp);

        foto = (ImageView)findViewById(R.id.imgfoto);



        //////////////////////////////////////////////////////////////// Boton datos generales

        btndatos = (Button) findViewById(R.id.btndatos);
        btndatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Opciones.this, DatosGenerales.class);
                intent.putExtra("m", temp);
                startActivity(intent);
            }
        });


        //////////////////////////////////////////////////////////////// Boton denuncias

        btndenuncias = (Button) findViewById(R.id.btndenuncias);
        btndenuncias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Opciones.this, Denuncias.class);
                intent.putExtra("m", temp);
                startActivity(intent);
            }
        });


        //////////////////////////////////////////////////////////////// Boton pagos pendientes

        btnpagospen = (Button) findViewById(R.id.btnpagospen);
        btnpagospen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Opciones.this, PagosPendientes.class);
                intent.putExtra("m", temp);
                startActivity(intent);
            }
        });


        //////////////////////////////////////////////////////////////// Boton ver multas

        btnmultas = (Button) findViewById(R.id.btnmultas);
        btnmultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Opciones.this, VerMultas.class);
                intent.putExtra("m", temp);
                startActivity(intent);
            }
        });

    }


    public Boolean CambiarImagen(String Img, ImageView imagen)
    {
        Boolean Res = false;
        FileInputStream in;
        BufferedInputStream buf;
        try
        {
            in = new FileInputStream(Img);
            buf = new BufferedInputStream(in);
            Bitmap bMap = BitmapFactory.decodeStream(buf);
            imagen.setImageBitmap(bMap);
            if (in != null)
            {
                in.close();
                Res = true;
            }
            if (buf != null)
            {
                buf.close();
                Res = true;
            }
        }
        catch (Exception e)
        {
            Res = false;
        }
        return Res;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.opciones, menu);
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
