/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import conexionesBD.Conexion;

import excepciones.PersistenciaException;
import presentacion.MenuPrincipa;

/**
 *
 * @author HP
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        // TODO code application logic here
        MenuPrincipa menuPrincipal = new MenuPrincipa();
        menuPrincipal.setVisible(true);
  

//        IConexionBD manejadorConexiones = new ConexionBD(
//                "jdbc:mysql://localhost/banco_1pm",
//                "root",
//                "daniel2002");
//
//        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
//        String fecha = "2002-06-07";
//
//        Cliente cliente = new Cliente("Daniel", "Alameda", "Lopez", fecha, 1);
//        
//        Cliente clienteCreado = clientesDAO.insertar(cliente);
    }

}
