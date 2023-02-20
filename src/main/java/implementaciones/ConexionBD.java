/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import java.sql.*;

/**
 *
 * @author HP
 */
public class ConexionBD implements interfaces.IConexionBD {

    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;

    public ConexionBD(String CADENA_CONEXION, String USUARIO, String PASSWORD) {
        this.CADENA_CONEXION = CADENA_CONEXION;
        this.USUARIO = USUARIO;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }

}
