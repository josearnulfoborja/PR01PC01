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
    protected String reservante, recepcionista, suite, mensaje;
    protected boolean estadoReserva;

    public String validarReserva() throws Exception {
        if (reservante == null || recepcionista == null || suite == null) {
            Exception excep = new Exception("No tiene asignado a cliente o empleado o habitacion");
            throw excep;
        } else {
            if (estadoReserva = true) {
                return "RESERVA VALIDA";
            } else {
                return "RESERVA INVALIDA";
            }
        }
    }
}
