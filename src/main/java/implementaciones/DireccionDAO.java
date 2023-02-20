/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Direccion;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;

/**
 *
 * @author HP
 */
public class DireccionDAO implements interfaces.IDireccionDAO {

    private static final Logger LOG = Logger.getLogger(DireccionDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public DireccionDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    @Override
    public Direccion insertar(Direccion direccion) throws PersistenciaException {
        String sql = "INSERT INTO direccion(calle, numero, colonia)VALUES(?,?,?)";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, direccion.getCalle());
            comando.setString(2, direccion.getNumero());
            comando.setString(3, direccion.getColonia());
            comando.execute();
            ResultSet resultado = comando.getGeneratedKeys();

            while (resultado.next()) {
                int claveGenerada = resultado.getInt(1);
                direccion.setId_direccion(claveGenerada);
                return direccion;
            }
            LOG.log(Level.WARNING, "Se inserto la direccion pero no se generó id");
            throw new PersistenciaException("Se inserto la direccion pero no se generó id");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar la direccion " + ex.getMessage());
            throw new PersistenciaException("No se pudo insertar la direccion " + ex.getMessage());
        }
    }

    @Override
    public Direccion actualizar(Integer id_direccion, Direccion direccionNueva) throws PersistenciaException {
        Direccion direccion = null;
        String sql = "UPDATE direccion SET calle=?, numero=?, colonia=? WHERE id_direccion=?";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setString(1, direccionNueva.getCalle());
            comando.setString(2, direccionNueva.getCalle());
            comando.setString(3, direccionNueva.getColonia());
            ResultSet resultado = comando.executeQuery();
            JOptionPane.showMessageDialog(null, "La direccion se actualizo con exito");
            while (resultado.next()) {
                Integer id_direccionNueva = resultado.getInt("id_direccion");
                String calleNueva = resultado.getString("calle");
                String numeroNueva = resultado.getString("numero");
                String coloniaNueva = resultado.getString("colonia");
                direccion = new Direccion(id_direccionNueva, calleNueva, numeroNueva, coloniaNueva);
                return direccion;
            }
            LOG.log(Level.WARNING, "Se actualizo la direccion pero no se obtuvo pero no regresa la direccion");
            throw new PersistenciaException("Se actualizo la direccion pero no se obtuvo pero no regresa la direccion");

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "No se pudo actualizar la direccion " + ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar la direccion " + ex.getMessage());
        }
    }

    @Override
    public Direccion consultar(Integer id_direccion) throws PersistenciaException {
        String sql = "SELECT * FROM direccion WHERE id_direccion=?";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, id_direccion);
            ResultSet resultado = comando.executeQuery();
            Direccion direccion = null;
            if (resultado.next()) {
                Integer id_direccionConsulta = resultado.getInt("id_direccion");
                String calle = resultado.getString("calle");
                String numero = resultado.getString("numero");
                String colonia = resultado.getString("Colonia");
                direccion = new Direccion(id_direccionConsulta, calle, numero, colonia);
                return direccion;
            }
            throw new PersistenciaException("No se pudo consultar la direccion");

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar la direccion " + ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la direccion " + ex.getMessage());
        }
    }

}
