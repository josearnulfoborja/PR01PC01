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
    private static int contadorId = 1; // autoincremental, empieza en 1

    private int id;
    private int capacidad = 0;
    private String tipo = "SIN ESPECIFICAR"; 
    private int nivel = 0; 
    private float precio = 0.0f;
    private String estado = "SIN ESPECIFICAR"; 

    // 🚀 Constructor: asigna automáticamente un ID único
    public Habitaciones() {
        this.id = contadorId++;
    }

    // ✅ No pongas setId(), ya no se necesita
    public int getId() {
        return id;
    }

    // --- getters/setters de los demás campos ---
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

    public void setNivel(int nivel) {
        if (nivel < 1 || nivel > 3) {
            throw new IllegalArgumentException("El nivel solo puede ser 1, 2 o 3.");
        }
        this.nivel = nivel;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        }
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        estado = estado.trim().toLowerCase();
        if (!(estado.equals("disponible") || estado.equals("ocupado"))) {
            throw new IllegalArgumentException("El estado solo puede ser: disponible u ocupado.");
        }
        this.estado = Character.toUpperCase(estado.charAt(0)) + estado.substring(1);
    }
    
   //VERIFICAR ESTADO DE LA HABITACION
    public static Habitaciones buscarHabitacionPorId(ArrayList<Habitaciones> lista, int id) {
        for (Habitaciones h : lista) {
            if (h.getId() == id) {
                if (h.getEstado().equalsIgnoreCase("Ocupado")) {
                    System.out.println("x|x ERROR: La habitacion " + id + " no esta disponible, selecciona otra x|x");
                    return null; // retorna null si está ocupada
                }
                return h; // retorna la habitacion si está disponible
            }
        }
        System.out.println("====== No existe una habitacion con el ID: " + id);
        return null; // retorna null si no encuentra el id
    } 

    @Override
    public String toString() {
        return "Habitacion " + id
                + "| Capacidad:" + capacidad
                + "| Tipo:" + tipo
                + "| Nivel:" + nivel
                + "| Precio:" + precio
                + "| Estado:" + estado;
    }
}