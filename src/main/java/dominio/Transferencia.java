/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class Transferencia {

    private Integer id_transferencia;
    private String fecha_hora;
    private Integer id_CuentaClienteOrigen;
    private Integer id_CuentaClienteDestino;
    private float saldo;

    public Transferencia() {
    }

    public Transferencia(Integer id_transferencia, String fecha_hora, Integer id_CuentaClienteOrigen, Integer id_CuentaClienteDestino) {
        this.id_transferencia = id_transferencia;
        this.fecha_hora = fecha_hora;
        this.id_CuentaClienteOrigen = id_CuentaClienteOrigen;
        this.id_CuentaClienteDestino = id_CuentaClienteDestino;
    }

    public Transferencia(String fecha_hora, Integer id_CuentaClienteOrigen, Integer id_CuentaClienteDestino, float saldo) {
        this.fecha_hora = fecha_hora;
        this.id_CuentaClienteOrigen = id_CuentaClienteOrigen;
        this.id_CuentaClienteDestino = id_CuentaClienteDestino;
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Integer getId_transferencia() {
        return id_transferencia;
    }

    public void setId_transferencia(Integer id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Integer getId_CuentaClienteOrigen() {
        return id_CuentaClienteOrigen;
    }

    public void setId_CuentaClienteOrigen(Integer id_CuentaClienteOrigen) {
        this.id_CuentaClienteOrigen = id_CuentaClienteOrigen;
    }

    public Integer getId_CuentaClienteDestino() {
        return id_CuentaClienteDestino;
    }

    public void setId_CuentaClienteDestino(Integer id_CuentaClienteDestino) {
        this.id_CuentaClienteDestino = id_CuentaClienteDestino;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "id_transferencia=" + id_transferencia + ", fecha_hora=" + fecha_hora + ", id_CuentaClienteOrigen=" + id_CuentaClienteOrigen + ", id_CuentaClienteDestino=" + id_CuentaClienteDestino + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id_transferencia);
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
        final Transferencia other = (Transferencia) obj;
        if (!Objects.equals(this.id_transferencia, other.id_transferencia)) {
            return false;
        }
        return true;
    }

}
