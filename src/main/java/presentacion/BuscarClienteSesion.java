/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import conexionesBD.Conexion;
import dominio.Cliente;

import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import utils.ConfiguracionPaginado;

/**
 *
 * @author HP
 */
public class BuscarClienteSesion extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(BuscarClienteSesion.class.getName());

    TableRowSorter<TableModel> sorter;
    private final IClientesDAO clientesDAO;
    private ConfiguracionPaginado configPaginado;
    int idCliente;
    String nombreCliente;
    Conexion conexion = new Conexion();

    /**
     * Creates new form InisiarSesion
     */
    public BuscarClienteSesion(IClientesDAO clientesDAO) throws PersistenciaException {
        this.clientesDAO = clientesDAO;
        this.configPaginado = new ConfiguracionPaginado(0, 10);
        initComponents();
        this.cargarTablaClientes();
        tblCliente.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(tblCliente.getModel());
        tblCliente.setRowSorter(sorter);

    }

    private void cargarTablaClientes() throws PersistenciaException {
        try {
            List<Cliente> listaClientes = this.clientesDAO.consultarClientes(this.configPaginado);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCliente.getModel();
            //Limpia tabla anterior
            modeloTabla.setRowCount(0);
            listaClientes.forEach(cliente -> {
                Object[] fila = {
                    cliente.getId_cliente(),
                    cliente.getNombre() + " "
                    + cliente.getApellido_paterno() + " "
                    + cliente.getApellido_materno(),
                    cliente.getFecha_nacimineto(),
                    cliente.getId_cliente()
                };
                modeloTabla.addRow(fila);
            });

        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }

    }

    public void seleccionarCliente() {
        int fila = this.tblCliente.getSelectedRow();
        idCliente = (int) this.tblCliente.getValueAt(fila, 0);
        nombreCliente = (String) this.tblCliente.getValueAt(fila, 1);

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscador = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnAvanzar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorActionPerformed(evt);
            }
        });
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyReleased(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Completo", "Fecha Nacimiento ", "ID Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCliente);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Nombre:");

        btnAvanzar.setText(">");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "15", "20" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAvanzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAvanzar)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        // TODO add your handling code here:

        seleccionarCliente();

        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?\n" + idCliente + " "
                + nombreCliente, "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {

            conexion.generarPresentacionPaginaPrincipal(conexion.clienteID(idCliente));
            dispose();

        } else {
            repaint();
        }


    }//GEN-LAST:event_tblClienteMouseClicked

    public void filtrar() {
        try {
            sorter.setRowFilter(RowFilter.regexFilter(txtBuscador.getText(), 1));

        } catch (Exception e) {
        }
    }

    private void avanzarPagina() throws PersistenciaException {
        this.configPaginado.avanzarPagina();
        this.cargarTablaClientes();
    }

    private void retrocederPagina() throws PersistenciaException {
        this.configPaginado.retrocederPagina();
        this.cargarTablaClientes();
    }

    private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorActionPerformed

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_txtBuscadorKeyReleased

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        try {
            // TODO add your handling code here:
            avanzarPagina();
        } catch (PersistenciaException ex) {
            Logger.getLogger(BuscarClienteSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            retrocederPagina();
        } catch (PersistenciaException ex) {
            Logger.getLogger(BuscarClienteSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int elementosPorPagina = Integer.parseInt(evt.getItem().toString());
            this.configPaginado.setElementosPorPagina(elementosPorPagina);

            try {
                this.cargarTablaClientes();
            } catch (PersistenciaException ex) {
                Logger.getLogger(BuscarClienteSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
