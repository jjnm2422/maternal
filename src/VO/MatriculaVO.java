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
public class MatriculaVO {
    private int id_matricula, id_alumno, id_empleado;
    private String seccion;
    
    public MatriculaVO() {
}

    public MatriculaVO(int id_matricula, int id_alumno, int id_empleado, String seccion) {
        this.id_matricula = id_matricula;
        this.id_alumno = id_alumno;
        this.id_empleado = id_empleado;
        this.seccion = seccion;
    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
   
}
