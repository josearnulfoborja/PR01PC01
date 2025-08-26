/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Habitaciones {

    private int nivel = 0;// solo hay 3 niveles

    private int id, capacidad;
    private String tipo, estado;
    private float precio;

    public Habitaciones(int id,int capacidad,String tipo,int nivel,float precio,String estado){
        this.id=id;
        this.capacidad=capacidad;
        this.tipo=tipo;
        this.nivel=nivel;
        this.precio=precio;
        this.estado=estado;
    }

    Habitaciones() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0.");
        }
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        tipo = tipo.trim().toLowerCase();
        if (!(tipo.equals("individual") || tipo.equals("doble") || tipo.equals("triple"))) {
            throw new IllegalArgumentException("El tipo debe ser: individual, doble o triple.");
        }
        this.tipo = tipo;
    }


    public int getNivel() {
        return nivel;
    }


    public int getCapacidad() {
        return capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public float getPrecio() {
        return precio;
    }

    public ArrayList<String> getHabitaciones() {
        return habitaciones;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        estado = estado.trim().toLowerCase();
        if (!(estado.equals("disponible") || estado.equals("ocupado"))) {
            throw new IllegalArgumentException("El estado solo puede ser: disponible u ocupado.");
        }
        this.estado = Character.toUpperCase(estado.charAt(0)) + estado.substring(1);
    }

    @Override
    public String toString() {
        return "Habitacion " + id
                + ", Capacidad:" + capacidad
                + ", Tipo:" + tipo
                + ", Nivel:" + nivel
                + ", Precio:" + precio
                + ", Estado:" + estado;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setHabitaciones(ArrayList<String> habitaciones) {
        this.habitaciones = habitaciones;
    }

    private ArrayList<String> habitaciones = new ArrayList<>();
    private final String archivo = "Habitaciones.txt";

   public Habitaciones agregarHabitacion() {
    Scanner sc = new Scanner(System.in);

    //  Declarar variables al inicio
    int id = 0, capacidad = 0, nivel = 0;
    float precio = 0;
    String tipo = "", estado = "";

    try {
        while (true) {
            try {
                System.out.print("ID: ");
                id = sc.nextInt();
                if (id <= 0) throw new IllegalArgumentException("ID debe ser mayor que 0");
                sc.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Capacidad: ");
                capacidad = sc.nextInt();
                if (capacidad <= 0) throw new IllegalArgumentException("Capacidad debe ser mayor que 0");
                sc.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Tipo (individual/doble/triple): ");
                tipo = sc.nextLine().trim().toLowerCase();
                if (!(tipo.equals("individual") || tipo.equals("doble") || tipo.equals("triple")))
                    throw new IllegalArgumentException("Tipo inválido");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nivel (1-3): ");
                nivel = sc.nextInt();
                if (nivel < 1 || nivel > 3) throw new IllegalArgumentException("Nivel debe ser 1, 2 o 3");
                sc.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Precio: ");
                precio = sc.nextFloat();
                if (precio < 0) throw new IllegalArgumentException("Precio no puede ser negativo");
                sc.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Estado (disponible/ocupado): ");
                estado = sc.nextLine().trim().toLowerCase();
                if (!(estado.equals("disponible") || estado.equals("ocupado")))
                    throw new IllegalArgumentException("Estado inválido");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" " + e.getMessage());
            }
        }

    } catch (Exception e) {
        System.out.println(" Error inesperado: " + e.getMessage());
        return null;
    }
   
    return new Habitaciones(id, capacidad, tipo, nivel, precio, estado);
}

    public void guardarHabitacionEnArchivo(Habitaciones h) {
        try (FileWriter writer = new FileWriter("habitaciones.txt", true)) {
            String linea = h.getId() + ","
                    + h.getCapacidad() + ","
                    + h.getTipo() + ","
                    + h.getNivel() + ","
                    + h.getPrecio() + ","
                    + h.getEstado();
            writer.write(linea + "\n");
            System.out.println(" Habitacion guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    public void mostrarHabitaciones() {
        Reserva reserva = new Reserva();
        Scanner scanner = new Scanner(System.in);
        Habitaciones habitacion;
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas en memoria.");
        } else {
            habitaciones.forEach(System.out::println);
        }

    }
}
