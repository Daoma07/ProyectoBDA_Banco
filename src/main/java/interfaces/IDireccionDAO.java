/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Direccion;

/**
 * Interfaz para la creacion de los metodos a impletentar en la clase de IDireccionDAO.
 * @author Daniel & David
 */
public interface IDireccionDAO {

    /**
     * Metodo de interfaz para hacer una insert en la clase de direccion del cliente.
     * @param direccion Objeto de direccion.
     * @return
     * @throws excepciones.PersistenciaException 
     */
    Direccion insertar(Direccion direccion) throws excepciones.PersistenciaException;

    /**
     * Metodo de interfaz para hacer una actualizacion en la clase de direccion del cliente.
     * @param id_direccion llave principal
     * @param direccionNueva direccion nueva
     * @return
     * @throws excepciones.PersistenciaException Error
     */
    Direccion actualizar(Integer id_direccion, Direccion direccionNueva) throws excepciones.PersistenciaException;

    /**
     * Metodo de interfaz para hacer una consulta en la clase de direccion del cliente.
     * @param id_direccion llave principal
     * @return
     * @throws excepciones.PersistenciaException 
     */
    Direccion consultar(Integer id_direccion) throws excepciones.PersistenciaException;

}
