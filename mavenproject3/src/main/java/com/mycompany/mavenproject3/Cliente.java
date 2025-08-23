package com.mycompany.mavenproject3;

public class Cliente extends Usuarios {

    private String noTarjeta, tipoCliente, codTarjeta;

    public void setNoTarjeta(String noTarjeta) {
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

    public String getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }
}
