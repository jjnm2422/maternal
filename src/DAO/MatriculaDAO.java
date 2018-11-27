/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Coordinador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acjj
 */
public class MatriculaDAO {
    
    private Coordinador coordinador;
    private final String tabla = "matricula";

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public DefaultTableModel consultarMatriculaPorSeccionTabla(String seccion){
    Statement st = null;
    Connection conexion= null;
    Conexion.ConexionBd conexiondb = new Conexion.ConexionBd();
    conexion = conexiondb.getConnection();
    String[]titulos={"ID","Primer Nombre","Primer Apellido"};
    String[]fila=new String[titulos.length];
    String sql="SELECT * FROM "+this.tabla+" INNER JOIN alumno ON matricula.id_alumno = alumno.id_alumno WHERE seccion = '"+seccion+"'";
    DefaultTableModel model = new DefaultTableModel(null,titulos);
    
    try {
    st=conexion.createStatement();
    ResultSet rs=st.executeQuery(sql);
   
    while(rs.next()){
        fila[0]=rs.getString("id_alumno");
        fila[1]=rs.getString("primer_nombre");
        fila[2]=rs.getString("primer_apellido");
        model.addRow(fila);
    }
    conexion.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, " Ha ocurrido un error al consultar ", null, JOptionPane.ERROR_MESSAGE);
        return model = null;
    }
    return model;
}
}
