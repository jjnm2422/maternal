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
public class EmpleadoDAO {

    private Coordinador coordinador;
    private final String tabla = "empleado";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarEmpleado(VO.EmpleadoVO empleadoVO) {
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO "+this.tabla+" (primer_nombre, primer_apellido, edad, telefono1, direccion, cedula, fecha_nacimiento, foto) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        if (conexion!=null) {
            try {
            ps = conexion.prepareCall(sql);
            ps.setString(1, empleadoVO.getPrimer_nombre());
            ps.setString(2, empleadoVO.getPrimer_apellido());
            ps.setInt(3, empleadoVO.getEdad());
            ps.setString(4, empleadoVO.getTelefono1());
            ps.setString(5, empleadoVO.getDireccion());
            ps.setString(6, empleadoVO.getCedula());
            ps.setString(7, empleadoVO.getFechaNacimiento());
            if (empleadoVO.getFis() != null) {
                   ps.setBinaryStream(8, empleadoVO.getFis(), empleadoVO.getBinarioFoto());
            } else {
                ps.setBinaryStream(8, null, 0);
            }
            int n = ps.executeUpdate();
            if (n > 0) {
                respuesta = "INGRESADO CON EXITO";
            }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                 respuesta = ex.getMessage();
            } 
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.EmpleadoVO consultarEmpleado(String usuario) {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        InputStream is;
        ImageIcon foto;
        VO.EmpleadoVO empleadoVO = new VO.EmpleadoVO();
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM "+this.tabla+" WHERE cedula = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, usuario);
                result = ps.executeQuery();
                while (result.next()==true) {
                empleadoVO.setPrimer_nombre(result.getString("primer_nombre"));
                empleadoVO.setPrimer_apellido(result.getString("primer_apellido"));
                empleadoVO.setCedula(result.getString("cedula"));
                empleadoVO.setFechaNacimiento(result.getString("fecha_nacimiento"));
                empleadoVO.setDireccion(result.getString("direccion"));
                empleadoVO.setTelefono1(result.getString("telefono1"));
                empleadoVO.setId_empleado(result.getInt("id_empleado"));
                //codigo para extraer imagen
                if (result.getBinaryStream("foto") != null) {
                    is = result.getBinaryStream("foto");
                    BufferedImage bi = ImageIO.read(is);
                    foto = new ImageIcon(bi);
                    empleadoVO.setFoto(foto);
                }
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return empleadoVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    
    public String eliminarEmpleado(int id){
        Statement st = null;
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM "+this.tabla+" WHERE id_empleado= "+id;
        if (conexion!=null) {
             try {
            st = conexion.createStatement();
            if (st.execute(sql)) {
                return "ELIMINADO";
            } else {
                return "NO ELIMINADO";
            }   
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "NO ELIMINADO";
        }  
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
        
    }
    
    public String actualizarEmpleadoConFoto(VO.EmpleadoVO empleadoVO, int id){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET primer_nombre=?, primer_apellido=?, edad=?, telefono1=?, direccion=?, cedula=?, fecha_nacimiento=?, foto=? where id_empleado= "+id;

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps = conexion.prepareCall(sql);
                ps.setString(1, empleadoVO.getPrimer_nombre());
                ps.setString(2, empleadoVO.getPrimer_apellido());
                ps.setInt(3, empleadoVO.getEdad());
                ps.setString(4, empleadoVO.getTelefono1());
                ps.setString(5, empleadoVO.getDireccion());
                ps.setString(6, empleadoVO.getCedula());
                ps.setString(7, empleadoVO.getFechaNacimiento());
                if (empleadoVO.getFis() != null) {
                       ps.setBinaryStream(8, empleadoVO.getFis(), empleadoVO.getBinarioFoto());
                } else {
                    ps.setBinaryStream(8, null, 0);
                }
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }
    
        public String actualizarEmpleadoSinFoto(VO.EmpleadoVO empleadoVO, int id){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET primer_nombre=?, primer_apellido=?, edad=?, telefono1=?, direccion=?, cedula=?, fecha_nacimiento=? where id_empleado= "+id;

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps = conexion.prepareCall(sql);
                ps.setString(1, empleadoVO.getPrimer_nombre());
                ps.setString(2, empleadoVO.getPrimer_apellido());
                ps.setInt(3, empleadoVO.getEdad());
                ps.setString(4, empleadoVO.getTelefono1());
                ps.setString(5, empleadoVO.getDireccion());
                ps.setString(6, empleadoVO.getCedula());
                ps.setString(7, empleadoVO.getFechaNacimiento());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }
    
    public DefaultTableModel consultarEmpleadosTodosTabla(){
    Statement st = null;
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    conexion = conexiondb.getConnection();
    String[]titulos={"ID","Primer Nombre","Primer Apellido"};
    String[]fila=new String[titulos.length];
    String sql="SELECT * FROM "+this.tabla+ " where id_empleado <> 1";
    DefaultTableModel model = new DefaultTableModel(null,titulos);
    
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
   
    while(rs.next()){
        fila[0]=rs.getString("id_empleado");
        fila[1]=rs.getString("primer_nombre");
        fila[2]=rs.getString("primer_apellido");
        model.addRow(fila);
    }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar "+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
           return model = null;
        }
    return model;
}
    public String registrarAsistenciaEmpleados(DefaultTableModel model, boolean asistencia,  int usuario) {
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
                respuesta = "Asistencia guardada con exito";
            }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
                break;
            } 
        } else {
            respuesta = "ERROR al conectarse con BD";
        }
        }
        return respuesta;
    }
}
