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
        DAO.PagoDAO pagoDAO = new DAO.PagoDAO();
        DAO.UsuarioDAO usuarioDAO = new DAO.UsuarioDAO();
        DAO.EmpleadoDAO empleadoDAO = new DAO.EmpleadoDAO();
        DAO.NotaDAO notaDAO = new DAO.NotaDAO();
        DAO.RepresentanteDAO representanteDAO = new DAO.RepresentanteDAO();
        Modelo.Logica logica = new Modelo.Logica();
        Vista.frmLogin login = new Vista.frmLogin();
        Vista.frmLoginRecuperacion frmLoginRecuperacion = new Vista.frmLoginRecuperacion();
        Vista.frmDocenteAsistencia frmDocenteAsistencia = new Vista.frmDocenteAsistencia();
        Vista.frmAsistencia frmAsistencia = new Vista.frmAsistencia();
        DAO.MatriculaDAO matriculaDAO = new DAO.MatriculaDAO();
        DAO.AsistenciaADAO asistenciaDAO = new DAO.AsistenciaADAO();
        DAO.Asistencia_dDAO asistencia_dDAO = new DAO.Asistencia_dDAO();
        DAO.VariablesDAO variablesDAO = new DAO.VariablesDAO();
        VO.RequisitosVO requisitosVO = new VO.RequisitosVO();
        DAO.RequisitosDAO requisitosDAO = new DAO.RequisitosDAO();
        Vista.frmMenu frmMenu = new Vista.frmMenu();
        Vista.frmGrupos frmGrupos = new Vista.frmGrupos();
        Vista.frmInscripcion frmInscripcion = new Vista.frmInscripcion();
        Vista.frmUsuario frmUsuario = new Vista.frmUsuario();
        Vista.frmAjustes frmAjustes = new Vista.frmAjustes();
        Vista.frmdocente frmDocente = new Vista.frmdocente();
        Vista.frmNotas frmNotas = new Vista.frmNotas();
        Vista.frmPago frmPago = new Vista.frmPago();
        DAO.RegistroPagoDAO registroPagoDAO = new DAO.RegistroPagoDAO();
        Vista.frmMenuReportes frmMenuReportes = new Vista.frmMenuReportes();
        DAO.DireccionDAO direccionDAO = new DAO.DireccionDAO();
        
        coordinador.setAlumnoDAO(alumnoDAO);
        coordinador.setDireccionDAO(direccionDAO);
        coordinador.setFrmMenuReportes(frmMenuReportes);
        coordinador.setRegistroPagoDAO(registroPagoDAO);
        coordinador.setPagoDAO(pagoDAO);
        coordinador.setFrmPago(frmPago);
        coordinador.setFrmNotas(frmNotas);
        coordinador.setNotaDAO(notaDAO);
        coordinador.setfrmDocente(frmDocente);
        coordinador.setVariablesDAO(variablesDAO);
        coordinador.setFrmAjustes(frmAjustes);
        coordinador.setFrmUsuario(frmUsuario);
        coordinador.setRequisitosVO(requisitosVO);
        coordinador.setRequisitosDAO(requisitosDAO);
        coordinador.setFrmInscripcion(frmInscripcion);
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
        direccionDAO.setCoordinador(coordinador);
        frmMenuReportes.setCoordinador(coordinador);
        alumnoDAO.setCoordinador(registroPagoDAO);
        pagoDAO.setCoordinador(coordinador);
        frmPago.setCoordinador(coordinador);
        frmNotas.setCoordinador(coordinador);
        notaDAO.setCoordinador(coordinador);
        frmDocente.setCoordinador(coordinador);
        variablesDAO.setCoordinador(coordinador);
        frmAjustes.setCoordinador(coordinador);
        frmUsuario.setCoordinador(coordinador);
        requisitosVO.setCoordinador(coordinador);
        requisitosDAO.setCoordinador(coordinador);
        frmInscripcion.setCoordinador(coordinador);
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
        
        //incializacion de datos en formularios
        frmAjustes.llenarCampos();
        variablesDAO.llenarPeriodos(frmAjustes.cbxPeriodo);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
