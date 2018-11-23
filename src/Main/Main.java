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
        DAO.UsuarioDAO usuarioDAO = new DAO.UsuarioDAO();
        DAO.EmpleadoDAO empleadoDAO = new DAO.EmpleadoDAO();
        Vista.NewJFrame newJFrame = new Vista.NewJFrame();
        DAO.RepresentanteDAO representanteDAO = new DAO.RepresentanteDAO();
        Modelo.Logica logica = new Modelo.Logica();
        Vista.Login login = new Vista.Login();
        
        
        coordinador.setAlumnoDAO(alumnoDAO);
        coordinador.setNewFrame(newJFrame);
        coordinador.setEmpleadoDAO(empleadoDAO);
        coordinador.setRepresentanteDAO(representanteDAO);
        coordinador.setUsuarioDAO(usuarioDAO);
        coordinador.setLogica(logica);
        coordinador.setLogin(login);
        
        alumnoDAO.setCoordinador(coordinador);
        newJFrame.setCoordinador(coordinador);
        representanteDAO.setCoordinador(coordinador);
        empleadoDAO.setCoordinador(coordinador);
        usuarioDAO.setCoordinador(coordinador);
        login.setCoordinador(coordinador);
        logica.setCoordinador(coordinador);
        
        newJFrame.setVisible(true);
        newJFrame.setLocationRelativeTo(null);
    }
}
