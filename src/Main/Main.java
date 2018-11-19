/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author acjj
 */
public class Main {
    public static void main(String[] args) {
        
        Controlador.Coordinador coordinador = new Controlador.Coordinador();
        DAO.AlumnoDAO alumnoDAO = new DAO.AlumnoDAO();
        Modelo.Logica logica = new Modelo.Logica();
        Vista.Login login = new Vista.Login();
        
        coordinador.setAlumnoDAO(alumnoDAO);
        coordinador.setLogica(logica);
        coordinador.setLogin(login);
        
        alumnoDAO.setCoordinador(coordinador);
        login.setCoordinador(coordinador);
        logica.setCoordinador(coordinador);
        
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
