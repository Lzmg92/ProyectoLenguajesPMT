package com.lezapp.tarea.proyectolenguajespmt.app;

/**
 * Created by Leslie on 20/09/2014.
 */
public class DtsDenuncias {

    String placa, fecha,  denunciante, tomadapor, ubicacion;

    public DtsDenuncias(String placa, String fecha, String denunciante, String tomadapor, String ubicacion){

        this.placa = placa;
        this.fecha = fecha;
        this.denunciante = denunciante;
        this.tomadapor = tomadapor;
        this.ubicacion = ubicacion;
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

    public String getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(String denunciante) {
        this.denunciante = denunciante;
    }

    public String getTomadapor() {
        return tomadapor;
    }

    public void setTomadapor(String tomadapor) {
        this.tomadapor = tomadapor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}

