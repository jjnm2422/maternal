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
        Vista.frmLogin login = new Vista.frmLogin();
        Vista.frmLoginRecuperacion frmLoginRecuperacion = new Vista.frmLoginRecuperacion();
        Vista.frmDocenteAsistencia frmDocenteAsistencia = new Vista.frmDocenteAsistencia();
        Vista.frmAsistencia frmAsistencia = new Vista.frmAsistencia();
        DAO.MatriculaDAO matriculaDAO = new DAO.MatriculaDAO();
        DAO.AsistenciaADAO asistenciaDAO = new DAO.AsistenciaADAO();
        DAO.Asistencia_dDAO asistencia_dDAO = new DAO.Asistencia_dDAO();
        Vista.frmMenu frmMenu = new Vista.frmMenu();
        Vista.frmGrupos frmGrupos = new Vista.frmGrupos();
        
        coordinador.setAlumnoDAO(alumnoDAO);
        coordinador.setFrmGrupos(frmGrupos);
        coordinador.setFrmMenu(frmMenu);
        coordinador.setAsistencia_dDAO(asistencia_dDAO);
        coordinador.setFrmDocenteAsistencia(frmDocenteAsistencia);
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
        frmGrupos.setCoordinador(coordinador);
        frmMenu.setCoordinador(coordinador);
        asistencia_dDAO.setCoordinador(coordinador);
        frmDocenteAsistencia.setCoordinador(coordinador);
        asistenciaDAO.setCoordinador(coordinador);
        matriculaDAO.setCoordinador(coordinador);
        frmAsistencia.setCoordinador(coordinador);
        frmLoginRecuperacion.setCoordinador(coordinador);
        representanteDAO.setCoordinador(coordinador);
        empleadoDAO.setCoordinador(coordinador);
        usuarioDAO.setCoordinador(coordinador);
        login.setCoordinador(coordinador);
        logica.setCoordinador(coordinador);
        
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
