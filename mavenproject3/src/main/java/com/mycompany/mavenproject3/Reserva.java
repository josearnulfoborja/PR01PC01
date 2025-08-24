/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dmeji
 */
public class Reserva {

    private int id = 0;
    //private String fechaSolicitud=null, inicioReserva=null, finReserva=null;
    private Date fechaSolicitud, inicioReserva, finReserva;
    // private String reservante=null;
    private Empleado recepcionista;
    private Cliente reservante;

    private Habitaciones suite;

    public String estadoReserva = "INVALIDA", mensaje = "SIN MENSAJE";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setInicioReserva(Date inicioReserva) {
        this.inicioReserva = inicioReserva;
    }

    public void setFinReserva(Date finReserva) {
        this.finReserva = finReserva;
    }

    public void setReservante(Cliente reservante) {
        this.reservante = reservante;
    }

    /*
    public String getReservante() {
        return reservante;
    }
     */

 /*
    public String getRecepcionista() {
        return recepcionista;
    }
     */

 /*
    public void setRecepcionista(String recepcionista) {
        this.recepcionista = recepcionista;
    }
     */
    public void setRecepcionista(Empleado recepcionista) {
        this.recepcionista = recepcionista;
    }

    /*
    public String getSuite() {
        return suite;
    }
 /*   
    
/*
    public void setSuite(String suite) {
        this.suite = suite;
    } 
     */

    public void setSuite(Habitaciones suite) {
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

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "Reserva {"
                + "ID=" + id
                + ", FechaSolicitud=" + (fechaSolicitud != null ? sdf.format(fechaSolicitud) : "null")
                + ", InicioReserva=" + (inicioReserva != null ? sdf.format(inicioReserva) : "null")
                + ", FinReserva=" + (finReserva != null ? sdf.format(finReserva) : "null")
                + ", Cliente=" + (reservante != null ? reservante.getCorreo() : "null")
                + ", Empleado=" + (recepcionista != null ? recepcionista.getNombre() : "null")
                + ", Habitación=" + (suite != null ? suite.getNivel() : "null")
                + ", Estado='" + estadoReserva + '\''
                + ", Mensaje='" + mensaje + '\''
                + '}';
    }
}
