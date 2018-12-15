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
public class AlumnoVO {
    
    private String primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_sangre, alergias, direccion, sexo, fechaNacimiento;
    private int edad, id_alumno, id_nota, id_pago, binarioFoto;
    private FileInputStream fis;
    private ImageIcon foto; 

    public AlumnoVO() {
    }

    public AlumnoVO(String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String tipo_sangre, String alergias, String direccion, String sexo, String fechaNacimiento, int edad, int id_alumno, int id_nota, int id_pago, int binarioFoto, FileInputStream fis, ImageIcon foto) {
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.tipo_sangre = tipo_sangre;
        this.alergias = alergias;
        this.direccion = direccion;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.id_alumno = id_alumno;
        this.id_nota = id_nota;
        this.id_pago = id_pago;
        this.binarioFoto = binarioFoto;
        this.fis = fis;
        this.foto = foto;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }    

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public int getBinarioFoto() {
        return binarioFoto;
    }

    public void setBinarioFoto(int binarioFoto) {
        this.binarioFoto = binarioFoto;
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

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    
   
}
