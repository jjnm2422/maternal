/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author acjj
 */
public class frmLogin extends javax.swing.JFrame {

    private Coordinador coordinador;
    private final ImageIcon iconLogo = new javax.swing.ImageIcon(getClass().getResource("/Recursos/logo.png"));
    private final ImageIcon iconusuario = new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_user.png"));
    private final ImageIcon iconclave = new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_clave.png"));

    /**
     * Creates new form Login
     */
    public frmLogin() {
        this.setlook();
        initComponents();
        ajustar(lblLogo, iconLogo);
        ajustar(lblUsuario, iconusuario);
        ajustar(lblClave, iconclave);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnOlvidoClave = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 87, 155));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/logo.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 160, 220));

        jPanel4.setBackground(new java.awt.Color(69, 90, 100));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(2, 119, 189));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Control de Acceso");
        jLabel1.setOpaque(true);
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 37));

        jPanel3.setBackground(new java.awt.Color(2, 119, 189));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuario");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setText("admin");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 150, -1));

        txtClave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClave.setText("admin1212");
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveKeyTyped(evt);
            }
        });
        jPanel3.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 150, 20));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 20, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Clave");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 23));

        lblClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblClave.setForeground(new java.awt.Color(255, 255, 255));
        lblClave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 20, 20));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, 130));

        jPanel2.setBackground(new java.awt.Color(2, 119, 189));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/interfaz-de-hogar.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setPreferredSize(new java.awt.Dimension(60, 23));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel2.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        btnSalir.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_exit16.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(60, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 80, -1));

        btnOlvidoClave.setBackground(new java.awt.Color(129, 212, 250));
        btnOlvidoClave.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnOlvidoClave.setForeground(new java.awt.Color(255, 255, 255));
        btnOlvidoClave.setText("Olvide mi Clave");
        btnOlvidoClave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOlvidoClave.setBorderPainted(false);
        btnOlvidoClave.setContentAreaFilled(false);
        btnOlvidoClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOlvidoClaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnOlvidoClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        //obtengo clave
        String clave = coordinador.getClave(txtClave.getPassword());
    if (txtUsuario.getText().isEmpty() || clave.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Campos Vacios ","Error", JOptionPane.ERROR_MESSAGE);
    }else{
        switch (coordinador.consultarUsuarioLogin(txtUsuario.getText(), clave)) {
            case "ACCESO_ADMIN":
                //JOptionPane.showMessageDialog(null, "Acceso Concedido admin", "Informacion", JOptionPane.PLAIN_MESSAGE);
                coordinador.getFrmMenu().setVisible(true);
                coordinador.getFrmMenu().btnInscripcion.setEnabled(true);
                coordinador.getFrmMenu().btnUsuario.setEnabled(true);
                coordinador.getFrmMenu().btnNotas.setEnabled(true);
                coordinador.getFrmMenu().btnSeccion.setEnabled(true);
                coordinador.getFrmMenu().btnAsistencia.setEnabled(true);
                coordinador.getFrmMenu().btnDocentes.setEnabled(true);
                coordinador.getFrmMenu().btnReportes.setEnabled(true);
                coordinador.getFrmMenu().btnPagos.setEnabled(true);
                coordinador.getFrmMenu().btnAjustes.setEnabled(true);
                coordinador.getFrmMenu().setLocationRelativeTo(null);
                coordinador.getFrmMenu().lblUsuarioActvo.setText(txtUsuario.getText());
                coordinador.getLogin().dispose();
                borrarCampos();
                break;
            case "ACCESO_NORMAL":
                //JOptionPane.showMessageDialog(null, "Acceso Concedido usuario comun", "Informacion", JOptionPane.PLAIN_MESSAGE);.
                 coordinador.getFrmMenu().setVisible(true);
                 coordinador.getFrmMenu().btnInscripcion.setEnabled(false);
                coordinador.getFrmMenu().btnUsuario.setEnabled(false);
                coordinador.getFrmMenu().btnNotas.setEnabled(false);
                coordinador.getFrmMenu().btnSeccion.setEnabled(false);
                coordinador.getFrmMenu().btnDocentes.setEnabled(false);
                coordinador.getFrmMenu().btnReportes.setEnabled(false);
                coordinador.getFrmMenu().btnPagos.setEnabled(false);
                coordinador.getFrmMenu().btnAjustes.setEnabled(false);
                 coordinador.getFrmMenu().btnAsistencia.setEnabled(true);
                coordinador.getFrmMenu().setLocationRelativeTo(null);
                coordinador.getFrmMenu().lblUsuarioActvo.setText(txtUsuario.getText());
                borrarCampos();
                break;
            case "NO_USUARIO":
                JOptionPane.showMessageDialog(null, "Usuario no existe", "Informacion", JOptionPane.PLAIN_MESSAGE);
                break;
            case "NO_CLAVE":
                JOptionPane.showMessageDialog(null, "Clave incorrecta", "Informacion", JOptionPane.PLAIN_MESSAGE);
                break;
            case "ERROR_SQL":
                JOptionPane.showMessageDialog(null, "Error al ejecutar consulta", "Informacion", JOptionPane.PLAIN_MESSAGE);
                break;
            case "SIN_CONEXION":
                JOptionPane.showMessageDialog(null, "Problemas conexion con BD", "Informacion", JOptionPane.PLAIN_MESSAGE);
                break;
            case "NO_ACTIVO":
                JOptionPane.showMessageDialog(null, "Usuario desactivado consulte con el administrador", "Informacion", JOptionPane.PLAIN_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
    }
    }//GEN-LAST:event_btnInicioActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        int lim = txtUsuario.getText().length();
            //establesco limite
            //cambie este numero que es el limite
            if (lim >= 10) {
                evt.consume();
                getToolkit().beep();
            }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyTyped
        int lim;
        lim = txtClave.getText().length();
            //establesco limite
            //cambie este numero que es el limite
            if (lim >= 15) {
                evt.consume();
                getToolkit().beep();
            }
    }//GEN-LAST:event_txtClaveKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
     System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnOlvidoClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOlvidoClaveActionPerformed
    coordinador.getFrmLoginRecuperacion().setVisible(true);
    coordinador.getFrmLoginRecuperacion().setLocationRelativeTo(null);
    }//GEN-LAST:event_btnOlvidoClaveActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public void consultar(String consulta){
       VO.AlumnoVO alumnoDAO = coordinador.consultarAlumno(consulta);
        if (alumnoDAO==null) {
            JOptionPane.showMessageDialog(this, "USUARIO NO EXISTE");
        } else {
            //txtUsuario.setText(alumnoDAO.getPrimer_nombre());
            //txtClave.setText(alumnoDAO.getPrimer_apellido());
        }
    }
    
    private String actualizar(String id) {
        VO.AlumnoVO alumnoVO = new VO.AlumnoVO();
       // alumnoVO.setPrimer_nombre(txtUsuario.getText());
        return coordinador.actualizarAlumno(alumnoVO, id);
    }
    
    public String eliminar(String id){
        return coordinador.eliminarAlumno(id);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnOlvidoClave;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void borrarCampos() {
        txtUsuario.setText("");
        txtClave.setText("");
    }
 
}
