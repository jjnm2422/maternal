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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author acjj
 */
public class RegistroPagoDAO {

    private Coordinador coordinador;
    private final String tabla = "registro_pago";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String registrarRegistroPago(VO.RegistroPagoVO registroPagoVO) {
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO "+this.tabla+"(numero_registro, tipo_pago, numero_transaccion, fecha_comprobante, banco_emisor, numero_referencia, fecha_ejecucion, fecha, monto, id_pago, depositante, concepto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        if (conexion != null) {
            try {
                ps = conexion.prepareCall(sql);
                ps.setString(1, registroPagoVO.getNumero_registro());
                ps.setString(2, registroPagoVO.getTipo_pago());
                ps.setString(3, registroPagoVO.getNumero_transaccion());
                ps.setString(4, registroPagoVO.getFecha_comprobante());
                ps.setString(5, registroPagoVO.getBanco_emisor());
                ps.setString(6, registroPagoVO.getNumero_referencia());
                ps.setString(7, registroPagoVO.getFecha_ejecucion());
                ps.setString(8, registroPagoVO.getFecha());
                ps.setDouble(9, registroPagoVO.getMonto());
                ps.setInt(10, registroPagoVO.getId_pago());
                ps.setString(11, registroPagoVO.getDepositante());
                ps.setString(12, registroPagoVO.getConcepto());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "INGRESADO CON EXITO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
                System.out.println(respuesta);
            }
        } else {
            respuesta = "ERROR AL CONECTAR CON BD";
        }
        return respuesta;
    }
    
        public VO.RegistroPagoVO consultarRegistroPago(String id_alumno) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.RegistroPagoVO registroPagoVO = new VO.RegistroPagoVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                registroPagoVO.setNumero_registro(result.getString("numero_registro"));
               registroPagoVO.setTipo_pago(result.getString("tipo_pago"));
                 registroPagoVO.setNumero_transaccion(result.getString("numero_transaccion"));
                registroPagoVO.setFecha_comprobante(result.getString("fecha_comprobante"));
                registroPagoVO.setBanco_emisor(result.getString("banco_emisor"));
                registroPagoVO.setNumero_referencia(result.getString("numero_referencia"));
                 registroPagoVO.setFecha_ejecucion(result.getString("fecha_ejecucion"));
                 registroPagoVO.setDepositante(result.getString("depositante"));
                 registroPagoVO.setFecha(result.getString("fecha"));
                 registroPagoVO.setMonto(result.getDouble("monto"));
                registroPagoVO.setId_pago(result.getInt("id_pago"));
                registroPagoVO.setId_registro(result.getInt("id_registro"));
                registroPagoVO.setConcepto(result.getString("concepto"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return registroPagoVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    

    public String eliminarRegistroPago(String id) {
        Statement st = null;
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "DELETE FROM " + this.tabla + " WHERE id_registro='" + id + "'";
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
                Logger.getLogger(RegistroPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return "NO ELIMINADO \n"+ex.getMessage();
            }
        } else {
            return "ERROR AL CONECTAR CON BD";
        }

    }

    public String actualizarRegistroPago(VO.RegistroPagoVO registroPagoVO, int id) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET numero_registro=?, tipo_pago=?, numero_transaccion=?, fecha_comprobante=?, banco_emisor=?, numero_referencia=?, fecha_ejecucion=?, fecha=?, monto=?, id_pago=?, depositante=?, concepto=? where id_registro= " + id  ;

            try {
                 PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, registroPagoVO.getNumero_registro());
                ps.setString(2, registroPagoVO.getTipo_pago());
                ps.setString(3, registroPagoVO.getNumero_transaccion());
                ps.setString(4, registroPagoVO.getFecha_comprobante());
                ps.setString(5, registroPagoVO.getBanco_emisor());
                ps.setString(6, registroPagoVO.getNumero_referencia());
                ps.setString(7, registroPagoVO.getFecha_ejecucion());
                ps.setString(8, registroPagoVO.getFecha());
                ps.setDouble(9, registroPagoVO.getMonto());
                ps.setInt(10, registroPagoVO.getId_pago());
                ps.setString(11, registroPagoVO.getDepositante());
                ps.setString(12, registroPagoVO.getConcepto());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
    }

    public int llenarCodigoRegistroPago() {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        Statement st = null;
        ResultSet result = null;
        int valor = -1;
        conexion = conexiondb.getConnection();
        try {
            String sql = "select last_value+1 as valor from public.pago_id_pago_seq";
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
    
    public String NumeroAleatorio() {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        long numero = 0;
        Random rd = new Random();
        conexion = conexiondb.getConnection();
        numero = rd.nextInt(99999) + 1;
        try {
            String sql = "select * from "+ this.tabla + " where numero_registro= '" + numero + "'";
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                numero = Long.parseLong(this.NumeroAleatorio());
            }
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return String.valueOf(numero);
    }

}
