/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import VO.UsuarioVO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmDocenteAsistencia extends javax.swing.JFrame {

    private Coordinador coordinador;

    /**
     * Creates new form frmDocenteAsistencia
     */
    public frmDocenteAsistencia() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDocente = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDocenteI = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDocenteA = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnAtras = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLlenarLista = new javax.swing.JButton();
        lblUsuarioActvo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(1, 87, 155));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inasistentes");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 320, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Responsable:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, 20));

        jScrollPane1.setName("tblDocentes"); // NOI18N

        tblDocente.setBackground(new java.awt.Color(69, 90, 100));
        tblDocente.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        tblDocente.setForeground(new java.awt.Color(255, 255, 255));
        tblDocente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Primer Nombre", "Primer Apellido"
            }
        ));
        tblDocente.setName(""); // NOI18N
        tblDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocenteMouseClicked(evt);
            }
        });
        tblDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDocenteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDocente);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 280, 260));

        tblDocenteI.setBackground(new java.awt.Color(69, 90, 100));
        tblDocenteI.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        tblDocenteI.setForeground(new java.awt.Color(255, 255, 255));
        tblDocenteI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Primer Nombre", "Primer Apellido"
            }
        ));
        tblDocenteI.setName(""); // NOI18N
        tblDocenteI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocenteIMouseClicked(evt);
            }
        });
        tblDocenteI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDocenteIKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDocenteI);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 320, 130));

        tblDocenteA.setBackground(new java.awt.Color(69, 90, 100));
        tblDocenteA.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        tblDocenteA.setForeground(new java.awt.Color(255, 255, 255));
        tblDocenteA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Primer Nombre", "Primer Apellido"
            }
        ));
        tblDocenteA.setName(""); // NOI18N
        tblDocenteA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocenteAMouseClicked(evt);
            }
        });
        tblDocenteA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDocenteAKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblDocenteA);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 320, 120));

        btnAtras.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_back24.png"))); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.setName("btnAtras"); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel2.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 100, 30));

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_guardar24.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 110, 30));

        btnLlenarLista.setText("LLenar Lista");
        btnLlenarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlenarListaActionPerformed(evt);
            }
        });
        jPanel2.add(btnLlenarLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 280, -1));

        lblUsuarioActvo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuarioActvo.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioActvo.setText("usuario activo");
        lblUsuarioActvo.setName("lblUsuarioActivo"); // NOI18N
        jPanel2.add(lblUsuarioActvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 120, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Asistencia Docente");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 240, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lista de Docentes");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 280, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Asistentes");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 320, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDocenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDocenteKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("tecla pulsada");
            Object opciones[] = {"Asistente", "Inasistente"};
            int respuesta = JOptionPane.showOptionDialog(this, "Lista Asistente o inasistente", "Mover a:", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, "Asistente");
            if (respuesta == 0) {
                int fila = this.tblDocente.getSelectedRow();
                tblDocenteA.setModel(coordinador.añadirListaDocentesAsistentes(tblDocente, tblDocenteA, fila));
                DefaultTableModel model = (DefaultTableModel) tblDocente.getModel();
                model.removeRow(fila);
                tblDocente.setModel(model);
            } else {
                int fila = this.tblDocente.getSelectedRow();
                tblDocenteI.setModel(coordinador.añadirListaDocentesAsistentes(tblDocente, tblDocenteI, fila));
                DefaultTableModel model = (DefaultTableModel) tblDocente.getModel();
                model.removeRow(fila);
                tblDocente.setModel(model);
            }
        }
    }//GEN-LAST:event_tblDocenteKeyPressed

    private void tblDocenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocenteMouseClicked
        if (evt.getClickCount() == 2) {
            Object opciones[] = {"Asistente", "Inasistente"};
            int respuesta = JOptionPane.showOptionDialog(this, "Lista Asistente o inasistente", "Mover a:", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, "Asistente");
            if (respuesta == 0) {
                int fila = this.tblDocente.getSelectedRow();
                tblDocenteA.setModel(coordinador.añadirListaDocentesAsistentes(tblDocente, tblDocenteA, fila));
                DefaultTableModel model = (DefaultTableModel) tblDocente.getModel();
                model.removeRow(fila);
                tblDocente.setModel(model);
            } else {
                int fila = this.tblDocente.getSelectedRow();
                tblDocenteI.setModel(coordinador.añadirListaDocentesAsistentes(tblDocente, tblDocenteI, fila));
                DefaultTableModel model = (DefaultTableModel) tblDocente.getModel();
                model.removeRow(fila);
                tblDocente.setModel(model);
            }
        }
    }//GEN-LAST:event_tblDocenteMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (tblDocente.getRowCount() == 0) {

            if (tblDocenteA.getRowCount() > 0 ||  tblDocenteI.getRowCount() > 0) {
                String respuesta = "";
                
                if (tblDocenteA.getModel().getRowCount() > 0) {
                    respuesta = coordinador.registrarAsistenciaEmpleado((DefaultTableModel) tblDocenteA.getModel(), true, coordinador.consultarUsuario(lblUsuarioActvo.getText()).getId_usuario());
                }
                if (tblDocenteI.getRowCount() > 0) {
                    respuesta = coordinador.registrarAsistenciaEmpleado((DefaultTableModel) tblDocenteI.getModel(), false, coordinador.consultarUsuario(lblUsuarioActvo.getText()).getId_usuario());
                }
                if (respuesta.equals("INSERT")) {
                    coordinador.getLogica().mensajeCorrecto("Asistencia guardada con exito");
                }else{
                     coordinador.getLogica().mensajeError("Error al guardar Asistencia");
                }
                coordinador.borrarTablas(tblDocenteA, tblDocenteI);
            } else {
                coordinador.getLogica().mensajeError("Lista de docente vacia, pulse el boton llenar lista");
            }
        } else {
             coordinador.getLogica().mensajeError("Docentes  pendientes por pasar asistencia");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
     coordinador.getFrmMenu().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void tblDocenteAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDocenteAKeyPressed
 if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            int fila = this.tblDocenteA.getSelectedRow();
            tblDocente.setModel(coordinador.añadirListaAsistentes(tblDocenteA, tblDocente, fila));
            DefaultTableModel model = (DefaultTableModel) tblDocenteA.getModel();
            model.removeRow(fila);
            tblDocenteA.setModel(model);
        }
    }//GEN-LAST:event_tblDocenteAKeyPressed

    private void tblDocenteAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocenteAMouseClicked
    if (evt.getClickCount() == 2) {
            int fila = this.tblDocenteA.getSelectedRow();
            tblDocente.setModel(coordinador.añadirListaAsistentes(tblDocenteA, tblDocente, fila));
            DefaultTableModel model = (DefaultTableModel) tblDocenteA.getModel();
            model.removeRow(fila);
            tblDocenteA.setModel(model);
        }
    }//GEN-LAST:event_tblDocenteAMouseClicked

    private void tblDocenteIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDocenteIKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            int fila = this.tblDocenteI.getSelectedRow();
            tblDocente.setModel(coordinador.añadirListaAsistentes(tblDocenteI, tblDocente, fila));
            DefaultTableModel model = (DefaultTableModel) tblDocenteI.getModel();
            model.removeRow(fila);
            tblDocenteI.setModel(model);
        }
    }//GEN-LAST:event_tblDocenteIKeyPressed

    private void tblDocenteIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocenteIMouseClicked
      if (evt.getClickCount() == 2) {
              int fila = this.tblDocenteI.getSelectedRow();
            tblDocente.setModel(coordinador.añadirListaAsistentes(tblDocenteI, tblDocente, fila));
            DefaultTableModel model = (DefaultTableModel) tblDocenteI.getModel();
            model.removeRow(fila);
            tblDocenteI.setModel(model);
        }
    }//GEN-LAST:event_tblDocenteIMouseClicked

    private void btnLlenarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlenarListaActionPerformed
        if (coordinador.consultarAsistenciaDelDia(coordinador.getFechaFormateada())) {
             coordinador.getLogica().mensajeError("Asistencia lista el dia de hoy");
        } else {
            llenarTabla();
        }
    }//GEN-LAST:event_btnLlenarListaActionPerformed

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
            java.util.logging.Logger.getLogger(frmDocenteAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDocenteAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDocenteAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDocenteAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDocenteAsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLlenarLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel lblUsuarioActvo;
    private javax.swing.JTable tblDocente;
    private javax.swing.JTable tblDocenteA;
    private javax.swing.JTable tblDocenteI;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        tblDocente.setModel(coordinador.consultarEmpleadosTodosTabla());
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

}
