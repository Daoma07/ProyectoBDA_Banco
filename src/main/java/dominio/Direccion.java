/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Objects;

/**
 * Clase de dominio direccion donde se establecen valores de la direccion y se recuperan los mismos.
 * @author Daniel & David
 */
public class Direccion {

    private Integer id_direccion;
    private String calle;
    private String numero;
    private String colonia;

    /**
     * Constructor de la direccion por default.
     */
    public Direccion() {
    }

    /**
     * Constructor con identificador de la direccion
     * @param id_direccion Identificador de la direccion del cliente (llave primaria).
     * @param calle Nombre de la calle del cliente.
     * @param numero Numero de casa del cliente.
     * @param colonia Colonia de la zona de la vivienda del cliente.
     */
    public Direccion(Integer id_direccion, String calle, String numero, String colonia) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

    /**
     * Constructor de la direccion.
     * @param calle Nombre de la calle del cliente.
     * @param numero Numero de casa del cliente.
     * @param colonia Colonia de la zona de la vivienda del cliente.
     */
    public Direccion(String calle, String numero, String colonia) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }


    public Integer getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Integer id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Override
    public String toString() {
        return "Direccion{" + "id_direccion=" + id_direccion + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id_direccion);
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
        final Direccion other = (Direccion) obj;
        if (!Objects.equals(this.id_direccion, other.id_direccion)) {
            return false;
        }
        return true;
    }

}
