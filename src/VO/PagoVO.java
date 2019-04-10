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
    private double saldo_favor, saldo_pendiente, total_pagado;
    private String periodo, cuotas[], id_alumno;
    

    public PagoVO() {
    }

    public PagoVO(int id_pago, String id_alumno, double saldo_favor, double saldo_pendiente, double total_pagado, String periodo, String[] cuotas) {
        this.id_pago = id_pago;
        this.id_alumno = id_alumno;
        this.saldo_favor = saldo_favor;
        this.saldo_pendiente = saldo_pendiente;
        this.total_pagado = total_pagado;
        this.periodo = periodo;
        this.cuotas = cuotas;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public double getSaldo_favor() {
        return saldo_favor;
    }

    public void setSaldo_favor(double saldo_favor) {
        this.saldo_favor = saldo_favor;
    }

    public double getSaldo_pendiente() {
        return saldo_pendiente;
    }

    public void setSaldo_pendiente(double saldo_pendiente) {
        this.saldo_pendiente = saldo_pendiente;
    }

    public double getTotal_pagado() {
        return total_pagado;
    }

    public void setTotal_pagado(double total_pagado) {
        this.total_pagado = total_pagado;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String[] getCuotas() {
        return cuotas;
    }

    public void setCuotas(String[] cuotas) {
        this.cuotas = cuotas;
    }

}
