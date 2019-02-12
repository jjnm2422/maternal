/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import java.awt.Image;
import java.sql.Connection;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class frmMenu extends javax.swing.JFrame implements Runnable {

    private Coordinador coordinador;
    private final ImageIcon iconLogo = new javax.swing.ImageIcon(getClass().getResource("/Recursos/logo.png"));
    private final Thread h1;
    private String ampm;
    private String hora;
    private String minutos;
    private String segundos;
    private long i=0;

    /**
     * Creates new form frmMenu
     */
    public frmMenu() {
        this.setlook();
         initComponents();
        h1 = new Thread(this);
        h1.start();
        setLocationRelativeTo(null);
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
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(69, 90, 100));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), new java.awt.Color(0, 51, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHora.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setText("hora fecha");
        lblHora.setName("lblHora"); // NOI18N
        jPanel2.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 170, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CENTRO DE EDUCACIÓN INICIAL \"HUMBOLDT\"");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 110));

        lblLogo.setName("lblLogo"); // NOI18N
        jPanel2.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 110, 110));

        btnAjustes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/apoyo-tecnico.png"))); // NOI18N
        btnAjustes.setText("ajustes");
        btnAjustes.setEnabled(false);
        btnAjustes.setName("btnAjustes"); // NOI18N
        btnAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjustesActionPerformed(evt);
            }
        });
        jPanel2.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, 70));

        btnCerrarSesion.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icon_exit24.png"))); // NOI18N
        btnCerrarSesion.setText("cerrar sesion");
        btnCerrarSesion.setName("btnCerrarSesion"); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 160, 70));

        lblUsuarioActvo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblUsuarioActvo.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioActvo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuarioActvo.setText("usuario activo");
        lblUsuarioActvo.setName("lblUsuarioActivo"); // NOI18N
        jPanel2.add(lblUsuarioActvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 170, 30));

        btnNotas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/evaluacion.png"))); // NOI18N
        btnNotas.setText("Notas");
        btnNotas.setEnabled(false);
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });
        jPanel2.add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 150, 70));

        btnPagos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tarjeta-de-debito(3).png"))); // NOI18N
        btnPagos.setText("Pagos");
        btnPagos.setEnabled(false);
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });
        jPanel2.add(btnPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 160, 70));

        btnUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/entrevista.png"))); // NOI18N
        btnUsuario.setText("Usuario");
        btnUsuario.setEnabled(false);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 160, 70));

        btnAsistencia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/contrato.png"))); // NOI18N
        btnAsistencia.setText("Asistencia");
        btnAsistencia.setEnabled(false);
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, 70));

        btnSeccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/carpeta.png"))); // NOI18N
        btnSeccion.setText("Matricula");
        btnSeccion.setEnabled(false);
        btnSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 160, 70));

        btnInscripcion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/analitica.png"))); // NOI18N
        btnInscripcion.setText("Inscripcion");
        btnInscripcion.setEnabled(false);
        btnInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscripcionActionPerformed(evt);
            }
        });
        jPanel2.add(btnInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, 70));

        btnReportes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/periodico.png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setEnabled(false);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel2.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, 70));

        btnDocentes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDocentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/equipo.png"))); // NOI18N
        btnDocentes.setText("Docentes");
        btnDocentes.setEnabled(false);
        btnDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocentesActionPerformed(evt);
            }
        });
        jPanel2.add(btnDocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 370));

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
    coordinador.getFrmMenuReportes().setVisible(true);
    coordinador.getFrmMenuReportes().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
    coordinador.getFrmMenuReportes().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjustesActionPerformed
    coordinador.getFrmAjustes().setVisible(true);
    coordinador.getFrmAjustes().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
    coordinador.getFrmAjustes().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnAjustesActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
    coordinador.getFrmUsuario().setVisible(true);
    coordinador.getFrmUsuario().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
    coordinador.getFrmUsuario().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
         coordinador.getFrmPago().setVisible(true);
        coordinador.getFrmPago().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
        coordinador.getFrmPago().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
    coordinador.getLogin().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocentesActionPerformed
    coordinador.getFrmDocente().setVisible(true);
     coordinador.getFrmDocente().jTable1.setModel(coordinador.consultarEmpleadosTodosTabla()); 
    coordinador.getFrmDocente().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
    coordinador.getFrmDocente().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnDocentesActionPerformed

    private void btnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasActionPerformed
    coordinador.getFrmNotas().setVisible(true);
    coordinador.getFrmNotas().lblUsuarioActvo.setText(lblUsuarioActvo.getText());
    coordinador.getFrmNotas().setLocationRelativeTo(this);
    }//GEN-LAST:event_btnNotasActionPerformed

      @Override
    public void run() {
            //metodo run para que hilo inicie llamando la funcion calcula tiempo y establece el tiempo en el label
            Thread ct = Thread.currentThread();
            while (ct == h1) {
                try {
                    calculaTiempo();
                } catch (ParseException ex) {
                    Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                lblHora.setText(hora + ":" + minutos + ":" + segundos);
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
    }

    private void calculaTiempo() throws ParseException {
        //esta funcion genera los valores para el tiempo
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY);
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAjustes;
    public javax.swing.JButton btnAsistencia;
    public javax.swing.JButton btnCerrarSesion;
    public javax.swing.JButton btnDocentes;
    public javax.swing.JButton btnInscripcion;
    public javax.swing.JButton btnNotas;
    public javax.swing.JButton btnPagos;
    public javax.swing.JButton btnReportes;
    public javax.swing.JButton btnSeccion;
    public javax.swing.JButton btnUsuario;
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
