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

    private int nivel =0;// solo hay 3 niveles

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
private ArrayList<String> habitaciones = new ArrayList<>();
    private final String archivo = "Habitaciones.txt";

    public void agregarHabitacion() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("ID: ");
            int id = sc.nextInt();
            if (id <= 0) throw new IllegalArgumentException("ID debe ser mayor que 0");
            sc.nextLine();

            System.out.print("Capacidad: ");
            int capacidad = sc.nextInt();
            if (capacidad <= 0) throw new IllegalArgumentException("Capacidad debe ser mayor que 0");
            sc.nextLine();

            System.out.print("Tipo (individual/doble/triple): ");
            String tipo = sc.nextLine().trim().toLowerCase();
            if (!(tipo.equals("individual") || tipo.equals("doble") || tipo.equals("triple"))) {
                throw new IllegalArgumentException("Tipo inválido");
            }

            System.out.print("Nivel (1-3): ");
            int nivel = sc.nextInt();
            if (nivel < 1 || nivel > 3) throw new IllegalArgumentException("Nivel debe ser 1, 2 o 3");
            sc.nextLine();

            System.out.print("Precio: ");
            float precio = sc.nextFloat();
            if (precio < 0) throw new IllegalArgumentException("Precio no puede ser negativo");
            sc.nextLine();

            System.out.print("Estado (disponible/ocupado): ");
            String estado = sc.nextLine().trim().toLowerCase();
            if (!(estado.equals("disponible") || estado.equals("ocupado"))) {
                throw new IllegalArgumentException("Estado inválido");
            }

            // Guardar en lista y archivo solo si todo es válido
            String habitacion = id + "," + capacidad + "," + tipo + "," + nivel + "," + precio + "," + estado;
            habitaciones.add(habitacion);
            guardarHabitacionEnArchivo(habitacion);
            System.out.println("✔ Habitación guardada correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void guardarHabitacionEnArchivo(String habitacion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(habitacion);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    public void mostrarHabitaciones() {
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas en memoria.");
        } else {
            habitaciones.forEach(System.out::println);
        }
    }
}