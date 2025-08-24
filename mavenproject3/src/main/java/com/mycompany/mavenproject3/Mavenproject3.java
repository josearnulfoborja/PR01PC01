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

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Mavenproject3 {

    public static void main(String[] args) {

        System.out.println("=== BIENVENIDO AL SISTEMA DE RESERVAS HOTEL EL PARAISO ===");
        System.out.println("=== -------------------------------------------------- ===");
        System.out.println("=== INGRESE SUS CREDENCIALES PARA PODER INICIAR ===");
        System.out.println("=== -------------------------------------------------- ===");
        Scanner scanner = new Scanner(System.in);
        Empleado empleadoActivo = iniciarSesion(scanner);

        if (empleadoActivo != null) {
            mostrarMenuPrincipal(scanner, empleadoActivo);
        } else {
            System.out.println("❌ Acceso denegado.");
        }
        /*
        Habitaciones hotel = new Habitaciones();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE HABITACIONES ---");
            System.out.println("1. Agregar Habitación");
            System.out.println("2. Mostrar Habitaciones (en memoria)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> hotel.agregarHabitacion();
                case 2 -> hotel.mostrarHabitaciones();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
         */
    }

    public static Empleado iniciarSesion(Scanner scanner) {
        System.out.println("\n=== INICIO DE SESIÓN ===");

        System.out.print("Correo: ");
        String correoIngresado = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contraseñaIngresada = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length == 4) {
                    String nombre = partes[0];
                    String apellido = partes[1];
                    String correo = partes[2];
                    String contraseña = partes[3];

                    if (correo.equals(correoIngresado) && contraseña.equals(contraseñaIngresada)) {
                        Empleado empleado = new Empleado();
                        empleado.setNombre(nombre);
                        empleado.setApellido(apellido);
                        empleado.setCorreo(correo);
                        empleado.setClave(contraseña);
                        return empleado;
                    }
                }
            }

            System.out.println("❌ Credenciales incorrectas o empleado no encontrado.");
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }

    public static void mostrarMenuPrincipal(Scanner scanner, Empleado empleadoActivo) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver clientes");
            System.out.println("3. Crear reserva");
            System.out.println("4. Ver reservas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    registrarNuevoCliente(scanner);
                    break;
                case "2":
                    mostrarClientesRegistrados();
                    break;
                case "3":
                    crearReserva(scanner);
                    break;
                case "4":
                    mostrarReservas();
                    break;
                case "5":
                    continuar = false;
                    System.out.println("👋 Cerrando sesión...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        }
    }

    public static void registrarNuevoCliente(Scanner scanner) {
        Cliente cliente = new Cliente();

        System.out.println("\n=== Registro de Nuevo Cliente ===");

        System.out.print("Nombre: ");
        cliente.setNombre(scanner.nextLine());

        System.out.print("Apellido: ");
        cliente.setApellido(scanner.nextLine());

        System.out.print("Correo: ");
        cliente.setCorreo(scanner.nextLine());

        System.out.print("Contraseña: ");
        cliente.setClave(scanner.nextLine());

        System.out.print("Teléfono: ");
        cliente.setTelefono(scanner.nextLine());

        if (cliente.getNombre() != null
                && cliente.getApellido() != null
                && cliente.getCorreo() != null
                && cliente.getClave() != null
                && cliente.getTelefono() != null) {

            try (FileWriter writer = new FileWriter("clientes.txt", true)) {
                writer.write(cliente.getNombre() + ","
                        + cliente.getApellido() + ","
                        + cliente.getCorreo() + ","
                        + cliente.getClave() + ","
                        + cliente.getTelefono() + "\n");
                System.out.println("✅ Cliente registrado y guardado correctamente.");
            } catch (IOException e) {
                System.out.println("❌ Error al guardar el cliente: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ Registro fallido. Verifique los datos.");
        }
    }

    public static void mostrarClientesRegistrados() {
        System.out.println("\n=== Clientes Registrados ===");

        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"))) {
            String linea;
            int contador = 1;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    System.out.println(contador + ". "
                            + "Nombre: " + partes[0] + " " + partes[1]
                            + " | Correo: " + partes[2]
                            + " | Teléfono: " + partes[4]);
                    contador++;
                }
            }

            if (contador == 1) {
                System.out.println("⚠️ No hay clientes registrados.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer clientes: " + e.getMessage());
        }
    }

    public static void crearReserva(Scanner sc) {
        System.out.println("\n=== Crear Reserva ===");

        Reserva reserva = new Reserva(); // ID fijo para ejemplo
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Fecha de solicitud (dd/MM/yyyy): ");
            reserva.setFechaSolicitud(sdf.parse(sc.nextLine()));

            System.out.print("Inicio de reserva (dd/MM/yyyy): ");
            reserva.setInicioReserva(sdf.parse(sc.nextLine()));

            System.out.print("Fin de reserva (dd/MM/yyyy): ");
            reserva.setFinReserva(sdf.parse(sc.nextLine()));

            // Simulación de objetos relacionados
            System.out.print("Nombre del cliente: ");
            String nombreCliente = sc.nextLine();
            Cliente cliente = new Cliente(); // Constructor simple
            cliente.setNombre(nombreCliente);
            reserva.setReservante(cliente);

            System.out.print("Nombre del recepcionista: ");
            String nombreEmpleado = sc.nextLine();
            Empleado empleado = new Empleado();
            empleado.setNombre(nombreEmpleado);
            reserva.setRecepcionista(empleado);

            System.out.print("Número de habitación: ");
            int numeroHabitacion = Integer.parseInt(sc.nextLine());
            Habitaciones habitacion = new Habitaciones();
            habitacion.setNivel(numeroHabitacion);
            //validar
            reserva.setSuite(habitacion);

            // Validación
            String resultado = reserva.validarReserva();
            System.out.println("Resultado: " + resultado);
            //Crear el mensaje
            System.out.println("Mensaje: " + reserva.toString());

            // Persistencia simulada
            if (resultado.equals("RESERVA VÁLIDA")) {
                System.out.println("Reserva lista para guardar en archivo.");
                // Aquí podrías llamar a guardarEnArchivo(reserva);
                guardarArchivo(reserva, "reservas.txt");
            } else {
                System.out.println("No se puede guardar la reserva. Datos incompletos.");
            }

        } catch (Exception e) {
            System.out.println("Error en el formato de fecha o entrada: " + e.getMessage());
        }

    }

    public static void mostrarReservas() {
        System.out.println("\n=== Reservas Registradas ===");

        try (BufferedReader reader = new BufferedReader(new FileReader("reservas.txt"))) {
            String linea;
            int contador = 1;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    System.out.println(contador + ". "
                            + "Cliente: " + partes[0]
                            + " | Habitación: " + partes[1]
                            + " | Entrada: " + partes[2]
                            + " | Salida: " + partes[3]);
                    contador++;
                }
            }

            if (contador == 1) {
                System.out.println("⚠️ No hay reservas registradas.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer reservas: " + e.getMessage());
        }
    }

    public static void guardarArchivo(Object entidad, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            Class<?> clase = entidad.getClass();
            Field[] campos = clase.getDeclaredFields();
            StringBuilder linea = new StringBuilder();

            for (Field campo : campos) {
                campo.setAccessible(true);
                Object valor = campo.get(entidad);
                linea.append(valor != null ? valor.toString() : "null").append(",");
            }

            writer.write(linea.substring(0, linea.length() - 1) + "\n");
            System.out.println("✅ " + clase.getSimpleName() + " guardado en " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("❌ Error al guardar " + entidad.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    public Cliente buscarCliente(String criterio) {
        try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                // Validación mínima
                if (partes.length < 5) {
                    continue;
                }

                //String id = partes[0].trim();
                int id = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();

                if (nombre.equalsIgnoreCase(criterio)) {
                    Cliente cliente = new Cliente();
                    cliente.setId(id);
                    cliente.setNombre(nombre);
                    cliente.setApellido(partes[2].trim());
                    cliente.setTipoCliente(partes[3].trim());
                    cliente.setCorreo(partes[4].trim());
                    cliente.setClave(partes[5].trim());
                    cliente.setNickname(partes[6].trim());

                    return cliente;
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error al buscar cliente: " + e.getMessage());
        }
        return null;
    }

}
