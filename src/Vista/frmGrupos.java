/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmGrupos extends javax.swing.JFrame {

    private Coordinador coordinador;

    /**
     * Creates new form frmGrupos
     */
    public frmGrupos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSeccion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMatricula = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnAtras = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxSeccion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnLlenar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        lblUsuarioActvo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(1, 87, 155));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Secciones");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 140, -1));

        tblSeccion.setBackground(new java.awt.Color(69, 90, 100));
        tblSeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Primer Nombre", "Primer Apellido"
            }
        ));
        tblSeccion.setName("tblSeccion"); // NOI18N
        tblSeccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSeccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSeccion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 310, 310));

        tblMatricula.setBackground(new java.awt.Color(69, 90, 100));
        tblMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMatricula.setName("tblMatricula"); // NOI18N
        tblMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMatriculaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMatricula);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 310, 310));

        btnAtras.setText("atras");
        btnAtras.setName("btnAtras"); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel2.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, -1, -1));

        btnGuardar.setText("guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, -1, -1));

        lblLogo.setText("logo");
        lblLogo.setName("lblLogo"); // NOI18N
        jPanel2.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Matricula");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        cbxSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        jPanel2.add(cbxSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 60, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("grupo a cargar");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        btnLlenar.setText("Actualizar Tabla");
        btnLlenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlenarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLlenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 310, -1));

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 310, -1));

        lblUsuarioActvo.setText("usuario activo");
        lblUsuarioActvo.setName("lblUsuarioActivo"); // NOI18N
        jPanel2.add(lblUsuarioActvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 474, 120, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLlenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlenarActionPerformed
       tblMatricula.setModel(coordinador.consultarMatriculaSinSeccion()); 
    }//GEN-LAST:event_btnLlenarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        //lleno la seccion
        tblSeccion.setModel(coordinador.consultarMatriculaPorSeccionTabla(cbxSeccion.getSelectedItem().toString()));
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void tblMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMatriculaMouseClicked
        if (evt.getClickCount() == 2) {
            if (coordinador.consultarCantidadDeAlumnoSeccion(cbxSeccion.getSelectedItem().toString())<coordinador.getVariablesDAO().consultarVariables().getLimite_alumno()) {
                DefaultTableModel model = null;
                int fila = this.tblMatricula.getSelectedRow();
                model = (DefaultTableModel) tblMatricula.getModel();
                tblSeccion.setModel(coordinador.añadirListaGrupos(tblMatricula, tblSeccion, fila));
                model.removeRow(fila);
                tblMatricula.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "La seccion ha llegado al limite de alumnos por favor seleccione otra seccion");
            }
        }
    }//GEN-LAST:event_tblMatriculaMouseClicked

    private void tblSeccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSeccionMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = this.tblSeccion.getSelectedRow();
            tblMatricula.setModel(coordinador.añadirListaAsistentes(tblSeccion, tblMatricula, fila));
            DefaultTableModel model = (DefaultTableModel) tblSeccion.getModel();
            model.removeRow(fila);
            tblSeccion.setModel(model);
        }
    }//GEN-LAST:event_tblSeccionMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

           if (tblSeccion.getRowCount() >0) {
            DefaultTableModel model = (DefaultTableModel) tblSeccion.getModel();
            String respuesta= "";
            int id_alumno = 0;
            for (int i = 0; i < tblSeccion.getRowCount(); i++) {
                VO.MatriculaVO matriculaVO = new VO.MatriculaVO();
                matriculaVO.setId_alumno(Integer.parseInt(model.getValueAt(i, 0).toString()));
                matriculaVO.setSeccion(cbxSeccion.getSelectedItem().toString());
                respuesta = coordinador.getMatriculaDAO().actualizarMatricula(matriculaVO, String.valueOf(matriculaVO.getId_alumno()));
            }
            JOptionPane.showMessageDialog(this, respuesta);
            coordinador.borrarTablas(tblSeccion, tblMatricula);
            tblMatricula.setModel(coordinador.consultarMatriculaSinSeccion()); 
        } else {
            JOptionPane.showMessageDialog(this, "consulte un seccion");
        }  

        
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
      coordinador.getFrmMenu().setVisible(true);
      coordinador.getFrmMenu().setLocationRelativeTo(null);
      this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(frmGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLlenar;
    private javax.swing.JComboBox<String> cbxSeccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblUsuarioActvo;
    private javax.swing.JTable tblMatricula;
    public javax.swing.JTable tblSeccion;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
       this.coordinador = coordinador;
    }
}
