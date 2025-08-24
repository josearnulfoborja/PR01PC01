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
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("El ID debe ser mayor que 0.");
            }
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el Id: " + e.getMessage());
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

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

    public String getTipo() {
        return tipo;
    }

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

    public int getNivel() {
        return nivel;
    }

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

    public float getPrecio() {
        return precio;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        try {
            estado = estado.trim().toLowerCase();
            if (!(estado.equals("disponible") || estado.equals("ocupado"))) {
                throw new IllegalArgumentException("El estado solo puede ser: disponible u ocupado.");
            }
            this.estado = Character.toUpperCase(estado.charAt(0)) + estado.substring(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el Estado: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Habitacion "+ id +
                ", Capacidad:" + capacidad +
                ", Tipo:" + tipo +
                ", Nivel:" + nivel +
                ", Precio:" + precio +
                ", Estado:" + estado;
    }
}