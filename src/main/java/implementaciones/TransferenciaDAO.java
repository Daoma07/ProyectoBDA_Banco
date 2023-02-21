/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;
//Imports de otras clases o librerias.
import dominio.Transferencia;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITrasnferenciasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author deivi
 */
public class TransferenciaDAO implements ITrasnferenciasDAO {
    //Se crean las variables finales.
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;

    /**
     * Constructor de manejador de coneciones de la clase ConexionBD
     * @param manejadorConexiones 
     */
    public TransferenciaDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }

    /**
     * Metodo que crea/inserta una transferencia con sus atributos.
     * @param transferencia transferencia
     * @throws PersistenciaException Errores.
     */
    public void insertar(Transferencia transferencia) throws PersistenciaException {

        String sql = "INSERT INTO transferencia(fecha_hora, monto, id_CuentaClienteOrigen, "
                + "id_CuentaClienteDestino) VALUES(?,?,?,?)";
        String sqlOrigen = "UPDATE cuenta SET saldo = saldo-? WHERE id_cliente=?";
        String sqlDestino = "UPDATE cuenta SET saldo = saldo+? WHERE id_cliente=?";

        try (
                Connection conexion = MANEJADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); PreparedStatement comandoOrigen = conexion.prepareStatement(sqlOrigen); PreparedStatement comandoDestino = conexion.prepareStatement(sqlDestino);) {

            try {
                conexion.setAutoCommit(false);
                //Agregar datos a la transferencia
                comando.setString(1, transferencia.getFecha_hora());
                comando.setFloat(2, transferencia.getSaldo());
                comando.setInt(3, transferencia.getId_CuentaClienteOrigen());
                comando.setInt(4, transferencia.getId_CuentaClienteDestino());

                // Agregar datos a la cuenta origen
                comandoOrigen.setFloat(1, transferencia.getSaldo());
                comandoOrigen.setInt(2, transferencia.getId_CuentaClienteOrigen());
                // Agregar datos a la cuenta destino
                comandoDestino.setFloat(1, transferencia.getSaldo());
                comandoDestino.setInt(2, transferencia.getId_CuentaClienteDestino());
                comando.executeUpdate();
                comandoOrigen.executeUpdate();
                comandoDestino.executeUpdate();
                comando.executeUpdate();
                ResultSet rs = comando.getGeneratedKeys();

                while (rs.next()) {
                    int claveGenerada = rs.getInt(1);
                    transferencia.setId_transferencia(claveGenerada);
                    JOptionPane.showMessageDialog(null, "Transferencia Exitosa\n"
                            + "Id: " + transferencia.getId_transferencia() + "\n"
                            + "Monto: " + transferencia.getSaldo());
                }

            } catch (SQLException e) {
                if (conexion != null) {
                    try {
                        conexion.rollback();
                    } catch (SQLException ex) {
                        System.out.println(ex.toString());
                    }
                }
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar la transferencia " + ex.getMessage());
            throw new PersistenciaException("No se pudo insertar la transferencia " + ex.getMessage());
        }

    }

    /**
     * Metodo que consulta la informacion de la transferencia que recibe como parametro el id de transferencia (llave primaria).
     * @param id_transferencia id de tranferencia (llave primaria).
     * @return retorna la trasnferencia.
     */
    @Override
    public Transferencia consultar(Integer id_transferencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
