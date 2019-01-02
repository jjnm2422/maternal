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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * 
 */
public class RequisitosDAO {
    
    private Coordinador coordinador;
    private final String tabla = "requisitos";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarRequisitos(VO.RequisitosVO requisitosVO) {
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into "+this.tabla+"(id_alumno, partida, foto_postal, foto_carnet, foto_familiar, cedula_padres, observaciones)"
                    + "values(?,?,?,?,?,?,?)";
        if (conexion!=null) {
            try {
            ps = conexion.prepareCall(sql);
            ps.setInt(1, requisitosVO.getId_alumno());
            ps.setBoolean(2, requisitosVO.isPartida());
            ps.setBoolean(3, requisitosVO.isFoto_postal());
            ps.setBoolean(4, requisitosVO.isFoto_carnet());
            ps.setBoolean(5, requisitosVO.isFoto_familiar());
            ps.setBoolean(6, requisitosVO.isCedula_padres());
            ps.setString(7, requisitosVO.getObservaciones());
            int n = ps.executeUpdate();
            if (n > 0) {
                respuesta = "INGRESADO CON EXITO";
            }
            } catch (SQLException ex) {
                Logger.getLogger(RequisitosDAO.class.getName()).log(Level.SEVERE, null, ex);
                 respuesta = ex.getMessage();
            } 
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.RequisitosVO consultarRequisitos(int id_requisitos) {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.RequisitosVO requisitosVO = new VO.RequisitosVO();
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM "+this.tabla+" WHERE id_requisito = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setInt(1, id_requisitos);
                result = ps.executeQuery();
                    while (result.next()==true) {
                    requisitosVO.setId_requisito(result.getInt("id_requisito"));
                    requisitosVO.setCedula_padres(result.getBoolean("cedula_padres"));
                    requisitosVO.setFoto_carnet(result.getBoolean("foto_carnet"));
                    requisitosVO.setFoto_familiar(result.getBoolean("foto_familiar"));
                    requisitosVO.setFoto_postal(result.getBoolean("foto_postal"));
                    requisitosVO.setPartida(result.getBoolean("partida"));
                    requisitosVO.setObservaciones(result.getString("observaciones"));
                    }
            } catch (SQLException ex) {
                Logger.getLogger(RequisitosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return requisitosVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    
    public String eliminarRequisitos(String id_alumno){
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
    
    public String actualizarRequisitos(VO.RequisitosVO requisitosVO){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET partida=?, foto_postal=?, foto_carnet=?, foto_familiar=?, cedula_padres=?, observaciones=? where id_alumno= '"+requisitosVO.getId_alumno()+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setBoolean(1, requisitosVO.isPartida());
                ps.setBoolean(2, requisitosVO.isFoto_postal());
                ps.setBoolean(3, requisitosVO.isFoto_carnet());
                ps.setBoolean(4, requisitosVO.isFoto_familiar());
                ps.setBoolean(5, requisitosVO.isCedula_padres());
                ps.setString(6, requisitosVO.getObservaciones());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RequisitosDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }
    
    public  int  llenarCodigoRequisitos(){
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    Statement st = null;
    ResultSet result = null;
    int valor = -1;
    conexion = conexiondb.getConnection();
      try {
            String sql = "select last_value+1 as valor from public.requisitoss_id_requisitoss_seq";
            st=conexion.createStatement();
            result=st.executeQuery(sql);
            while (result.next()) {
                 valor = result.getInt("valor");
            }
             conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
      return valor;
    }
    
    public DefaultTableModel consultarRequisitossTabla(String parametro){
    boolean encontrado=false;
    Statement st = null;
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    conexion = conexiondb.getConnection();
    String[]titulos={"Primer Nombre","Primer Apellido"};
    String[]fila=new String[titulos.length];
    String sql="SELECT * FROM usuarios WHERE nombre1 = '"+parametro+"'";
    DefaultTableModel model = new DefaultTableModel(null,titulos);
    
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
   
    while(rs.next()){
        fila[0]=rs.getString("nombre1");
        fila[1]=rs.getString("apellido1");
        model.addRow(fila);
        encontrado = true;
    }
    if (encontrado==false){
        JOptionPane.showMessageDialog(null, " La cedula ingresada no esta registrada ", null, JOptionPane.ERROR_MESSAGE);
        return model = null;
    }
         } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar ", null, JOptionPane.ERROR_MESSAGE);
            return model = null;
         }
    return model;
}

}
