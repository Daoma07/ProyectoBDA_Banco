/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Transferencia;
import excepciones.PersistenciaException;
/**
 *
 * @author HP
 */
public interface ITrasnferenciasDAO {

    void insertar(Transferencia transferencia) throws PersistenciaException;

    Transferencia consultar(Integer id_transferencia);

}
