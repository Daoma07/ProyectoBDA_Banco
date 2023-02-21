/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionesBD;
//Imports
import dominio.*;
import excepciones.PersistenciaException;
import implementaciones.*;
import interfaces.*;
import java.util.List;
import javax.swing.JOptionPane;
import presentacion.*;

/**
 * Clase manejadora de la conexion a la base de datos MySql.
 * @author Daniel & David
 */
public class Conexion {
    
    //Se crea la conexion a la base de datos con usuario y contrasena
    IConexionBD manejadorConexiones = new ConexionBD(
            "jdbc:mysql://localhost/banco_1pm",
            "root",
            "daniel2002");
    
    /**
     * 
     * @param idCliente
     * @return 
     */
    public Cliente clienteID(int idCliente) {
        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
        return clientesDAO.consultar(idCliente);
    }

    /**
     * 
     * @param transferencia
     * @throws PersistenciaException 
     */
    public void ingresarTranferencia(Transferencia transferencia) throws PersistenciaException {
        ITrasnferenciasDAO transferenciaDAO = new TransferenciaDAO(manejadorConexiones);
        transferenciaDAO.insertar(transferencia);
    }



    /**
     * 
     * @param retiro
     * @throws PersistenciaException 
     */

    public void ingresarRetiro(Retiro retiro) throws PersistenciaException {
        IRetiroDAO retiroDAO = new RetiroDAO(manejadorConexiones);
        retiroDAO.insertar(retiro);
    }

    /**
     * 
     * @param cliente
     * @throws PersistenciaException 
     */
    public void cuentaListaTransferencia(Cliente cliente) throws PersistenciaException {
        ICuentasDAO cuentasDAO = new CuentasDAO(manejadorConexiones);
        List<Cuenta> cuentas = cuentasDAO.consultarCuentas(cliente.getId_cliente());
        new GenerarTransferencia(cliente, cuentas).setVisible(true);
    }




   
    /**
     * 
     * @param cliente
     * @throws PersistenciaException 
     */
     public void cuentaListaRetiro(Cliente cliente) throws PersistenciaException {

        ICuentasDAO cuentasDAO = new CuentasDAO(manejadorConexiones);
        List<Cuenta> cuentas = cuentasDAO.consultarCuentas(cliente.getId_cliente());
        new GenerarRetirosinCuenta(cliente, cuentas).setVisible(true);
    }


    
    
     /**
      * 
      * @param cliente
      * @return
      * @throws PersistenciaException 
      */

    public List<Cuenta> generarListaCuentas(Cliente cliente) throws PersistenciaException {
        ICuentasDAO cuentasDAO = new CuentasDAO(manejadorConexiones);
        List<Cuenta> cuentas = cuentasDAO.consultarCuentas(cliente.getId_cliente());
        return cuentas;
    }
    
    /**
     * 
     */
    public void generarPresentacionesRegistroCliente() {
        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
        IDireccionDAO direccionesDAO = new DireccionDAO(manejadorConexiones);
        new RegistroCliente(clientesDAO, direccionesDAO).setVisible(true);
    }

    /**
     * 
     * @return 
     */
    public ICuentasDAO generarPresentacionesRegistrarCuenta() {
        ICuentasDAO cuentasDAO = new CuentasDAO(manejadorConexiones);

        return new CuentasDAO(manejadorConexiones);

    }
    
    /**
     * 
     * @throws PersistenciaException 
     */
    public void tablaCientesSesion() throws PersistenciaException {
        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
        new BuscarClienteSesion(clientesDAO).setVisible(true);
    }


    public void confirmarRetiro() {
        IRetiroDAO retiroDAO = new RetiroDAO(manejadorConexiones);
        new RegistroRetiro(retiroDAO).setVisible(true);
    }


    /**
     * 
     * @param cliente 
     */

    public void generarPresentacionPaginaPrincipal(Cliente cliente) {
        new PaginaPrincipal(cliente).setVisible(true);
    }
}
