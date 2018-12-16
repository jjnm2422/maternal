/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VO;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VariablesVO {
    
    private int id_variable, dias_mora, limite_alumno;
    private String ubicacion_reporte, periodo_actual;
    private double iva, precio_cuota, precio_mora;

    public VariablesVO(int id_variable, int dias_mora, int limite_alumno, String ubicacion_reporte, String periodo_actual, double iva, double precio_cuota, double precio_mora) {
        this.id_variable = id_variable;
        this.dias_mora = dias_mora;
        this.limite_alumno = limite_alumno;
        this.ubicacion_reporte = ubicacion_reporte;
        this.periodo_actual = periodo_actual;
        this.iva = iva;
        this.precio_cuota = precio_cuota;
        this.precio_mora = precio_mora;
    }

    public VariablesVO() {
    }

    public int getId_variable() {
        return id_variable;
    }

    public void setId_variable(int id_variable) {
        this.id_variable = id_variable;
    }

    public int getDias_mora() {
        return dias_mora;
    }

    public void setDias_mora(int dias_mora) {
        this.dias_mora = dias_mora;
    }

    public int getLimite_alumno() {
        return limite_alumno;
    }

    public void setLimite_alumno(int limite_alumno) {
        this.limite_alumno = limite_alumno;
    }

    public String getUbicacion_reporte() {
        return ubicacion_reporte;
    }

    public void setUbicacion_reporte(String ubicacion_reporte) {
        this.ubicacion_reporte = ubicacion_reporte;
    }

    public String getPeriodo_actual() {
        return periodo_actual;
    }

    public void setPeriodo_actual(String periodo_actual) {
        this.periodo_actual = periodo_actual;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecio_cuota() {
        return precio_cuota;
    }

    public void setPrecio_cuota(double precio_cuota) {
        this.precio_cuota = precio_cuota;
    }

    public double getPrecio_mora() {
        return precio_mora;
    }

    public void setPrecio_mora(double precio_mora) {
        this.precio_mora = precio_mora;
    }
    
    

}
