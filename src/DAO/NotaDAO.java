/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Coordinador;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acjj
 */
public class NotaDAO {

    private Coordinador coordinador;
    private final String tabla = "nota";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarNota(VO.NotaVO notaVO) {
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO "+this.tabla+"(id_empleado, id_alumno, fecha, formacion_personal_social, relacion_ambiente, comunicacion_presentacion, indicadores_evaluados, habitos_trabajo, lapso) VALUES (?,?,?,?,?,?,?,?,?);";
        if (conexion != null) {
            try {
                Array notaArray = conexion.createArrayOf("text", notaVO.getFormacion_personal_social());
                Array notaArray2 = conexion.createArrayOf("text", notaVO.getRelacion_ambiente());
                Array notaArray3 = conexion.createArrayOf("text", notaVO.getComunicacion_presentacion());
                Array notaArray4 = conexion.createArrayOf("text", notaVO.getIndicadores_evaluados());
                Array notaArray5 = conexion.createArrayOf("text", notaVO.getHabitos_trabajo());
                ps = conexion.prepareCall(sql);
                ps.setInt(1, notaVO.getId_empleado());
                ps.setInt(2, notaVO.getId_alumno());
                ps.setString(3, notaVO.getFecha());
                ps.setArray(4, notaArray);
                ps.setArray(5, notaArray2);
                ps.setArray(6, notaArray3);
                ps.setArray(7, notaArray4);
                ps.setArray(8, notaArray5);
                ps.setInt(9, notaVO.getLapso());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "INGRESADO CON EXITO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
                System.out.println(respuesta);
            }
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }

    public VO.NotaVO consultarNota(String parametro) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.NotaVO notaVO = new VO.NotaVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_nota = '" + parametro + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return notaVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }

    public String eliminarNota(String id) {
        Statement st = null;
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM " + this.tabla + " WHERE id_nota='" + id + "'";
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
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return "NO ELIMINADO \n"+ex.getMessage();
            }
        } else {
            return "ERROR AL CONECTAR CON BD";
        }

    }

    public String actualizarNota(VO.NotaVO notaVO, String id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET fecha_nacimiento=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, tipo_sangre=?, edad=?, sexo=?, direccion=?, alergias=?, foto=? where id_nota= '" + id + "'";

        if (conexion != null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }
    
    public String actualizarNotaSinFoto(VO.NotaVO notaVO, String id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET fecha_nacimiento=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, tipo_sangre=?, edad=?, sexo=?, direccion=?, alergias=? where id_nota= '" + id + "'";

        if (conexion != null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }

    public int llenarCodigoNota() {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        Statement st = null;
        ResultSet result = null;
        int valor = -1;
        conexion = conexiondb.getConnection();
        try {
            String sql = "select last_value+1 as valor from public.notas_id_notas_seq";
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

    public DefaultTableModel consultarNotasTabla(String parametro) {
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

}
