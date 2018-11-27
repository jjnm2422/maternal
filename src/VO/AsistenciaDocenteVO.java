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
    private int id_asistenciaD, id_empleado, id_usuario;
    private String fecha;
    private boolean asistencia;

    public AsistenciaDocenteVO(int id_asistenciaD, int id_empleado, int id_usuario, String fecha, boolean asistencia) {
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

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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
