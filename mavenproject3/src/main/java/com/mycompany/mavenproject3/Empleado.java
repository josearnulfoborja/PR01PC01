/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

/**
 *
 * @author User
 */
public class Empleado extends Usuarios {
    private String Area ="SIN ESPECIFICAR";
    private String Puesto  = "SIN ESPECIFICAR";

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, String telefono, String correo, String nickname, String clave, String Area, String Puesto) {
        super(id, nombre, apellido, telefono, correo, nickname, clave);
        this.Area = Area;
        this.Puesto =  Puesto;
    }    
    
    public void setArea(String Area) {
        this.Area = Area;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }
    public String getArea() {
        return Area;
    }

    public String getPuesto() {
        return Puesto;
    }
}
