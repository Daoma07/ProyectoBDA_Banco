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
public class Direccion {

    private Integer id_direccion;
    private String calle;
    private String numero;
    private String colonia;

    public Direccion() {
    }

    public Direccion(Integer id_direccion, String calle, String numero, String colonia) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

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
