/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import java.awt.Image;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class frmMenu extends javax.swing.JFrame {

    private Coordinador coordinador;
    private final ImageIcon iconLogo = new javax.swing.ImageIcon(getClass().getResource("/Recursos/logo.png"));

    /**
     * Creates new form frmMenu
     */
    public frmMenu() {
        this.setlook();
        initComponents();
        ajustar(lblLogo, iconLogo);
    }
    
    public void setlook() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ajustar(JLabel label, ImageIcon icon) {
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint();
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
        lblUsuarioActvo = new javax.swing.JLabel();
        btnNotas = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnAsistencia = new javax.swing.JButton();
        btnSeccion = new javax.swing.JButton();
        btnInscripcion = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnDocentes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(69, 90, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHora.setText("hora fecha");
        lblHora.setName("lblHora"); // NOI18N
        jPanel2.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, -1, -1));

        jLabel2.setText("hombol maternal");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 450, 50));

        lblLogo.setName("lblLogo"); // NOI18N
        jPanel2.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 90, 100));

        btnAjustes.setText("ajustes");
        btnAjustes.setName("btnAjustes"); // NOI18N
        btnAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjustesActionPerformed(evt);
            }
        });
        jPanel2.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 100, 70));

        btnCerrarSesion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_exit24.png"))); // NOI18N
        btnCerrarSesion.setText("cerrar sesion");
        btnCerrarSesion.setName("btnCerrarSesion"); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, 30));

        lblUsuarioActvo.setText("usuario activo");
        lblUsuarioActvo.setName("lblUsuarioActivo"); // NOI18N
        jPanel2.add(lblUsuarioActvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 150, -1));

        btnNotas.setText("Notas");
        jPanel2.add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 100, 70));

        btnPagos.setText("Pagos");
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });
        jPanel2.add(btnPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 100, 70));

        btnUsuario.setText("Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 100, 70));

        btnAsistencia.setText("Asistencia");
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 100, 70));

        btnSeccion.setText("Matricula");
        btnSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 100, 70));

        btnInscripcion.setText("Inscripcion");
        btnInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscripcionActionPerformed(evt);
            }
        });
        jPanel2.add(btnInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, 70));

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel2.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 100, 70));

        btnDocentes.setText("Docentes");
        btnDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocentesActionPerformed(evt);
            }
        });
        jPanel2.add(btnDocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 100, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 650, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
     Object opciones[] = {"Alumnos", "Docentes", "Cancelar"};
            int respuesta = JOptionPane.showOptionDialog(this, "Por favor elija a quien desea pasar asistencia", "Atencion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, "Alumnos");
            switch (respuesta) {
            case 0:
                coordinador.getFrmAsistencia().setVisible(true);
                coordinador.getFrmAsistencia().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
                coordinador.getFrmAsistencia().setLocationRelativeTo(this);
                break;
                case 1:
                coordinador.getFrmDocenteAsistencia().setVisible(true);
                coordinador.getFrmDocenteAsistencia().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
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
        coordinador.getFrmGrupos().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
        coordinador.getFrmGrupos().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnSeccionActionPerformed

    private void btnInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscripcionActionPerformed
        coordinador.getFrmInscripcion().lblTitulo.setText("INSCRIPCION DE ALUMNOS PERIODO: "+coordinador.getVariablesDAO().consultarVariables().getPeriodo_actual());
        coordinador.getFrmInscripcion().setVisible(true);
        coordinador.getFrmInscripcion().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
        coordinador.getFrmInscripcion().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnInscripcionActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
    try {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
            String dir = "G:\\report2.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conexion);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjustesActionPerformed
    coordinador.getFrmAjustes().setVisible(true);
    coordinador.getFrmAjustes().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
    coordinador.getFrmAjustes().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnAjustesActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
    coordinador.getFrmUsuario().setVisible(true);
    coordinador.getFrmUsuario().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
    coordinador.getLogin().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocentesActionPerformed
    coordinador.getFrmDocente().setVisible(true);
    coordinador.getFrmDocente().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
    coordinador.getFrmDocente().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnDocentesActionPerformed

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
    private javax.swing.JButton btnDocentes;
    private javax.swing.JButton btnInscripcion;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSeccion;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblUsuarioActvo;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
       this.coordinador = coordinador;
    }
}
