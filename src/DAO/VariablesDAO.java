/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Coordinador;
import VO.VariablesVO;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acjj
 */
public class VariablesDAO {

    private Coordinador coordinador;
    private final String tabla = "variables";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public VO.VariablesVO consultarVariables() {
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        PreparedStatement ps = null;
        ResultSet result = null;
        ImageIcon foto;
        InputStream is;
        VO.VariablesVO variablesVO = new VO.VariablesVO();
        conexion = conexiondb.getConnection();

        if (conexion != null) {
            String sql = "SELECT * FROM " + this.tabla + " WHERE id_variable = '0'";
            try {
                ps = conexion.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next() == true) {
                    variablesVO.setId_variable(result.getInt("id_variable"));
                    variablesVO.setIva(result.getDouble("iva"));
                    variablesVO.setDias_mora(result.getInt("dias_mora"));
                    variablesVO.setLimite_alumno(result.getInt("limite_alumno"));
                    variablesVO.setSeguro(result.getDouble("seguro"));
                    variablesVO.setUbicacion_reporte(result.getString("ubicacion_reporte"));
                    variablesVO.setPeriodo_actual(result.getString("periodo_actual"));
                    variablesVO.setPrecio_cuota(result.getDouble("precio_cuota"));
                    variablesVO.setPrecio_mora(result.getDouble("precio_mora"));
                    variablesVO.setPrecio_inscripcion(result.getDouble("precio_inscripcion"));
                    variablesVO.setCuota_old(result.getDouble("cuota_old"));
                    variablesVO.setMes_cambio(result.getInt("mes_cambio"));
                    variablesVO.setMes_cobro(result.getInt("mes_cobro"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(VariablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexiondb.desconexion();
            return variablesVO;
        } else {
            conexiondb.desconexion();
            return null;
        }
    }
    
    public void llenarPeriodos(JComboBox combobox){
        combobox.removeAllItems();
        int año_actual = Integer.parseInt(this.consultarVariables().getPeriodo_actual().substring(0, 4));
        int año_proximo = Integer.parseInt(this.consultarVariables().getPeriodo_actual().substring(5, 9));
        for (int i = 0; i < 5; i++) {
            combobox.insertItemAt(año_actual+"-"+año_proximo,i);
            año_actual++;
            año_proximo++;
        }
        combobox.setSelectedIndex(0);
    }
    
    public String periodoAnterior(){
        int año_actual = Integer.parseInt(this.consultarVariables().getPeriodo_actual().substring(0, 4));
        int año_proximo = Integer.parseInt(this.consultarVariables().getPeriodo_actual().substring(5, 9));
        return (año_actual-1) +"-"+(año_proximo-1);
    }

    public String actualizarVariables(VO.VariablesVO variablesVO) {
        Statement st = null;
        String respuesta = "";
        Connection conexion = null;
        Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
        conexion = conexiondb.getConnection();
        String sql = "UPDATE " + this.tabla + " SET id_variable=?, iva=?, ubicacion_reporte=?, limite_alumno=?, precio_mora=?, precio_cuota=?, dias_mora=?, periodo_actual=?, precio_inscripcion=?, cuota_old=?, mes_cambio=?, mes_cobro=?, seguro=? where id_variable= '0'";

        if (conexion != null) {
            try {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setInt(1, variablesVO.getId_variable());
                ps.setDouble(2, variablesVO.getIva());
                ps.setString(3, variablesVO.getUbicacion_reporte());
                ps.setInt(4, variablesVO.getLimite_alumno());
                ps.setDouble(5, variablesVO.getPrecio_mora());
                ps.setDouble(6, variablesVO.getPrecio_cuota());
                ps.setDouble(7, variablesVO.getDias_mora());
                ps.setString(8, variablesVO.getPeriodo_actual());
                ps.setDouble(9, variablesVO.getPrecio_inscripcion());
                ps.setDouble(10, variablesVO.getCuota_old());
                ps.setInt(11, variablesVO.getMes_cambio());
                ps.setInt(12, variablesVO.getMes_cobro());
                ps.setDouble(13, variablesVO.getSeguro());
                int n = ps.executeUpdate();
                if (n > 0) {
                    respuesta = "UPDATE";
                }else{
                     respuesta = "NO ACTUALIZO";
                }
            } catch (SQLException ex) {
                Logger.getLogger(VariablesDAO.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = ex.getMessage();
            }
            return respuesta;
        } else {
            return "ERROR AL CONECTAR CON BD";
        }
    }

    public int llenarCodigoVariables() {
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

    public DefaultTableModel consultarVariablessTabla(String parametro) {
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
