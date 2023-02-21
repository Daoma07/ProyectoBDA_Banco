/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Objects;

/**
 * Clase de dominio transferencia donde se establecen valores de la transferencia y se recuperan los mismos.
 * @author Daniel & David
 */
public class Transferencia {
    //Atributos
    private Integer id_transferencia;
    private String fecha_hora;
    private Integer id_CuentaClienteOrigen;
    private Integer id_CuentaClienteDestino;
    private float saldo;

    /**
     * Constructor de la transferencia por default.
     */
    public Transferencia() {
    }

    /**
     * Constructor de la tranferencia con el identificador de tranferencia.
     * @param id_transferencia Identificador de la transferencia (llave primaria).
     * @param fecha_hora Fecha y hora de cuando se hizo la transferencia.
     * @param id_CuentaClienteOrigen Identificador de la cuenta del cliente de donde se hizo el retiro (llave foranea).
     * @param id_CuentaClienteDestino Identificador de la cuenta del cliente a donde se reflejara el saldo a favor (llave foranea).
     */
    public Transferencia(Integer id_transferencia, String fecha_hora, Integer id_CuentaClienteOrigen, Integer id_CuentaClienteDestino) {
        this.id_transferencia = id_transferencia;
        this.fecha_hora = fecha_hora;
        this.id_CuentaClienteOrigen = id_CuentaClienteOrigen;
        this.id_CuentaClienteDestino = id_CuentaClienteDestino;
    }

    /**
     * Constructor de la transferencia.
     * @param fecha_hora Fecha y hora de cuando se hizo la transferencia.
     * @param id_CuentaClienteOrigen Identificador de la cuenta del cliente de donde se hizo el retiro (llave foranea).
     * @param id_CuentaClienteDestino Identificador de la cuenta del cliente a donde se reflejara el saldo a favor (llave foranea).
     * @param saldo Dinero a transferir.
     */
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

    /**
     * toString de la clase trasnferencia donde en un string se imprimen los datos
     * @return String de datos
     */
    @Override
    public String toString() {
        return "Transferencia{" + "id_transferencia=" + id_transferencia + ", fecha_hora=" + fecha_hora + ", id_CuentaClienteOrigen=" + id_CuentaClienteOrigen + ", id_CuentaClienteDestino=" + id_CuentaClienteDestino + '}';
    }

    /**
     * Se utiliza para obtener un valor entero único que representa el objeto actual.
     * @return retorna el hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id_transferencia);
        return hash;
    }

    /**
     * Se utiliza para comparar dos objetos de esa clase en función de su contenido o estado
     * @param obj objeto
     * @return retorna verdadero
     */
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
