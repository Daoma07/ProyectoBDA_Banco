/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import java.util.Objects;

/**
 * Clase de dominio cuenta donde se establecen valores de la cuenta  y se recuperan los mismos.
 * @author Daniel & David
 */
public class Cuenta {

    private Integer numero_cuenta;
    private String fecha_apertura;
    private float saldo;
    private String estado;
    private Integer id_cliente;

    /**
     * Constructor de la cuenta por default
     */
    public Cuenta() {
    }

    /**
     * Constructor con identificador de la cuenta del cliente.
     * @param numero_cuenta Numero de cuenta del cliente (llave primaria).
     * @param fecha_apertura Fecha de la apertura de la cuenta del cliente.
     * @param saldo Saldo total de la cuenta del cliente.
     * @param estado Estado de la cuenta del cliente (inactivo o inactivo).
     * @param id_cliente Identificador del dueño del cliente (llave foranea).
     */
    public Cuenta(Integer numero_cuenta, String fecha_apertura, float saldo, String estado, Integer id_cliente) {
        this.numero_cuenta = numero_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    /**
     * Constructor del cliente.
     * @param fecha_apertura Fecha de la apertura de la cuenta del cliente.
     * @param saldo Saldo total de la cuenta del cliente.
     * @param estado Estado de la cuenta del cliente (inactivo o inactivo).
     * @param id_cliente Identificador del dueño del cliente (llave foranea).
     */
    public Cuenta(String fecha_apertura, float saldo, String estado, Integer id_cliente) {
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    public Integer getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(Integer numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numero_cuenta=" + numero_cuenta + ", fecha_apertura=" + fecha_apertura + ", saldo=" + saldo + ", estado=" + estado + ", id_cliente=" + id_cliente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.numero_cuenta);
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
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.numero_cuenta, other.numero_cuenta)) {
            return false;
        }
        return true;
    }

}
