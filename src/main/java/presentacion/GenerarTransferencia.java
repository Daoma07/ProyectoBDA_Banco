/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
//Imports de todos los paquetes y librerias.

import conexionesBD.Conexion;
import dominio.Cliente;
import dominio.Transferencia;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Metodo para generar una transferencia entre dos cuentas.
 *
 * @author Daniel & David
 */
public class GenerarTransferencia extends javax.swing.JFrame {

    //Se crea una instancia para crear la conexion.
    Conexion conexion = new Conexion();
    //se crean los atributos de los metodos.
    List<Cuenta> cuentas;
    Cliente cliente;
    Cliente clienteDestinatario;
    List<Cuenta> cuentasDestinatario;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Transferencia transferenciaGuardada;

    /**
     * Creates new form GenerarTransferencia
     */
    public GenerarTransferencia(Cliente cliente, List<Cuenta> cuentas) throws PersistenciaException {
        this.cliente = cliente;
        this.cuentas = cuentas;
        initComponents();

        guardarCuentasClienteOrigen();
    }

    public void setClienteDestinatario(Cliente clienteDestinatario) {
        this.clienteDestinatario = clienteDestinatario;
    }

    /**
     * Metodo que ayuda a guardar las cuentas de lo cliente de donde se va a
     * enviar el dinero.
     *
     * @throws PersistenciaException Errores.
     */
    public void guardarCuentasClienteOrigen() throws PersistenciaException {

        String nombre;

        this.comBoxCuentasCliente.removeAllItems();//limpia el combobox

        //try por si fallara al momento de rellenar
        try {

            for (int i = 0; i < cuentas.size(); i++) {

                nombre = String.valueOf(cuentas.get(i).getNumero_cuenta());
                //Se arega un nuevo ??tem al combobox
                this.comBoxCuentasCliente.addItem(nombre);
            }

        } catch (Exception e) { //capta el error y lo muestra
            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox" + e);
        }
    }

    /**
     * Metodo que guarda las cuentas del cliente a donde se va a enviar el
     * dinero (beneficiario).
     *
     * @throws PersistenciaException Errores.
     */
    public void guardarCuentasClienteDestinatario() throws PersistenciaException {
        String nombre;
        cuentasDestinatario = conexion.generarListaCuentas(clienteDestinatario);

        this.comBoxCuentasClienteDestinatario.removeAllItems();//limpia el combobox
        //try por si fallara al momento de rellenar
        try {

            //Se arega un nuevo ??tem al combobox
            for (int i = 0; i < cuentasDestinatario.size(); i++) {
                nombre = String.valueOf(cuentasDestinatario.get(i).getNumero_cuenta());
                this.comBoxCuentasClienteDestinatario.addItem(nombre);

                if (this.comBoxCuentasCliente.getSelectedItem().
                        equals(this.comBoxCuentasClienteDestinatario.getItemAt(i))) {
                    this.comBoxCuentasClienteDestinatario.removeItemAt(i);
                }

            }

        } catch (Exception e) { //capta el error y lo muestra
            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox" + e);
        }
    }

    /**
     * Metodo que guarda el cliente destinatario.
     */
    public void guardarClienteDestinatario() {
        clienteDestinatario = conexion.clienteID(Integer.parseInt(this.txtiDClienteDestinatario.getText()));

    }
//
//    public void determinarCuentasDestinatario() {
//        for (int i = 0; i < cuentasDestinatario.size(); i++) {
//            
//            if (this.comBoxCuentasCliente.getSelectedItem().
//                    equals(this.comBoxCuentasClienteDestinatario.getItemAt(i))) {
//                this.comBoxCuentasClienteDestinatario.removeItemAt(i);
//            }
//            
//        }
//
//    }

    /**
     * Metodo que guarda la transferncia de los clientes.
     */
    public void guardarTransferencia() {
        if (Float.valueOf(this.txtMonto.getText()) > Float.valueOf(this.txtSaldoCuenta.getText())) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Transferencia transferencia = new Transferencia(dateFormat.format(new Date()),
                    Integer.parseInt(String.valueOf(comBoxCuentasCliente.getSelectedItem())),
                    Integer.parseInt(String.valueOf(comBoxCuentasClienteDestinatario.getSelectedItem())),
                    Float.parseFloat(this.txtMonto.getText()));

            try {
                conexion.ingresarTranferencia(transferencia);
                dispose();
            } catch (PersistenciaException ex) {
                Logger.getLogger(GenerarTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        comBoxCuentasCliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comBoxCuentasClienteDestinatario = new javax.swing.JComboBox<>();
        txtNombreClienteDistinatario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnValidar = new javax.swing.JButton();
        txtiDClienteDestinatario = new javax.swing.JTextField();
        btnEnvial = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        txtSaldoCuenta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Transferenecia");

        comBoxCuentasCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comBoxCuentasClienteItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Destinatario ID:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Cuentas");

        comBoxCuentasClienteDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBoxCuentasClienteDestinatarioActionPerformed(evt);
            }
        });

        txtNombreClienteDistinatario.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Mis Cuentas");

        btnValidar.setText("Validar");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        btnEnvial.setText("Enviar");
        btnEnvial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvialActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Monto");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtSaldoCuenta.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Saldo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(comBoxCuentasClienteDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(26, 26, 26)
                                .addComponent(txtiDClienteDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comBoxCuentasCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnEnvial)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSalir))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnValidar)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombreClienteDistinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 36, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comBoxCuentasCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtiDClienteDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValidar)
                    .addComponent(txtNombreClienteDistinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(comBoxCuentasClienteDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnvial)
                    .addComponent(btnSalir))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton las validar la accion,
     *
     * @param evt evento.
     */
    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        guardarClienteDestinatario();
        this.txtNombreClienteDistinatario.setText(clienteDestinatario.getNombre()
                + " " + clienteDestinatario.getApellido_paterno() + " "
                + clienteDestinatario.getApellido_materno());

  
        try {
            guardarCuentasClienteDestinatario();
        } catch (PersistenciaException ex) {
            Logger.getLogger(GenerarTransferencia.class.getName()).log(Level.SEVERE, null, ex);
        }

      

    }//GEN-LAST:event_btnValidarActionPerformed

    private void comBoxCuentasClienteDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBoxCuentasClienteDestinatarioActionPerformed
        // TODO add your handling code here:
        //determinarCuentasDestinatario();
    }//GEN-LAST:event_comBoxCuentasClienteDestinatarioActionPerformed

    private void btnEnvialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvialActionPerformed

        guardarTransferencia();
        
    }//GEN-LAST:event_btnEnvialActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void comBoxCuentasClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comBoxCuentasClienteItemStateChanged
        // TODO add your handling code here:
        this.txtSaldoCuenta.setText(String.valueOf(cuentas.get(comBoxCuentasCliente.getSelectedIndex()).getSaldo()));
    }//GEN-LAST:event_comBoxCuentasClienteItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnvial;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnValidar;
    private javax.swing.JComboBox<String> comBoxCuentasCliente;
    private javax.swing.JComboBox<String> comBoxCuentasClienteDestinatario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombreClienteDistinatario;
    private javax.swing.JTextField txtSaldoCuenta;
    private javax.swing.JTextField txtiDClienteDestinatario;
    // End of variables declaration//GEN-END:variables
}
