/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acjj
 */
public class ConexionBd {
    private String nombreDB = "dbMaternal";
    private String usuario = "postgres";
    private String pass = "e8ngmm48";
    private String puerto = "2422";
    private String ip = "192.168.0.109";
    private String url = "jdbc:postgresql://"+ip+":"+puerto+"/"+nombreDB;
    
    Connection conn = null;
    
    public ConexionBd(){
        try {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url, usuario,pass);
            if (conn!=null) {
                System.out.println("Conexion exitosa a bd "+nombreDB);
            }
        } catch (ClassNotFoundException e) {
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void desconexion(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn = null;
    }
}
