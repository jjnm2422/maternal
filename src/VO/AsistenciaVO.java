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
public class AsistenciaVO {
   private int id_asistencia;
    private String fecha, id_alumno, id_usuario;
    private boolean asistencia;

    public AsistenciaVO(int id_asistencia, String id_alumno, String id_usuario, String fecha, boolean asistencia) {
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

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_usuario) {
        this.id_alumno = id_usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
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
