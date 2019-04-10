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
public class AsistenciaDocenteVO {
    private int id_asistenciaD;
    private String fecha, id_empleado, id_usuario;
    private boolean asistencia;

    public AsistenciaDocenteVO(int id_asistenciaD, String id_empleado, String id_usuario, String fecha, boolean asistencia) {
        this.id_asistenciaD = id_asistenciaD;
        this.id_empleado = id_empleado;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.asistencia = asistencia;
    }

    public AsistenciaDocenteVO() {
    }

    public int getId_asistenciaD() {
        return id_asistenciaD;
    }

    public void setId_asistenciaD(int id_asistenciaD) {
        this.id_asistenciaD = id_asistenciaD;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
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
