/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Coordinador;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmDocenteAsistencia extends javax.swing.JFrame {

    private Coordinador coordinador;

    /** Creates new form frmDocenteAsistencia */
    public frmDocenteAsistencia() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(1, 87, 155));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asistencia Docente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 240, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("responsable");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 70, 20));

        jScrollPane1.setName("tblDocentes"); // NOI18N

        tblDocente.setBackground(new java.awt.Color(69, 90, 100));
        tblDocente.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        tblDocente.setForeground(new java.awt.Color(255, 255, 255));
        tblDocente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 280, 290));

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
        jScrollPane2.setViewportView(tblDocenteI);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 320, 140));

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
        jScrollPane3.setViewportView(tblDocenteA);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 320, 140));

        btnAtras.setText("atras");
        btnAtras.setName("btnAtras"); // NOI18N
        jPanel2.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        btnGuardar.setText("guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("jjnm");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 90, 20));

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
       // if (tblDocente.getRowCount() == 0) {
            String respuesta = "";
            if (tblDocenteA.getModel().getRowCount()>0) {
                respuesta = coordinador.registrarAsistenciaEmpleado((DefaultTableModel) tblDocenteA.getModel(), true, 1);
            }
            if (tblDocenteI.getRowCount()>0) {
                respuesta = coordinador.registrarAsistenciaEmpleado((DefaultTableModel) tblDocenteI.getModel(), false, 1);
            }
            JOptionPane.showMessageDialog(this, respuesta);
            borrarTablas();
       // } else {
         //   JOptionPane.showMessageDialog(this, "Docentes  pendientes por pasar asistencia");
        //}
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblDocente;
    private javax.swing.JTable tblDocenteA;
    private javax.swing.JTable tblDocenteI;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        tblDocente.setModel(coordinador.consultarEmpleadosTodosTabla());
    }

    public void setCoordinador(Coordinador coordinador) {
       this.coordinador = coordinador;
       llenarTabla();
    }

    private void borrarTablas() {
        DefaultTableModel model = (DefaultTableModel) tblDocenteA.getModel();
        if (model.getRowCount() > 0) {
            int filas = tblDocenteA.getModel().getRowCount();
            for (int i = 0; i <filas; i++) {
                model.removeRow(0);
            }
        }

        DefaultTableModel model2 = (DefaultTableModel) tblDocenteI.getModel();
        if (model2.getRowCount() > 0) {
             int filas = tblDocenteI.getModel().getRowCount();
            for (int i = 0; i <filas; i++) {
                model2.removeRow(0);
            }
        }
    }

}
