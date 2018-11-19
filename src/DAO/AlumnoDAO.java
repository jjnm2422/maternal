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
public class AlumnoDAO {

    private Coordinador coordinador;
    private final String tabla = "alumno";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarAlumno(VO.AlumnoVO alumnoVO) {
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
            ps.setString(1, alumnoVO.getPrimer_nombre());
            ps.setString(2, alumnoVO.getPrimer_apellido());
            ps.setString(3, alumnoVO.getTipoSangre());
            int n = ps.executeUpdate();
            if (n > 0) {
                 respuesta = "INGRESADO CON EXITO";
            }
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
                 respuesta = ex.getMessage();
            } 
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.AlumnoVO consultarAlumno(String parametro) {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.AlumnoVO alumnoVO = new VO.AlumnoVO();
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM "+this.tabla+" WHERE cedula = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, parametro);
                result = ps.executeQuery();
                if (result.getRow()!=0) {
                    while (result.next()==true) {
                    alumnoVO.setPrimer_nombre(result.getString("nombre1"));
                    alumnoVO.setPrimer_apellido(result.getString("apellido1"));
                    }
                } else {
                    conexiondb.desconexion();
                    return null;
                } 
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return alumnoVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    
    public String eliminarAlumno(String id){
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
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "NO ELIMINADO";
        }  
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
        
    }
    
    public String actualizarAlumno(VO.AlumnoVO alumnoVO, String id){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET nombre1=? where cedula= '"+id+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, alumnoVO.getPrimer_nombre());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }
}
