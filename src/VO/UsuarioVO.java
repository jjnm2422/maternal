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
    private String nombre_usuario, clave, pregunta_secreta, respuesta_secreta, id_usuario;
    private boolean admin, activo;

    public UsuarioVO() {
    }

    public UsuarioVO(String nombre_usuario, String clave, String pregunta_secreta, String respuesta_secreta, String id_usuario, boolean admin, boolean activo) {
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
        this.pregunta_secreta = pregunta_secreta;
        this.respuesta_secreta = respuesta_secreta;
        this.id_usuario = id_usuario;
        this.admin = admin;
        this.activo = activo;
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

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }    
}
