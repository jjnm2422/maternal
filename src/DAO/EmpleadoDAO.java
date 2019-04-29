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
import java.sql.Array;
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
        String sql = "INSERT INTO "+this.tabla+" (primer_nombre, primer_apellido, edad, telefono1, direccion, cedula, fecha_nacimiento, foto, id_empleado, grupo, fecha_ingreso) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        if (conexion!=null) {
            try {
            ps = conexion.prepareCall(sql);
            ps.setString(1, empleadoVO.getPrimer_nombre());
            ps.setString(2, empleadoVO.getPrimer_apellido());
            ps.setInt(3, empleadoVO.getEdad());
            ps.setString(4, empleadoVO.getTelefono1());
            Array direccionArray = conexion.createArrayOf("text",  empleadoVO.getDireccion());
            ps.setArray(5, direccionArray);
            ps.setString(6, empleadoVO.getCedula());
            ps.setString(7, empleadoVO.getFechaNacimiento());
            if (empleadoVO.getFis() != null) {
                   ps.setBinaryStream(8, empleadoVO.getFis(), empleadoVO.getBinarioFoto());
            } else {
                ps.setBinaryStream(8, null, 0);
            }
            ps.setString(9, empleadoVO.getId_empleado());
            ps.setString(10, empleadoVO.getGrupo());
            ps.setString(11, empleadoVO.getFecha_ingreso());
            int n = ps.executeUpdate();
            if (n > 0) {
                respuesta = "INSERT";
            }
            } catch (SQLException ex) {
                 if (ex.getSQLState().equals("23505")) {
                    respuesta =  "ERROR_COD";
                }else{
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                 respuesta = ex.getMessage();
                }
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
                empleadoVO.setFecha_ingreso(result.getString("fecha_ingreso"));
                
                Array direccionArray = result.getArray("direccion");
                String[] direccionArrayS = (String[]) direccionArray.getArray();
                empleadoVO.setDireccion(direccionArrayS);
                
                empleadoVO.setTelefono1(result.getString("telefono1"));
                empleadoVO.setId_empleado(result.getString("id_empleado"));
                empleadoVO.setGrupo(result.getString("grupo"));
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
    
    public String eliminarEmpleado(String id){
        Statement st = null;
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM "+this.tabla+" WHERE id_empleado= '"+id+"'";
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
            System.out.println(ex.getMessage());
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "NO ELIMINADO";
        }  
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
        
    }
    
    public String actualizarEmpleadoConFoto(VO.EmpleadoVO empleadoVO, String id_empleado){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET primer_nombre=?, primer_apellido=?, edad=?, telefono1=?, direccion=?, cedula=?, fecha_nacimiento=?, foto=?, grupo=?, fecha_ingreso=? where id_empleado= '"+id_empleado+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps = conexion.prepareCall(sql);
                ps.setString(1, empleadoVO.getPrimer_nombre());
                ps.setString(2, empleadoVO.getPrimer_apellido());
                ps.setInt(3, empleadoVO.getEdad());
                ps.setString(4, empleadoVO.getTelefono1());
                Array direccionArray = conexion.createArrayOf("text",  empleadoVO.getDireccion());
                ps.setArray(5, direccionArray);
                ps.setString(6, empleadoVO.getCedula());
                ps.setString(7, empleadoVO.getFechaNacimiento());
                ps.setString(8, empleadoVO.getFecha_ingreso());
                if (empleadoVO.getFis() != null) {
                       ps.setBinaryStream(8, empleadoVO.getFis(), empleadoVO.getBinarioFoto());
                } else {
                    ps.setBinaryStream(8, null, 0);
                }
                ps.setString(9, empleadoVO.getGrupo());
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
    
        public String actualizarEmpleadoSinFoto(VO.EmpleadoVO empleadoVO, String id_empleado){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET primer_nombre=?, primer_apellido=?, edad=?, telefono1=?, direccion=?, cedula=?, fecha_nacimiento=?, grupo=?, fecha_ingreso=? where id_empleado= '"+id_empleado+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps = conexion.prepareCall(sql);
                ps.setString(1, empleadoVO.getPrimer_nombre());
                ps.setString(2, empleadoVO.getPrimer_apellido());
                ps.setInt(3, empleadoVO.getEdad());
                ps.setString(4, empleadoVO.getTelefono1());
                Array direccionArray = conexion.createArrayOf("text",  empleadoVO.getDireccion());
                ps.setArray(5, direccionArray);
                ps.setString(6, empleadoVO.getCedula());
                ps.setString(7, empleadoVO.getFechaNacimiento());
                ps.setString(8, empleadoVO.getGrupo());
                ps.setString(9, empleadoVO.getFecha_ingreso());
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
    String[]titulos={"ID","Nombre y Apellido"};
    String[]fila=new String[titulos.length];
    String sql="SELECT * FROM "+this.tabla+ " where id_empleado <> '1'";
    DefaultTableModel model = new DefaultTableModel(null,titulos);
    
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
   
    while(rs.next()){
        fila[0]=rs.getString("id_empleado");
        fila[1]=rs.getString("primer_nombre") +" " + rs.getString("primer_apellido");
        model.addRow(fila);
    }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar "+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
           return model = null;
        }
    return model;
}
    
public DefaultTableModel consultarEmpleadosCedulaTabla(String cedula){
    Statement st = null;
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    conexion = conexiondb.getConnection();
    String[]titulos={"ID","Cedula","Primer Nombre","Primer Apellido"};
    String[]fila=new String[titulos.length];
    String sql="SELECT * FROM "+this.tabla+ " where id_empleado <> '1' and cedula = '"+cedula+"'";
    DefaultTableModel model = new DefaultTableModel(null,titulos);
    
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
   
    while(rs.next()){
        fila[0]=rs.getString("id_empleado");
        fila[1]=rs.getString("cedula");
        fila[2]=rs.getString("primer_nombre");
        fila[3]=rs.getString("primer_apellido");
        model.addRow(fila);
    }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar "+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
           return model = null;
        }
    return model;
}

public DefaultTableModel consultarEmpleadosCedulaONombreTabla(String cedula){
    Statement st = null;
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    conexion = conexiondb.getConnection();
    String[]titulos={"ID","Cedula","Primer Nombre","Primer Apellido"};
    String[]fila=new String[titulos.length];
    String sql="SELECT * FROM "+this.tabla+ " where (id_empleado <> '1' or primer_nombre <> 'admin') and (cedula like '%"+cedula+"%' " +" or primer_nombre like '%"+cedula+"%')";
    DefaultTableModel model = new DefaultTableModel(null,titulos);
    
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
   
    while(rs.next()){
        fila[0]=rs.getString("id_empleado");
        fila[1]=rs.getString("cedula");
        fila[2]=rs.getString("primer_nombre");
        fila[3]=rs.getString("primer_apellido");
        model.addRow(fila);
    }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar "+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
           return model = null;
        }
    return model;
}
    
    public String registrarAsistenciaEmpleados(DefaultTableModel model, boolean asistencia,  String id_usuario) {
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
            ps.setString(1, model.getValueAt(i, 0).toString());
            ps.setString(2, coordinador.getFechaFormateada());
            ps.setBoolean(3,  asistencia);
            ps.setString(4,  id_usuario);
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
