/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class frmMenu extends javax.swing.JFrame {

    private Coordinador coordinador;

    /**
     * Creates new form frmMenu
     */
    public frmMenu() {
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
        lblHora = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnAjustes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        lblInscripcion = new javax.swing.JLabel();
        lblReporte = new javax.swing.JLabel();
        lblUsuarioActvo = new javax.swing.JLabel();
        btnNotas = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnAsistencia = new javax.swing.JButton();
        btnSeccion = new javax.swing.JButton();
        btnInscripcion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(69, 90, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHora.setText("hora fecha");
        lblHora.setName("lblHora"); // NOI18N
        jPanel2.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

        jLabel2.setText("hombol maternal");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        lblLogo.setText("logo ");
        lblLogo.setName("lblLogo"); // NOI18N
        jPanel2.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        btnAjustes.setText("ajustes");
        btnAjustes.setName("btnAjustes"); // NOI18N
        jPanel2.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        btnCerrarSesion.setText("cerrar sesion");
        btnCerrarSesion.setName("btnCerrarSesion"); // NOI18N
        jPanel2.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        lblInscripcion.setText("inscripcion");
        lblInscripcion.setName("lblInscripcion"); // NOI18N
        jPanel2.add(lblInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        lblReporte.setText("reportes");
        lblReporte.setName("lblReportes"); // NOI18N
        jPanel2.add(lblReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        lblUsuarioActvo.setText("usuario activo");
        lblUsuarioActvo.setName("lblUsuarioActivo"); // NOI18N
        jPanel2.add(lblUsuarioActvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        btnNotas.setText("Notas");
        jPanel2.add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 110));

        btnPagos.setText("Pagos");
        jPanel2.add(btnPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 100, 110));

        btnUsuario.setText("Usuario");
        jPanel2.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 100, 110));

        btnAsistencia.setText("Asistencia");
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 100, 110));

        btnSeccion.setText("Secciones");
        btnSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 90, 110));

        btnInscripcion.setText("Inscripcion");
        btnInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscripcionActionPerformed(evt);
            }
        });
        jPanel2.add(btnInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 100, 110));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
     Object opciones[] = {"Alumnos", "Docentes", "Cancelar"};
            int respuesta = JOptionPane.showOptionDialog(this, "Por favor elija a quien desea pasar asistencia", "Atencion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, "Alumnos");
            switch (respuesta) {
            case 0:
                coordinador.getFrmAsistencia().setVisible(true);
                coordinador.getFrmAsistencia().setLocationRelativeTo(this);
                break;
                case 1:
                coordinador.getFrmDocenteAsistencia().setVisible(true);
                coordinador.getFrmDocenteAsistencia().setLocationRelativeTo(this);
                break;
                case 2:
                
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void btnSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccionActionPerformed
                coordinador.getFrmGrupos().setVisible(true);
                coordinador.getFrmGrupos().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnSeccionActionPerformed

    private void btnInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscripcionActionPerformed

    }//GEN-LAST:event_btnInscripcionActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnInscripcion;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnSeccion;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblInscripcion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblReporte;
    private javax.swing.JLabel lblUsuarioActvo;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
       this.coordinador = coordinador;
    }
}
