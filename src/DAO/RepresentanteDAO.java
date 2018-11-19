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
public class RepresentanteDAO {

    private Coordinador coordinador;
    private final String tabla = "representante";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarRepresentante(VO.RepresentanteVO representanteVO) {
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into "+this.tabla+"(nombre1, apellido1, cedula)"
                    + "values(?,?,?)";
        if (conexion!=null) {
            try {
            ps = conexion.prepareCall(sql);
            ps.setString(1, representanteVO.getNombre1());
            ps.setString(2, representanteVO.getApellido1());
            int n = ps.executeUpdate();
            if (n > 0) {
                 respuesta = "INGRESADO CON EXITO";
            }
            } catch (SQLException ex) {
                Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                 respuesta = ex.getMessage();
            } 
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.RepresentanteVO consultarRepresentante(String parametro) {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.RepresentanteVO representanteVO = new VO.RepresentanteVO();
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM "+this.tabla+" WHERE cedula = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, parametro);
                result = ps.executeQuery();
                if (result.getRow()!=0) {
                    while (result.next()==true) {
                    representanteVO.setNombre1(result.getString("nombre1"));
                    representanteVO.setApellido1(result.getString("apellido1"));
                    }
                } else {
                    conexiondb.desconexion();
                    return null;
                } 
            } catch (SQLException ex) {
                Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return representanteVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    
    public String eliminarRepresentante(String id){
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
            Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "NO ELIMINADO";
        }  
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
        
    }
    
    public String actualizarRepresentante(VO.RepresentanteVO representanteVO, String id){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET nombre1=? where cedula= '"+id+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, representanteVO.getNombre1());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }
}
