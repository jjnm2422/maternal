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
   private int id_asistencia, id_alumno, id_usuario;
    private String fecha;
    private boolean asistencia;

    public AsistenciaVO(int id_asistencia, int id_alumno, int id_usuario, String fecha, boolean asistencia) {
        this.id_asistencia = id_asistencia;
        this.id_alumno = id_alumno;
        this.id_usuario = id_usuario;
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

    public void setId_alumno(int id_usuario) {
        this.id_alumno = id_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
}
