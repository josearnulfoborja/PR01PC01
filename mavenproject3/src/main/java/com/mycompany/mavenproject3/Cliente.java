package com.mycompany.mavenproject3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cliente extends Usuarios {

    private String noTarjeta="SIN ESPECIFICAR", tipoCliente="SIN ESPECIFICAR", codTarjeta="SIN ESPECIFICAR";

    public void setTarjeta(String noTarjeta) {
        this.noTarjeta = noTarjeta;
    }

    public String getNoTarjeta() {
        return noTarjeta;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public String getCodTarjeta() {
        return codTarjeta;
    }
    

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, String telefono, String correo, String nickname, String clave,String noTarjeta, String tipoCliente, String codTarjeta) {
        super(id, nombre, apellido, telefono, correo, nickname, clave);
        this.noTarjeta = noTarjeta;
        this.tipoCliente = tipoCliente;
        this.codTarjeta = codTarjeta;    
    }
    
     public Cliente crearClienteDesdeUsuario(Cliente usuario) {       
        Cliente cliente = new Cliente(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getTelefono(),
                                      usuario.getCorreo(), usuario.getNickname(), usuario.getClave(),
                                     usuario.getNoTarjeta(),usuario.getCodTarjeta(),usuario.getTipoCliente());
        guardarCliente(cliente);
        return cliente;
    }

    
    public static void guardarCliente(Cliente e) {
        try (FileWriter writer = new FileWriter("clientes.txt", true)) {
               String linea = e.getId() + "," +
                       e.getNombre() + "," +
                       e.getApellido() + "," +
                       e.getTelefono() + "," +
                       e.getCorreo() + "," +                      
                       e.getNoTarjeta() + "," +
                       e.getTipoCliente() + "," +
                       e.getCodTarjeta();               
        writer.write(linea + "\n");            
        
        System.out.println("Cliente guardado exitosamente.");
        } catch (IOException ex) {
            System.out.println("Error al guardar el cliente: " + ex.getMessage());
        }
    }

    
}
