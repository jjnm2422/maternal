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
public class UsuarioVO {
    private String nombre, apellido, nombre_usuario, clave, pregunta_secreta, respuesta_secreta;
    int id_usuario, id_empleado;

    public UsuarioVO() {
    }

    public UsuarioVO(String nombre, String apellido, String nombre_usuario, String clave, String pregunta_secreta, String respuesta_secreta, int id_usuario, int id_empleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
        this.pregunta_secreta = pregunta_secreta;
        this.respuesta_secreta = respuesta_secreta;
        this.id_usuario = id_usuario;
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPregunta_secreta() {
        return pregunta_secreta;
    }

    public void setPregunta_secreta(String pregunta_secreta) {
        this.pregunta_secreta = pregunta_secreta;
    }

    public String getRespuesta_secreta() {
        return respuesta_secreta;
    }

    public void setRespuesta_secreta(String respuesta_secreta) {
        this.respuesta_secreta = respuesta_secreta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }  
}