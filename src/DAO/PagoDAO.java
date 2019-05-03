/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Coordinador;
import VO.PagoVO;
import Vista.frmPago;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        String sql = "INSERT INTO " + this.tabla + "(id_alumno, saldo, periodo, pago, pagado) VALUES (?,?,?,?,?);";
        if (conexion != null) {
            try {
                //declaro vector
                Double[] pago = new Double[pagoVO.getPago().length];
                pago = pagoVO.getPago();
                Array arrayPago = conexion.createArrayOf("float8", pago);

                ps = conexion.prepareCall(sql);
                ps.setString(1, pagoVO.getId_alumno());
                ps.setDouble(2, pagoVO.getSaldo());
                ps.setString(3, pagoVO.getPeriodo());
                ps.setArray(4, arrayPago);
                ps.setDouble(5, pagoVO.getPagado());
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
        conexiondb.desconexion();
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
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '" + coordinador.consultarVariables().getPeriodo_actual() + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    //conversion de arrays
                    Array pagoArray = result.getArray("pago");
                    Double[] pagoArrayS = (Double[]) pagoArray.getArray();
                    pagoVO.setId_pago(result.getInt("id_pago"));
                    pagoVO.setId_alumno(result.getString("id_alumno"));
                    pagoVO.setSaldo(result.getDouble("saldo"));
                    pagoVO.setPeriodo(result.getString("periodo"));
                    pagoVO.setPago(pagoArrayS);
                    pagoVO.setPagado(result.getDouble("pagado"));
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
    
    public double consultarPagoSaldoAnterior(String id_alumno) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        double saldo = 0D;
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '" + coordinador.periodoAnterior() + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    saldo = result.getDouble("saldo");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return saldo;
        } else {
            conexiondb.desconexion();
            return saldo;
        }
    }
    
        public int getCuotasPendientes(String id_alumno) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.PagoVO pagoVO = new VO.PagoVO();
        conexion = conexiondb.getConnection();
        int cuotasPendientes = 0;

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '" + coordinador.consultarVariables().getPeriodo_actual() + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    //conversion de arrays
                    //recorro el vector buscando montos diferentes de 0 (con deuda)
                    Array pagoArray = result.getArray("pago");
                    Double[] pagoArrayS = (Double[]) pagoArray.getArray();
                    for (int i = 0; i < pagoArrayS.length; i++) {
                        if (pagoArrayS[i] != 0) {
                            cuotasPendientes++;
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return cuotasPendientes;
        } else {
            conexiondb.desconexion();
            return 0;
        }
    }
        
    public int getCuotasPagadas(String id_alumno) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.PagoVO pagoVO = new VO.PagoVO();
        conexion = conexiondb.getConnection();
        int cuotasPagadas = 0;

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '" + coordinador.consultarVariables().getPeriodo_actual() + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    //conversion de arrays
                    //recorro el vector buscando montos diferentes de 0 (con deuda)
                    Array pagoArray = result.getArray("pago");
                    Double[] pagoArrayS = (Double[]) pagoArray.getArray();
                    for (int i = 0; i < pagoArrayS.length; i++) {
                        if (pagoArrayS[i] == 0) {
                            cuotasPagadas++;
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return cuotasPagadas;
        } else {
            conexiondb.desconexion();
            return 0;
        }
    }
    
        public double getPorPagar(String id_alumno) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        VO.PagoVO pagoVO = new VO.PagoVO();
        conexion = conexiondb.getConnection();
        double porPagar = 0;
        double mora = 0;
        double precioCuota = coordinador.getVariablesDAO().consultarVariables().getPrecio_cuota();
        double valorMora = coordinador.getVariablesDAO().consultarVariables().getPrecio_mora();
        int diaCobro = coordinador.getVariablesDAO().consultarVariables().getDias_mora();
        String mesyaño = coordinador.getFechaFormateada().substring(6, coordinador.getFechaFormateada().length());

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '" + coordinador.consultarVariables().getPeriodo_actual() + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    //conversion de arrays
                    //recorro el vector buscando montos diferentes de 0 (con deuda)
                    Array pagoArray = result.getArray("pago");
                    Double[] pagoArrayS = (Double[]) pagoArray.getArray();
                    for (int i = 0; i < pagoArrayS.length; i++) {
                        if (pagoArrayS[i] == 0) {
                                continue;
                        }                        
                        //compruebo si esta en mora
                        if (isCuotaMora(String.valueOf(diaCobro), String.valueOf(i+1))) {
                            mora = precioCuota * (valorMora / 100);
                        }else{
                            mora = 0;
                        }
                       porPagar += pagoArrayS[i] + mora; 
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return porPagar;
        } else {
            conexiondb.desconexion();
            return 0;
        }
    }

    public VO.PagoVO consultarPagoPorLapso(String id_alumno, int lapso) {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.PagoVO pagoVO = new VO.PagoVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_alumno = '" + id_alumno + "' and periodo= '" + coordinador.consultarVariables().getPeriodo_actual() + "' "
                    + " and lapso= " + lapso;
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    pagoVO.setId_alumno(result.getString("id_alumno"));
                    pagoVO.setId_pago(result.getInt("id_pago"));
                    pagoVO.setPeriodo(result.getString("periodo"));
                    //conversion de arrays
                    Array pagoArray = result.getArray("formacion_personal_social");
                    Array pagoArray2 = result.getArray("relacion_ambiente");
                    Array pagoArray3 = result.getArray("comunicacion_presentacion");
                    Array pagoArray4 = result.getArray("indicadores_evaluados");
                    Array pagoArray5 = result.getArray("habitos_trabajo");
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
                int n = st.executeUpdate(sql);
                if (n > 0) {
                    return "ELIMINADO";
                } else {
                    return "NO ELIMINADO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return "NO ELIMINADO \n" + ex.getMessage();
            }
        } else {
            return "ERROR AL CONECTAR CON BD";
        }

    }

    public String actualizarPago(VO.PagoVO pagoVO, String id_alumno) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET saldo=?, periodo=?, pago=?, pagado=? where id_alumno= '"+ id_alumno+"' and periodo = '"+coordinador.consultarVariables().getPeriodo_actual()+"'";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setDouble(1, pagoVO.getSaldo());
            ps.setString(2, pagoVO.getPeriodo());

            //declaro vector
            Double[] pago = new Double[pagoVO.getPago().length];
            pago = pagoVO.getPago();
            Array arrayPago = conexion.createArrayOf("float8", pago);
            ps.setArray(3, arrayPago);
            
            ps.setDouble(4, pagoVO.getPagado());
            int n = ps.executeUpdate();
            if (n > 0) {
                respuesta = "DATOS ACTUALIZADOS";
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = ex.getMessage();
        }
        conexiondb.desconexion();
        return respuesta;
    }

    public PagoVO[] getRegistroPago() {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        PagoVO[] pagoVO = null;
        int i = 0;
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE periodo= '" + coordinador.consultarVariables().getPeriodo_actual() + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                pagoVO = new PagoVO[getFilasPago()];

                while (result.next()) {
                    //conversion de arrays
                    Array pagoArray = result.getArray("pago");
                    Double[] pagoArrayS = (Double[]) pagoArray.getArray();
                    //creo objeto
                    pagoVO[i] = new PagoVO();
                    //asigno valores
                    pagoVO[i].setId_alumno(result.getString("id_alumno"));
                    pagoVO[i].setPago(pagoArrayS);
                    pagoVO[i].setSaldo(result.getDouble("saldo"));
                    pagoVO[i].setPeriodo(result.getString("periodo"));
                    i++;
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
    
        public int getFilasPago() {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        PagoVO[] pagoVO = null;
        int i = 0;
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT count(*) as filas FROM " + this.tabla + " WHERE periodo= '" + coordinador.consultarVariables().getPeriodo_actual() + "'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next()) {
                    i = result.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
            conexiondb.desconexion();
            return i;
        } else {
            conexiondb.desconexion();
            return 0;
        }
    }
    
     public String actualizarPagoAumento(int mes_cambio, double precio_cuota) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        int mesCobro = coordinador.consultarVariables().getMes_cobro()-1;
        conexion = conexiondb.getConnection();
        PagoVO[] registros = getRegistroPago();
        //recorro el vector la cantidad de registro que recibo
         for (int i = 0; i < registros.length; i++) {
            try {
                //cambio el valor de las cuotas
                //declaro vector
                Double[] pago = new Double[registros[i].getPago().length];
                pago = registros[i].getPago();
//                for (int j = (mes_cambio-1); j < mesCobro; j++) {
//                    pago[j] += precio_cuota;   
//                }
                
                if (mesCobro > mes_cambio-1) {
                    for (int j = (mes_cambio-1); j < mesCobro; j++) {
                    pago[j] += precio_cuota;   
                    }
                }else if (mesCobro < mes_cambio-1){
                    for (int j = (mes_cambio-1); j < pago.length; j++) {
                    pago[j] += precio_cuota;   
                    }
                    for (int j = 0; j < mesCobro; j++) {
                    pago[j] += precio_cuota;   
                    }
                }else {
                    for (int j = (mes_cambio-1); j < pago.length; j++) {
                    pago[j] += precio_cuota;   
                    }
                    for (int j = 0; j < mesCobro; j++) {
                    pago[j] += precio_cuota;   
                    }
                }
                Array arrayPago = conexion.createArrayOf("float8", pago);
                //actualizo registro
                String sql = "UPDATE " + this.tabla + " SET saldo=?, periodo=?, pago=? where id_alumno= ?";
                PreparedStatement ps = conexion.prepareStatement(sql);

                ps.setDouble(1, registros[i].getSaldo());
                ps.setString(2, registros[i].getPeriodo());

                //declaro vector
                Double[] pagos = new Double[registros[i].getPago().length];
                pagos = registros[i].getPago();
                Array arrayPagos = conexion.createArrayOf("float8", pagos);
                ps.setArray(3, arrayPagos);
                
                ps.setString(4, registros[i].getId_alumno());

                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "DATOS ACTUALIZADOS";
                }

            } catch (SQLException ex) {
                Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
                break;
            }
         }
        conexiondb.desconexion();
        return respuesta;     
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        conexiondb.desconexion();
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
        conexiondb.desconexion();
        return model;
    }
    private boolean isCuotaMora(String dia, String mes) {
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        /**
         * recorro vector para saber que mes pertenecen al periodo anterior
         * y que meses al periodo nuevo
         */
        String fechaOrigen = obtenerFecha(dia, mes);

        
        try {
            Date fecha = ft.parse(fechaOrigen);
            Date fecha2 = ft.parse(coordinador.getFechaFormateada());
            if (fecha2.compareTo(fecha) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(frmPago.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private String obtenerFecha(String dia, String mes) {
        int mesCobroI = coordinador.getVariablesDAO().consultarVariables().getMes_cobro();
        int diaCobroI = coordinador.getVariablesDAO().consultarVariables().getDias_mora();
        String mesCobro = String.valueOf(mesCobroI);
        String diaCobro = String.valueOf(diaCobroI);
        int diaI = Integer.parseInt(dia);
        int mesI = Integer.parseInt(mes);
        String periodo = coordinador.consultarVariables().getPeriodo_actual();
        String anioViejo = periodo.substring(0,4);
        String anionuevo = periodo.substring(5);
        
        if (diaI > 0 && diaI < 10) {
            dia = "0"+dia;
        }
        if (mesI > 0 && mesI < 10) {
            mes = "0"+mes;
        }
        //reasigno
        diaI = Integer.parseInt(dia);
        mesI = Integer.parseInt(mes);
        
        if (mesI < mesCobroI) {
            return dia + "-" + mes + "-" + anionuevo;
        }else{
            return dia + "-" + mes + "-" + anioViejo;
        }
    }
}
