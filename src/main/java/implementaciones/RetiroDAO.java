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
import java.sql.ResultSet;
import javax.swing.JOptionPane;

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
        String sql = "INSERT INTO retiro(contraseña,fecha_hora, numero_cuenta, monto) VALUES (md5(?),?,?,?)";
        String sqlTemp
                = "CREATE EVENT temporizador "
                + "ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL  50 second "
                + "DO "
                //       + "BEGIN "
                + "update retiro set estado = 'No cobrado' where folio=? and monto >0 ";
        //      + "END";

        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                PreparedStatement comandoTem = conexion.prepareCall(sqlTemp);) {

            comando.setString(1, retiro.getContraseña());

            comando.setString(2, retiro.getFecha_hora());
            comando.setInt(3, retiro.getNumero_cuenta());
            comando.setFloat(4, retiro.getSaldo());

            comando.execute();
            ResultSet rs = comando.getGeneratedKeys();

            while (rs.next()) {
                int claveGenerada = rs.getInt(1);
                retiro.setFolio(claveGenerada);
            }

            comandoTem.setInt(1, retiro.getFolio());
            comandoTem.execute();
            JOptionPane.showMessageDialog(null, "Retiro Exitoso\nFolio: " + retiro.getFolio() + "\nContraseña: " + retiro.getContraseña());

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar el retiro " + ex.getMessage());
            throw new PersistenciaException("No se pudo insertar el retiro " + ex.getMessage());
        }
    }

    @Override
    public Retiro consultar(Integer folio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(int folio, int contraseña) throws PersistenciaException {
        String sql = "UPDATE retiro"
                + "    SET estado = 'Cobrado',"
                +"           monto = monto/-1           "
                + "    WHERE folio= ? and contraseña = md5(?)";

        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {

            comando.setInt(1, folio);
            comando.setInt(2, contraseña);
            comando.executeUpdate();
            JOptionPane.showMessageDialog(null, "Retiro Extoso");

        } catch (Exception e) {
        }
    }

}
