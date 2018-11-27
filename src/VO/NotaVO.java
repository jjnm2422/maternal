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
public class NotaVO {
    private int id_nota, id_empleado, id_alumno;
    private String fecha, nota;

    public int getId_nota() {
        return id_nota;
    }

    public NotaVO(int id_nota, int id_empleado, int id_alumno, String fecha, String nota) {
        this.id_nota = id_nota;
        this.id_empleado = id_empleado;
        this.id_alumno = id_alumno;
        this.fecha = fecha;
        this.nota = nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public NotaVO() {
    }
}
