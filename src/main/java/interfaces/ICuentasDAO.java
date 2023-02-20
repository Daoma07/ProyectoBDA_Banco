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
 *
 * @author HP
 */
public interface ICuentasDAO {

    Cuenta insertar(Cuenta cuenta) throws PersistenciaException;

    /**
     * Deposito asi mismo
     */
    Cuenta actualizarSaldo(Cuenta numero_cuenta);

    Cuenta cancelarCuenta(Cuenta numero_cuenta);

    List<Cuenta> consultarCuentas(int id_cliente) throws PersistenciaException;

}
