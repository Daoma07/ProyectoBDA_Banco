/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionesBD;

import dominio.*;
import excepciones.PersistenciaException;
import implementaciones.*;
import interfaces.*;
import java.util.List;
import javax.swing.JOptionPane;
import presentacion.*;

/**
 *
 * @author HP
 */
public class Conexion {

    IConexionBD manejadorConexiones = new ConexionBD(
            "jdbc:mysql://localhost/banco_1pm",
            "root",
            "david");

    public Cliente clienteID(int idCliente) {
        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
        return clientesDAO.consultar(idCliente);
    }

    public void ingresarTranferencia(Transferencia transferencia) throws PersistenciaException {
        ITrasnferenciasDAO transferenciaDAO = new TransferenciaDAO(manejadorConexiones);
        transferenciaDAO.insertar(transferencia);
    }

    public void cuentaLista(Cliente cliente) throws PersistenciaException {
        ICuentasDAO cuentasDAO = new CuentasDAO(manejadorConexiones);
        List<Cuenta> cuentas = cuentasDAO.consultarCuentas(cliente.getId_cliente());
        new GenerarTransferencia(cliente, cuentas).setVisible(true);
    }

    public List<Cuenta> generarListaCuentas(Cliente cliente) throws PersistenciaException {
        ICuentasDAO cuentasDAO = new CuentasDAO(manejadorConexiones);
        List<Cuenta> cuentas = cuentasDAO.consultarCuentas(cliente.getId_cliente());
        return cuentas;
    }

    public void generarPresentacionesRegistroCliente() {
        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
        IDireccionDAO direccionesDAO = new DireccionDAO(manejadorConexiones);
        new RegistroCliente(clientesDAO, direccionesDAO).setVisible(true);
    }

    public ICuentasDAO generarPresentacionesRegistrarCuenta() {
        ICuentasDAO cuentasDAO = new CuentasDAO(manejadorConexiones);

        return new CuentasDAO(manejadorConexiones);

    }

    public void tablaCientesSesion() throws PersistenciaException {
        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
        new BuscarClienteSesion(clientesDAO).setVisible(true);
    }

    public void generarPresentacionPaginaPrincipal(Cliente cliente) {
        new PaginaPrincipal(cliente).setVisible(true);
    }
}
