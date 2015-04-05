package com.lezapp.tarea.proyectolenguajespmt.app;

/**
 * Created by Leslie on 20/09/2014.
 */
public class Opcion implements Comparable <Opcion> {

    private String nombre;
    private String data;
    private String path;

    public Opcion(String n, String d, String p){

        nombre = n;
        data = d;
        path = p;
    }

    public String getNombre(){
        return nombre;
    }

    public String getData(){
        return data;
    }

    public String getPath(){
        return path;
    }


    public int compareTo(Opcion o) {
        if(this.nombre != null)
            return this.nombre.toLowerCase().compareTo(o.getNombre().toLowerCase());
        else
            throw  new IllegalArgumentException();
    }
}

