/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.util.Date;

/**
 *
 * @author acjj
 */
public class AsistenciaVO {
    private int id_asistencia, id_alumno, id_empleado;
    private Date fecha;
    private boolean asistencia;

    public AsistenciaVO(int id_asistencia, int id_alumno, int id_empleado, Date fecha, boolean asistencia) {
        this.id_asistencia = id_asistencia;
        this.id_alumno = id_alumno;
        this.id_empleado = id_empleado;
        this.fecha = fecha;
        this.asistencia = asistencia;
    }

    public AsistenciaVO() {
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
    
    
}
