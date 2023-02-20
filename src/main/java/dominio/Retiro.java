/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Objects;

/**
 * Clase de dominio retiro donde se establecen valores del retiro  y se recuperan los mismos.
 * @author Daniel & David
 */
public class Retiro {

    private Integer folio;
    private String contraseña;
    private String estado;
    private String fecha_hora;
    private Integer numero_cuenta;
    private Float saldo;

    /**
     * Constructor del retiro por default.
     */
    public Retiro() {
    }

    /**
     * Constructor del retiro con el folio de retiro.
     * @param folio folio del retiro (llave principal).
     * @param contraseña contraseña del retiro (cifrada).
     * @param estado estado del retiro (activo o inactivo).
     * @param fecha_hora Fecha y hora del retiro en el cual se hizo el retiro.
     * @param numero_cuenta numero de cuenta del retiro (llave foranea de cuenta).
     */
    public Retiro(Integer folio, String contraseña, String estado, String fecha_hora, Integer numero_cuenta) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
        this.fecha_hora = fecha_hora;
        this.numero_cuenta = numero_cuenta;
    }

    /**
     * Constructor del retiro.
     * @param contraseña contraseña del retiro (cifrada).
     * @param estado estado del retiro (activo o inactivo).
     * @param fecha_hora Fecha y hora del retiro en el cual se hizo el retiro.
     * @param numero_cuenta numero de cuenta del retiro (llave foranea de cuenta).
     */
    public Retiro(String contraseña, String estado, String fecha_hora, Integer numero_cuenta, float saldo) {
        this.contraseña = contraseña;
        this.estado = estado;
        this.fecha_hora = fecha_hora;
        this.numero_cuenta = numero_cuenta;
        this.saldo=saldo;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
    

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Integer getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(Integer numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    @Override
    public String toString() {
        return "Retiro{" + "folio=" + folio + ", contrase\u00f1a=" + contraseña + ", estado=" + estado + ", fecha_hora=" + fecha_hora + ", numero_cuenta=" + numero_cuenta + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.folio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Retiro other = (Retiro) obj;
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        return true;
    }

}
