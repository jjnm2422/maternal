/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Coordinador;
import Vista.frmMenuReportes;
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
public class AlumnoDAO {

    private Coordinador coordinador;
    private final String tabla = "alumno";
    private RegistroPagoDAO registroPagoDAO;
    private frmMenuReportes frmMenuReportes;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarAlumno(VO.AlumnoVO alumnoVO) {
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into " + this.tabla + "(fecha_nacimiento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_sangre, edad, sexo, direccion, alergias, foto, estatus, enfermedades)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if (conexion != null) {
            try {
                Array alergiasArray = conexion.createArrayOf("text", alumnoVO.getAlergias());
                ps = conexion.prepareCall(sql);
                ps.setString(1, alumnoVO.getFechaNacimiento());
                ps.setString(2, alumnoVO.getPrimer_nombre());
                ps.setString(3, alumnoVO.getSegundo_nombre());
                ps.setString(4, alumnoVO.getPrimer_apellido());
                ps.setString(5, alumnoVO.getSegundo_apellido());
                ps.setString(6, alumnoVO.getTipo_sangre());
                ps.setInt(7, alumnoVO.getEdad());
                ps.setString(8, alumnoVO.getSexo());
                ps.setString(9, alumnoVO.getDireccion());
                ps.setArray(10, alergiasArray);
                if (alumnoVO.getFis() != null) {
                    ps.setBinaryStream(11, alumnoVO.getFis(), alumnoVO.getBinarioFoto());
                } else {
                    ps.setBinaryStream(11, null, 0);
                }
                ps.setBoolean(12, alumnoVO.isEstatus());
                ps.setString(13, alumnoVO.getEnfermedades());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "INGRESADO CON EXITO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
                System.out.println(respuesta);
            }
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.AlumnoVO consultarAlumno(String parametro) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.AlumnoVO alumnoVO = new VO.AlumnoVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + parametro + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    alumnoVO.setPrimer_nombre(result.getString("primer_nombre"));
                    alumnoVO.setSegundo_nombre(result.getString("segundo_nombre"));
                    alumnoVO.setPrimer_apellido(result.getString("primer_apellido"));
                    alumnoVO.setSegundo_apellido(result.getString("segundo_apellido"));
                    alumnoVO.setDireccion(result.getString("direccion"));
                    //conversion de arrays
                    Array alergiasArray =  result.getArray("alergias");
                    String[] alergiaArrayS = (String[]) alergiasArray.getArray();
                    alumnoVO.setAlergias(alergiaArrayS);
                    
                    alumnoVO.setEdad(result.getInt("edad"));
                    alumnoVO.setId_nota(result.getInt("id_nota"));
                    alumnoVO.setId_pago(result.getInt("id_pago"));
                    alumnoVO.setFechaNacimiento(result.getString("fecha_nacimiento"));
                    alumnoVO.setTipo_sangre(result.getString("tipo_sangre"));
                    alumnoVO.setSexo(result.getString("sexo"));
                    alumnoVO.setId_alumno(result.getInt("id_alumno"));
                    alumnoVO.setEnfermedades(result.getString("enfermedades"));
                    //codigo para extraer imagen
                    if (result.getBinaryStream("foto") != null) {
                        is = result.getBinaryStream("foto");
                        BufferedImage bi = ImageIO.read(is);
                        foto = new ImageIcon(bi);
                        alumnoVO.setFoto(foto);
                    }
                    alumnoVO.setEstatus(result.getBoolean("estatus"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return alumnoVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }

    public String eliminarAlumno(String id) {
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
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return "NO ELIMINADO \n"+ex.getMessage();
            }
        } else {
            return "ERROR AL CONECTAR CON BD";
        }

    }

    public String actualizarAlumno(VO.AlumnoVO alumnoVO, String id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET fecha_nacimiento=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, tipo_sangre=?, edad=?, sexo=?, direccion=?, alergias=?, foto=?, estatus=?, enfermedades=? where id_alumno= '" + id + "'";

        if (conexion != null) {
            try {
                Array alergiasArray = conexion.createArrayOf("text", alumnoVO.getAlergias());
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, alumnoVO.getFechaNacimiento());
                ps.setString(2, alumnoVO.getPrimer_nombre());
                ps.setString(3, alumnoVO.getSegundo_nombre());
                ps.setString(4, alumnoVO.getPrimer_apellido());
                ps.setString(5, alumnoVO.getSegundo_apellido());
                ps.setString(6, alumnoVO.getTipo_sangre());
                ps.setInt(7, alumnoVO.getEdad());
                ps.setString(8, alumnoVO.getSexo());
                ps.setString(9, alumnoVO.getDireccion());
                ps.setArray(10, alergiasArray);
                if (alumnoVO.getFis() != null) {
                    ps.setBinaryStream(11, alumnoVO.getFis(), alumnoVO.getBinarioFoto());
                } else {
                    ps.setBinaryStream(11, null, 0);
                }
                ps.setBoolean(12, alumnoVO.isEstatus());
                ps.setString(13, alumnoVO.getEnfermedades());
 
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
    
    public String actualizarAlumnoSinFoto(VO.AlumnoVO alumnoVO, String id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET fecha_nacimiento=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, tipo_sangre=?, edad=?, sexo=?, direccion=?, alergias=?, estatus=?, enfermedades=? where id_alumno= '" + id + "'";

        if (conexion != null) {
            try {
                Array alergiasArray = conexion.createArrayOf("text", alumnoVO.getAlergias());
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, alumnoVO.getFechaNacimiento());
                ps.setString(2, alumnoVO.getPrimer_nombre());
                ps.setString(3, alumnoVO.getSegundo_nombre());
                ps.setString(4, alumnoVO.getPrimer_apellido());
                ps.setString(5, alumnoVO.getSegundo_apellido());
                ps.setString(6, alumnoVO.getTipo_sangre());
                ps.setInt(7, alumnoVO.getEdad());
                ps.setString(8, alumnoVO.getSexo());
                ps.setString(9, alumnoVO.getDireccion());
                ps.setArray(10, alergiasArray);
                ps.setBoolean(11, alumnoVO.isEstatus());
                ps.setString(12, alumnoVO.getEnfermedades());
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

    public int llenarCodigoAlumno() {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        Statement st = null;
        ResultSet result = null;
        int valor = -1;
        conexion = conexiondb.getConnection();
        try {
            String sql = "select last_value+1 as valor from public.alumnos_id_alumnos_seq";
            st = conexion.createStatement();
            result = st.executeQuery(sql);
            while (result.next()) {
                valor = result.getInt("valor");
            }
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return valor;
    }

    public DefaultTableModel consultarAlumnosTabla(String parametro) {
        boolean encontrado = false;
        Statement st = null;
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String[] titulos = {"Primer Nombre", "Primer Apellido"};
        String[] fila = new String[titulos.length];
        String sql = "SELECT * FROM usuarios WHERE nombre1 = '" + parametro + "'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                fila[0] = rs.getString("nombre1");
                fila[1] = rs.getString("apellido1");
                model.addRow(fila);
                encontrado = true;
            }
            if (encontrado == false) {
                JOptionPane.showMessageDialog(null, " La cedula ingresada no esta registrada ", null, JOptionPane.ERROR_MESSAGE);
                return model = null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar ", null, JOptionPane.ERROR_MESSAGE);
            return model = null;
        }
        return model;
    }

    public void setCoordinador(RegistroPagoDAO registroPagoDAO) {
        this.registroPagoDAO = registroPagoDAO;
    }

}
