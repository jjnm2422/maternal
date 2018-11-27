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
    private int id_pago, id_alumno;
    private double total, mora, saldo_favor;

    public PagoVO() {
    }

    public PagoVO(int id_pago, int id_alumno, double total, double mora, double saldo_favor) {
        this.id_pago = id_pago;
        this.id_alumno = id_alumno;
        this.total = total;
        this.mora = mora;
        this.saldo_favor = saldo_favor;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }

    public double getSaldo_favor() {
        return saldo_favor;
    }

    public void setSaldo_favor(double saldo_favor) {
        this.saldo_favor = saldo_favor;
    }

}
