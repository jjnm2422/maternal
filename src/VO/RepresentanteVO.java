/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.io.FileInputStream;
import javax.swing.ImageIcon;

/**
 *
 * @author acjj
 */
public class RepresentanteVO {
    private String  primer_nombre, primer_apellido, telefono1, telefono2, direccion, correo, ocupacion, sexo, fecha_nacimiento, cedula, parentesco, empresa;
    private int id_representante, edad, id_alumno, binarioFoto, tipo;
    private FileInputStream fis;
    private ImageIcon foto; 
    
    public RepresentanteVO() {
    }

    public RepresentanteVO(String primer_nombre, String primer_apellido, String telefono1, String telefono2, String direccion, String correo, String ocupacion, String sexo, String fecha_nacimiento, String cedula, String parentesco, String empresa, int id_representante, int edad, int id_alumno, int binarioFoto, int tipo, FileInputStream fis, ImageIcon foto) {
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.direccion = direccion;
        this.correo = correo;
        this.ocupacion = ocupacion;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cedula = cedula;
        this.parentesco = parentesco;
        this.empresa = empresa;
        this.id_representante = id_representante;
        this.edad = edad;
        this.id_alumno = id_alumno;
        this.binarioFoto = binarioFoto;
        this.tipo = tipo;
        this.fis = fis;
        this.foto = foto;
    }

    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }



    public int getBinarioFoto() {
        return binarioFoto;
    }

    public void setBinarioFoto(int binarioFoto) {
        this.binarioFoto = binarioFoto;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }



    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getId_representante() {
        return id_representante;
    }

    public void setId_representante(int id_representante) {
        this.id_representante = id_representante;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    
}
