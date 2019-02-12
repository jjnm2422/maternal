/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Coordinador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acjj
 */
public class AsistenciaADAO {
    private Coordinador coordinador;
    private final String tabla = "asistencia_a";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public String registrarAsistenciaPorSeccion(DefaultTableModel model, String seccion, boolean asistencia, int usuario) {
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;
        
        for (int i = 0; i < model.getRowCount(); i++) {
            String sql = "insert into "+this.tabla+" (id_alumno, fecha, asistencia, id_usuario) values(?,?,?,?)";
        if (conexion!=null) {
            try {
            ps = conexion.prepareCall(sql);
            ps.setInt(1, Integer.parseInt(model.getValueAt(i, 0).toString()));
            ps.setString(2, coordinador.getFechaFormateada());
            ps.setBoolean(3,  asistencia);
            ps.setInt(4,  usuario);
            int n = ps.executeUpdate();
            if (n > 0 && i==model.getRowCount()-1) {
                respuesta = "INSERT";
            }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
                break;
            } 
        } else {
            respuesta = "ERROR";
        }
        }
        return respuesta;
    }
    
    public boolean consultarAsistenciaDelDia(String fecha, String seccion) {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.AsistenciaVO asistenciaVO = new VO.AsistenciaVO();
        conexion = conexiondb.getConnection();
        boolean respuesta;
        
        if (conexion!=null) {
        String sql = "select * from asistencia_a inner join matricula on asistencia_a.id_alumno = matricula.id_alumno where matricula.seccion = '"+seccion+"' and fecha = '"+fecha+"'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                if (result.next()) {
                    respuesta = true;
                } else {
                    respuesta = false;
                } 
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = false;
            }
        } else {
            respuesta = false;
        }
        conexiondb.desconexion();
        return respuesta;
    }
    
        public String eliminarAsistencia(String id_alumno){
        Statement st = null;
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM "+this.tabla+" WHERE id_alumno='"+id_alumno+"'";
        if (conexion!=null) {
             try {
            st = conexion.createStatement();
                int n= st.executeUpdate(sql);
                if (n>0) {
                    return "ELIMINADO";
                }else{
                    return "NO ELIMINADO";
                }  
        } catch (SQLException ex) {
            Logger.getLogger(RequisitosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "NO ELIMINADO";
        }  
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
        
    }
}
