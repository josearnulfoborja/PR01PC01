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
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

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
            System.out.println("\n=== MENU DE INICIO ===");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    empleadoActivo = iniciarSesion(scanner);
                    if (empleadoActivo == null) {
                        System.out.println(" Credenciales incorrectas.");
                    }
                    break;
                case 2:
                    crearEmpleado(scanner);
                    break;
                case 3:
                    salir = true;
                    System.out.println(" Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println(" Opción no válida. Intente de nuevo.");
            }
        }

        if (empleadoActivo != null) {
            mostrarMenuPrincipal(scanner, empleadoActivo);
        }
    }

// <editor-fold desc="Reverva">
    public static void crearReserva(Scanner sc, Empleado recepcionistaActivo) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Crear Reserva ===");

        Reserva reserva = new Reserva();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            /*
            int idReserva = obtenerNuevoReservaId();
            reserva.setId(idReserva);
            System.out.print("Fecha de solicitud (dd/MM/yyyy): ");
            reserva.setFechaSolicitud(sdf.parse(sc.nextLine()));

            System.out.print("Inicio de reserva (dd/MM/yyyy): ");
            reserva.setInicioReserva(sdf.parse(sc.nextLine()));

            System.out.print("Fin de reserva (dd/MM/yyyy): ");
            reserva.setFinReserva(sdf.parse(sc.nextLine()));
             */

            // Validar fecha de solicitud
            // Validar fecha de solicitud
            sdf.setLenient(false); // ← esto fuerza el formato exacto

            Date fechaSolicitud = null;
            Date inicioReserva = null;
            Date finReserva = null;
            while (true) {
                System.out.print("📅 Fecha de solicitud (dd/MM/yyyy): ");
                String input = sc.nextLine();
                try {
                    fechaSolicitud = sdf.parse(input);
                    break;
                } catch (ParseException e) {
                    System.out.println("❌ Fecha inválida. Intente de nuevo con el formato dd/MM/yyyy.");
                }
            }

// Validar inicio de reserva
            while (true) {
                System.out.print("📅 Inicio de reserva (dd/MM/yyyy): ");
                String input = sc.nextLine();
                try {
                    inicioReserva = sdf.parse(input);
                    break;
                } catch (ParseException e) {
                    System.out.println("❌ Fecha inválida. Intente de nuevo con el formato dd/MM/yyyy.");
                }
            }

// Validar fin de reserva
            while (true) {
                System.out.print("📅 Fin de reserva (dd/MM/yyyy): ");
                String input = sc.nextLine();
                try {
                    finReserva = sdf.parse(input);
                    break;
                } catch (ParseException e) {
                    System.out.println("❌ Fecha inválida. Intente de nuevo con el formato dd/MM/yyyy.");
                }
            }

// Asignar a la reserva
            reserva.setFechaSolicitud(fechaSolicitud);
            reserva.setInicioReserva(inicioReserva);
            reserva.setFinReserva(finReserva);

            Cliente cliente = new Cliente();

            System.out.print("¿El cliente ya está registrado? (s/n): ");
            String respuestaC = sc.nextLine().trim().toLowerCase();

            while (!respuestaC.equals("s") && !respuestaC.equals("n")) {
                System.out.print("ERROR: Ingrese una respuesta valida\n¿El cliente ya está registrado? (s/n): ");
                respuestaC = sc.nextLine().trim().toLowerCase();
            }
            if (respuestaC.equals("s")) {
                mostrarClientesRegistrados();

                System.out.println("\nSeleccione una opción:");

                System.out.println("1. Crear nuevo cliente");
                System.out.println("2. Seleccionar cliente existente");
                System.out.print("Opción: ");
                String opcionCliente = sc.nextLine().trim();

                switch (opcionCliente) {
                    case "1":
                        cliente = registrarNuevoClienteClase(sc);
                        break;
                    case "2":
                        System.out.print("Ingrese el código del Cliente: ");
                        int idCliente = Integer.parseInt(sc.nextLine());
                        cliente = buscarClientePorId(idCliente);
                        if (cliente == null) {
                            System.out.println(" Cliente no encontrado. No se puede continuar.");
                            return;
                        }
                        break;
                    default:
                        System.out.println(" Opción inválida. No se puede continuar.");
                        return;
                }

            } else {

                cliente = registrarNuevoClienteClase(sc);

            }
            reserva.setReservante(cliente);
            reserva.setRecepcionista(recepcionistaActivo);

            /**
             * Pedir datos de habitaciones
             */
            mostrarHabitacionesDisponibles();

            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear nueva habitación");
            System.out.println("2. Seleccionar habitación existente");
            System.out.print("Opción: ");
            String opcionHabitacion = sc.nextLine().trim();

            Habitaciones habit = null;

            switch (opcionHabitacion) {
                case "1":
                    habit = menuAgregarHabitacion(sc); // método que retorna una habitación creada
                    break;
                case "2":
                    //System.out.print("Ingrese el ID de la habitación: ");
                    // int idHabitacion = Integer.parseInt(sc.nextLine());
                    habit = seleccionarHabitacion(sc); // método que busca y retorna la habitación
                    if (habit == null) {
                        System.out.println(" Habitación no encontrada. No se puede continuar.");
                        return;
                    }
                    break;
                default:
                    System.out.println(" Opción inválida. No se puede continuar.");
                    return;
            }

            reserva.setSuite(habit);

            // Validación
            reserva.setEstadoReserva("VALIDA");
            String resultado = reserva.validarReserva();
            System.out.println("Resultado: " + resultado);

            // Persistencia simuladaINVALIDA
            if (resultado.equals("RESERVA VALIDA")) {
                System.out.println("Reserva lista para guardar en archivo.");
                // Aquí podrías llamar a guardarEnArchivo(reserva);
                reserva.crearReserva(reserva);
                System.out.println("-------------------------------");
                //Crear el mensaje
                System.out.println("Datos de la Reserva: " + reserva.toString());
                System.out.println("-------------------------------");
            } else {
                System.out.println("No se puede guardar la reserva. Datos incompletos.");
            }

        } catch (Exception e) {
            System.out.println("Error en el formato de fecha o entrada: " + e.getMessage());
        }

    }

    public static Habitaciones seleccionarHabitacion(Scanner sc) {
        System.out.print("Ingrese el ID de la habitación que desea reservar: ");
        int id = Integer.parseInt(sc.nextLine());

        try (BufferedReader br = new BufferedReader(new FileReader("habitaciones.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 6 && Integer.parseInt(partes[0].trim()) == id) {
                    String estado = partes[5].trim().toLowerCase();
                    if (estado.equals("disponible")) {
                        Habitaciones hab = new Habitaciones();
                        hab.setId(Integer.parseInt(partes[0]));
                        hab.setCapacidad(Integer.parseInt(partes[1]));
                        hab.setTipo(partes[2]);
                        hab.setNivel(Integer.parseInt(partes[3]));
                        hab.setPrecio(Float.parseFloat(partes[4]));
                        hab.setEstado(estado);
                        return hab;
                    } else {
                        System.out.println(" La habitación está ocupada.");
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(" Error al buscar habitación: " + e.getMessage());
        }

        System.out.println(" Habitación no encontrada.");
        return null;
    }

    public static void mostrarReservas() {
        System.out.println("\n=== Reservas Registradas ===");

        try (BufferedReader reader = new BufferedReader(new FileReader("reservas.txt"))) {
            String linea;
            int contador = 1;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 8) {
                    System.out.println(contador + ". "
                            + "ID: " + partes[0]
                            + " | Fecha Solicitud: " + partes[1]
                            + " | Entrada: " + partes[2]
                            + " | Salida: " + partes[3]
                            + " | Cliente: " + partes[4]
                            + " | Empleado: " + partes[5]
                            + " | Habitación Nivel: " + partes[6]
                            + " | Estado: " + partes[7]);
                    contador++;
                }
            }

            if (contador == 1) {
                System.out.println(" No hay reservas registradas.");
            }
        } catch (IOException e) {
            System.out.println(" Error al leer reservas: " + e.getMessage());
        }
    }

    public static int obtenerNuevoReservaId() {
        File archivo = new File("reservas.txt");
        int maxId = 0;

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                return 1; // Primer ID
            } catch (IOException e) {
                System.out.println(" Error al crear el archivo: " + e.getMessage());
                return 1; // Asignamos 1 por defecto
            }

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
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
            System.out.println(" No se pudo leer el archivo: " + e.getMessage());
        }

        return maxId + 1;
    }

// </editor-fold>
// <editor-fold desc="Habitaciones">
    public static void mostrarHabitacionesDisponibles() {
        try (BufferedReader br = new BufferedReader(new FileReader("habitaciones.txt"))) {
            String linea;
            System.out.println("\n Habitaciones disponibles:");
            boolean hayDisponibles = false;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 6 && partes[5].trim().equalsIgnoreCase("disponible")) {
                    hayDisponibles = true;
                    System.out.println("ID: " + partes[0] + ", Capacidad: " + partes[1]
                            + ", Tipo: " + partes[2] + ", Nivel: " + partes[3]
                            + ", Precio: $" + partes[4] + ", Estado: " + partes[5]);
                }
            }

            if (!hayDisponibles) {
                System.out.println(" No hay habitaciones disponibles.");
            }

        } catch (IOException e) {
            System.out.println(" Error al leer habitaciones: " + e.getMessage());
        }
    }

    public static Habitaciones menuAgregarHabitacion(Scanner sc) {
        Habitaciones nueva = new Habitaciones();
        Habitaciones habitCreada = nueva.agregarHabitacion();
        if (habitCreada != null) {
            nueva.guardarHabitacionEnArchivo(habitCreada);
            return habitCreada;
        } else {
            System.out.println(" No se pudo crear la habitación.");
            return null;
        }
    }

    public static boolean hayHabitacionesRegistradas() {
        File archivo = new File("habitaciones.txt");
        return archivo.exists() && archivo.length() > 0;
    }
    // </editor-fold>

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
            System.out.println(" Error al buscar cliente: " + e.getMessage());
        }
        return null;
    }

    public static Cliente buscarClientePorId(int idBuscado) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("clientes.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 7 && Integer.parseInt(partes[0].trim()) == idBuscado) {
                    Cliente cliente = new Cliente();
                    cliente.setId(Integer.parseInt(partes[0].trim()));
                    cliente.setNombre(partes[1]);
                    cliente.setApellido(partes[2]);
                    cliente.setTelefono(partes[3]);
                    cliente.setCorreo(partes[4]);
                    //cliente.setNickname(partes[5]);
                    //cliente.setClave(partes[6]);
                    cliente.setTarjeta(partes[5]);
                    cliente.setCodTarjeta(partes[6]);
                    cliente.setTipoCliente(partes[7]);
                    br.close();
                    return cliente;
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println(" Error al leer archivo de clientes: " + e.getMessage());
        }
        return null;
    }

    public static void registrarNuevoCliente(Scanner sc) {
        while (true) {
            Cliente cliente = new Cliente();

            int nuevoId = obtenerNuevoIdCliente(); // ID automático        
            cliente.setId(nuevoId);

            System.out.print("\n Nombre del cliente: ");
            cliente.setNombre(sc.nextLine());

            System.out.print("Apellido del cliente: ");
            cliente.setApellido(sc.nextLine());

            System.out.print("Teléfono: ");
            cliente.setTelefono(sc.nextLine());

            while (true) {
                System.out.print("Correo electrónico: ");
                cliente.setCorreo(sc.nextLine());

                if (!cliente.getCorreo().contains("@")) {
                    System.out.println("El correo, debe contener \"@\".");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print(" Número de tarjeta: ");
                cliente.setTarjeta(sc.nextLine());

                if (cliente.getNoTarjeta().length() != 16) {
                    System.out.println("El numero de tarjeta, debe tener al menos 16 caracteres");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print(" Codigo de tarjeta: ");
                cliente.setCodTarjeta(sc.nextLine());

                if (cliente.getCodTarjeta().length() != 3) {
                    System.out.println("El codigo de tarjeta, debe tener al menos 3 caracteres.");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print(" Tipo de cliente (Regular, VIP): ");
                cliente.setTipoCliente(sc.nextLine());

                if (!(cliente.getTipoCliente().toUpperCase()).equals("REGULAR") && !cliente.getTipoCliente().toUpperCase().equals("VIP")) {
                    System.out.println("Ingrese un tipo valido. Vuelva a ingresar.");
                } else {
                    break;
                }
            }

            cliente.crearClienteDesdeUsuario(cliente);

            System.out.println(" Cliente registrado exitosamente.");

            System.out.println("\n¿Desea registrar otro cliente? (s/n)");
            String resp = sc.nextLine().trim().toLowerCase();

            while (!resp.equals("s") && !resp.equals("n")) {
                System.out.println("Ingrese una respuesta valida. ");
                System.out.println("\n¿Desea registrar otro cliente? (s/n)");
                resp = sc.nextLine().trim().toLowerCase();
            }

            if (resp.equals("s")) {

            } else {
                System.out.println("Volviendo a menu...");
                break;
            }
        }
    }

    public static Cliente registrarNuevoClienteClase(Scanner sc) {
        while (true) {
            Cliente cliente = new Cliente();

            int nuevoId = obtenerNuevoIdCliente(); // ID automático        
            cliente.setId(nuevoId);

            System.out.print("\n Nombre del cliente: ");
            cliente.setNombre(sc.nextLine());

            System.out.print(" Apellido del cliente: ");
            cliente.setApellido(sc.nextLine());

            System.out.print(" Teléfono: ");
            cliente.setTelefono(sc.nextLine());

            while (true) {
                System.out.print("📧 Correo electrónico: ");
                cliente.setCorreo(sc.nextLine());

                if (!cliente.getCorreo().contains("@")) {
                    System.out.println("El correo, debe contener \"@\".");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print(" Número de tarjeta: ");
                cliente.setTarjeta(sc.nextLine());

                if (cliente.getNoTarjeta().length() != 16) {
                    System.out.println("El numero de tarjeta, debe tener al menos 16 caracteres");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print(" Codigo de tarjeta: ");
                cliente.setCodTarjeta(sc.nextLine());

                if (cliente.getCodTarjeta().length() != 3) {
                    System.out.println("El codigo de tarjeta, debe tener al menos 3 caracteres.");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print(" Tipo de cliente (Regular, VIP): ");
                cliente.setTipoCliente(sc.nextLine());

                if (!(cliente.getTipoCliente().toUpperCase()).equals("REGULAR") && !cliente.getTipoCliente().toUpperCase().equals("VIP")) {
                    System.out.println("Ingrese un tipo valido. Vuelva a ingresar.");
                } else {
                    break;
                }
            }

            cliente.crearClienteDesdeUsuario(cliente);

            System.out.println(" Cliente registrado exitosamente.");

            System.out.println("\n¿Desea registrar otro cliente? (s/n)");
            String resp = sc.nextLine().trim().toLowerCase();

            while (!resp.equals("s") && !resp.equals("n")) {
                System.out.println("Ingrese una respuesta valida. ");
                System.out.println("\n¿Desea registrar otro cliente? (s/n)");
                resp = sc.nextLine().trim().toLowerCase();
            }

            if (resp.equals("s")) {

            } else {
                System.out.println("Volviendo a menu...");
                return cliente;
            }

        }
    }

    public static void mostrarClientesRegistrados() {
        System.out.println("\n=== Clientes Registrados ===");

        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"))) {
            String linea;
            int contador = 1;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 8) {
                    System.out.println(contador + ". "
                            + "ID: " + partes[0]
                            + " | Nombre: " + partes[1] + " " + partes[2]
                            + " | Teléfono: " + partes[3]
                            + " | Correo: " + partes[4]
                            + " | NoTarjeta: " + partes[5]
                            + " | CodTarjeta: " + partes[6]
                            + " | TipoCliente: " + partes[7]);
                    contador++;
                }
            }

            if (contador == 1) {
                System.out.println(" No hay clientes registrados.");
            }
        } catch (IOException e) {
            System.out.println(" Error al leer clientes: " + e.getMessage());
        }
    }

    // </editor-fold>
// <editor-fold desc="Empleados">
    public static void crearEmpleado(Scanner sc) {
        Empleado empleado = new Empleado();
        System.out.println("\n=== INGRESE LOS DATOS DEL NUEVO EMPLEADO ===");

        int nuevoId = obtenerNuevoIdEmpleado(); // ID automático        

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

        System.out.print("Area: ");
        empleado.setArea(sc.nextLine());

        System.out.print("Puesto: ");
        empleado.setPuesto(sc.nextLine());

        empleado.crearEmpleadoDesdeUsuario(empleado);

        System.out.println(" Empleado registrado con ID: " + nuevoId);

    }

    public static int obtenerNuevoIdEmpleado() {
        File archivo = new File("empleados.txt");
        int maxId = 0;

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                return 1; // Primer ID
            } catch (IOException e) {
                System.out.println(" Error al crear el archivo: " + e.getMessage());
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
            System.out.println(" No se pudo leer el archivo: " + e.getMessage());
        }

        return maxId + 1;
    }

    public static int obtenerNuevoIdCliente() {
        File archivo = new File("clientes.txt");
        int maxId = 0;

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                return 1; // Primer ID
            } catch (IOException e) {
                System.out.println(" Error al crear el archivo: " + e.getMessage());
                return 1; // Asignamos 1 por defecto
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"))) {
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
            System.out.println(" No se pudo leer el archivo: " + e.getMessage());
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
                    emp.setId(Integer.parseInt(partes[0].replaceAll("[^\\d]", ""))); // 
                    emp.setNombre(partes[1].trim());
                    emp.setApellido(partes[2].trim());
                    //emp.setUsuario(usuario);
                    //emp.setContrasena(contrasena);
                    return emp;
                }
            }
        } catch (IOException e) {
            System.out.println(" Error al buscar cliente: " + e.getMessage());
        }
        return null;
    }

    public static Empleado iniciarSesion(Scanner scanner) {

        System.out.println("\n=== INICIO DE SESIO1N ===");

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

            System.out.println(" Credenciales incorrectas o empleado no encontrado.");
        } catch (IOException e) {
            System.out.println(" Error al leer el archivo: " + e.getMessage());
        }

        return null;
    }

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
                    crearReserva(scanner, empleadoActivo);
                    break;
                case "4":
                    mostrarReservas();
                    break;
                case "5":
                    continuar = false;
                    System.out.println(" Cerrando sesión...");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }
        }
    }

    public static Habitaciones menuHabitaciones(Scanner scanner) {
        Habitaciones habitaciones = new Habitaciones();
        boolean salir = false;
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar habitacion");
            System.out.println("2. Mostrar habitaciones");
            System.out.println("3. Buscar habitacion");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion < 1 && opcion > 4) {
                throw new IllegalArgumentException("Escoja una opcion valida.");
            }

            try {
                switch (opcion) {
                    case 1:
                        habitaciones.agregarHabitacion();
                        // Guardar en lista y archivo solo si todo es válido
                        Habitaciones hab = new Habitaciones(habitaciones.getId(), habitaciones.getCapacidad(),
                                habitaciones.getTipo(), habitaciones.getNivel(), habitaciones.getPrecio(),
                                habitaciones.getEstado());
                        habitaciones.guardarHabitacionEnArchivo(hab);
                        break;
                    case 2:
                        habitaciones.mostrarHabitaciones();
                        break;
                    case 3:
                        //  Buscar cliente existente
                        System.out.print("Ingrese el codigo de la habitacion: ");
                        String idHabitacion = scanner.nextLine();
                        System.out.print("Contraseña del cliente: ");
                        String nivel = scanner.nextLine();
                        //habitacion = buscarHabitaciones(cliente);

                        break;
                    case 4:
                        System.out.println("Regresando al registro de reserva...\n");
                        salir = true;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
                System.out.print("Vuelva a ingresar. ");
            }
        }
    }

    public Habitaciones buscarHabitacion(Habitaciones habi) {
        try (BufferedReader br = new BufferedReader(new FileReader("habitaciones.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                //String id = partes[0].trim();
                int id = Integer.parseInt(partes[0].trim());
                int nivel = Integer.parseInt(partes[3].trim());

                if (id == habi.getId()) {
                    Habitaciones habitacion = new Habitaciones();
                    habitacion.setId(id);
                    habitacion.setCapacidad(Integer.parseInt(partes[1].trim()));
                    habitacion.setTipo(partes[2].trim());
                    habitacion.setNivel(nivel);
                    habitacion.setPrecio(Float.parseFloat(partes[4].trim()));
                    habitacion.setEstado(partes[5].trim());

                    return habitacion;
                }
            }
        } catch (IOException e) {
            System.out.println(" Error al buscar habitacion: " + e.getMessage());
        }
        return null;
    }

}
