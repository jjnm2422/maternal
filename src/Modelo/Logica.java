/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Coordinador;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acjj
 */
public class Logica{

    private Coordinador coordinador;
    private final ImageIcon ICON_ADVERTENCIA = new javax.swing.ImageIcon(getClass().getResource("/Recursos/iconw64.png"));
    private final ImageIcon ICON_ERROR = new javax.swing.ImageIcon(getClass().getResource("/Recursos/icone64.png"));
    private final ImageIcon ICON_CORRECTO = new javax.swing.ImageIcon(getClass().getResource("/Recursos/icong64.png"));

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public DefaultTableModel añadirListaAsistentes(JTable tabla_origen, JTable tabla_destino, int fila) {
        /*inicio verifcacion de la cantidad*/
        String cantidad = "";
        boolean entrada = true;
        //obtengo el modelo de la tabla para escribir sobre el
        DefaultTableModel model = (DefaultTableModel) tabla_destino.getModel();

        String[] vector = new String[3];
        
        vector[0] = tabla_origen.getValueAt(fila, 0).toString();
        vector[1] = tabla_origen.getValueAt(fila, 1).toString();
        model.addRow(vector);

        return model;
    }
    
    public int mensajeAdvertencia(String mensaje){
        return JOptionPane.showConfirmDialog(null, mensaje, "Advertencia", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, ICON_ADVERTENCIA);
    }
    
    public int mensajeError(String mensaje){
        return JOptionPane.showConfirmDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, ICON_ERROR);
    }
    
    public int mensajeCorrecto(String mensaje){
        return JOptionPane.showConfirmDialog(null, mensaje, "Correcto", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, ICON_CORRECTO);
    }
    
        public DefaultTableModel añadirListaGrupos(JTable tabla, JTable tabla2, int fila) {
        /*inicio verifcacion de la cantidad*/
        String cantidad = "";
        boolean entrada = true;
        //obtengo el modelo de la tabla 2 para escribir sobre el
        DefaultTableModel model = (DefaultTableModel) tabla2.getModel();

        String[] vector = new String[3];
        
        vector[0] = tabla.getValueAt(fila, 0).toString();
        vector[1] = tabla.getValueAt(fila, 1).toString();
        vector[2] = tabla.getValueAt(fila, 2).toString();
        model.addRow(vector);

        return model;
    }
    
    public DefaultTableModel añadirListaInasistentes(JTable tabla, JTable tabla2, int fila) {
        /*inicio verifcacion de la cantidad*/
        String cantidad = "";
        boolean entrada = true;
        //obtengo el modelo de la tabla 1 para escribir sobre el
        DefaultTableModel model = (DefaultTableModel) tabla2.getModel();

        String[] vector = new String[3];
        
        vector[0] = tabla.getValueAt(fila, 0).toString();
        vector[1] = tabla.getValueAt(fila, 1).toString();
        model.addRow(vector);

        return model;
    }
    
    public String getClave(char[] campoClave){
        char[] arrayC1 = campoClave; 
        String c1 = new String(arrayC1);
        return c1;
    } 
    
 public  void borrarTablas(JTable tbl1,  JTable tbl2) {
        DefaultTableModel model = (DefaultTableModel) tbl1.getModel();
        if (model.getRowCount() > 0) {
            int filas = tbl1.getModel().getRowCount();
            for (int i = 0; i <filas; i++) {
                model.removeRow(0);
            }
        }

        DefaultTableModel model2 = (DefaultTableModel) tbl2.getModel();
        if (model2.getRowCount() > 0) {
             int filas = tbl2.getModel().getRowCount();
            for (int i = 0; i <filas; i++) {
                model2.removeRow(0);
            }
        }
    }
 
    public boolean validacionCorreo(String entrada){
        //formato de correo abd@123.com
        return entrada.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
    }

    public boolean validacionLimiteSoloNumeros(String entrada){
        //solo permito - _ . y letras y numeros
        return entrada.matches("[\\d]*");
    }
    
    public boolean validacionLimiteSoloNumerosYGuion(String entrada){
        //solo permito - _ . y letras y numeros
        return entrada.matches("[\\d-]*");
    }
    
    public boolean validacionSoloNumerosYPunto(String entrada){
        //solo permito - _ . y letras y numeros
        return entrada.matches("[0123456789.\\s]");
    }
    
    public boolean validacionSoloLetras(String entrada){
        //solo permito - _ . y letras y numeros
        return entrada.matches("[qwertyuiopasdfghjklñzxcvbnmZXCVBNMASDFGHJKLÑQWERTYUIOP]*");
    }
    public boolean validacionSoloLetrasEspacio(String entrada){
        //solo permito - _ . y letras y numeros
        return entrada.matches("[qwertyuiopasdfghjklñzxcvbnmZXCVBNMASDFGHJKLÑQWERTYUIOP ]*");
    }
    
    public boolean validacionNumeroTelefonico(String entrada){
        //telefono 0286-1234567
        return entrada.matches("[\\d]{4}+[-]+[\\d]{7}");
    }
    
    public Date getFecha(){
        Date fecha = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
        System.out.println("Current Date: " + ft.format(fecha));
        return fecha;
    }
    
    public String getFechaFormateada(){
        Date fecha = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
        return ft.format(fecha);
    }
    
    public String getHora(){
        Date fecha = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("H:m:s");
        return ft.format(fecha);
    }

    public DefaultTableModel añadirListaDocentesAsistentes(JTable tabla, JTable tabla2, int fila) {
            /*inicio verifcacion de la cantidad*/
            String cantidad = "";
            boolean entrada = true;
            //obtengo el modelo de la tabla 1 para escribir sobre el
            DefaultTableModel model = (DefaultTableModel) tabla2.getModel();

            String[] vector = new String[3];

            vector[0] = tabla.getValueAt(fila, 0).toString();
            vector[1] = tabla.getValueAt(fila, 1).toString();
            vector[2] = tabla.getValueAt(fila, 2).toString();
            model.addRow(vector);

            return model;
    }

}
