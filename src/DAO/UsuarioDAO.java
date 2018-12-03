/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Coordinador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acjj
 */
public class UsuarioDAO {

    private Coordinador coordinador;
    private final String tabla = "usuario";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarUsuario(VO.UsuarioVO usuarioVO) {
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into "+this.tabla+"(nombre, apellido, nombre_usuario)"
                    + "values(?,?,?)";
        if (conexion!=null) {
            try {
            ps = conexion.prepareCall(sql);
            /*ps.setString(1, usuarioVO..getNombre1());
            ps.setString(2, usuarioVO.getApellido1());
            ps.setString(3, usuarioVO.getTipoSangre());*/
            int n = ps.executeUpdate();
            if (n > 0) {
                 respuesta = "INGRESADO CON EXITO";
            }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                 respuesta = ex.getMessage();
            } 
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.UsuarioVO consultarUsuario(String parametro) {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.UsuarioVO usuarioVO = new VO.UsuarioVO();
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM "+this.tabla+" WHERE nombre_usuario = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, parametro);
                result = ps.executeQuery();
                    while (result.next()==true) {
                    usuarioVO.setNombre_usuario(result.getString("nombre_usuario"));
                    usuarioVO.setPregunta_secreta(result.getString("pregunta_secreta"));
                    usuarioVO.setRespuesta_secreta(result.getString("respuesta_secreta"));
                    usuarioVO.setId_usuario(result.getInt("id_usuario"));
                    }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return usuarioVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    
    public String consultarUsuarioLogin(String usuario, String clave){
        Connection conexion= null;
        String resultado = "";
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM "+this.tabla+" WHERE nombre_usuario = '"+usuario+"'";
            try {
                ps = conexion.prepareStatement(sql);
                boolean isVacia = false;
                result = ps.executeQuery();
                while (result.next()==true) {
                    isVacia = true;
                //String nombre =result.getString("nombre_usuario");
                    if( clave.equals(result.getString("clave"))){
                        if (result.getBoolean("admin")) {
                            resultado = "ACCESO_ADMIN";
                        } else {
                            resultado = "ACCESO_NORMAL";
                        }
                    }else{
                        resultado = "NO_CLAVE";
                    }
                }
            if(isVacia==false){
                resultado = "NO_USUARIO";
            }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex); 
                resultado = "ERROR_SQL";
            }
        } else {
            resultado = "SIN_CONEXION";
        }
        conexiondb.desconexion();
        return resultado;
    }
    
    public String eliminarUsuario(String id){
        Statement st = null;
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM "+this.tabla+" WHERE cedula='"+id+"'";
        if (conexion!=null) {
             try {
            st = conexion.createStatement();
            if (st.execute(sql)) {
                return "ELIMINADO";
            } else {
                return "NO ELIMINADO";
            }   
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "NO ELIMINADO";
        }  
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
        
    }
    
    public String actualizarUsuario(VO.UsuarioVO usuarioVO, String id){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET nombre1=? where cedula= '"+id+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                //ps.setString(1, usuarioVO.getNombre1());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }
    
        public String actualizarClaveUsuario(String clave, String id){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET clave=? where id_usuario= '"+id+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1,clave);
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }

    public String getPreguntaSecreta(String usuario) {
        return "";
    }
}
