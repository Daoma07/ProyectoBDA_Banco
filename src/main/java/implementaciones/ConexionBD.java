/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;
//Imports de otras clases o librerias.
import java.sql.*;

/**
 * Clase que crea la conexion a la base de datos MySql.
 * @author Daniel & David
 */
public class ConexionBD implements interfaces.IConexionBD {
    //Se crean las variables finales.
    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;

    /**
     * Metodo que guarda los datos necesarios para crear la conexion a la base de datos.
     * @param CADENA_CONEXION cadena de conexion
     * @param USUARIO Usuario
     * @param PASSWORD Constreasena
     */
    public ConexionBD(String CADENA_CONEXION, String USUARIO, String PASSWORD) {
        this.CADENA_CONEXION = CADENA_CONEXION;
        this.USUARIO = USUARIO;
        this.PASSWORD = PASSWORD;
    }

    /**
     * Metodo que crea la conexion a la base de datos y se ingresan los datos que se guardaron en el metodo de ConexionBD.
     * @return retorna la conexion
     * @throws SQLException Errores
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }

}
