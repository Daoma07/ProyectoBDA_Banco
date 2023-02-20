/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import java.util.Objects;

/**
 * Clase de dominio cliente donde se establecen valores del cliente y se recuperan los mismos.
 * @author Daniel & David
 */
public class Cliente {

    private Integer id_cliente;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_nacimineto;
    private Integer id_direccion;
    private Direccion direccion;
    

    public Cliente() {
    }

    /**
     * Constructor para un cliente.
     * @param id_cliente Identificador del cliente (llave primaria).
     * @param nombre Nombre del cliente.
     * @param apellido_paterno Apellido paterno del cliente.
     * @param apellido_materno Apellido materno del cliente.
     * @param fecha_nacimineto Fecha de nacimiento del cliente.
     * @param id_direccion Identificador de la direccion del cliente (llave foranea).
     */
    public Cliente(Integer id_cliente, String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimineto, Integer id_direccion) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimineto = fecha_nacimineto;
        this.id_direccion = id_direccion;
    }

    /**
     * Constructor de el cliente.
     * @param nombre Nombre del cliente.
     * @param apellido_paterno Apellido paterno del cliente.
     * @param apellido_materno Apellido materno del cliente.
     * @param fecha_nacimineto Fecha de nacimiento del cliente.
     * @param id_direccion Identificador de la direccion del cliente (llave foranea).
     */
    public Cliente(String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimineto, Integer id_direccion) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimineto = fecha_nacimineto;
        this.id_direccion = id_direccion;
    }

    /**
     * Constructor del cliente sin necesidad de una direccion.
     * @param nombre Nombre del cliente.
     * @param apellido_paterno Apellido paterno del cliente.
     * @param apellido_materno Apellido materno del cliente.
     * @param fecha_nacimineto Fecha de nacimiento del cliente.
     */
    public Cliente(String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimineto) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimineto = fecha_nacimineto;
    }


    public Cliente(Direccion direccion) {
        this.direccion = direccion;
    }

    public Cliente(int id) {
        this.id_cliente=id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que Obtiene el id del cliente.
     *
     * @return retorna del id del cliente.
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     * Metodo que Setea el id del cliente.
     *
     * @param id_cliente
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Metodo que Obtiene el nombre del cliente.
     *
     * @return retornal el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que setea el nombre del cliente.
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el apellido paterno del cliente.
     *
     * @return retorna el apellido paterno del cliente.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Metodo que setea el apellido paterno del cliente.
     *
     * @param apellido_paterno
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Metodo que obtiene el apellido materno del cliente.
     *
     * @return retorna el apellido materno del cliente.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Metodo que setea el apellido materno del cliente
     *
     * @param apellido_materno
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Metodo que se encarga de obtiener la fecha del nacimiento del cliente.
     *
     * @return retornal la fecha de nacimiento del cliente
     */
    public String getFecha_nacimineto() {
        return fecha_nacimineto;
    }

    /**
     * Metodo que se encarga de setear la fecha de nacimiento del cliente.
     *
     * @param fecha_nacimineto
     */
    public void setFecha_nacimineto(String fecha_nacimineto) {
        this.fecha_nacimineto = fecha_nacimineto;
    }

    /**
     * Metodo que se encarga de obtiener el id de la tabla de direccion del
     * cliente
     *
     * @return retorna el id de la direccion del cleinte
     */
    public Integer getId_direccion() {
        return id_direccion;
    }

    /**
     * Metodo que se encarga de setear el id de la direccion del cliente.
     *
     * @param id_direccion
     */
    public void setId_direccion(Integer id_direccion) {
        this.id_direccion = id_direccion;
    }

    /**
     * Metodo toString por default del cliente.
     *
     * @return retorna un String con la informacion del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", fecha_nacimineto=" + fecha_nacimineto + ", id_direccion=" + id_direccion + '}';
    }

    /**
     * Metodo que recupera el hash Code asignado
     *
     * @return retorna el hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id_cliente);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id_cliente, other.id_cliente)) {
            return false;
        }
        return true;
    }

}
