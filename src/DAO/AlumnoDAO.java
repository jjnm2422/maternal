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
    private Connection conexion;
    private final Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarAlumno() {
        String respuesta = "";
        this.conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        if (conexion!=null) {
            respuesta= "Conectado";
        } else {
            respuesta = "NO Conectado";
        }
        return respuesta;
    }

    public VO.AlumnoVO consultarAlumno(String parametro) {
        this.conexion = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.AlumnoVO alumnoVO = new VO.AlumnoVO();
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM usuarios WHERE cedula = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, parametro);
                result = ps.executeQuery();
                if (result.getRow()!=0) {
                    while (result.next()==true) {
                    alumnoVO.setNombre1(result.getString("nombre1"));
                    alumnoVO.setApellido1(result.getString("apellido1"));
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
        this.conexion = null;
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM usuarios WHERE cedula='"+id+"'";
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
    }
}
