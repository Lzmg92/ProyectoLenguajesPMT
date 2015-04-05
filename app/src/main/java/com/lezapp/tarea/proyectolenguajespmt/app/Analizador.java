package com.lezapp.tarea.proyectolenguajespmt.app;

import java.util.LinkedList;

/**
 * Created by Leslie on 20/09/2014.
 */
public class Analizador {

    public static LinkedList<DtsDatosGenerales> ListaDatosGenerales = new LinkedList<DtsDatosGenerales>();
    public static LinkedList<DtsDenuncias> ListaDenuncias = new LinkedList<DtsDenuncias>();
    public static LinkedList<DtsMultas> ListaMultas = new LinkedList<DtsMultas>();
    public static LinkedList<DtsPagosPendientes> ListaPagosPendientes = new LinkedList<DtsPagosPendientes>();


    String d = "dato";


    public static  LinkedList<TablaTokens> tab = new LinkedList();
    String resultado = "";

    public Analizador() {


    }

    public void Analizadorlex(String cad) {

        char[] arreglo = cad.toCharArray();


        String tempest1 = "";

        String tempest3 = "";


        int estadoactual = 0;


        int i = 0;

        while (i < arreglo.length) {

            if (estadoactual == 0) {

                if (arreglo[i] == '<') {
                    estadoactual = 11;
                    tempest1 = "<";
                    i++;
                }  else if (Character.isLetter(arreglo[i]) || Character.isDigit(arreglo[i])) {
                    estadoactual = 13;
                    tempest3 = Character.toString(arreglo[i]);
                    i++;
                } else {
                    estadoactual = 14;
                    tempest1 = Character.toString(arreglo[i]);
                    i++;
                }
            } else if (estadoactual == 14) {
                TablaTokens nuevo = new TablaTokens(tempest1, "NoPertenece");
                tab.add(nuevo);
                resultado = resultado + "\n" + tempest1 + "= No_pertenece";
                tempest1 = "";
                estadoactual = 0;
            }
            //////////////////////////////////////////////////////////////////////////////////////////////
            else if (estadoactual == 11) {
                if (Character.isLetter(arreglo[i]) || arreglo[i] == '/') {
                    estadoactual = 11;
                    tempest1 = tempest1 + Character.toString(arreglo[i]);
                    i++;
                } else if (arreglo[i] == '>') {
                    estadoactual = 21;
                    tempest1 = tempest1 + Character.toString(arreglo[i]);
                    i++;
                } else {

                    estadoactual = -21;
                    ;
                }
            } else if (estadoactual == -21) {

                if (arreglo[i] != '>') {
                    estadoactual = -21;
                    tempest1 = tempest1 + Character.toString(arreglo[i]);

                    i++;
                } else {
                    TablaTokens nuevo2 = new TablaTokens(tempest1, "NoPertenece");
                    tab.add(nuevo2);
                    tempest1 = tempest1 + Character.toString(arreglo[i]);
                    resultado = resultado + "\n" + tempest1 + "= NoPertenece";
                    tempest1 = "";
                    estadoactual = 0;
                    i++;
                }
            } else if (estadoactual == 21) {

                if (tempest1.startsWith("</")) {
                    TablaTokens nuevo3 = new TablaTokens(tempest1, "Cerrar");
                    tab.add(nuevo3);
                    resultado = resultado + "\n" + tempest1 + "= Cerrar";

                } else if (tempest1.startsWith("<")) {
                    TablaTokens nuevo4 = new TablaTokens(tempest1, "Abrir");
                    tab.add(nuevo4);
                    resultado = resultado + "\n" + tempest1 + "= Abrir";

                }

                estadoactual = 0;
                tempest1 = "";
            }  else if (estadoactual == 13) {

                if (Character.isLetter(arreglo[i]) || arreglo[i] == ' ' || Character.isDigit(arreglo[i]) || arreglo[i] == '.' || arreglo[i] == '-'|| arreglo[i] == '/'|| arreglo[i] == ':') {
                    estadoactual = 13;
                    tempest3 = tempest3 + Character.toString(arreglo[i]);
                    i++;
                } else {
                    estadoactual = 23;

                }
            } else if (estadoactual == 23) {

                TablaTokens nuevo6 = new TablaTokens(tempest3, "Palabra");
                tab.add(nuevo6);

                resultado = resultado + "\n" + tempest3 + "= Palabra";

                /////////////////////////////////////////////// condiciones palabra

                estadoactual = 0;
                tempest3 = "";
            }
        }

        LlenarListas();
    }
    ///////////////////// termina while




    public void LlenarListas() {

        int ta = tab.size();



        int i = 0;
        int estadoactual = 0;
        String datos = "<Datos>";
        String temp;


        String placa = "no hay datos";
        String nit = "no hay datos";
        String poliza = "no hay datos";
        String direccion = "no hay datos";
        String municipio = "no hay datos";
        String departamento = "no hay datos";
        String nombre = "no hay datos";
        String vehiculo = "no hay datos";
        String modelo = "no hay datos";
        String uso = "no hay datos";
        String tipo = "no hay datos";
        String chasis = "no hay datos";
        String linea = "no hay datos";
        String marca = "no hay datos";
        String color = "no hay datos";
        String asientos = "no hay datos";
        String motor = "no hay datos";
        String ubicacion = "no hay datos";
        String cantidad = "Q.100.00";
        String fecha = "no hay datos";
        String foto = "nohaydatos.jpg";
        String valor = "no hay datos";
        String denunciante = "Denunciante: no hay datos";
        String tomadapor = "Tomada por: no hay datos";

        while (i < ta) {


            if (estadoactual == 0 && "Abrir".equals(tab.get(i).getTipo())) {
                System.out.println("encuentra abrir ");
                estadoactual = 1;

                ////////////////////////////////////////////////// comienza datos

                if (estadoactual ==1 && tab.get(i).getValor().toLowerCase().equals("<datos>")) {
                    System.out.println("encuentra datos "+tab.get(i).getValor());
                    i++;
                    estadoactual = 2;

                    while(estadoactual == 2){

                        if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<placa>")) {
                            i++;
                            placa = tab.get(i).getValor();
                            System.out.println("Encuentra placa"+placa);
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<nit>")) {
                            i++;
                            nit = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<direccion>")) {
                            i++;
                            direccion = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<municipio>")) {
                            i++;
                            municipio = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<departamento>")) {
                            i++;
                            departamento = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<nombre>")) {
                            i++;
                            nombre = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<modelo>")) {
                            i++;
                            modelo = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<uso>")) {
                            i++;
                            uso = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<tipo>")) {
                            i++;
                            tipo = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<chasis>")) {
                            i++;
                            chasis = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<linea>")) {
                            i++;
                            linea = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<marca>")) {
                            i++;
                            marca = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<color>")) {
                            i++;
                            color = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<asientos>")) {
                            i++;
                            asientos = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<motor>")) {
                            i++;
                            motor = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("<foto>")) {
                            i++;
                            foto = tab.get(i).getValor();
                            System.out.println("Encuentra foto"+foto);
                            i++;

                        }  else if (estadoactual == 2 && tab.get(i).getValor().toLowerCase().equals("</datos>")) {

                            DtsDatosGenerales nvo = new DtsDatosGenerales(placa, nit, poliza, modelo, uso, tipo, chasis, linea, marca, color, asientos, motor, nombre, direccion, municipio, departamento);
                            ListaDatosGenerales.add(nvo);
                            estadoactual = 0;

                            placa = "no hay datos";
                            nit = "no hay datos";
                            poliza = "no hay datos";
                            direccion = "no hay datos";
                            municipio = "no hay datos";
                            departamento = "no hay datos";
                            nombre = "no hay datos";
                            modelo = "no hay datos";
                            uso = "no hay datos";
                            tipo = "no hay datos";
                            chasis = "no hay datos";
                            linea = "no hay datos";
                            marca = "no hay datos";
                            color = "no hay datos";
                            asientos = "no hay datos";
                            motor = "no hay datos";
                            foto = "nohaydatos.jpg";
                            i++;
                        }
                        else{i++;
                        }}
                }


                ////////////////////////////////////////////////////////////////////// MULTA

                else if (estadoactual ==1 && tab.get(i).getValor().toLowerCase().equals("<multa>")) {
                    i++;
                    estadoactual = 3;


                    while(estadoactual == 3){

                        if (estadoactual == 3 && tab.get(i).getValor().toLowerCase().equals("<placa>")) {
                            i++;
                            placa = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 3 && tab.get(i).getValor().toLowerCase().equals("<fecha>")) {
                            i++;
                            fecha = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 3 && tab.get(i).getValor().toLowerCase().equals("<ubicacion>")) {
                            i++;
                            direccion = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 3 && tab.get(i).getValor().toLowerCase().equals("<tipo>")) {
                            i++;
                            tipo = tab.get(i).getValor();
                            i++;
                        }else if (estadoactual == 3 && tab.get(i).getValor().toLowerCase().equals("<cantidad>")) {
                            i++;
                            cantidad = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 3 && tab.get(i).getValor().toLowerCase().equals("<foto>")) {
                            i++;
                            foto = tab.get(i).getValor();
                            i++;
                        }
                        else if (estadoactual == 3 && tab.get(i).getValor().toLowerCase().equals("</multa>")) {

                            DtsMultas nvo = new DtsMultas(placa,fecha,direccion,tipo,cantidad,foto);
                            ListaMultas.add(nvo);

                            DtsPagosPendientes otro = new DtsPagosPendientes(placa,fecha,cantidad);
                            ListaPagosPendientes.add(otro);


                            estadoactual = 0;

                            placa = "no hay datos";
                            direccion = "no hay datos";
                            tipo = "no hay datos";
                            fecha = "no hay datos";
                            cantidad = "no hay datos";
                            foto =  "nohaydatos.jpg";

                            i++;

                        }
                        else{i++;
                        }}

                }
                //////////////////////////////////////// comienza denuncia
                else if (estadoactual ==1 && tab.get(i).getValor().toLowerCase().equals("<denuncia>")) {

                    estadoactual = 4;


                    while(estadoactual == 4){

                        if (estadoactual == 4 && tab.get(i).getValor().toLowerCase().equals("<placa>")) {
                            i++;
                            placa = tab.get(i).getValor();
                            System.out.println("Encuentra placa"+placa);
                            i++;
                        } else if (estadoactual == 4 && tab.get(i).getValor().toLowerCase().equals("<fecha>")) {
                            i++;
                            fecha = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 4 && tab.get(i).getValor().toLowerCase().equals("<ubicacion>")) {
                            i++;
                            direccion = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 4 && tab.get(i).getValor().toLowerCase().equals("<denunciante>")) {
                            i++;
                            denunciante = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 4 && tab.get(i).getValor().toLowerCase().equals("<tomadapor>")) {
                            i++;
                            tomadapor = tab.get(i).getValor();
                            i++;
                        }  else if (estadoactual == 4 && tab.get(i).getValor().toLowerCase().equals("</denuncia>")) {

                            DtsDenuncias nvo = new DtsDenuncias(placa,fecha,denunciante,tomadapor, direccion);
                            ListaDenuncias.add(nvo);

                            DtsPagosPendientes otro = new DtsPagosPendientes(placa,fecha,cantidad);
                            ListaPagosPendientes.add(otro);


                            estadoactual = 0;

                            placa = "no hay datos";
                            direccion = "no hay datos";
                            tipo = "no hay datos";
                            fecha = "no hay datos";
                            denunciante = "Denunciante: no hay datos";
                            tomadapor = "Tomada por: no hay datos";



                            i++;

                        }      }


                    i++;
                    estadoactual = 0;}

                //////////////////////////////////////// comienza impuesto

                else if (estadoactual ==1 && tab.get(i).getValor().toLowerCase().equals("<impuesto>")) {

                    i++;
                    estadoactual = 5;


                    while(estadoactual == 5){

                        if (estadoactual == 5 && tab.get(i).getValor().toLowerCase().equals("<placa>")) {
                            i++;
                            placa = tab.get(i).getValor();
                            System.out.println("Encuentra placa"+placa);
                            i++;
                        } else if (estadoactual == 5 && tab.get(i).getValor().toLowerCase().equals("<fecha>")) {
                            i++;
                            fecha = "vence en "+ tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 5 && tab.get(i).getValor().toLowerCase().equals("<ubicacion>")) {
                            i++;
                            direccion = tab.get(i).getValor();
                            i++;
                        } else if (estadoactual == 5 && tab.get(i).getValor().toLowerCase().equals("<cantidad>")) {
                            i++;
                            cantidad = tab.get(i).getValor();
                            i++;
                        }
                        else if (estadoactual == 5 && tab.get(i).getValor().toLowerCase().equals("</impuesto>")) {

                            DtsPagosPendientes nvo = new DtsPagosPendientes(placa,fecha, cantidad);
                            ListaPagosPendientes.add(nvo);


                            estadoactual = 0;

                            placa = "no hay datos";
                            direccion = "no hay datos";
                            fecha = "no hay datos";
                            cantidad = "no hay datos";

                            i++;

                        }
                        else{i++;
                        }}



                    i++;
                    estadoactual = 0;
                }else{i++;
                    estadoactual = 0;}

                /////////////////////////////////////////////// termina impuesto
            }else{i++;}
        }
    }
}
