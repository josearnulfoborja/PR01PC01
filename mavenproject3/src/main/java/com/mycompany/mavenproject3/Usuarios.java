package com.mycompany.mavenproject3;

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

    public void setId(int id){
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("El ID debe ser mayor que 0.");
            }
            this.id = id;
        } catch (IllegalArgumentException e){
            System.out.println("Error en el Id: " + e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        try {
            nombre = nombre.trim();
            if (nombre.length() <= 3 || !nombre.matches("^[a-zA-Z]+$")){ //matches indica si ka cadena coincide o no con la expresión regular dada
                throw new IllegalArgumentException("El nombre debe tener solo letras y al menos 3 caracteres.");
            }
            this.nombre = nombre;
        } catch (IllegalArgumentException e){
            System.out.println("Error en el Nombre: " + e.getMessage());
        }    
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido){
        try {
            apellido = apellido.trim(); //trim elimina los espacios iniciales y finales de la cedena
            if (apellido.length() <= 1 || !apellido.matches("^[a-zA-Z]+$")){
                throw new IllegalArgumentException("El apellido debe tener solo letras y al menos 2 caracteres.");
            }
            this.apellido = apellido;
        } catch (IllegalArgumentException e){
            System.out.println("Error en el Apellido: " + e.getMessage());
        } 
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono){
        try {
            if (telefono == null || !telefono.matches("\\d{8}")){
                throw new IllegalArgumentException("El teléfono debe tener exactamente 8 dígitos.");
            }
            this.telefono = telefono;
        } catch (IllegalArgumentException e){
            System.out.println("Error en el Teléfono: " + e.getMessage());
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        try {
            if (correo == null || !correo.contains("@")){
                throw new IllegalArgumentException("El correo debe contener '@'.");
            }
            this.correo = correo;
        } catch (IllegalArgumentException e){
            System.out.println("Error en el Correo: " + e.getMessage());
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        try {
            nickname = nickname.trim();
            if (nickname.length() <= 4 || !nickname.matches("^[a-zA-Z0-9]+$")){
                throw new IllegalArgumentException("El nickname debe tener al menos 5 caracteres y solo letras/números.");
            }
            this.nickname = nickname;
        } catch (IllegalArgumentException e){
            System.out.println("Error en el Nickname: " + e.getMessage());
        }
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave){
        try {
            String regex = "^(?=.*[A-Za-z])(?=.*[^A-Za-z0-9]).{9,}$";
            if (!clave.matches(regex)) {
                throw new IllegalArgumentException("La clave debe tener al menos 9 caracteres, una letra y un carácter especial.");
            }
            this.clave = clave;
        } catch (IllegalArgumentException e){
            System.out.println("Error en la Clave: " + e.getMessage());
        }

    }
        
    //======Método toString para mostrar información
    @Override
    public String toString() {
        return "Usuario {" +
                "ID=" + id +
                ", Nombre='" + nombre + " " + apellido + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Correo='" + correo + '\'' +
                ", Nickname='" + nickname + '\'' +
                '}';
    }
    
}
