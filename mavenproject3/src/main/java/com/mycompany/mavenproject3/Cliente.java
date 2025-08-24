package com.mycompany.mavenproject3;

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
}
