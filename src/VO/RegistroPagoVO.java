/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author acjj
 */
public class RegistroPagoVO {
    private  String numero_registro, tipo_pago, numero_transaccion, fecha_comprobante, banco_emisor, numero_referencia, fecha_ejecucion, fecha, depositante, concepto;
    private int id_registro, id_pago;
    private double  monto;
    
    public RegistroPagoVO() {
    }

    public RegistroPagoVO(String numero_registro, String tipo_pago, String numero_transaccion, String fecha_comprobante, String banco_emisor, String numero_referencia, String fecha_ejecucion, String fecha, String depositante, int id_registro, int id_pago, double monto) {
        this.numero_registro = numero_registro;
        this.tipo_pago = tipo_pago;
        this.numero_transaccion = numero_transaccion;
        this.fecha_comprobante = fecha_comprobante;
        this.banco_emisor = banco_emisor;
        this.numero_referencia = numero_referencia;
        this.fecha_ejecucion = fecha_ejecucion;
        this.fecha = fecha;
        this.depositante = depositante;
        this.id_registro = id_registro;
        this.id_pago = id_pago;
        this.monto = monto;
    }

    public String getDepositante() {
        return depositante;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    public void setDepositante(String depositante) {
        this.depositante = depositante;
    }


    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

   
    public String getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(String numero_registro) {
        this.numero_registro = numero_registro;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getNumero_transaccion() {
        return numero_transaccion;
    }

    public void setNumero_transaccion(String numero_transaccion) {
        this.numero_transaccion = numero_transaccion;
    }

    public String getFecha_comprobante() {
        return fecha_comprobante;
    }

    public void setFecha_comprobante(String fecha_comprobante) {
        this.fecha_comprobante = fecha_comprobante;
    }

    public String getBanco_emisor() {
        return banco_emisor;
    }

    public void setBanco_emisor(String banco_emisor) {
        this.banco_emisor = banco_emisor;
    }

    public String getNumero_referencia() {
        return numero_referencia;
    }

    public void setNumero_referencia(String numero_referencia) {
        this.numero_referencia = numero_referencia;
    }

    public String getFecha_ejecucion() {
        return fecha_ejecucion;
    }

    public void setFecha_ejecucion(String fecha_ejecucion) {
        this.fecha_ejecucion = fecha_ejecucion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    
    
    
}
