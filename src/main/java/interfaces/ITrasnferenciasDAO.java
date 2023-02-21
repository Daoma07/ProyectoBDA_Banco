/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Transferencia;
import excepciones.PersistenciaException;
/**
 * Interfaz para la creacion de los metodos a impletentar en la clase de ITrasnferenciasDAO.
 * @author Daniel & David
 */
public interface ITrasnferenciasDAO {

    void insertar(Transferencia transferencia) throws PersistenciaException;
    /**
     * Metodo de interfaz para consultar la transferencia de algun cliente.
     * @param id_transferencia
     * @return 
     */
    Transferencia consultar(Integer id_transferencia);

}
