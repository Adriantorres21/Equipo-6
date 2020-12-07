/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ConexionBD;
import Controlador.Consulta_Historial;
import Controlador.GenerarPDF;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * Interfaz para el historial de reparto
 */
public class Historial_Reparto extends javax.swing.JFrame {

    /**
     * Creates new form Historial_Reparto
     */
    public Historial_Reparto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            Connection con = ConexionBD.getConexionMysql();
            String sql = "SELECT idUsuario FROM usuario";
            PreparedStatement st;
            st = con.prepareStatement(sql);

            ResultSet resultado = st.executeQuery();
            comboBoxID.addItem("idUsuario");
            while (resultado.next()) {
                comboBoxID.addItem(resultado.getString("idUsuario"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        Date date = new Date();
        JDate1.setDate(date);
        JDate2.setDate(date);
        Consulta_Historial c = new Consulta_Historial();
        c.consultar_historial(JDate1,JDate2,tbInforme,etqTotalVenta,etqtotalDev);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelHistorialReparto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxID = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInforme = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnBuscarHistorial = new javax.swing.JButton();
        btnGenerarPdf = new javax.swing.JButton();
        JDate1 = new com.toedter.calendar.JDateChooser();
        JDate2 = new com.toedter.calendar.JDateChooser();
        etqTotalVenta = new javax.swing.JLabel();
        etqtotalDev = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 233, 202));
        jPanel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        labelHistorialReparto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelHistorialReparto.setText("Historial de Reparto");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("ID del repartidor: ");

        comboBoxID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        comboBoxID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxIDMouseClicked(evt);
            }
        });
        comboBoxID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxIDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("De");

        tbInforme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idUsuario", "Nombre", "idReparto", "Fecha", "Hora Salida", "Hora Regreso", "Producto", "Cantidad", "Total", "Total"
            }
        ));
        jScrollPane1.setViewportView(tbInforme);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("a");

        btnBuscarHistorial.setText("Buscar");
        btnBuscarHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarHistorialMouseClicked(evt);
            }
        });

        btnGenerarPdf.setText("Generar");
        btnGenerarPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarPdfMouseClicked(evt);
            }
        });
        btnGenerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(JDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel3)
                                .addGap(49, 49, 49)
                                .addComponent(JDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelHistorialReparto)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(btnBuscarHistorial)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGenerarPdf))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(49, 49, 49)
                                .addComponent(comboBoxID, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(269, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(etqTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(etqtotalDev, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGap(10, 10, 10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelHistorialReparto)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarHistorial)
                        .addComponent(btnGenerarPdf)
                        .addComponent(jLabel2))
                    .addComponent(JDate2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(JDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqtotalDev, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxIDActionPerformed

    private void btnGenerarPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPdfMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarPdfMouseClicked

    private void btnBuscarHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarHistorialMouseClicked
        Consulta_Historial c = new Consulta_Historial();
        String seleccion = (String) comboBoxID.getSelectedItem();

        try {
            if (seleccion == "idUsuario") {
                c.consultar_historial(JDate1, JDate2, tbInforme,etqTotalVenta,etqtotalDev);
            } else {
                c.consultar_historial_ID(seleccion,JDate1,JDate2,tbInforme,etqTotalVenta,etqtotalDev);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos completos",
                    "Error al procesar", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarHistorialMouseClicked

    private void comboBoxIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxIDMouseClicked

    }//GEN-LAST:event_comboBoxIDMouseClicked

    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            String fInicial = f.format(JDate1.getDate());
            String fFinal = f.format(JDate2.getDate());

            String ruta = "C:\\Users\\Adrian\\Desktop\\mipdf.pdf";
            GenerarPDF g = new GenerarPDF();
            g.createPDF(ruta, tbInforme,fInicial,fFinal,etqTotalVenta.getText(),etqtotalDev.getText());

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnGenerarPdfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Historial_Reparto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial_Reparto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial_Reparto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial_Reparto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial_Reparto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDate1;
    private com.toedter.calendar.JDateChooser JDate2;
    private javax.swing.JButton btnBuscarHistorial;
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JComboBox<String> comboBoxID;
    private javax.swing.JLabel etqTotalVenta;
    private javax.swing.JLabel etqtotalDev;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHistorialReparto;
    private javax.swing.JTable tbInforme;
    // End of variables declaration//GEN-END:variables
}
