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
public class PagoDAO {

    private Coordinador coordinador;
    private final String tabla = "pago";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarPago(VO.PagoVO pagoVO) {
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO "+this.tabla+"(id_alumno, saldo_favor, saldo_pendiente, total_pagado, periodo, cuotas) VALUES (?,?,?,?,?,?);";
        if (conexion != null) {
            try {
                Array cuotaArray = conexion.createArrayOf("text", pagoVO.getCuotas());
                ps = conexion.prepareCall(sql);
                ps.setInt(1, pagoVO.getId_alumno());
                ps.setDouble(2, pagoVO.getSaldo_favor());
                ps.setDouble(3, pagoVO.getSaldo_pendiente());
                ps.setDouble(4, pagoVO.getTotal_pagado());
                ps.setString(5, pagoVO.getPeriodo());
                ps.setArray(6,  cuotaArray);
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "INGRESADO CON EXITO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
                System.out.println(respuesta);
            }
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }
    
        public VO.PagoVO consultarPago(String id_alumno) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.PagoVO pagoVO = new VO.PagoVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '"+coordinador.consultarVariables().getPeriodo_actual()+"'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    //conversion de arrays
                    Array pagoArray =  result.getArray("cuotas");
                   String[] pagoArrayS = (String[]) pagoArray.getArray();
                    
                    pagoVO.setId_alumno(result.getInt("id_alumno"));
                    pagoVO.setSaldo_favor(result.getDouble("saldo_favor"));
                    pagoVO.setSaldo_pendiente(result.getDouble("saldo_pendiente"));
                    pagoVO.setTotal_pagado(result.getDouble("total_pagado"));
                    pagoVO.setPeriodo(result.getString("periodo"));
                    pagoVO.setCuotas(pagoArrayS);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return pagoVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
        
        public VO.PagoVO consultarPagoPorLapso(String id_alumno, int lapso ) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.PagoVO pagoVO = new VO.PagoVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '"+coordinador.consultarVariables().getPeriodo_actual()+"' "
                    + " and lapso= "+lapso;
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    pagoVO.setId_alumno(result.getInt("id_alumno"));
                    pagoVO.setId_pago(result.getInt("id_pago")); 
                    pagoVO.setPeriodo(result.getString("periodo"));
                    //conversion de arrays
                    Array pagoArray =  result.getArray("formacion_personal_social");
                    Array pagoArray2 =  result.getArray("relacion_ambiente");
                    Array pagoArray3 =  result.getArray("comunicacion_presentacion");
                    Array pagoArray4 =  result.getArray("indicadores_evaluados");
                    Array pagoArray5 =  result.getArray("habitos_trabajo");
                    String[] pagoArrayS = (String[]) pagoArray.getArray();
                    
                //    pagoVO.setFormacion_personal_social(pagoArrayS);

                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return pagoVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }

    public String eliminarPago(String id) {
        Statement st = null;
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM " + this.tabla + " WHERE id_pago='" + id + "'";
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
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return "NO ELIMINADO \n"+ex.getMessage();
            }
        } else {
            return "ERROR AL CONECTAR CON BD";
        }

    }

    public String actualizarPago(VO.PagoVO pagoVO, int id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET saldo_favor=?, saldo_pendiente=?, total_pagado=?, periodo=?, cuotas=? where id_alumno= " + id  ;

            try {
                 PreparedStatement ps = conexion.prepareStatement(sql);
                Array cuotaArray = conexion.createArrayOf("text", pagoVO.getCuotas()); 
                ps.setDouble(1, pagoVO.getSaldo_favor());
                ps.setDouble(2, pagoVO.getSaldo_pendiente());
                ps.setDouble(3, pagoVO.getTotal_pagado());
                ps.setString(4, pagoVO.getPeriodo());
                ps.setArray(5,  cuotaArray);
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
    }
    
    public String actualizarPagoSinFoto(VO.PagoVO pagoVO, String id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET fecha_nacimiento=?, primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, tipo_sangre=?, edad=?, sexo=?, direccion=?, alergias=? where id_pago= '" + id + "'";

        if (conexion != null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }

    public int llenarCodigoPago() {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        Statement st = null;
        ResultSet result = null;
        int valor = -1;
        conexion = conexiondb.getConnection();
        try {
            String sql = "select last_value+1 as valor from public.pagos_id_pagos_seq";
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

    public DefaultTableModel consultarPagosTabla(String parametro) {
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
