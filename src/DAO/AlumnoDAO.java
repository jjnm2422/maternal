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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        String sql = "insert into "+this.tabla+"(fechaNacimiento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipoSangre, edad, sexo)"
                    + "values(?,?,?)";
        if (conexion!=null) {
            try {
            ps = conexion.prepareCall(sql);
            ps.setString(1, alumnoVO.getFechaNacimiento());
            ps.setString(2, alumnoVO.getPrimer_nombre());
            ps.setString(3, alumnoVO.getSegundo_nombre());
            ps.setString(4, alumnoVO.getPrimer_apellido());
            ps.setString(5, alumnoVO.getSegundo_apellido());
            ps.setString(6, alumnoVO.getTipo_sangre());
            ps.setInt(7, alumnoVO.getEdad());
            ps.setString(8, alumnoVO.getSexo());
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
            String sql = "SELECT * FROM "+this.tabla+" WHERE id_alumno = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, parametro);
                result = ps.executeQuery();
                if (result.getRow()!=0) {
                    while (result.next()==true) {
                    alumnoVO.setPrimer_nombre(result.getString("primer_nombre"));
                    alumnoVO.setSegundo_nombre(result.getString("segundo_nombre"));
                    alumnoVO.setPrimer_apellido(result.getString("primer_apellido"));
                    alumnoVO.setSegundo_apellido(result.getString("segundo_apellido"));
                    alumnoVO.setFechaNacimiento(result.getString("fechaNacimiento"));
                    alumnoVO.setTipo_sangre(result.getString("tipoSangre"));
                    alumnoVO.setSexo(result.getString("sexo"));
                    alumnoVO.setId_alumno(result.getInt("id_alumno"));
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
        String sql = "DELETE FROM "+this.tabla+" WHERE id_alumno='"+id+"'";
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
        String sql = "UPDATE "+this.tabla+" SET primer_nombre=? where id_alumno= '"+id+"'";

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
    
    private void LlenarCodigo(){
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    PreparedStatement ps = null;
    ResultSet result = null;
    conexion = conexiondb.getConnection();
      try {
            String sql = "select last_value+1 as valor from public.pedidos_codped_seq";
            //ResultSet rs = acciones.Consultar(sql);
            while (result.next()) {
                //lblCodigo.setText(String.valueOf(rs.getInt("valor")));
            }
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }
    
    public DefaultTableModel consultarAlumnosTabla(String parametro){
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
