/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;
//Imports de otras clases o librerias.
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
 * Clase que afecta a toda la informacion de las cuenta vinculadas a los clientes.
 * @author Daniel & David
 */
public class CuentasDAO implements interfaces.ICuentasDAO {

    //Se crean las variables finales.
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    /**
     * Constructor de manejador de coneciones de la clase ConexionBD
     * @param manejadorConexiones 
     */
    public CuentasDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    /**
     * Metodo que crea/inserta una cuenta con sus atributos.
     * @param cuenta Cuenta
     * @return Retorna la cuenta.
     * @throws PersistenciaException Errores.
     */
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

    /**
     * Metodo que ayuda a actualizar el saldo de la cuenta con un UPDATE ede codigo de MySql.
     * @param numero_cuenta numero de cuenta (llave primaria)
     * @return retorna el saldo actualizado del usuario afectado.
     */
    @Override
    public Cuenta actualizarSaldo(Cuenta numero_cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que ayuda a cancelar/eliminar cuenta de un usuario asociado.
     * @param numero_cuenta numero de cuenta (llave primaria)
     * @return 
     */
    @Override
    public Cuenta cancelarCuenta(Cuenta numero_cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que consulta la lista de cuentas que recibe como parametro el id del cliente.
     * @param id_cliente id del cliente (llave primaria)
     * @return retorna la lista de cuentas.
     * @throws PersistenciaException Errores.
     */
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
