package com.lezapp.tarea.proyectolenguajespmt.app;

/**
 * Created by Leslie on 20/09/2014.
 */
public class DtsPagosPendientes {

    String placa, fecha, valor;

    public DtsPagosPendientes(String placa, String fecha, String valor){

        this.placa = placa;
        this.fecha = fecha;
        this.valor = valor;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}