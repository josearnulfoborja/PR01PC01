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
    private int id = 0;
    private int capacidad = 0;
    private String tipo = "SIN ESPECIFICAR";
    private int nivel = 0;
    private float precio = (float) 0.0;
    private String estado = "SIN ESPECIFICAR";

    // Lista para almacenar habitaciones
    private ArrayList<Habitaciones> listaHabitaciones = new ArrayList<>();
    private final String archivo = "Habitaciones.txt";

    // Constructores
    public Habitaciones() {}
    public Habitaciones(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("El ID debe ser mayor que 0.");
            }
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el Id: " + e.getMessage());
        }
    }

    // Getters y Setters con validaciones
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) {
        try {
            if (capacidad <= 0) {
                throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
            }
            this.capacidad = capacidad;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la capacidad: " + e.getMessage());
        }
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {
        try {
            tipo = tipo.trim().toLowerCase();
            if (!(tipo.equals("individual") || tipo.equals("doble") || tipo.equals("triple"))) {
                throw new IllegalArgumentException("El tipo debe ser: individual, doble o triple.");
            }
            this.tipo = tipo;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el Tipo de habitación: " + e.getMessage());
        }
    }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) {
        try {
            if (nivel < 1 || nivel > 3) {
                throw new IllegalArgumentException("El nivel solo puede ser 1, 2 o 3.");
            }
            this.nivel = nivel;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el Nivel: " + e.getMessage());
        }
    }

    public float getPrecio() { return precio; }
    public void setPrecio(float precio) {
        try {
            if (precio < 0) {
                throw new IllegalArgumentException("El precio no puede ser negativo.");
            }
            this.precio = precio;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el Precio: " + e.getMessage());
        }
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) {
        try {
            estado = estado.trim().toLowerCase();
            if (!(estado.equals("disponible") || estado.equals("ocupado"))) {
                throw new IllegalArgumentException("El estado solo puede ser: Disponible u Ocupado.");
            }
            this.estado = Character.toUpperCase(estado.charAt(0)) + estado.substring(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el Estado: " + e.getMessage());
        }
    }

    // ===== MÉTODOS DE GESTIÓN DE HABITACIONES =====
    public void agregarHabitacionDesdeScanner() {
        Scanner sc = new Scanner(System.in);
        Habitaciones h = new Habitaciones();

        System.out.print("ID: ");
        h.setId(sc.nextInt());
        sc.nextLine(); // Limpiar buffer

        System.out.print("Capacidad: ");
        h.setCapacidad(sc.nextInt());
        sc.nextLine();

        System.out.print("Tipo (individual/doble/triple): ");
        h.setTipo(sc.nextLine());

        System.out.print("Nivel (1-3): ");
        h.setNivel(sc.nextInt());
        sc.nextLine();

        System.out.print("Precio: ");
        h.setPrecio(sc.nextFloat());
        sc.nextLine();

        System.out.print("Estado (disponible/ocupado): ");
        h.setEstado(sc.nextLine());

        listaHabitaciones.add(h);
        System.out.println("Habitación agregada correctamente.");
    }

    public void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Habitaciones h : listaHabitaciones) {
                writer.write(h.getId() + "," + h.getCapacidad() + "," + h.getTipo() + "," +
                             h.getNivel() + "," + h.getPrecio() + "," + h.getEstado());
                writer.newLine();
            }
            System.out.println("Datos guardados en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
