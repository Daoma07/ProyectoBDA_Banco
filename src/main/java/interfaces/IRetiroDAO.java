/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Retiro;
import excepciones.PersistenciaException;

/**
 *
 * @author HP
 */
public interface IRetiroDAO {

    void insertar(Retiro retiro) throws PersistenciaException;

    void actualizar(int folio, int contraseña) throws PersistenciaException;

    Retiro consultar(Integer folio);

}
