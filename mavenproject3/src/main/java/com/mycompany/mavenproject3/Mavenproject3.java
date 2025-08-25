/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import java.io.FileWriter;

import java.lang.reflect.Field;

import java.io.FileWriter;

import java.io.FileWriter;

import java.lang.reflect.Field;

import java.lang.reflect.Field;

import java.io.FileWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Mavenproject3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Habitaciones> listaHabitaciones = new ArrayList<>();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n========= MENU HABITACIONES =========");
            System.out.println("1. Agregar habitacion");
            System.out.println("2. Mostrar habitaciones");
            System.out.println("3. Salir de habitaciones");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    
                    Habitaciones habi = new Habitaciones();
                    
                    //CAPACIDAD
                    while (true) {
                        try {
                            System.out.print("Capacidad (numero entero positivo): ");
                            habi.setCapacidad(sc.nextInt());
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("x|x ERROR: " + e.getMessage() + " x|x");
                            sc.nextLine(); // limpiar buffer
                        }
                    }

                    //TIPO
                    while (true) {
                        try {
                            System.out.print("Tipo (individual/doble/triple): ");
                            habi.setTipo(sc.nextLine());
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("x|x ERROR: " + e.getMessage() + " x|x");
                            sc.nextLine(); // limpiar buffer
                        }
                    }

                    //NIVEL
                    while (true) {
                        try {
                            System.out.print("Nivel (1, 2 o 3): ");
                            habi.setNivel(sc.nextInt());
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("x|x ERROR: " + e.getMessage() + " x|x");
                            sc.nextLine(); // limpiar buffer
                        }
                    }

                    //PRECIO
                    while (true) {
                        try {
                            System.out.print("Precio: ");
                            habi.setPrecio(sc.nextFloat());
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("x|x ERROR: " + e.getMessage() + " x|x");
                            sc.nextLine(); // limpiar buffer
                        }
                    }
                    
                    //ESTADO
                     while (true) {
                        try {
                            System.out.print("Estado (disponible/ocupado): ");
                            habi.setEstado(sc.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("x|x ERROR: " + e.getMessage() + " x|x");
                            sc.nextLine(); // limpiar buffer
                        }
                    }

                    System.out.println(">>ENHORABUENA Se genero el ID de la habitacion: " + habi.getId());

                    listaHabitaciones.add(habi);
                    System.out.println(">> Habitacion agregada con exito.");
                    break;

                case 2:
                    if (listaHabitaciones.isEmpty()) {
                        System.out.println("x|x ERROR: Ups! No hay habitaciones registradas x|x");
                    } else {
                        System.out.println("\n========LISTADO DE HABITACIONES REGISTRADAS");
                        listaHabitaciones.forEach(System.out::println);
                    }
                    break;

                case 3:
                    salir = true;
                    break;

                default:
                    System.out.println("x|x ERROR: Opcion invalida x|x");
            }
        }

        //METODO PARA VERIFICAR QUE LA HABITACION NO ESTE OCUPADA, solo es de copiar y pegarlo justo donde se pide el ID de la habitacion
        Habitaciones habitacionSeleccionada = null;
        while (habitacionSeleccionada == null) {
            System.out.print("Ingrese el ID de la habitacion: ");
            int id = sc.nextInt();
            sc.nextLine();
            habitacionSeleccionada = Habitaciones.buscarHabitacionPorId(listaHabitaciones, id);
        }
        System.out.println("===== Habitacion seleccionada: " + habitacionSeleccionada);
        
        
    }
}
