/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VO;

/**
 * 
 * @author Ing. Junior Navarro
 */
public class DireccionVO {
    
    private String calle, numcasa, sector, parroquia, casa;
    private String id_direccion;

    public DireccionVO(String calle, String numcasa, String sector, String parroquia, String casa, String id_direccion) {
        this.calle = calle;
        this.numcasa = numcasa;
        this.sector = sector;
        this.parroquia = parroquia;
        this.casa = casa;
        this.id_direccion = id_direccion;
    }

    public DireccionVO() {
    }
    
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumcasa() {
        return numcasa;
    }

    public void setNumcasa(String numcasa) {
        this.numcasa = numcasa;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(String id_direccion) {
        this.id_direccion = id_direccion;
    }
    
}
