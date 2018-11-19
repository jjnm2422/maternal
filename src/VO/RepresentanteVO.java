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
public class RepresentanteVO {
    private String  primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefonoPersonal, telefonoCasa, telefonotrabajo,
            direccionHogar, direccionTrabajo, cedula, parentesco;
    private Date fechaNacimiento;
    private int edad;
    private char sexo;

    public RepresentanteVO() {
    }

    public RepresentanteVO(String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String telefonoPersonal, String telefonoCasa, String telefonotrabajo, String direccionHogar, String direccionTrabajo, String cedula, String parentesco, Date fechaNacimiento, int edad, char sexo) {
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefonoPersonal = telefonoPersonal;
        this.telefonoCasa = telefonoCasa;
        this.telefonotrabajo = telefonotrabajo;
        this.direccionHogar = direccionHogar;
        this.direccionTrabajo = direccionTrabajo;
        this.cedula = cedula;
        this.parentesco = parentesco;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getTelefonotrabajo() {
        return telefonotrabajo;
    }

    public void setTelefonotrabajo(String telefonotrabajo) {
        this.telefonotrabajo = telefonotrabajo;
    }

    public String getDireccionHogar() {
        return direccionHogar;
    }

    public void setDireccionHogar(String direccionHogar) {
        this.direccionHogar = direccionHogar;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
 
}
