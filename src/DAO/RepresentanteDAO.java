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
        String sql = "insert into "+this.tabla+"(primer_nombre, primer_apellido, telefono1, telefono2, direccion, parentesco, ocupacion, cedula, empresa, id_alumno, foto, tipo)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        if (conexion!=null) {
            try {
            ps = conexion.prepareCall(sql);
            ps.setString(1, representanteVO.getPrimer_nombre());
            ps.setString(2, representanteVO.getPrimer_apellido());
            ps.setString(3, representanteVO.getTelefono1());
            ps.setString(4, representanteVO.getTelefono2());
            
            Array direccionArray = conexion.createArrayOf("text",  representanteVO.getDireccion());
            ps.setArray(5, direccionArray);
            ps.setString(6, representanteVO.getParentesco());
            ps.setString(7, representanteVO.getOcupacion());
            ps.setString(8, representanteVO.getCedula());
            ps.setString(9, representanteVO.getEmpresa());
            ps.setString(10, representanteVO.getId_alumno());
            if (representanteVO.getFis() != null) {
                    ps.setBinaryStream(11, representanteVO.getFis(), representanteVO.getBinarioFoto());
                } else {
                    ps.setBinaryStream(11, null, 0);
                }
            ps.setInt(12, representanteVO.getTipo());
            int n = ps.executeUpdate();
            if (n > 0) {
                 respuesta = "INGRESADO CON EXITO";
            }
            } catch (SQLException ex) {
                Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                 respuesta = ex.getMessage();
                 System.out.println(ex.getMessage());
            } 
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.RepresentanteVO consultarRepresentante(String cedula, int tipo) {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.RepresentanteVO representanteVO = new VO.RepresentanteVO();
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM "+this.tabla+" WHERE cedula = ? and tipo = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, cedula);
                ps.setInt(2, tipo);
                result = ps.executeQuery();
                    while (result.next()==true) {
                    representanteVO.setPrimer_nombre(result.getString("primer_nombre"));
                    representanteVO.setPrimer_apellido(result.getString("primer_apellido"));
                    representanteVO.setTelefono1(result.getString("telefono1"));
                    representanteVO.setTelefono2(result.getString("telefono2"));
                   
                    Array direccionArray = result.getArray("direccion");
                    String[] direccionArrayS = (String[]) direccionArray.getArray();
                    representanteVO.setDireccion(direccionArrayS);
                    
                    representanteVO.setParentesco(result.getString("parentesco"));
                    representanteVO.setOcupacion(result.getString("ocupacion"));
                    representanteVO.setCedula(result.getString("cedula"));
                    representanteVO.setEmpresa(result.getString("empresa"));
                    representanteVO.setId_alumno(result.getString("id_alumno"));
                    representanteVO.setTipo(result.getInt("tipo"));
                    //codigo para extraer imagen
                    if (result.getBinaryStream("foto") != null) {
                        is = result.getBinaryStream("foto");
                        BufferedImage bi = ImageIO.read(is);
                        foto = new ImageIcon(bi);
                        representanteVO.setFoto(foto);
                    }
                    }
            } catch (SQLException ex) {
                Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return representanteVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    
      public VO.RepresentanteVO consultarRepresentantePorAlumno(String id_alumno, int tipo) {
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.RepresentanteVO representanteVO = new VO.RepresentanteVO();
        conexion = conexiondb.getConnection();
        
        if (conexion!=null) {
            String sql = "SELECT * FROM "+this.tabla+" WHERE id_alumno = ? and tipo = ?";
        
            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, id_alumno);
                ps.setInt(2, tipo);
                result = ps.executeQuery();
                    while (result.next()==true) {
                    representanteVO.setPrimer_nombre(result.getString("primer_nombre"));
                    representanteVO.setPrimer_apellido(result.getString("primer_apellido"));
                    representanteVO.setTelefono1(result.getString("telefono1"));
                    representanteVO.setTelefono2(result.getString("telefono2"));
                    
                    Array direccionArray = result.getArray("direccion");
                    String[] direccionArrayS = (String[]) direccionArray.getArray();
                    representanteVO.setDireccion(direccionArrayS);
                    
                    representanteVO.setParentesco(result.getString("parentesco"));
                    representanteVO.setOcupacion(result.getString("ocupacion"));
                    representanteVO.setCedula(result.getString("cedula"));
                    representanteVO.setEmpresa(result.getString("empresa"));
                    representanteVO.setId_alumno(result.getString("id_alumno"));
                    representanteVO.setTipo(result.getInt("tipo"));
                    //codigo para extraer imagen
                    if (result.getBinaryStream("foto") != null) {
                        is = result.getBinaryStream("foto");
                        BufferedImage bi = ImageIO.read(is);
                        foto = new ImageIcon(bi);
                        representanteVO.setFoto(foto);
                    }
                    }
            } catch (SQLException ex) {
                Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return representanteVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    
    public String eliminarRepresentante(String id_alumno){
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
            Logger.getLogger(RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "NO ELIMINADO \n"+ex.getMessage();
        }  
        } else {
            return "ERROR AL CONECTAR CON BD";
        }  
    }
    
    public String actualizarRepresentante(VO.RepresentanteVO representanteVO, String id_alumno, int tipo){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET primer_nombre=?, primer_apellido=?, telefono1=?, telefono2=?, direccion=?, parentesco=?, ocupacion=?, cedula=?, empresa=?, foto=? where id_alumno= '"+id_alumno+"' and tipo= '"+tipo+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, representanteVO.getPrimer_nombre());
                ps.setString(2, representanteVO.getPrimer_apellido());
                ps.setString(3, representanteVO.getTelefono1());
                ps.setString(4, representanteVO.getTelefono2());
                Array direccionArray = conexion.createArrayOf("text",  representanteVO.getDireccion());
                ps.setArray(5, direccionArray);
                ps.setString(6, representanteVO.getParentesco());
                ps.setString(7, representanteVO.getOcupacion());
                ps.setString(8, representanteVO.getCedula());
                ps.setString(9, representanteVO.getEmpresa());
                if (representanteVO.getFis() != null) {
                    ps.setBinaryStream(10, representanteVO.getFis(), representanteVO.getBinarioFoto());
                } else {
                    ps.setBinaryStream(10, null, 0);
                }
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
    
        public String actualizarRepresentanteSinFoto(VO.RepresentanteVO representanteVO, String id_alumno, int tipo){
        Statement st = null;
        String respuesta = "";
        Connection conexion= null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE "+this.tabla+" SET primer_nombre=?, primer_apellido=?, telefono1=?, telefono2=?, direccion=?, parentesco=?, ocupacion=?, cedula=?, empresa=? where id_alumno= '"+id_alumno+"' and tipo= '"+tipo+"'";

        if (conexion!=null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, representanteVO.getPrimer_nombre());
                ps.setString(2, representanteVO.getPrimer_apellido());
                ps.setString(3, representanteVO.getTelefono1());
                ps.setString(4, representanteVO.getTelefono2());
                Array direccionArray = conexion.createArrayOf("text",  representanteVO.getDireccion());
                ps.setArray(5, direccionArray);
                ps.setString(6, representanteVO.getParentesco());
                ps.setString(7, representanteVO.getOcupacion());
                ps.setString(8, representanteVO.getCedula());
                ps.setString(9, representanteVO.getEmpresa());
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
        
    public DefaultTableModel consultarRepresentanteTabla(String cedula_representante) {
        boolean encontrado = false;
        Statement st = null;
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String[] titulos = {"Cedula", "Nombre y Apellido"};
        String[] fila = new String[titulos.length];
        String sql = "SELECT cedula, primer_nombre, primer_apellido FROM "+this.tabla+" WHERE cedula like '%"+cedula_representante+"%' and tipo =1 GROUP BY cedula, primer_nombre, primer_apellido" ;
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                fila[0] = rs.getString("cedula");
                fila[1] = rs.getString("primer_nombre") + " " +rs.getString("primer_apellido");
                model.addRow(fila);
                encontrado = true;
            }
//            if (encontrado == false) {
//                JOptionPane.showMessageDialog(null, " La cedula ingresada no esta registrada ", null, JOptionPane.ERROR_MESSAGE);
//                return model = null;
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar ", null, JOptionPane.ERROR_MESSAGE);
            return model = null;
        }
        return model;
    }
}
