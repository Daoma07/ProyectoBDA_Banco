/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cuenta;
import java.util.List;
import excepciones.PersistenciaException;

/**
 * Interfaz para la creacion de los metodos a impletentar en la clase de ICuentasDAO.
 * @author Daniel & David
 */
public interface ICuentasDAO {

    Cuenta insertar(Cuenta cuenta) throws PersistenciaException;

    /**
     * Metodo de interfaz para hacer una actualizacion del saldo.
     * @param numero_cuenta numero de cuenta
     * @return 
     */
    Cuenta actualizarSaldo(Cuenta numero_cuenta);

    /**
     * Metodo de interfaz para cancelar la cuenta del cliente.
     * @param numero_cuenta Numero de cuenta.
     * @return 
     */
    Cuenta cancelarCuenta(Cuenta numero_cuenta);

    List<Cuenta> consultarCuentas(int id_cliente) throws PersistenciaException;

}
