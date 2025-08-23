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
    protected String id, fechaSolicitud, inicioReserva, finReserva;
    protected String reservante, recepcionista, suite, estadoReserva, mensaje;
    protected boolean estado;
    
    public String validarReserva(){
        if (estado=true)
            return "RESERVA VALIDAa";
        else 
            return "RESERVA INVALIDA";
    }
}
