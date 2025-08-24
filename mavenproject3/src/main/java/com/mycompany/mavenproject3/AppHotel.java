/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class AppHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empleado empleadoActivo = null;

        System.out.println("=== BIENVENIDO AL SISTEMA DE RESERVAS HOTEL EL PARAISO ===");
        System.out.println("1. Iniciar sesión como empleado");
        System.out.println("2. Registrar nuevo empleado");
        System.out.print("Seleccione una opción: ");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                empleadoActivo = iniciarSesion(scanner);
                break;
            case "2":
                empleadoActivo = registrarNuevoEmpleado(scanner);
                break;
            default:
                System.out.println("❌ Opción inválida. Finalizando programa.");
                return;
        }

        if (empleadoActivo != null) {
            System.out.println("✅ Sesión iniciada como: " + empleadoActivo.getNombre() + " " + empleadoActivo.getApellido());
            // Aquí puedes continuar con el menú de reservas, habitaciones, etc.
        } else {
            System.out.println("❌ No se pudo iniciar sesión.");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();

        Empleado empleadoActivo = Usuarios.loginDesdeArchivo(usuario, clave);
        if (empleadoActivo != null) {
            System.out.println("✅ Bienvenido, " + empleadoActivo.getNombre());
        } else {
            System.out.println("❌ Usuario o clave incorrectos.");
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== BIENVENIDO AL SISTEMA HOTEL EL PARAISO ===");
        System.out.println("1. Ingresar como empleado existente");
        System.out.println("2. Registrar nuevo empleado");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Empleado empleadoActivo = null;

        if (opcion == 1) {
            System.out.print("Ingrese nombre de usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Ingrese contraseña: ");
            String clave = scanner.nextLine();
            empleadoActivo = login(usuario, clave);
            if (empleadoActivo == null) {
                System.out.println("❌ Usuario o contraseña incorrectos.");
                return;
            }
        } else if (opcion == 2) {
            empleadoActivo = registrarEmpleado(scanner);
            guardarEmpleadoEnArchivo(empleadoActivo);
            System.out.println("✅ Registro exitoso.");
        } else {
            System.out.println("Opción inválida.");
            return;
        }

    }
    
    
    public static Empleado registrarNuevoEmpleado(Scanner scanner) {
    System.out.println("\n=== Registro de Nuevo Empleado ===");

    // Datos del usuario
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine().trim();

    System.out.print("Apellido: ");
    String apellido = scanner.nextLine().trim();

    System.out.print("Usuario: ");
    String usuario = scanner.nextLine().trim();

    System.out.print("Contraseña: ");
    String contrasena = scanner.nextLine().trim();

    // Validación
    if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
        System.out.println("❌ Todos los campos son obligatorios.");
        return null;
    }

    Usuarios nuevoUsuario = new Usuarios(nombre, apellido, usuario, contrasena);

    // Datos del empleado
    System.out.print("Puesto: ");
    String puesto = scanner.nextLine().trim();

    System.out.print("Área: ");
    String area = scanner.nextLine().trim();

    Empleado nuevoEmpleado = new Empleado(usuario, puesto, area); // Relacionado por usuario

    // Guardar usuario
    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("usuarios.txt", true)))) {
        out.println(nuevoUsuario.toLineaTXT());
    } catch (IOException e) {
        System.out.println("❌ Error al guardar usuario: " + e.getMessage());
        return null;
    }

    // Guardar empleado
    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("empleados.txt", true)))) {
        out.println(nuevoEmpleado.toLineaTXT());
    } catch (IOException e) {
        System.out.println("❌ Error al guardar empleado: " + e.getMessage());
        return null;
    }

    System.out.println("✅ Registro exitoso. Bienvenido, " + nombre + "!");
    return nuevoEmpleado;
}
}
