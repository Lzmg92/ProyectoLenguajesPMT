package com.lezapp.tarea.proyectolenguajespmt.app;

/**
 * Created by Leslie on 20/09/2014.
 */
public class DtsMultas {
    String placa, fecha, direccion, tipo, cantidad, foto;
    public DtsMultas(String placa, String fecha, String direccion, String tipo, String cantidad, String foto){

        this.placa = placa;
        this.fecha = fecha;
        this.direccion = direccion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

