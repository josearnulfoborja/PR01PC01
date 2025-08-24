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
    
    //======Metodos Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0){
           this.id = id; 
        }else{
            System.out.println("El ID debe ser mayor que 0");
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String regex = ".*[^a-zA-Z].*";
        nombre=nombre.trim();
        if(nombre.matches(regex)){
            this.nombre = "Nombre inválido";
        }else if(nombre.length()<=1){
            this.nombre = "Nombre inválido";
        }else{
            this.nombre = nombre;
        }        
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String regex = ".*[^a-zA-Z].*";
        apellido=apellido.trim();
        if(apellido.matches(regex)){
            this.apellido = "Apellido inválido";
        }else if(apellido.length()<=1){
            this.apellido = "Apellido inválido";
        }else{
            this.apellido = apellido;
        } 
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("\\d{8}")) { 
            this.telefono = telefono;
        } else {
            System.out.println("El teléfono debe tener 8 dígitos, sin guion.");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo != null && correo.contains("@")) {
            this.correo = correo;
        } else {
            System.out.println("Correo inválido.");
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        String regex = ".*[^a-zA-Z0-9].*";
        nickname=nickname.trim();
        if(nickname.matches(regex)){
            this.nickname = "nickname invalido";
        }else if(nickname.length()<=4){
            this.nickname = "nickname invalido";
        }else{
            this.nickname = nickname;
        }
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        String regex ="^(?=.*[A-Za-z])(?=.*[^A-Za-z0-9]).{9,}$";
        
        if (clave.matches(regex)){
            this.clave = clave;
        }else{
            this.clave = "Clave invalida";
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
