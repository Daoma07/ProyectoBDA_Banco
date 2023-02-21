/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import conexionesBD.Conexion;
import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import java.util.List;
import conexionesBD.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class AgregarSaldo extends javax.swing.JFrame {

    Cliente cliente;
    List<Cuenta> cuentasCliente;
    Conexion conexion = new Conexion();
    String estado;

    /**
     * Creates new form AgregarSaldo
     */
    public AgregarSaldo(Cliente cliente, List<Cuenta> cuentasCliente) throws PersistenciaException {
        this.cliente = cliente;
        this.cuentasCliente = cuentasCliente;
        initComponents();
        guardarCuentasCliente();

    }

    /**
     * Metodo para guardar las cuuentas del cliente.
     *
     * @throws PersistenciaException
     */
    public void guardarCuentasCliente() throws PersistenciaException {
        String nombre;
        cuentasCliente = conexion.generarListaCuentasG(cliente);

        this.comboBoxCuentas.removeAllItems();//limpia el combobox
        //try por si fallara al momento de rellenar
        try {

            //Se arega un nuevo ítem al combobox
            for (int i = 0; i < cuentasCliente.size(); i++) {
                nombre = String.valueOf(cuentasCliente.get(i).getNumero_cuenta());

                this.comboBoxCuentas.addItem(nombre);
            }

        } catch (Exception e) { //capta el error y lo muestra
            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox" + e);
        }
    }

    public void actualizar() {
        conexion.actualizarCuenta(Integer.parseInt(String.valueOf(this.comboBoxCuentas.getSelectedItem())), estado,
                Float.valueOf(this.txtSaldo.getText()));
    }

    public void seleccionarEstado() {
        if (this.rBotonDesactivar.isSelected()) {
            estado = "Cancelada";
        } else if (this.rBotonDesactivar.isSelected() == false) {

            estado = "Vigente";
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

        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboBoxCuentas = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        rBotonDesactivar = new javax.swing.JRadioButton();
        txtSaldo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Numero de Cuenta");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Agregar Saldo ");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Cuenta ");

        rBotonDesactivar.setText("Desactivar Cuenta ");
        rBotonDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBotonDesactivarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rBotonDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSaldo))
                            .addComponent(jLabel14))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(comboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnCancelar)
                        .addGap(56, 56, 56)
                        .addComponent(btnActualizar)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(rBotonDesactivar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rBotonDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBotonDesactivarActionPerformed
        // TODO add your handling code here:
        seleccionarEstado();
    }//GEN-LAST:event_rBotonDesactivarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:.
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
        dispose();

    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboBoxCuentas;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JRadioButton rBotonDesactivar;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}