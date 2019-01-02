/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import VO.VariablesVO;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Navarro
 */
public class frmAjustes extends javax.swing.JFrame {


    DefaultTableModel model;
    private String hora;
    private Coordinador coordinador;

    public frmAjustes() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
    }
    

    public void setTitle(String title) {
        super.setTitle(title);
    }

    public void setlook() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void restaurarVentana() {
        if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {//1
            setExtendedState(JFrame.NORMAL);//2
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }

    /*public void LlenarVariables() {
        try {
            String sql = "select * from variables where codvar = '1'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                txtIva.setText(rs.getString("iva"));
                txtRuta.setText(rs.getString("ruta"));
                txtHora.setText(rs.getString("hora"));
            }
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }*/
    
       public void Ajustar(JLabel label, ImageIcon icon) {
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        txtLimite = new javax.swing.JTextField();
        btnSalir2 = new javax.swing.JButton();
        txtIva = new javax.swing.JTextField();
        txtDiasmora = new javax.swing.JTextField();
        lblTitulo4 = new javax.swing.JLabel();
        btnRuta = new javax.swing.JButton();
        lblTitulo16 = new javax.swing.JLabel();
        lblTitulo17 = new javax.swing.JLabel();
        lblTitulo18 = new javax.swing.JLabel();
        txtCuota = new javax.swing.JTextField();
        txtMora = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        lblTitulo19 = new javax.swing.JLabel();
        cbxPeriodo = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        lblUsuarioActvo = new javax.swing.JLabel();
        btnRestaurar = new javax.swing.JButton();
        lblTitulo15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Variables del Sistema");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(1, 87, 155));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(69, 90, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo1.setText("Limite de Alumos por seccion");
        jPanel1.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo2.setText("%");
        jPanel1.add(lblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 20, 20));

        lblTitulo3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setText("Ubicacion de Reportes ");
        jPanel1.add(lblTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 20));

        txtRuta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRuta.setEnabled(false);
        jPanel1.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 350, -1));

        txtLimite.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLimite.setEnabled(false);
        txtLimite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLimiteKeyTyped(evt);
            }
        });
        jPanel1.add(txtLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 110, -1));

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 100, 30));

        txtIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIva.setEnabled(false);
        txtIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIvaKeyTyped(evt);
            }
        });
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 60, -1));

        txtDiasmora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDiasmora.setEnabled(false);
        txtDiasmora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasmoraKeyTyped(evt);
            }
        });
        jPanel1.add(txtDiasmora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 60, -1));

        lblTitulo4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo4.setText("Valor Actual Iva");
        jPanel1.add(lblTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 20));

        btnRuta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRuta.setText("...");
        btnRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRuta.setEnabled(false);
        btnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaActionPerformed(evt);
            }
        });
        jPanel1.add(btnRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 30, -1));

        lblTitulo16.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTitulo16.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo16.setText("Periodo Actual");
        jPanel1.add(lblTitulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 130, 20));

        lblTitulo17.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTitulo17.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo17.setText("Precio Cuota Mensual");
        jPanel1.add(lblTitulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 20));

        lblTitulo18.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTitulo18.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo18.setText("Precio de Mora");
        jPanel1.add(lblTitulo18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 20));

        txtCuota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCuota.setEnabled(false);
        txtCuota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuotaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 100, -1));

        txtMora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMora.setEnabled(false);
        txtMora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMoraKeyTyped(evt);
            }
        });
        jPanel1.add(txtMora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 100, -1));

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 90, 30));

        lblTitulo19.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTitulo19.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo19.setText("Dias para mora");
        jPanel1.add(lblTitulo19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 130, 20));

        cbxPeriodo.setEnabled(false);
        cbxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPeriodoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 100, -1));

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 90, 30));

        lblUsuarioActvo.setText("usuario activo");
        lblUsuarioActvo.setName("lblUsuarioActivo"); // NOI18N
        jPanel1.add(lblUsuarioActvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 120, 20));

        btnRestaurar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRestaurar.setText("Restaurar");
        btnRestaurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 90, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 565, 290));

        lblTitulo15.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo15.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo15.setText("Ajustes");
        jPanel3.add(lblTitulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 560, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed

    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged

    }//GEN-LAST:event_jPanel3MouseDragged

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaActionPerformed
    JFileChooser explorador = new JFileChooser("\\home\\");
    explorador.setDialogTitle("Abrir ubicacion de los reportes...");
    explorador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int seleccion = explorador.showDialog(null, "Abrir!");
    //Podemos crear un File con lo seleccionado
    File archivo = explorador.getSelectedFile();

    //y guardar una ruta
    String ruta = archivo.getPath();
    //analizamos la respuesta
    switch(seleccion) {
    case JFileChooser.APPROVE_OPTION:
        txtRuta.setText(ruta);
     break;

    case JFileChooser.CANCEL_OPTION:
     //dio click en cancelar o cerro la ventana
     break;

    case JFileChooser.ERROR_OPTION:
     //llega aqui si sucede un error
     break;
    }
    }//GEN-LAST:event_btnRutaActionPerformed

    private void txtIvaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIvaKeyTyped
    validacionSoloNumeros(evt, 3, txtIva.getText().length());
    }//GEN-LAST:event_txtIvaKeyTyped

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    if (verificacionCampos()) {
        VO.VariablesVO variablesVO = new VO.VariablesVO();
        variablesVO.setIva(Double.parseDouble(txtIva.getText().trim()));
        variablesVO.setPrecio_cuota(Double.parseDouble(txtCuota.getText().trim()));
        variablesVO.setPrecio_mora(Double.parseDouble(txtMora.getText().trim()));
        variablesVO.setDias_mora(Integer.parseInt(txtDiasmora.getText().trim()));
        variablesVO.setLimite_alumno(Integer.parseInt(txtLimite.getText().trim()));
        variablesVO.setUbicacion_reporte(txtRuta.getText());
        variablesVO.setPeriodo_actual(cbxPeriodo.getSelectedItem().toString());
        String respuesta = coordinador.actualizarVariables(variablesVO);
        System.out.println(respuesta);
        desactivarCampos();
        llenarCampos();            
    } else {
        JOptionPane.showMessageDialog(this, "Faltan Campos por llenar");
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cbxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPeriodoActionPerformed
    
    }//GEN-LAST:event_cbxPeriodoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    activarCampos();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtCuotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuotaKeyTyped
    validacionSoloNumerosYPunto(evt, 10, txtCuota.getText().length());
    }//GEN-LAST:event_txtCuotaKeyTyped

    private void txtMoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoraKeyTyped
    validacionSoloNumerosYPunto(evt, 10, txtMora.getText().length());
    }//GEN-LAST:event_txtMoraKeyTyped

    private void txtLimiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLimiteKeyTyped
    validacionSoloNumeros(evt, 3, txtLimite.getText().length());
    }//GEN-LAST:event_txtLimiteKeyTyped

    private void txtDiasmoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasmoraKeyTyped
    validacionSoloNumeros(evt, 3, txtDiasmora.getText().length());
    }//GEN-LAST:event_txtDiasmoraKeyTyped

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
    llenarCampos(); 
    }//GEN-LAST:event_btnRestaurarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAjustes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnRuta;
    private javax.swing.JButton btnSalir2;
    public javax.swing.JComboBox<String> cbxPeriodo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo15;
    private javax.swing.JLabel lblTitulo16;
    private javax.swing.JLabel lblTitulo17;
    private javax.swing.JLabel lblTitulo18;
    private javax.swing.JLabel lblTitulo19;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    public javax.swing.JLabel lblUsuarioActvo;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtDiasmora;
    private javax.swing.JTextField txtIva;
    public javax.swing.JTextField txtLimite;
    private javax.swing.JTextField txtMora;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public void llenarCampos(){
        VariablesVO variablesVO = coordinador.consultarVariables();
        txtCuota.setText(String.valueOf(variablesVO.getPrecio_cuota()));
        txtIva.setText(String.valueOf(variablesVO.getIva()));
        txtRuta.setText(String.valueOf(variablesVO.getUbicacion_reporte()));
        txtLimite.setText(String.valueOf(variablesVO.getLimite_alumno()));
        txtMora.setText(String.valueOf(variablesVO.getPrecio_mora()));
        txtDiasmora.setText(String.valueOf(variablesVO.getDias_mora()));
        cbxPeriodo.setSelectedItem(variablesVO.getPeriodo_actual());
    }

    private void activarCampos() {
       txtCuota.setEnabled(true);
       txtIva.setEnabled(true);
       btnRuta.setEnabled(true);
       txtLimite.setEnabled(true);
       txtMora.setEnabled(true);
       txtDiasmora.setEnabled(true);
       cbxPeriodo.setEnabled(true);
    }
    
       private void validacionSoloNumerosYPunto(KeyEvent evt, int maximo, int lim) {
        if (coordinador.validacionSoloNumerosYPunto(evt.getKeyChar() + "")) {
            if (lim >= maximo) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            evt.consume();
            getToolkit().beep();
        }
    }
       
    private void validacionSoloNumeros(KeyEvent evt, int maximo, int lim) {
        if (coordinador.validacionLimiteSoloNumeros(evt.getKeyChar() + "")) {
            if (lim >= maximo) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            evt.consume();
            getToolkit().beep();
        }
    }
    
    private void desactivarCampos() {
       txtCuota.setEnabled(false);
       txtIva.setEnabled(false);
       btnRuta.setEnabled(false);
       txtLimite.setEnabled(false);
       txtMora.setEnabled(false);
       txtDiasmora.setEnabled(false);
       cbxPeriodo.setEnabled(false);
    }

    private boolean verificacionCampos() {
        return !txtCuota.getText().isEmpty() && !txtIva.getText().isEmpty() && !txtLimite.getText().isEmpty()
                && !txtMora.getText().isEmpty() && !txtDiasmora.getText().isEmpty();
    }
}