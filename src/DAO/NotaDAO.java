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

        String sql = "INSERT INTO "+this.tabla+"(id_empleado, id_alumno, fecha, formacion_personal_social, relacion_ambiente, comunicacion_presentacion, indicadores_evaluados, habitos_trabajo, lapso, periodo) VALUES (?,?,?,?,?,?,?,?,?,?);";
        if (conexion != null) {
            try {
                Array notaArray = conexion.createArrayOf("text", notaVO.getFormacion_personal_social());
                Array notaArray2 = conexion.createArrayOf("text", notaVO.getRelacion_ambiente());
                Array notaArray3 = conexion.createArrayOf("text", notaVO.getComunicacion_presentacion());
                Array notaArray4 = conexion.createArrayOf("text", notaVO.getIndicadores_evaluados());
                Array notaArray5 = conexion.createArrayOf("text", notaVO.getHabitos_trabajo());
                ps = conexion.prepareCall(sql);
                ps.setString(1, notaVO.getId_empleado());
                ps.setString(2, notaVO.getId_alumno());
                ps.setString(3, notaVO.getFecha());
                ps.setArray(4, notaArray);
                ps.setArray(5, notaArray2);
                ps.setArray(6, notaArray3);
                ps.setArray(7, notaArray4);
                ps.setArray(8, notaArray5);
                ps.setInt(9, notaVO.getLapso());
                ps.setString(10, notaVO.getPeriodo());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "INSERT";
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
                System.out.println(respuesta);
            }
        } else {
            respuesta = "ERROR";
        }
        return respuesta;
    }
    
        public VO.NotaVO consultarNota(String id_alumno) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.NotaVO notaVO = new VO.NotaVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '"+coordinador.consultarVariables().getPeriodo_actual()+"' ORDER BY LAPSO";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    notaVO.setId_alumno(result.getString("id_alumno"));
                    notaVO.setId_empleado(result.getString("id_empleado")); 
                    notaVO.setId_nota(result.getInt("id_nota")); 
                    notaVO.setPeriodo(result.getString("periodo"));
                    notaVO.setFecha(result.getString("fecha"));
                    notaVO.setLapso(result.getInt("lapso"));
                    //conversion de arrays
                    Array notaArray =  result.getArray("formacion_personal_social");
                    Array notaArray2 =  result.getArray("relacion_ambiente");
                    Array notaArray3 =  result.getArray("comunicacion_presentacion");
                    Array notaArray4 =  result.getArray("indicadores_evaluados");
                    Array notaArray5 =  result.getArray("habitos_trabajo");
                    String[] notaArrayS = (String[]) notaArray.getArray();
                    String[] notaArray2S = (String[]) notaArray2.getArray();
                    String[] notaArray3S = (String[]) notaArray3.getArray();
                    String[] notaArray4S = (String[]) notaArray4.getArray();
                    String[] notaArray5S = (String[]) notaArray5.getArray();
                    
                    notaVO.setFormacion_personal_social(notaArrayS);
                    notaVO.setRelacion_ambiente(notaArray2S);
                    notaVO.setComunicacion_presentacion(notaArray3S);
                    notaVO.setIndicadores_evaluados(notaArray4S);
                    notaVO.setHabitos_trabajo(notaArray5S);
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
        
        public VO.NotaVO consultarNotaPorLapso(String id_alumno, int lapso ) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.NotaVO notaVO = new VO.NotaVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '"+coordinador.consultarVariables().getPeriodo_actual()+"' "
                    + " and lapso= "+lapso;
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    notaVO.setId_alumno(result.getString("id_alumno"));
                    notaVO.setId_empleado(result.getString("id_empleado")); 
                    notaVO.setId_nota(result.getInt("id_nota")); 
                    notaVO.setPeriodo(result.getString("periodo"));
                    notaVO.setFecha(result.getString("fecha"));
                    notaVO.setLapso(result.getInt("lapso"));
                    //conversion de arrays
                    Array notaArray =  result.getArray("formacion_personal_social");
                    Array notaArray2 =  result.getArray("relacion_ambiente");
                    Array notaArray3 =  result.getArray("comunicacion_presentacion");
                    Array notaArray4 =  result.getArray("indicadores_evaluados");
                    Array notaArray5 =  result.getArray("habitos_trabajo");
                    String[] notaArrayS = (String[]) notaArray.getArray();
                    String[] notaArray2S = (String[]) notaArray2.getArray();
                    String[] notaArray3S = (String[]) notaArray3.getArray();
                    String[] notaArray4S = (String[]) notaArray4.getArray();
                    String[] notaArray5S = (String[]) notaArray5.getArray();
                    
                    notaVO.setFormacion_personal_social(notaArrayS);
                    notaVO.setRelacion_ambiente(notaArray2S);
                    notaVO.setComunicacion_presentacion(notaArray3S);
                    notaVO.setIndicadores_evaluados(notaArray4S);
                    notaVO.setHabitos_trabajo(notaArray5S);
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

    public String actualizarNota(VO.NotaVO notaVO, int id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET id_empleado=? , fecha=? , formacion_personal_social=?,  relacion_ambiente=? , comunicacion_presentacion=? , indicadores_evaluados=? , habitos_trabajo=? where id_nota= " + id  ;

            try {
                 PreparedStatement ps = conexion.prepareStatement(sql);
                Array notaArray = conexion.createArrayOf("text", notaVO.getFormacion_personal_social());
                Array notaArray2 = conexion.createArrayOf("text", notaVO.getRelacion_ambiente());
                Array notaArray3 = conexion.createArrayOf("text", notaVO.getComunicacion_presentacion());
                Array notaArray4 = conexion.createArrayOf("text", notaVO.getIndicadores_evaluados());
                Array notaArray5 = conexion.createArrayOf("text", notaVO.getHabitos_trabajo());
                   ps.setString(1, notaVO.getId_empleado());
                   ps.setString(2, notaVO.getFecha());
                   ps.setArray(3, notaArray);
                   ps.setArray(4, notaArray2);
                   ps.setArray(5, notaArray3);
                   ps.setArray(6, notaArray4);
                   ps.setArray(7, notaArray5);
                     int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "UPDATE";
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
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
