/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.ConfiguracionPaginado;

/**
 *
 * @author HP
 */
public class ClientesDAO implements interfaces.IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public ClientesDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
     String sql = "INSERT INTO cliente(nombres, apellido_paterno, apellido_materno, fecha_nacimiento, id_direccion) VALUES(?,?,?,?,?)";
           // String sql = "{CALL agregar_cliente(?,?,?,?,?)}";
        
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellido_paterno());
            comando.setString(3, cliente.getApellido_materno());
            comando.setString(4, cliente.getFecha_nacimineto());
            comando.setInt(5, cliente.getId_direccion());

            comando.executeUpdate();
            ResultSet rs = comando.getGeneratedKeys();

            while (rs.next()) {
                int claveGenerada = rs.getInt(1);
                cliente.setId_cliente(claveGenerada);
                JOptionPane.showMessageDialog(null, "Cliente Creado con EXITO");
            return cliente;
            }
            LOG.log(Level.WARNING, "Se inserto el cliente pero no se gener� id");
            throw new PersistenciaException("Se inserto el cliente pero no se gener� id");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar al cliente " + ex.getMessage());
            throw new PersistenciaException("No se pudo insertar al cliente " + ex.getMessage());
        }
    }

    @Override
    public Cliente actualizar(Integer id_cliente) {

        return null;

    }

    @Override
    public Cliente consultar(Integer id_cliente) {
        String sql = "SELECT * FROM cliente WHERE id_cliente=?";
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {

            //Statement comando = conexion.createStatement();
            comando.setInt(1, id_cliente);
            ResultSet resultado = comando.executeQuery();
            Cliente cliente = null;
            if (resultado.next()) {
                Integer idClientee = resultado.getInt("id_cliente");
                String nombre = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                String fechaNacimiento = resultado.getString("fecha_nacimiento");
                Integer idDireccion = resultado.getInt("id_direccion");
                cliente = new Cliente(idClientee, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDireccion);
            }
            return cliente;

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Cliente> consultarClientes(ConfiguracionPaginado configPaginado) throws PersistenciaException {
        String sql = "SELECT * FROM cliente LIMIT ? OFFSET ?";
        List<Cliente> listaClientes = new LinkedList<>();
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {

            //Statement comando = conexion.createStatement();
            comando.setInt(1, configPaginado.getElementosPorPagina());
            comando.setInt(2, configPaginado.getElementosASaltar());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Integer idClientee = resultado.getInt("id_cliente");
                String nombre = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                String fechaNacimiento = resultado.getString("fecha_nacimiento");
                Integer idDireccion = resultado.getInt("id_direccion");
                Cliente cliente = new Cliente(idClientee, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDireccion);
                listaClientes.add(cliente);

            }
            return listaClientes;

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
            throw new PersistenciaException("No fue posible consultar lista de clientes");
        }
    }

}
