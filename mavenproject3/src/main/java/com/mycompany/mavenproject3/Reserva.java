/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;


/**
 *
 * @author dmeji
 */
public class Reserva {

    private int id=0;
    private String fechaSolicitud=null, inicioReserva=null, finReserva=null;
    private String reservante=null, recepcionista=null, suite=null;
    public String estadoReserva="INVALIDA", mensaje="SIN MENSAJE";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getInicioReserva() {
        return inicioReserva;
    }

    public void setInicioReserva(String inicioReserva) {
        this.inicioReserva = inicioReserva;
    }

    public String getFinReserva() {
        return finReserva;
    }

    public void setFinReserva(String finReserva) {
        this.finReserva = finReserva;
    }

    public String getReservante() {
        return reservante;
    }

    public void setReservante(String reservante) {
        this.reservante = reservante;
    }

    public String getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(String recepcionista) {
        this.recepcionista = recepcionista;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }    
    
    public String validarReserva() throws Exception {
        if (reservante == null || recepcionista == null || suite == null) {
            Exception excep = new Exception("No tiene asignado a cliente o empleado o habitacion");
            throw excep;
        } else {
            if (estadoReserva.contentEquals("INVALIDA")) {
                return "RESERVA INVALIDA";
            } else {
                return "RESERVA VALIDA";
            }
        }
    }
}
