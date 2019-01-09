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
    private int id_nota, id_empleado, id_alumno, lapso;
    private String fecha;
    private String formacion_personal_social[], relacion_ambiente[], comunicacion_presentacion[], indicadores_evaluados[], habitos_trabajo[];

    public int getId_nota() {
        return id_nota;
    }

    public NotaVO() {
    }

    public NotaVO(int id_nota, int id_empleado, int id_alumno, int lapso, String fecha, String[] formacion_personal_social, String[] relacion_ambiente, String[] comunicacion_presentacion, String[] indicadores_evaluados, String[] habitos_trabajo) {
        this.id_nota = id_nota;
        this.id_empleado = id_empleado;
        this.id_alumno = id_alumno;
        this.lapso = lapso;
        this.fecha = fecha;
        this.formacion_personal_social = formacion_personal_social;
        this.relacion_ambiente = relacion_ambiente;
        this.comunicacion_presentacion = comunicacion_presentacion;
        this.indicadores_evaluados = indicadores_evaluados;
        this.habitos_trabajo = habitos_trabajo;
    }

    public String[] getRelacion_ambiente() {
        return relacion_ambiente;
    }

    public void setRelacion_ambiente(String[] relacion_ambiente) {
        this.relacion_ambiente = relacion_ambiente;
    }

    public String[] getComunicacion_presentacion() {
        return comunicacion_presentacion;
    }

    public void setComunicacion_presentacion(String[] comunicacion_presentacion) {
        this.comunicacion_presentacion = comunicacion_presentacion;
    }

    public String[] getIndicadores_evaluados() {
        return indicadores_evaluados;
    }

    public void setIndicadores_evaluados(String[] indicadores_evaluados) {
        this.indicadores_evaluados = indicadores_evaluados;
    }

    public String[] getHabitos_trabajo() {
        return habitos_trabajo;
    }

    public void setHabitos_trabajo(String[] habitos_trabajo) {
        this.habitos_trabajo = habitos_trabajo;
    }

    public int getLapso() {
        return lapso;
    }

    public void setLapso(int lapso) {
        this.lapso = lapso;
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

    public String[] getFormacion_personal_social() {
        return formacion_personal_social;
    }

    public void setFormacion_personal_social(String[] formacion_personal_social) {
        this.formacion_personal_social = formacion_personal_social;
    }

  
}
