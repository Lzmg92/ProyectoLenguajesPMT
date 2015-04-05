package com.lezapp.tarea.proyectolenguajespmt.app;

/**
 * Created by Leslie on 20/09/2014.
 */
public class DtsDatosGenerales {
    String placa, nit, poliza, modelo, uso, tipo, chasis, linea, marca, color, asientos, motor, dueño, direccion, municipalidad, departamento;

    public DtsDatosGenerales(String placa, String nit, String poliza, String modelo, String uso, String tipo, String chasis, String linea, String marca, String color, String asientos, String motor, String dueño, String direccion, String municipalidad, String departamento){
        this.placa = placa;
        this.nit = nit;
        this.poliza = poliza;
        this.modelo = modelo;
        this.uso = uso;
        this.tipo = tipo;
        this.chasis = chasis;
        this.linea = linea;
        this.marca = marca;
        this.color = color;
        this.asientos = asientos;
        this.motor = motor;
        this.dueño = dueño;
        this.direccion = direccion;
        this.municipalidad = municipalidad;
        this.departamento = departamento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAsientos() {
        return asientos;
    }

    public void setAsientos(String asientos) {
        this.asientos = asientos;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipalidad() {
        return municipalidad;
    }

    public void setMunicipalidad(String municipalidad) {
        this.municipalidad = municipalidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
