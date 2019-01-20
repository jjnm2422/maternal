/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Coordinador;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acjj
 */
public class MatriculaDAO {
    
    private Coordinador coordinador;
    private final String tabla = "matricula";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public DefaultTableModel consultarMatriculaPorSeccionTabla(String seccion){
    Statement st = null;
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    conexion = conexiondb.getConnection();
    String[]titulos={"ID","Primer Nombre","Primer Apellido"};
    String[]fila=new String[titulos.length];
    String sql="SELECT * FROM "+this.tabla+" INNER JOIN alumno ON matricula.id_alumno = alumno.id_alumno WHERE seccion = '"+seccion+"'";
    DefaultTableModel model = new DefaultTableModel(null,titulos);
    
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
   
    while(rs.next()){
        fila[0]=rs.getString("id_alumno");
        fila[1]=rs.getString("primer_nombre");
        fila[2]=rs.getString("primer_apellido");
        model.addRow(fila);
    }
    conexion.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar ", null, JOptionPane.ERROR_MESSAGE);
        return model = null;
    }
    return model;
}
    
    public DefaultTableModel consultarMatriculaSinSeccion(){
    Statement st = null;
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    conexion = conexiondb.getConnection();
    String[]titulos={"ID","Primer Nombre","Primer Apellido"};
    String[]fila=new String[titulos.length];
    String sql="SELECT * FROM "+this.tabla+" INNER JOIN alumno ON matricula.id_alumno = alumno.id_alumno where matricula.seccion is null";
    DefaultTableModel model = new DefaultTableModel(null,titulos);
    
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
   
    while(rs.next()){
        fila[0]=rs.getString("id_alumno");
        fila[1]=rs.getString("primer_nombre");
        fila[2]=rs.getString("primer_apellido");
        model.addRow(fila);
    }
    conexion.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar ", null, JOptionPane.ERROR_MESSAGE);
        return model = null;
    }
    return model;
}
    
   public VO.MatriculaVO consultarMatriculaPorAlumno(String id_alumno) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.MatriculaVO matriculaVO = new VO.MatriculaVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    matriculaVO.setId_alumno(result.getInt("id_alumno"));
                    matriculaVO.setId_empleado(result.getInt("id_empleado"));
                    matriculaVO.setSeccion(result.getString("seccion"));
                    matriculaVO.setPeriodo(result.getString("periodo"));
                    matriculaVO.setId_matricula(result.getInt("id_matricula"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return matriculaVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    } 
    
    public int consultarCantidadDeMatriculaSeccion(String seccion){
    Statement st = null;
    int valor = 0;
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    conexion = conexiondb.getConnection(); 
    String sql="SELECT count(*) as cantidad FROM public.matricula where seccion = '"+seccion+"'";
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
    while(rs.next()){
        valor = rs.getInt("cantidad");
    }
    conexion.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar ", null, JOptionPane.ERROR_MESSAGE);
        return -1;
    }
    return valor;
}
       
public String registrarMatricula(VO.MatriculaVO matriculaVO) {
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO "+this.tabla+" (id_alumno, id_empleado, seccion) VALUES (?, ?, ?)" ;
        if (conexion!=null) {
           try {
            ps = conexion.prepareCall(sql);
            ps.setInt(1, matriculaVO.getId_alumno());
            ps.setInt(2, matriculaVO.getId_empleado());
            ps.setString(3, matriculaVO.getSeccion());
            int n = ps.executeUpdate();
            if (n > 0) {
                respuesta = "INGRESADO CON EXITO";
            }
            } catch (SQLException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
                 respuesta = ex.getMessage();
            }
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

   public String actualizarMatricula(VO.MatriculaVO matriculaVO, String id_alumno){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET seccion=? where id_alumno= '"+id_alumno+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, matriculaVO.getSeccion());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                    conexion.close();
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
   
    public String eliminarMatricula(String id) {
        Statement st = null;
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM " + this.tabla + " WHERE id_alumno='" + id + "'";
        if (conexion != null) {
            try {
                st = conexion.createStatement();
                int n= st.executeUpdate(sql);
                if (n>0) {
                    return "ELIMINADO";
                }else{
                    return "NO ELIMINADO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return "NO ELIMINADO \n"+ex.getMessage();
            }
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }
}
