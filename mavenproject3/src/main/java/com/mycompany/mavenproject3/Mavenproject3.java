/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Mavenproject3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Empleado empleadoActivo = null;
        boolean salir = false;
        Empleado empleado1 = null;

        System.out.println("=== BIENVENIDO AL SISTEMA DE RESERVAS HOTEL EL PARAISO ===");

        while (!salir && empleadoActivo == null) {
            System.out.println("\n=== MENÚ DE INICIO ===");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    empleadoActivo = iniciarSesion(scanner);
                    if (empleadoActivo == null) {
                        System.out.println("❌ Credenciales incorrectas.");
                    }
                    break;
                case 2:
                    crearEmpleado(scanner);
                    break;
                case 3:
                    salir = true;
                    System.out.println("👋 Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida. Intente de nuevo.");
            }
        }

        if (empleadoActivo != null) {
            mostrarMenuPrincipal(scanner, empleadoActivo);
        }
    }

    /**
     * Creacion de nuevo usuario
     *
     * @param empleado
     */
    // <editor-fold desc="Clientes">
    public Cliente buscarCliente(Cliente criterio) {
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

                if (nombre.equalsIgnoreCase(criterio.getNombre())) {
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

    // </editor-fold>
    // <editor-fold desc="Empleados">
    public static void crearEmpleado(Scanner sc) {
        Empleado empleado = new Empleado();
        System.out.println("\n=== INGRESE LOS DATOS DEL NUEVO EMPLEADO ===");

        int nuevoId = obtenerNuevoId(); // ID automático        
        empleado.setId(nuevoId);

        System.out.print("Nombre: ");
        empleado.setNombre(sc.nextLine());

        System.out.print("Apellido: ");
        empleado.setApellido(sc.nextLine());

        System.out.print("Telefono: ");
        empleado.setTelefono(sc.nextLine());

        System.out.print("Correo: ");
        empleado.setCorreo(sc.nextLine());

        System.out.print("Nickname (apodo): ");
        empleado.setNickname(sc.nextLine());

        System.out.print("Clave: ");
        empleado.setClave(sc.nextLine());

        System.out.print("Área: ");
        empleado.setArea(sc.nextLine());

        System.out.print("Puesto: ");
        empleado.setPuesto(sc.nextLine());

        empleado.crearEmpleadoDesdeUsuario(empleado);

        System.out.println("✅ Empleado registrado con ID: " + nuevoId);

    }

    public static int obtenerNuevoId() {
        File archivo = new File("empleados.txt");
        int maxId = 0;

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                return 1; // Primer ID
            } catch (IOException e) {
                System.out.println("❌ Error al crear el archivo: " + e.getMessage());
                return 1; // Asignamos 1 por defecto
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 1) {
                    try {
                        int id = Integer.parseInt(partes[0].trim());
                        if (id > maxId) {
                            maxId = id;
                        }
                    } catch (NumberFormatException e) {
                        // Ignorar líneas mal formateadas
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ No se pudo leer el archivo: " + e.getMessage());
        }

        return maxId + 1;
    }

    public Empleado buscarRecepcionista(String usuarioBuscado, String contrasenaBuscada) {
        try (BufferedReader br = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 5) {
                    continue;
                }
                String usuario = partes[3].trim();
                String contrasena = partes[4].trim();

                if (usuario.equals(usuarioBuscado) && contrasena.equals(contrasenaBuscada)) {
                    Empleado emp = new Empleado();
                    emp.setId(Integer.parseInt(partes[0].replaceAll("[^\\d]", ""))); // E001 → 1
                    emp.setNombre(partes[1].trim());
                    emp.setApellido(partes[2].trim());
                    //emp.setUsuario(usuario);
                    //emp.setContrasena(contrasena);
                    return emp;
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error al buscar cliente: " + e.getMessage());
        }
        return null;
    }

    public static Empleado iniciarSesion(Scanner scanner) {

        System.out.println("\n=== INICIO DE SESIÓN ===");

        //scanner.nextLine(); // Limpiar buffer sdespués del nextInt en el main
        System.out.print("Correo: ");
        String correoIngresado = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contraseñaIngresada = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length == 9) {
                    String nombre = partes[1];
                    String apellido = partes[2];
                    String correo = partes[4];
                    String contraseña = partes[6];

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

    // </editor-fold>
    // <editor-fold desc="Reverva">
    public static void crearReserva(Scanner sc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Crear Reserva ===");

        Reserva reserva = new Reserva();
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

            System.out.print("¿El cliente ya está registrado? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) {
                // 🔍 Buscar cliente existente
                System.out.print("Ingrese el codigo del Cliente: ");
                String usuarioCliente = sc.nextLine();
                System.out.print("Contraseña del cliente: ");
                String contrasenaCliente = sc.nextLine();
                // cliente = buscarCliente(cliente);

                if (cliente == null) {
                    System.out.println("❌ Cliente no encontrado. No se puede continuar.");
                    return;
                }
            } else {
                // 🆕 Registrar nuevo cliente
                cliente = new Cliente();
                System.out.print("Nombre del cliente: ");
                cliente.setNombre(sc.nextLine());
                System.out.print("Apellido del cliente: ");
                cliente.setApellido(sc.nextLine());
                System.out.print("Usuario para el cliente: ");
                //cliente.setUsuario(sc.nextLine());
                System.out.print("Contraseña para el cliente: ");
                //cliente.setContrasena(sc.nextLine());

                // Puedes generar un ID automático o pedirlo
                //cliente.setId(generarIdCliente()); // Método que busca el último ID y suma 1
                //guardarClienteEnArchivo(cliente); // Persistencia
                System.out.println("✅ Cliente registrado exitosamente.");

            }

            System.out.print("Nombre del recepcionista: ");
            String nombreEmpleado = sc.nextLine();
            Empleado empleado = new Empleado();
            empleado.setNombre(nombreEmpleado);
            reserva.setRecepcionista(empleado);

            /**
             * Pedir datos de habitaciones
             */
            Habitaciones habit =  menuHabitaciones(scanner);
            
            reserva.setSuite(habit);
            //validar
            

            // Validación
            String resultado = reserva.validarReserva();
            System.out.println("Resultado: " + resultado);
            //Crear el mensaje
            System.out.println("Mensaje: " + reserva.toString());

            // Persistencia simulada
            if (resultado.equals("RESERVA VÁLIDA")) {
                System.out.println("Reserva lista para guardar en archivo.");
                // Aquí podrías llamar a guardarEnArchivo(reserva);
                reserva.crearReserva(reserva);
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

    // </editor-fold>      
    // <editor-fold desc="Archivos">
    /*
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
     */
 /*
      public static void guardarArchivo(Object entidad, String nombreArchivo) {
    try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
        Class<?> clase = entidad.getClass();
        StringBuilder linea = new StringBuilder();

        // Recorre la jerarquía de clases
        while (clase != null) {
            Field[] campos = clase.getDeclaredFields();
            for (Field campo : campos) {
                campo.setAccessible(true);
                Object valor = campo.get(entidad);
                linea.append(valor != null ? valor.toString() : "null").append(",");
            }
            clase = clase.getSuperclass(); // Sube a la clase padre
        }

        writer.write(linea.substring(0, linea.length() - 1) + "\n");
        System.out.println("✅ " + entidad.getClass().getSimpleName() + " guardado en " + nombreArchivo);
    } catch (Exception e) {
        System.out.println("❌ Error al guardar " + entidad.getClass().getSimpleName() + ": " + e.getMessage());
    }
}
     */
    // </editor-fold>
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

    public static Habitaciones menuHabitaciones(Scanner scanner) {
        Habitaciones habitaciones = new Habitaciones();
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar habitacion");
            System.out.println("2. Mostrar habitaciones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion < 1 && opcion > 3) {
                throw new IllegalArgumentException("Escoja una opcion valida.");
            }

            try {
                switch (opcion) {
                    case 1:
                        habitaciones.agregarHabitacion();
                        break;
                    case 2:
                        habitaciones.mostrarHabitaciones();
                        break;
                    case 3:
                        System.out.println("Regresando al registro de reserva...\n");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
                System.out.print("Vuelva a ingresar. ");
            }
        }
    }

}
