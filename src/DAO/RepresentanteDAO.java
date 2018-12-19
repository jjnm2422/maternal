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
            ps.setString(2, representanteVO.getPrimer_nombre());
            ps.setString(3, representanteVO.getTelefono1());
            ps.setString(4, representanteVO.getTelefono2());
            ps.setString(5, representanteVO.getDireccion());
            ps.setString(6, representanteVO.getParentesco());
            ps.setString(7, representanteVO.getOcupacion());
            ps.setString(8, representanteVO.getCedula());
            ps.setString(9, representanteVO.getEmpresa());
            ps.setInt(10, representanteVO.getId_alumno());
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
                    representanteVO.setPrimer_nombre(result.getString("nombre1"));
                    representanteVO.setPrimer_apellido(result.getString("apellido1"));
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
    
      public VO.RepresentanteVO consultarRepresentantePorAlumno(int id_alumno, int tipo) {
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
                ps.setInt(1, id_alumno);
                ps.setInt(2, tipo);
                result = ps.executeQuery();
                    while (result.next()==true) {
                    representanteVO.setPrimer_nombre(result.getString("primer_nombre"));
                    representanteVO.setPrimer_apellido(result.getString("primer_apellido"));
                    representanteVO.setTelefono1(result.getString("telefono1"));
                    representanteVO.setTelefono2(result.getString("telefono2"));
                    representanteVO.setDireccion(result.getString("direccion"));
                    representanteVO.setParentesco(result.getString("parentesco"));
                    representanteVO.setOcupacion(result.getString("ocupacion"));
                    representanteVO.setCedula(result.getString("cedula"));
                    representanteVO.setEmpresa(result.getString("empresa"));
                    representanteVO.setId_alumno(result.getInt("id_alumno"));
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
                ps.setString(1, representanteVO.getPrimer_nombre());
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
