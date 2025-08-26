/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author User 
 */
public class Empleado extends Usuarios {
    private String Area ="SIN ESPECIFICAR";
    private String Puesto  = "SIN ESPECIFICAR";

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, String telefono, String correo, String nickname, String clave, String Area, String Puesto) {
        super(id, nombre, apellido, telefono, correo, nickname, clave);
        this.Area = Area;
        this.Puesto =  Puesto;
    }    
    
   public void setArea(String area) {
       while (true) {
            try {
                if (area == null || area.length() < 3)
                    throw new IllegalArgumentException("Area invalida, debe tener minimo 3 caracteres.");
                this.Area = area.trim();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en el area: " + e.getMessage());
                System.out.print("Vuelva a intentar. Arrea: ");
                area=scanner.nextLine();
            }
        } 
    }

    public void setPuesto(String puesto) {
        while (true) {
            try {
                if (puesto == null || puesto.length() < 3) {
                    throw new IllegalArgumentException("Puesto invalido, debe tener minimo 3 caracteres.");
                }
                this.Puesto = puesto.trim();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en el Puesto: " + e.getMessage());
                System.out.print("Vuelva a intentar. Puesto: ");
                puesto=scanner.nextLine();
            }
        }
        
        
    }

    public Empleado crearEmpleadoDesdeUsuario(Empleado usuario) {
       
        /*
                System.out.println("\n=== Datos del Empleado ===");

        System.out.print("Área: ");
        String area = scanner.nextLine();

        System.out.print("Puesto: ");
        String puesto = scanner.nextLine();
    */
        Empleado empleado = new Empleado(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getTelefono(),
                                         usuario.getCorreo(), usuario.getNickname(), usuario.getClave(),usuario.getArea() , usuario.getPuesto());
        guardarEmpleado(empleado);
        return empleado;
    }
    
    public String getArea() {
        return Area;
    }
    public String getPuesto() {
        return Puesto;
    }
    public static void guardarEmpleado(Empleado e) {
        try (FileWriter writer = new FileWriter("empleados.txt", true)) {
               String linea = e.getId() + "," +
                       e.getNombre() + "," +
                       e.getApellido() + "," +
                       e.getTelefono() + "," +
                       e.getCorreo() + "," +
                       e.getNickname() + "," +
                       e.getClave() + "," +
                       e.getArea() + "," +
                       e.getPuesto();
            writer.write(linea + "\n");            
        
        System.out.println("Empleado guardado exitosamente.");
        } catch (IOException ex) {
            System.out.println("Error al guardar el empleado: " + ex.getMessage());
        }
    }
}
