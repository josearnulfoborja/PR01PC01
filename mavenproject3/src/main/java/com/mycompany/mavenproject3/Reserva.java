/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.io.FileWriter;
import java.io.IOException;
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

    public Reserva() {
        
    }
    
    
     public Reserva(int id, Date fechaSolicitud, Date inicioReserva, Date finReserva,
                   Cliente reservante, Empleado recepcionista, Habitaciones suite, String estadoReserva) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.inicioReserva = inicioReserva;
        this.finReserva = finReserva;
        this.reservante = reservante;
        this.recepcionista = recepcionista;
        this.suite = suite;
        this.estadoReserva = estadoReserva;
    }
     

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
    
  
public Date getFechaSolicitud() {
    return fechaSolicitud;
}

public Date getInicioReserva() {
    return inicioReserva;
}

public Date getFinReserva() {
    return finReserva;
}

public Cliente getReservante() {
    return reservante;
}

public Empleado getRecepcionista() {
    return recepcionista;
}


public String getEstadoReserva() {
    return estadoReserva;
}

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }


    public Habitaciones getSuite() {
        return suite;
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
     public Reserva crearReserva(Reserva r) {
     
        Reserva reserva = new Reserva(
        r.getId(),
        r.getFechaSolicitud(),
        r.getInicioReserva(),
        r.getFinReserva(),
        r.getReservante(),
        r.getRecepcionista(),
        r.getSuite(),
        r.getEstadoReserva()
    );

        guardarReserva(reserva);
        return reserva;
     }
          
    public static void guardarReserva(Reserva r) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try (FileWriter writer = new FileWriter("reservas.txt", true)) {
            writer.write("ID: " + r.getId() + "\n");
            writer.write("Fecha de Solicitud: " + (r.getFechaSolicitud() != null ? sdf.format(r.getFechaSolicitud()) : "null") + "\n");
            writer.write("Inicio de Reserva: " + (r.getInicioReserva() != null ? sdf.format(r.getInicioReserva()) : "null") + "\n");
            writer.write("Fin de Reserva: " + (r.getFinReserva() != null ? sdf.format(r.getFinReserva()) : "null") + "\n");
            writer.write("Cliente: " + (r.getReservante() != null ? r.getReservante().getCorreo() : "null") + "\n");
            writer.write("Empleado: " + (r.getRecepcionista() != null ? r.getRecepcionista().getNombre() : "null") + "\n");
            writer.write("Habitación: " + (r.getSuite() != null ? r.getSuite().getNivel() : "null") + "\n");
            writer.write("Estado: " + r.getEstadoReserva() + "\n");
            writer.write("=====================================\n");
            System.out.println("✅ Reserva guardada exitosamente.");
        } catch (IOException ex) {
            System.out.println("❌ Error al guardar la reserva: " + ex.getMessage());
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
