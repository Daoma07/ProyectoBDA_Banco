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
 * Clase Main para realizar las pruebas y clase principal
 * @author Daniel & David
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        // TODO code application logic here
        MenuPrincipa menuPrincipal = new MenuPrincipa();
        menuPrincipal.setVisible(true);
 
    }

}
