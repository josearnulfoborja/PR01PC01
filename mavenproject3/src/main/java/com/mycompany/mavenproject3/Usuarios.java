package com.mycompany.mavenproject3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author karen
 */
public class Usuarios {

    //======Variables
    private int id = 0;
    private String nombre = "SIN ESPECIFICAR";
    private String apellido = "SIN ESPECIFICAR";
    private String telefono = "SIN ESPECIFICAR";
    private String correo = "SIN ESPECIFICAR";
    private String nickname = "SIN ESPECIFICAR";
    private String clave = "SIN ESPECIFICAR";

    Scanner scanner = new Scanner(System.in);

    //======Constructores
    public Usuarios() {
    }

    public Usuarios(int id, String nombre, String apellido, String telefono, String correo, String nickname, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.nickname = nickname;
        this.clave = clave;
    }

    //======Metodos Getters y Setters con sus validaciones respectivas
    public int getId() {
        return id;
    }

    public void setId(int id) {
        while (true) {
            try {
                if (id <= 0) {
                    throw new IllegalArgumentException("El ID debe ser mayor que 0.");
                }
                this.id = id;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en el Id: " + e.getMessage());
                System.out.print("Vuelva a intentar. ID: ");
                id = scanner.nextInt();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        while (true) {
            try {
                nombre = nombre.trim();
                if (nombre.length() <= 3 || !nombre.matches("^[a-zA-Z]+$")) { //matches indica si ka cadena coincide o no con la expresión regular dada
                    throw new IllegalArgumentException("El nombre debe tener solo letras y al menos 3 caracteres.");
                }
                this.nombre = nombre;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en el Nombre: " + e.getMessage());
                System.out.print("Vuelva a intentar. Nombre: ");
                nombre = scanner.nextLine();
            }
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        while (true) {
            try {
                apellido = apellido.trim(); //trim elimina los espacios iniciales y finales de la cedena
                if (apellido.length() <= 1 || !apellido.matches("^[a-zA-Z]+$")) {
                    throw new IllegalArgumentException("El apellido debe tener solo letras y al menos 2 caracteres.");
                }
                this.apellido = apellido;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en el Apellido: " + e.getMessage());
                System.out.print("Vuelva a intentar. \nApellido: ");
                apellido=scanner.nextLine();
            }
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        while (true) {
            try {
                if (telefono == null || !telefono.matches("\\d{8}")) {
                    throw new IllegalArgumentException("El telefono debe tener exactamente 8 digitos.");
                }
                this.telefono = telefono;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en el Telefono: " + e.getMessage());
                System.out.print("Vuelva a intentar. Telefono: ");
                telefono=scanner.nextLine();
            }
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        while (true) {
            try {
                if (correo == null || !correo.contains("@") || correo.length() <= 4 ) {
                    throw new IllegalArgumentException("El correo debe contener '@' y minimo 5 caracteres.");
                }
                this.correo = correo;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en el Correo: " + e.getMessage());
                System.out.print("Vuelva a intentar. Correo: ");
                correo=scanner.nextLine();
            }
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        while (true) {
            try {
                nickname = nickname.trim();
                if (nickname.length() <= 4 || !nickname.matches("^[a-zA-Z0-9]+$")) {
                    throw new IllegalArgumentException("El nickname debe tener al menos 5 caracteres y solo letras/numeros.");
                }
                this.nickname = nickname;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en el Nickname: " + e.getMessage());
                System.out.print("Vuelva a intentar. Nickname: ");
                nickname=scanner.nextLine();
            }
        }
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        while (true) {
            try {
                String regex = "^(?=.*[A-Za-z])(?=.*[^A-Za-z0-9]).{9,}$";
                if (!clave.matches(regex)) {
                    throw new IllegalArgumentException("La clave debe tener al menos 9 caracteres, una letra y un caracter especial.");
                }
                this.clave = clave;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la Clave: " + e.getMessage());
                System.out.print("Vuelva a intentar. Clave: ");
                clave=scanner.nextLine();
            }
        }
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    //======Método toString para mostrar información
    @Override
    public String toString() {
        return "Usuario {"
                + "ID=" + id
                + ", Nombre='" + nombre + " " + apellido + '\''
                + ", Teléfono='" + telefono + '\''
                + ", Correo='" + correo + '\''
                + ", Nickname='" + nickname + '\''
                + '}';
    }

    // Método para validar login
    /*
    public boolean login(String usuarioIngresado, String claveIngresada) {
        return this.nickname.equals(usuarioIngresado) && this.clave.equals(claveIngresada);
    }
     */
 /*  
     public static Empleado loginDesdeArchivo(String usuarioIngresado, String claveIngresada) {
        try (BufferedReader br = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String usuario = datos[1];
                String clave = datos[2];

                if (usuario.equals(usuarioIngresado) && clave.equals(claveIngresada)) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[3];
                    String apellido = datos[4];
                    String area = datos[5];
                    String puesto = datos[6];

                    // Crear y devolver el Empleado logueado
                    return new Empleado(id, usuario, clave, nombre, apellido, area, puesto);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
        return null; // No se encontró
    }
     */
    // Método estático para crear usuario desde consola
    public static Usuarios crearUsuarioDesdeInput(Scanner scanner) {
        System.out.println("\n=== Registro de Usuario ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();

        System.out.print("Telefono: ");
        String telefono = scanner.nextLine().trim();

        System.out.print("Correo: ");
        String correo = scanner.nextLine().trim();

        System.out.print("Nickname: ");
        String nickName = scanner.nextLine().trim();

        System.out.print("Clave: ");
        String clave = scanner.nextLine().trim();

        int nuevoId = generarNuevoId(); // Método que busca el último ID en el archivo

        Usuarios nuevoUsuario = new Usuarios(nuevoId, nombre, apellido, telefono, correo, nickName, clave);
        guardarUsuarioEnArchivo(nuevoUsuario);
        return nuevoUsuario;
    }

    private static void guardarUsuarioEnArchivo(Usuarios usuario) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("usuarios.txt", true)))) {
            out.println(usuario.toLineaTXT());
            System.out.println("Usuario guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
        }
    }

    public String toLineaTXT() {
        return id + "," + nombre + "," + apellido + "," + telefono + "," + correo + "," + nickname + "," + clave;
    }

    private static int generarNuevoId() {
        // Lógica para leer el archivo y obtener el último ID + 1
        // Puedes implementarla luego si quieres que te ayude
        return (int) (Math.random() * 10000); // Temporal
    }

}
