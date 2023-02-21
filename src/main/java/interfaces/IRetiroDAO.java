/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Retiro;
import excepciones.PersistenciaException;

/**
 * Interfaz para la creacion de los metodos a impletentar en la clase de IRetiroDAO.
 * @author Daniel & David
 */
public interface IRetiroDAO {

    /**
     * Metodo de interfaz para hacer un insert a un retiro sin cuenta.
     * @param retiro retiro
     * @throws PersistenciaException 
     */
    void insertar(Retiro retiro) throws PersistenciaException;

<<<<<<< HEAD
    void actualizar(int folio, int contraseña) throws PersistenciaException;

=======
    /**
     * Consullta con el folio (llave principal)
     * @param folio llave principal
     * @return 
     */
>>>>>>> 35a29362355b18926e3e499b5a5bb1ce604d8c15
    Retiro consultar(Integer folio);

}
