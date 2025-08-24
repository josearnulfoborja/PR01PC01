/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Empleado extends Usuarios {

    private String Area = "SIN ESPECIFICAR";
    private String Puesto = "SIN ESPECIFICAR";

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, String telefono, String correo, String nickname, String clave, String Area, String Puesto) {
        super(id, nombre, apellido, telefono, correo, nickname, clave);
        this.Area = Area;
        this.Puesto = Puesto;
    }

    public void setArea(String area) {
        try {
            while (true) {
                if (area == null || area.length() < 3) {
                    throw new IllegalArgumentException("Área inválida.");
                }
                this.Area = area.trim();
                break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el area: " + e.getMessage());
            System.out.print("Vuelva a intentar. Area: ");
            area = scanner.nextLine();
        }
    }

    public void setPuesto(String puesto) {
        try {
            while (true) {
                if (puesto == null || puesto.length() < 3) {
                    throw new IllegalArgumentException("Puesto inválido.");
                }
                this.Puesto = puesto.trim();
                break;
            }
        } catch (IllegalArgumentException e){
            System.out.println("Error en el puesto: "+e.getMessage());
            System.out.print("Vuelva a intentar. Puesto: ");
            puesto=scanner.nextLine();
        }
    }

    public static Empleado crearEmpleadoDesdeUsuario(Usuarios usuario, Scanner scanner) {
        System.out.println("\n=== Datos del Empleado ===");

        System.out.print("Área: ");
        String area = scanner.nextLine();

        System.out.print("Puesto: ");
        String puesto = scanner.nextLine();

        Empleado empleado = new Empleado(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getTelefono(),
                usuario.getCorreo(), usuario.getNickname(), usuario.getClave(), area, puesto);
        guardarEmpleado(empleado);
        return empleado;
    }

    public static void guardarEmpleado(Empleado empleado) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("empleados.txt", true)))) {
            out.println(empleado.getNickname() + "," + empleado.Area + "," + empleado.Puesto);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar empleado: " + e.getMessage());
        }
    }

    public String getArea() {
        return Area;
    }

    public String getPuesto() {
        return Puesto;
    }

}
