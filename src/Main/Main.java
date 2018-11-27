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
        DAO.RepresentanteDAO representanteDAO = new DAO.RepresentanteDAO();
        Modelo.Logica logica = new Modelo.Logica();
        Vista.Login login = new Vista.Login();
        Vista.frmLoginRecuperacion frmLoginRecuperacion = new Vista.frmLoginRecuperacion();
        Vista.frmAsistencia frmAsistencia = new Vista.frmAsistencia();
        DAO.MatriculaDAO matriculaDAO = new DAO.MatriculaDAO();
        DAO.AsistenciaDAO asistenciaDAO = new DAO.AsistenciaDAO();
        
        coordinador.setAlumnoDAO(alumnoDAO);
        coordinador.setAsistenciaDAO(asistenciaDAO);
        coordinador.setMatriculaDAO(matriculaDAO);
        coordinador.setFrmAsistencia(frmAsistencia);
        coordinador.setEmpleadoDAO(empleadoDAO);
        coordinador.setRepresentanteDAO(representanteDAO);
        coordinador.setUsuarioDAO(usuarioDAO);
        coordinador.setLogica(logica);
        coordinador.setLogin(login);
        coordinador.setFrmLoginRecuperacion(frmLoginRecuperacion);
        
        alumnoDAO.setCoordinador(coordinador);
        asistenciaDAO.setCoordinador(coordinador);
        matriculaDAO.setCoordinador(coordinador);
        frmAsistencia.setCoordinador(coordinador);
        frmLoginRecuperacion.setCoordinador(coordinador);
        representanteDAO.setCoordinador(coordinador);
        empleadoDAO.setCoordinador(coordinador);
        usuarioDAO.setCoordinador(coordinador);
        login.setCoordinador(coordinador);
        logica.setCoordinador(coordinador);
        
        frmAsistencia.setVisible(true);
        frmAsistencia.setLocationRelativeTo(null);
    }
}
