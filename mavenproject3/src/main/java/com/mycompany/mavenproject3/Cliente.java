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

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, String telefono, String correo, String nickname, String clave,String noTarjeta, String tipoCliente, String codTarjeta) {
        super(id, nombre, apellido, telefono, correo, nickname, clave);
        this.noTarjeta = noTarjeta;
        this.tipoCliente = tipoCliente;
        this.codTarjeta = codTarjeta;    
    }
    
     public static Cliente crearClienteDesdeUsuario(Usuarios usuario, Scanner scanner) {
        System.out.println("\n=== Datos del Cliente ===");

        System.out.print("Número de tarjeta: ");
        String noTarjeta = scanner.nextLine();

        System.out.print("Tipo de cliente: ");
        String tipoCliente = scanner.nextLine();

        System.out.print("Código de tarjeta: ");
        String codTarjeta = scanner.nextLine();

        Cliente cliente = new Cliente(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getTelefono(),
                                      usuario.getCorreo(), usuario.getNickname(), usuario.getClave(),
                                      noTarjeta, tipoCliente, codTarjeta);
        guardarCliente(cliente);
        return cliente;
    }

    private static void guardarCliente(Cliente cliente) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clientes.txt", true)))) {
            out.println(cliente.getNickname() + "," + cliente.noTarjeta + "," + cliente.getTipoCliente() + "," + cliente.getNoTarjeta());
        } catch (IOException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }
    }

    
}
