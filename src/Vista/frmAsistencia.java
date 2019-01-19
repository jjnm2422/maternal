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
public class frmAsistencia extends javax.swing.JFrame {

    private Coordinador coordinador;
    private int seleccion;

    /**
     * Creates new form frmAsistencia1
     */
    public frmAsistencia() {
        initComponents();
        if (coordinador!=null) {
            lblTitulo.setText("Asistencia de alumno fecha " + coordinador.getFechaFormateada());
        }
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
        btnConsultar = new javax.swing.JButton();
        cbxGrupo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatricula = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAlumnosI = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAlumnosA = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        lblUsuarioActvo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 87, 155));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_buscar24.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setName("btnConsultar"); // NOI18N
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 30));

        cbxGrupo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        cbxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGrupoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 80, 80, -1));

        jScrollPane1.setName("tblSeccion"); // NOI18N

        tblMatricula.setBackground(new java.awt.Color(2, 119, 189));
        tblMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Primer Nombre", "Primer Apellido"
            }
        ));
        tblMatricula.setName(""); // NOI18N
        tblMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMatriculaMouseClicked(evt);
            }
        });
        tblMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblMatriculaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblMatricula);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, 300));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_back24.png"))); // NOI18N
        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 100, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grupo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 50, 20));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_guardar24.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, 30));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Asistencia alumnos");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 230, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("responsable");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 20));

        tblAlumnosI.setBackground(new java.awt.Color(2, 119, 189));
        tblAlumnosI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Primer Nombre", "Primer Apellido"
            }
        ));
        tblAlumnosI.setName(""); // NOI18N
        tblAlumnosI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosIMouseClicked(evt);
            }
        });
        tblAlumnosI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAlumnosIKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblAlumnosI);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 310, 130));

        tblAlumnosA.setBackground(new java.awt.Color(2, 119, 189));
        tblAlumnosA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Primer Nombre", "Primer Apellido"
            }
        ));
        tblAlumnosA.setName(""); // NOI18N
        tblAlumnosA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosAMouseClicked(evt);
            }
        });
        tblAlumnosA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAlumnosAKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblAlumnosA);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 310, 130));

        lblUsuarioActvo.setText("usuario activo");
        lblUsuarioActvo.setName("lblUsuarioActivo"); // NOI18N
        jPanel1.add(lblUsuarioActvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 130, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMatriculaMouseClicked
        if (evt.getClickCount() == 2) {
            DefaultTableModel model = null;
            Object opciones[] = {"Asistente", "Inasistente"};
            int respuesta = JOptionPane.showOptionDialog(this, "Lista Asistente o inasistente", "Mover a:", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, "Asistente");
            if (respuesta == 0) {
                int fila = this.tblMatricula.getSelectedRow();
                model = (DefaultTableModel) tblMatricula.getModel();
                tblAlumnosA.setModel(coordinador.añadirListaAsistentes(tblMatricula, tblAlumnosA, fila));
                model.removeRow(fila);
                tblMatricula.setModel(model);
            } else {
                int fila = this.tblMatricula.getSelectedRow();
                model = (DefaultTableModel) tblMatricula.getModel();
                tblAlumnosI.setModel(coordinador.añadirListaInasistentes(tblMatricula, tblAlumnosI, fila));
                model.removeRow(fila);
                tblMatricula.setModel(model);
            }
        }
    }//GEN-LAST:event_tblMatriculaMouseClicked

    private void tblAlumnosAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosAMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = this.tblAlumnosA.getSelectedRow();
            tblMatricula.setModel(coordinador.añadirListaAsistentes(tblAlumnosA, tblMatricula, fila));
            DefaultTableModel model = (DefaultTableModel) tblAlumnosA.getModel();
            model.removeRow(fila);
            tblAlumnosA.setModel(model);
        }
    }//GEN-LAST:event_tblAlumnosAMouseClicked

    private void tblAlumnosIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosIMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = this.tblAlumnosI.getSelectedRow();
            tblMatricula.setModel(coordinador.añadirListaInasistentes(tblAlumnosI, tblMatricula, fila));
            DefaultTableModel model = (DefaultTableModel) tblAlumnosI.getModel();
            model.removeRow(fila);
            tblAlumnosI.setModel(model);
        }
    }//GEN-LAST:event_tblAlumnosIMouseClicked

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        if (tblAlumnosA.getRowCount() > 0 || tblAlumnosI.getRowCount() > 0) {
            Object opciones[] = {"Seguir", "Descartar"};
            int respuesta = JOptionPane.showOptionDialog(this, "Deseea usted descartar los cambios realizados", "Atencion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, "Seguir");
            if (respuesta == 1) {
                String[] titulos = {"ID", "Primer Nombre", "Primer Apellido"};
                coordinador.borrarTablas(tblAlumnosA, tblAlumnosI);
                this.llenarTabla(cbxGrupo.getSelectedItem().toString());
            }
        } else {
            if (coordinador.getAsistenciaDAO().consultarAsistenciaDelDia(coordinador.getFechaFormateada(), cbxGrupo.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(this, "Asistencia lista para esta seccion");
            } else {
                this.llenarTabla(cbxGrupo.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (tblMatricula.getRowCount() == 0) {
            if (tblAlumnosA.getRowCount() > 0 || tblAlumnosI.getRowCount() > 0) {
                String respuesta = "";
                if (tblAlumnosA.getModel().getRowCount() > 0) {
                    respuesta = coordinador.registrarAsistenciaPorSeccion((DefaultTableModel) tblAlumnosA.getModel(), cbxGrupo.getSelectedItem().toString(), true, coordinador.consultarUsuario(lblUsuarioActvo.getText()).getId_usuario());
                }
                if (tblAlumnosI.getRowCount() > 0) {
                    respuesta = coordinador.registrarAsistenciaPorSeccion((DefaultTableModel) tblAlumnosI.getModel(), cbxGrupo.getSelectedItem().toString(), false, coordinador.consultarUsuario(lblUsuarioActvo.getText()).getId_usuario());
                }
                JOptionPane.showMessageDialog(this, respuesta);
                coordinador.borrarTablas(tblAlumnosA, tblAlumnosI);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una seccion");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Alumno pendientes por pasar asistencia");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMatriculaKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("tecla pulsada");
            Object opciones[] = {"Asistente", "Inasistente"};
            int respuesta = JOptionPane.showOptionDialog(this, "Lista Asistente o inasistente", "Mover a:", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, "Asistente");
            if (respuesta == 0) {
                int fila = this.tblMatricula.getSelectedRow();
                tblAlumnosA.setModel(coordinador.añadirListaAsistentes(tblMatricula, tblAlumnosA, fila));
                DefaultTableModel model = (DefaultTableModel) tblMatricula.getModel();
                model.removeRow(fila);
                tblMatricula.setModel(model);
            } else {
                int fila = this.tblMatricula.getSelectedRow();
                tblAlumnosI.setModel(coordinador.añadirListaAsistentes(tblMatricula, tblAlumnosI, fila));
                DefaultTableModel model = (DefaultTableModel) tblMatricula.getModel();
                model.removeRow(fila);
                tblMatricula.setModel(model);
            }
        }
    }//GEN-LAST:event_tblMatriculaKeyPressed

    private void tblAlumnosAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlumnosAKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            int fila = this.tblAlumnosA.getSelectedRow();
            tblMatricula.setModel(coordinador.añadirListaAsistentes(tblAlumnosA, tblMatricula, fila));
            DefaultTableModel model = (DefaultTableModel) tblAlumnosA.getModel();
            model.removeRow(fila);
            tblAlumnosA.setModel(model);
        }
    }//GEN-LAST:event_tblAlumnosAKeyPressed

    private void tblAlumnosIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlumnosIKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            int fila = this.tblAlumnosI.getSelectedRow();
            tblMatricula.setModel(coordinador.añadirListaAsistentes(tblAlumnosI, tblMatricula, fila));
            DefaultTableModel model = (DefaultTableModel) tblAlumnosI.getModel();
            model.removeRow(fila);
            tblAlumnosI.setModel(model);
        }
    }//GEN-LAST:event_tblAlumnosIKeyPressed

    private void cbxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGrupoActionPerformed

    }//GEN-LAST:event_cbxGrupoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     coordinador.getFrmMenu().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxGrupo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel lblUsuarioActvo;
    private javax.swing.JTable tblAlumnosA;
    private javax.swing.JTable tblAlumnosI;
    private javax.swing.JTable tblMatricula;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    private void llenarTabla(String seccion) {
        tblMatricula.setModel(coordinador.consultarMatriculaPorSeccionTabla(seccion));
    }

}
