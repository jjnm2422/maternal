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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class frmUsuario extends javax.swing.JFrame {

    private Coordinador coordinador;
    private VO.UsuarioVO usuarioVO = new VO.UsuarioVO();

    /**
     * Creates new form frmUsuario
     */
    public frmUsuario() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtContraseña2 = new javax.swing.JPasswordField();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        chkAdmin = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnInicio1 = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtPregunta = new javax.swing.JTextField();
        txtRespuesta = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtContraseña4 = new javax.swing.JPasswordField();
        txtContraseña3 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        chkAdmin1 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        btnBorrar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        txtPregunta1 = new javax.swing.JTextField();
        txtRespuesta1 = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        chkActivo1 = new javax.swing.JCheckBox();
        lblUsuarioActvo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 87, 155));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(69, 90, 100));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(2, 119, 189));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de usuarios");
        jLabel1.setOpaque(true);
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 37));

        jPanel5.setBackground(new java.awt.Color(2, 119, 189));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)));
        jPanel5.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lista de Usuarios");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Contraseña");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 80, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Repita Contraseña");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 130, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Pregunta de Seguridad");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 160, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Activo");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 60, 30));

        txtContraseña2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtContraseña2.setToolTipText("");
        txtContraseña2.setEnabled(false);
        txtContraseña2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseña2ActionPerformed(evt);
            }
        });
        jPanel5.add(txtContraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 150, 30));

        txtContraseña.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtContraseña.setToolTipText("");
        txtContraseña.setEnabled(false);
        jPanel5.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 150, 30));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Usuario");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 80, 30));

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel5.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 150, 30));

        chkAdmin.setEnabled(false);
        jPanel5.add(chkAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, 30));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Respuesta de Seguridad");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 170, 30));

        tblUsuario.setBackground(new java.awt.Color(153, 204, 255));
        tblUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuarios"
            }
        ));
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 150));

        btnInicio1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnInicio1.setText("Llenar");
        btnInicio1.setPreferredSize(new java.awt.Dimension(60, 23));
        btnInicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicio1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnInicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, -1));

        btnBorrar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_delete24.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setPreferredSize(new java.awt.Dimension(60, 23));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 243, 100, 30));

        btnSalir.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_exit24.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(60, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 100, 30));

        txtPregunta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPregunta.setEnabled(false);
        jPanel5.add(txtPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 150, 30));

        txtRespuesta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRespuesta.setEnabled(false);
        jPanel5.add(txtRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 150, 30));

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_update24.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(60, 23));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel5.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 243, 120, 30));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Administrador");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 180, 30));

        chkActivo.setEnabled(false);
        jPanel5.add(chkActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 560, 280));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 360));

        jTabbedPane1.addTab("Gestion de Usuarios", jPanel1);

        jPanel2.setBackground(new java.awt.Color(1, 87, 155));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(69, 90, 100));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(2, 119, 189));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nuevo usuario");
        jLabel2.setOpaque(true);
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 37));

        jPanel7.setBackground(new java.awt.Color(2, 119, 189));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)));
        jPanel7.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Contraseña");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, 30));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Repita Contraseña");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, 30));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Pregunta de Seguridad");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, 30));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Activo");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 60, 30));

        txtContraseña4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtContraseña4.setToolTipText("");
        txtContraseña4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseña4ActionPerformed(evt);
            }
        });
        jPanel7.add(txtContraseña4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, 30));

        txtContraseña3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtContraseña3.setToolTipText("");
        jPanel7.add(txtContraseña3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 150, 30));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Usuario");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 30));

        txtNombre1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre1ActionPerformed(evt);
            }
        });
        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre1KeyTyped(evt);
            }
        });
        jPanel7.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 150, 30));
        jPanel7.add(chkAdmin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, 30));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Respuesta de Seguridad");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 170, 30));

        btnBorrar1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_delete24.png"))); // NOI18N
        btnBorrar1.setText("Borrar");
        btnBorrar1.setPreferredSize(new java.awt.Dimension(60, 23));
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 100, 30));

        btnSalir1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_exit24.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setPreferredSize(new java.awt.Dimension(60, 23));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 100, 30));

        txtPregunta1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(txtPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 150, 30));

        txtRespuesta1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(txtRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 150, 30));

        btnRegistrar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_guardar24.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setPreferredSize(new java.awt.Dimension(60, 23));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel7.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 120, 30));

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Administrador");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 100, 30));
        jPanel7.add(chkActivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, 30));

        lblUsuarioActvo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblUsuarioActvo.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioActvo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuarioActvo.setText("usuario activo");
        lblUsuarioActvo.setName("lblUsuarioActivo"); // NOI18N
        jPanel7.add(lblUsuarioActvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 110, 30));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 560, 280));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 360));

        jTabbedPane1.addTab("Nuevo Usuario", null, jPanel2, "");

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
    desactivarCampos();
    borrarCampos();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtContraseña2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseña2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseña2ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicio1ActionPerformed
    tblUsuario.setModel(coordinador.getUsuarioDAO().consultarUsuarioTabla());
    }//GEN-LAST:event_btnInicio1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        borrarCampos();
        desactivarCampos();
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
    usuarioVO = coordinador.getUsuarioDAO().consultarUsuario(tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 1).toString());
    activarCampos();
    borrarCampos();
    txtNombre.setText(usuarioVO.getNombre_usuario());
    txtPregunta.setText(usuarioVO.getPregunta_secreta());
    txtRespuesta.setText(usuarioVO.getRespuesta_secreta());
    chkAdmin.setSelected(usuarioVO.isAdmin());
    chkActivo.setSelected(usuarioVO.isActivo());
    txtContraseña.setText(usuarioVO.getClave());
    txtContraseña2.setText(usuarioVO.getClave());
    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (verificarCampos()) {
            if (coordinador.getClave(txtContraseña.getPassword()).equals(coordinador.getClave(txtContraseña2.getPassword()))) {
                if ( actualizarUsuario()) {
                    coordinador.getLogica().mensajeCorrecto("Actualizado con exito");
                    borrarCampos();
                    tblUsuario.setModel(coordinador.getUsuarioDAO().consultarUsuarioTabla());
                } else {
                    coordinador.getLogica().mensajeError("Problemas al Actualizar");
                }
            } else {
                coordinador.getLogica().mensajeError("los campos de contraseña debe ser iguales");
            }
        } else {
            coordinador.getLogica().mensajeError("Campos Vacios");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUsuarioMouseEntered

    private void txtContraseña4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseña4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseña4ActionPerformed

    private void txtNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1ActionPerformed

    private void txtNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1KeyTyped

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
       borrarCampos2();
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
         borrarCampos2();
        this.dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (verificarCampos2()) {
            if (coordinador.getClave(txtContraseña3.getPassword()).equals(coordinador.getClave(txtContraseña4.getPassword()))) {
                if ( registrarUsuario()) {
                   coordinador.getLogica().mensajeCorrecto("INGRESADO CON EXITO");
                    borrarCampos2();
                    tblUsuario.setModel(coordinador.getUsuarioDAO().consultarUsuarioTabla());
                } else {
                    coordinador.getLogica().mensajeError("Problemas al Registrar");
                }
            } else {
                coordinador.getLogica().mensajeError("los campos de contraseña debe ser iguales");
            }
        } else {
            coordinador.getLogica().mensajeError("Campos Vacios");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnInicio1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JCheckBox chkActivo1;
    private javax.swing.JCheckBox chkAdmin;
    private javax.swing.JCheckBox chkAdmin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel lblUsuarioActvo;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JPasswordField txtContraseña2;
    private javax.swing.JPasswordField txtContraseña3;
    private javax.swing.JPasswordField txtContraseña4;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtPregunta;
    private javax.swing.JTextField txtPregunta1;
    private javax.swing.JTextField txtRespuesta;
    private javax.swing.JTextField txtRespuesta1;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    private void activarCampos() {
    txtNombre.setEnabled(true);
    txtPregunta.setEnabled(true);
    txtRespuesta.setEnabled(true);
    chkAdmin.setEnabled(true);
    chkActivo.setEnabled(true);
    txtContraseña.setEnabled(true);
    txtContraseña2.setEnabled(true);
    }
    
    private void desactivarCampos() {
    txtNombre.setEnabled(false);
    txtPregunta.setEnabled(false);
    txtRespuesta.setEnabled(false);
    chkAdmin.setEnabled(false);
    chkActivo.setEnabled(false);
    txtContraseña.setEnabled(false);
    txtContraseña2.setEnabled(false);
    borrarCampos();
    }

    private void borrarCampos() {
    txtNombre.setText("");
    txtPregunta.setText("");
    txtRespuesta.setText("");
    chkAdmin.setSelected(false);
    txtContraseña.setText("");
    txtContraseña2.setText("");
    }
    
   private void borrarCampos2() {
    txtNombre1.setText("");
    txtPregunta1.setText("");
    txtRespuesta1.setText("");
    chkAdmin1.setSelected(false);
    chkActivo1.setSelected(false);
    txtContraseña3.setText("");
    txtContraseña4.setText("");
    }

    private boolean actualizarUsuario() {
        usuarioVO.setNombre_usuario(txtNombre.getText());
        usuarioVO.setClave(coordinador.getClave(txtContraseña.getPassword()));
        usuarioVO.setPregunta_secreta(txtPregunta.getText());
        usuarioVO.setRespuesta_secreta(txtRespuesta.getText());
        usuarioVO.setAdmin(chkAdmin.isSelected());
        usuarioVO.setActivo(chkActivo.isSelected());
        if (coordinador.actualizarUsuario(usuarioVO, tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 0).toString()).equals("INGRESADO CON EXITO")) {
            return true;
        } else {
            return false;
        }
    }
    
        private boolean registrarUsuario() {
        VO.UsuarioVO usuarioVO1 = new  VO.UsuarioVO();
        usuarioVO1.setNombre_usuario(txtNombre1.getText());
        usuarioVO1.setClave(coordinador.getClave(txtContraseña3.getPassword()));
        usuarioVO1.setPregunta_secreta(txtPregunta1.getText());
        usuarioVO1.setRespuesta_secreta(txtRespuesta1.getText());
        usuarioVO1.setId_usuario(coordinador.consultarUsuario(txtNombre.getText()).getId_usuario());
        usuarioVO1.setAdmin(chkAdmin1.isSelected());
        usuarioVO1.setActivo(chkActivo1.isSelected());
        if (coordinador.registrarUsuario(usuarioVO1).equals("INGRESADO CON EXITO")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificarCampos() {
       return !txtNombre.getText().isEmpty() && !txtContraseña.getText().isEmpty() && !txtContraseña2.getText().isEmpty()
               && !txtPregunta.getText().isEmpty() && !txtRespuesta.getText().isEmpty();
    }
    
        private boolean verificarCampos2() {
       return !txtNombre1.getText().isEmpty() && !txtContraseña3.getText().isEmpty() && !txtContraseña4.getText().isEmpty()
               && !txtPregunta1.getText().isEmpty() && !txtRespuesta1.getText().isEmpty();
    }

}
