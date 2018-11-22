/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Coordinador;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.UIManager;

/**
 *
 * @author acjj
 */
public class Logica {

    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public String getClave(char[] campoClave){
        char[] arrayC1 = campoClave; 
        String c1 = new String(arrayC1);
        return c1;
    }  
 
    public boolean validacionCorreo(String entrada){
        //formato de correo abd@123.com
        return entrada.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
    }

    public boolean validacionLimiteSoloNumeros(String entrada){
        //solo permito - _ . y letras y numeros
        return entrada.matches("[\\d]*");
    }
    
    public boolean validacionLimiteSoloLetras(String entrada){
        //solo permito - _ . y letras y numeros
        return entrada.matches("[qwertyuiopasdfghjklñzxcvbnm]*");
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

}
