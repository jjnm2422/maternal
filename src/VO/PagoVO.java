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
public class PagoVO {
    private int id_pago;
    private double saldo;
    private Double pago[], pagado;
    private String id_alumno, periodo;

    public PagoVO() {
    }

    public PagoVO(int id_pago, double saldo, Double[] pago, String id_alumno, String periodo) {
        this.id_pago = id_pago;
        this.saldo = saldo;
        this.pago = pago;
        this.id_alumno = id_alumno;
        this.periodo = periodo;
    }

    public int getId_pago() {
        return id_pago;
    }

    public Double getPagado() {
        return pagado;
    }

    public void setPagado(Double pagado) {
        this.pagado = pagado;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Double[] getPago() {
        return pago;
    }

    public void setPago(Double[] pago) {
        this.pago = pago;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "PagoVO{" + "id_pago=" + id_pago + ", saldo=" + saldo + ", pago=" + pago + ", id_alumno=" + id_alumno + ", periodo=" + periodo + '}';
    }
}
