/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VO;

import Controlador.Coordinador;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class RequisitosVO {
    private int id_requisito;
    private boolean partida, foto_postal, foto_carnet, foto_familiar, cedula_padres;
    private String observaciones, id_alumno;
    private Coordinador coordinador;

    public RequisitosVO(int id_requisito, boolean partida, boolean foto_postal, boolean foto_carnet, boolean foto_familiar, boolean cedula_padres, String observaciones, String id_alumno, Coordinador coordinador) {
        this.id_requisito = id_requisito;
        this.partida = partida;
        this.foto_postal = foto_postal;
        this.foto_carnet = foto_carnet;
        this.foto_familiar = foto_familiar;
        this.cedula_padres = cedula_padres;
        this.observaciones = observaciones;
        this.id_alumno = id_alumno;
        this.coordinador = coordinador;
    }

    public RequisitosVO() {
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_requisito() {
        return id_requisito;
    }

    public void setId_requisito(int id_requisito) {
        this.id_requisito = id_requisito;
    }

    public boolean isPartida() {
        return partida;
    }

    public void setPartida(boolean partida) {
        this.partida = partida;
    }

    public boolean isFoto_postal() {
        return foto_postal;
    }

    public void setFoto_postal(boolean foto_postal) {
        this.foto_postal = foto_postal;
    }

    public boolean isFoto_carnet() {
        return foto_carnet;
    }

    public void setFoto_carnet(boolean foto_carnet) {
        this.foto_carnet = foto_carnet;
    }

    public boolean isFoto_familiar() {
        return foto_familiar;
    }

    public void setFoto_familiar(boolean foto_familiar) {
        this.foto_familiar = foto_familiar;
    }

    public boolean isCedula_padres() {
        return cedula_padres;
    }

    public void setCedula_padres(boolean cedula_padres) {
        this.cedula_padres = cedula_padres;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    

}
