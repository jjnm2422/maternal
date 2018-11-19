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
public class PadresVO {
    private String  nombre1, nombre2, apellido1, apellido2, telefonoPersonal, telefonoCasa, telefonotrabajo,
            direccionHogar, direccionTrabajo, cedula, parentesco;
    private Date fechaNacimiento;
    private int edad;
    private char sexo;

    public PadresVO() {
    }

    public PadresVO(String nombre1, String nombre2, String apellido1, String apellido2, String telefonoPersonal, String telefonoCasa, String telefonotrabajo, String direccionHogar, String direccionTrabajo, String cedula, String parentesco, Date fechaNacimiento, int edad, char sexo) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
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

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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
