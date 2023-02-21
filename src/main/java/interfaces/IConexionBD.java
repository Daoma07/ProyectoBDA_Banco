/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.*;

/**
 * Interfaz para crer la conexion.
 * @author Daniel & David
 */
public interface IConexionBD {

    /**
     * Crea una conexión y devuelve ojeto Connection
     * @return Devuelve ojeto Connection
     * @throws SQLException Error
     */
    Connection crearConexion() throws SQLException;
}
