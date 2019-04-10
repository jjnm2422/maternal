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
 * @author acjj
 */
public class UsuarioDAO {

    private Coordinador coordinador;
    private final String tabla = "usuario";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarUsuario(VO.UsuarioVO usuarioVO) {
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into " + this.tabla + "(id_usuario, nombre_usuario, clave, pregunta_secreta, respuesta_secreta, admin, activo)"
                + "values(?,?,?,?,?,?,?)";
        if (conexion != null) {
            try {
                ps = conexion.prepareCall(sql);
                ps.setString(1, usuarioVO.getId_usuario());
                ps.setString(2, usuarioVO.getNombre_usuario());
                ps.setString(3, usuarioVO.getClave());
                ps.setString(4, usuarioVO.getPregunta_secreta());
                ps.setString(5, usuarioVO.getRespuesta_secreta());
                ps.setBoolean(6, usuarioVO.isAdmin());
                ps.setBoolean(7, usuarioVO.isActivo());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "INGRESADO CON EXITO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.UsuarioVO consultarUsuario(String nombre_usuario) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.UsuarioVO usuarioVO = new VO.UsuarioVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE nombre_usuario = ?";

            try {
                ps = conexion.prepareStatement(sql);
                ps.setString(1, nombre_usuario);
                result = ps.executeQuery();
                while (result.next() == true) {
                    usuarioVO.setNombre_usuario(result.getString("nombre_usuario"));
                    usuarioVO.setPregunta_secreta(result.getString("pregunta_secreta"));
                    usuarioVO.setRespuesta_secreta(result.getString("respuesta_secreta"));
                    usuarioVO.setId_usuario(result.getString("id_usuario"));
                    usuarioVO.setAdmin(result.getBoolean("admin"));
                    usuarioVO.setActivo(result.getBoolean("activo"));
                    usuarioVO.setClave(result.getString("clave"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return usuarioVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }

    public String consultarUsuarioLogin(String usuario, String clave) {
        Connection conexion = null;
        String resultado = "";
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE nombre_usuario = '" + usuario + "'";
            try {
                ps = conexion.prepareStatement(sql);
                boolean isVacia = false;
                result = ps.executeQuery();
                while (result.next() == true) {
                    isVacia = true;
                    if (result.getBoolean("activo")) {
                        if (clave.equals(result.getString("clave"))) {
                            if (result.getBoolean("admin")) {
                                resultado = "ACCESO_ADMIN";
                            } else {
                                resultado = "ACCESO_NORMAL";
                            }
                        } else {
                            resultado = "NO_CLAVE";
                        }
                    } else {
                        resultado = "NO_ACTIVO";
                    }
                }
                if (isVacia == false) {
                    resultado = "NO_USUARIO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                resultado = "ERROR_SQL";
            }
        } else {
            resultado = "SIN_CONEXION";
        }
        conexiondb.desconexion();
        return resultado;
    }

    public String eliminarUsuario(String id) {
        Statement st = null;
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM " + this.tabla + " WHERE cedula='" + id + "'";
        if (conexion != null) {
            try {
                st = conexion.createStatement();
                if (st.execute(sql)) {
                    return "ELIMINADO";
                } else {
                    return "NO ELIMINADO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                return "NO ELIMINADO";
            }
        } else {
            return "ERROR AL CONECTAR CON BD";
        }

    }

    public String actualizarUsuario(VO.UsuarioVO usuarioVO, String id_usuario) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET nombre_usuario = ?, clave = ?, pregunta_secreta = ?, respuesta_secreta = ?, admin = ?, activo=? where id_usuario= '" + id_usuario + "'";
        if (conexion != null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, usuarioVO.getNombre_usuario());
                ps.setString(2, usuarioVO.getClave());
                ps.setString(3, usuarioVO.getPregunta_secreta());
                ps.setString(4, usuarioVO.getRespuesta_secreta());
                ps.setBoolean(5, usuarioVO.isAdmin());
                ps.setBoolean(6, usuarioVO.isActivo());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "INGRESADO CON EXITO";
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

    public String actualizarClaveUsuario(String clave, String id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET clave=? where id_usuario= '" + id + "'";

        if (conexion != null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, clave);
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
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

    public String getPreguntaSecreta(String usuario) {
        return "";
    }

    public DefaultTableModel consultarUsuarioTabla() {
        Statement st = null;
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String[] titulos = {"id", "Usuario"};
        String[] fila = new String[titulos.length];
        String sql = "SELECT * FROM " + this.tabla;
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                fila[0] = rs.getString("id_usuario");
                fila[1] = rs.getString("nombre_usuario");
                model.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar ", null, JOptionPane.ERROR_MESSAGE);
            return model = null;
        }
        return model;
    }
}
