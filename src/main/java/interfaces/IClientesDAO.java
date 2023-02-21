/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 * Interfaz para la creacion de los metodos a impletentar en la clase de clienteDAO.
 * @author Daniel & David
 */
public interface IClientesDAO {

    /**
     * Metodo interfaz para insertar un cliente.
     * @param cliente objeto de cliente.
     * @return
     * @throws PersistenciaException 
     */
    Cliente insertar(Cliente cliente) throws PersistenciaException;

    /**
     * Metodo interfaz para actualizar un cliente.
     * @param id_cliente llave primaria de cliente.
     * @return 
     */
    Cliente actualizar(Integer id_cliente);

    /**
     * Metodo interfaz para consultar un cliente.
     * @param id_cliente llave primaria de cliente.
     * @return 
     */
    Cliente consultar(Integer id_cliente);

    /**
     * Metodo interfaz para consultar un cliente.
     * @param configPaginado la confiaguraciion del paginado
     * @return
     * @throws PersistenciaException 
     */
    List<Cliente> consultarClientes(ConfiguracionPaginado configPaginado) throws PersistenciaException;

}
