/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Cuenta;
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

/**
 *
 * @author HP
 */
public class CuentasDAO implements interfaces.ICuentasDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    public CuentasDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    @Override
    public Cuenta insertar(Cuenta cuenta) throws PersistenciaException {
        String sql = "INSERT INTO cuenta(fecha_apertura,saldo,estado,id_cliente) VALUES(?,?,?,?)";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cuenta.getFecha_apertura());
            comando.setFloat(2, cuenta.getSaldo());
            comando.setString(3, cuenta.getEstado());
            comando.setInt(4, cuenta.getId_cliente());
            comando.execute();
            ResultSet resultado = comando.getGeneratedKeys();
            while (resultado.next()) {
                int claveGenerada = resultado.getInt(1);
                cuenta.setNumero_cuenta(claveGenerada);
                JOptionPane.showMessageDialog(null, "La cuenta se creo con exito");
                return cuenta;
            }
            LOG.log(Level.WARNING, "Se inserto la cuenta pero no se generó id");
            throw new PersistenciaException("Se inserto la cuenta pero no se generó id");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar la cuenta " + ex.getMessage());
            throw new PersistenciaException("No se pudo insertar la cuenta " + ex.getMessage());
        }
    }

    @Override
    public Cuenta actualizarSaldo(Cuenta numero_cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuenta cancelarCuenta(Cuenta numero_cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cuenta> consultarCuentas(int id_cliente) throws PersistenciaException {
        String sql = "SELECT * FROM cuenta WHERE id_cliente=? AND estado=1";
        List<Cuenta> listaCuentas = new LinkedList<>();
        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, id_cliente);
            //Statement comando = conexion.createStatement();

            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Integer numeroCuenta = resultado.getInt("numero_cuenta");
                String fechaApertura = resultado.getString("fecha_apertura");
                float saldo = resultado.getFloat("saldo");
                String estado = resultado.getString("estado");
                Integer idCliente = resultado.getInt("id_cliente");
                Cuenta cuenta = new Cuenta(numeroCuenta, fechaApertura, saldo, estado, idCliente);

                listaCuentas.add(cuenta);

            }
            return listaCuentas;

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
            throw new PersistenciaException("No fue posible consultar lista de clientes");
        }
    }

}
