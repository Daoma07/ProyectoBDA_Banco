/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Retiro;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetiroDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import excepciones.PersistenciaException;

/**
 *
 * @author HP
 */
public class RetiroDAO implements IRetiroDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public RetiroDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    @Override
    public void insertar(Retiro retiro) throws PersistenciaException {
        String sql = "INSERT INTO retiro(contraseña, estado,fecha_hora, numero_cuenta, monto) VALUES (md5(?),?,?,?,?)";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {

            comando.setString(1, retiro.getContraseña());
            comando.setString(2, retiro.getEstado());
            comando.setString(3, retiro.getFecha_hora());
            comando.setInt(4, retiro.getNumero_cuenta());
            comando.setFloat(5, retiro.getSaldo());

            comando.execute();

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar al cliente " + ex.getMessage());
            throw new PersistenciaException("No se pudo insertar al cliente " + ex.getMessage());
        }
    }

    @Override
    public Retiro consultar(Integer folio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
