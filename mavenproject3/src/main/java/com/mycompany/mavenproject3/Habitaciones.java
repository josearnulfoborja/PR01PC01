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
    private String tipo = "SIN ESPECIFICAR"; // individual, doble o triple
    private int nivel = 0; // solo hay 3 niveles
    private float precio = 0.0f;
    private String estado = "SIN ESPECIFICAR"; // disponible u ocupado

    public Habitaciones() {
    }

    public Habitaciones(int id) {
        setId(id);
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

    @Override
    public String toString() {
        return "Habitacion " + id
                + ", Capacidad:" + capacidad
                + ", Tipo:" + tipo
                + ", Nivel:" + nivel
                + ", Precio:" + precio
                + ", Estado:" + estado;
    }
    
    //VERIFICAR ESTADO DE LA HABITACION
    public static Habitaciones buscarHabitacionPorId(ArrayList<Habitaciones> lista, int id) {
        for (Habitaciones h : lista) {
            if (h.getId() == id) {
                if (h.getEstado().equalsIgnoreCase("Ocupado")) {
                    System.out.println("===== La habitación " + id + " no está disponible, selecciona otra.");
                    return null; // retorna null si está ocupada
                }
                return h; // retorna la habitacion si está disponible
            }
        }
        System.out.println("====== No existe una habitación con el ID: " + id);
        return null; // retorna null si no encuentra el id
    }
    
    //VALIDA QUE EL IDE NO SE REPITA AL AÑADIR OTRO
    public static boolean existeId(ArrayList<Habitaciones> lista, int id) {
        for (Habitaciones h : lista) {
            if (h.getId() == id) {
                return true; // ya existe ese ID
            }
        }
        return false; // no existe todavía
    }
}
