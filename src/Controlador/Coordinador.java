/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.AlumnoDAO;
import DAO.AsistenciaADAO;
import DAO.Asistencia_dDAO;
import DAO.EmpleadoDAO;
import DAO.MatriculaDAO;
import DAO.RepresentanteDAO;
import DAO.RequisitosDAO;
import DAO.UsuarioDAO;
import Modelo.Logica;
import VO.AlumnoVO;
import VO.RequisitosVO;
import VO.UsuarioVO;
import Vista.frmAsistencia;
import Vista.frmLoginRecuperacion;
import Vista.frmLogin;
import Vista.frmDocenteAsistencia;
import Vista.frmGrupos;
import Vista.frmInscripcion;
import Vista.frmMenu;
import Vista.frmUsuario;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author acjj
 */
public class Coordinador {


    private AlumnoDAO alumnoDAO;
    private Logica logica;
    private frmLogin login;
    private UsuarioDAO usuarioDAO;
    private EmpleadoDAO empleadoDAO;
    private RepresentanteDAO representanteDAO;
    private frmLoginRecuperacion frmLoginRecuperacion;
    private frmAsistencia frmAsistencia;
    private MatriculaDAO matriculaDAO;
    private AsistenciaADAO asistenciaDAO;
    private frmDocenteAsistencia frmDocenteAsistencia;
    private Asistencia_dDAO asistencia_dDAO;
    private frmMenu frmMenu;
    private frmGrupos frmGrupos;
    private frmInscripcion frmInscripcion;
    private RequisitosVO requisitosVO;
    private RequisitosDAO requisitosDAO;
    private frmUsuario frmUsuario;

    public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
       this.alumnoDAO = alumnoDAO;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public void setLogin(frmLogin login) {
        this.login = login;
    }

    public AlumnoDAO getAlumnoDAO() {
        return alumnoDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Logica getLogica() {
        return logica;
    }

    public frmLogin getLogin() {
        return login;
    }

    public String registrarAlumno(AlumnoVO alumnoVO) {
        return getAlumnoDAO().registrarAlumno(alumnoVO);
    }
    
    public String registrarRepresentante(VO.RepresentanteVO representanteVO) {
        return getRepresentanteDAO().registrarRepresentante(representanteVO) ;
    }
    
    public String registrarMatricula(VO.MatriculaVO matriculaVO) {
        return getMatriculaDAO().registrarMatricula(matriculaVO);
    }
    
    public String registrarRequisitos(VO.RequisitosVO requisitosVO) {
        return  getRequisitosDAO().registrarRequisitos(requisitosVO);
    }
    
    public String consultarUsuarioLogin(String usuario, String clave){
        return getUsuarioDAO().consultarUsuarioLogin(usuario, clave);
    }

    public VO.AlumnoVO consultarAlumno(String parametro) {
        return getAlumnoDAO().consultarAlumno(parametro);
    }

    public String eliminarAlumno(String id) {
        return getAlumnoDAO().eliminarAlumno(id);
    }
    
    public String actualizarAlumno(VO.AlumnoVO alumnoVO,String id) {
        return getAlumnoDAO().actualizarAlumno(alumnoVO, id);
    }

    public boolean validacionCorreo(String entrada) {
        return getLogica().validacionCorreo(entrada);
    }

     public boolean validacionLimiteSoloNumeros(String entrada){
        return getLogica().validacionLimiteSoloNumeros(entrada);
    }
    
    public boolean validacionLimiteSoloLetras(String entrada){
        return getLogica().validacionLimiteSoloLetras(entrada);
    }
    
    public String getClave(char[] campoClave){
        return getLogica().getClave(campoClave);
    }
    
    public boolean validacionNumeroTelefonico(String entrada){
        //telefono 0286-1234567
         return getLogica().validacionNumeroTelefonico(entrada);
    }
    
    public boolean validacionLimiteSoloNumerosYGuion(String entrada){
        return getLogica().validacionLimiteSoloNumerosYGuion(entrada);
    }
    
    public DefaultTableModel consultarAlumnosTabla(String parametro){
        return getAlumnoDAO().consultarAlumnosTabla(parametro);
    }
    
    public Date getFecha(){
        return getLogica().getFecha();
    }
    
    public String getFechaFormateada(){
        return getLogica().getFechaFormateada();
    }
    
    public String getHora(){
        return getLogica().getHora();
    }  

    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    public void setRepresentanteDAO(RepresentanteDAO representanteDAO) {
        this.representanteDAO = representanteDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public EmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public RepresentanteDAO getRepresentanteDAO() {
        return representanteDAO;
    }
    
    public DefaultTableModel añadirListaAsistentes(JTable tabla, JTable tabla2, int fila) {
        return getLogica().añadirListaAsistentes(tabla, tabla2, fila);
    }
    
    public DefaultTableModel añadirListaGrupos(JTable tabla, JTable tabla2, int fila) {
          return getLogica().añadirListaGrupos(tabla, tabla2, fila);
    }
    
    public DefaultTableModel añadirListaDocentesAsistentes(JTable tabla, JTable tabla2, int fila) {
        return getLogica().añadirListaDocentesAsistentes(tabla, tabla2, fila);
    }
    
    public DefaultTableModel añadirListaInasistentes(JTable tabla, JTable tabla2, int fila) {
        return getLogica().añadirListaInasistentes(tabla, tabla2, fila);
    }

    public void setFrmLoginRecuperacion(frmLoginRecuperacion frmLoginRecuperacion) {
       this.frmLoginRecuperacion = frmLoginRecuperacion;
    }

    public frmLoginRecuperacion getFrmLoginRecuperacion() {
        return frmLoginRecuperacion;
    }

    public String getPreguntaSecreta(String usuario) {
        return getUsuarioDAO().getPreguntaSecreta(usuario);
    }
    
    public VO.UsuarioVO consultarUsuario(String parametro) {
        return getUsuarioDAO().consultarUsuario(parametro);
    }
   
    public void setFrmAsistencia(frmAsistencia frmAsistencia) {
        this.frmAsistencia = frmAsistencia;
    }

    public frmAsistencia getFrmAsistencia() {
        return frmAsistencia;
    }
    
    public DefaultTableModel consultarMatriculaPorSeccionTabla(String seccion){
        return matriculaDAO.consultarMatriculaPorSeccionTabla(seccion);
    }

    public void setMatriculaDAO(MatriculaDAO matriculaDAO) {
        this.matriculaDAO = matriculaDAO;
    }
    
    public String registrarAsistenciaPorSeccion(DefaultTableModel model, String seccion, boolean asistencia, int id_usuario) {
        return getAsistenciaDAO().registrarAsistenciaPorSeccion(model, seccion, asistencia, 1);
    }

    public void setAsistenciaDAO(AsistenciaADAO asistenciaDAO) {
        this.asistenciaDAO = asistenciaDAO;
    }

    public MatriculaDAO getMatriculaDAO() {
        return matriculaDAO;
    }

    public AsistenciaADAO getAsistenciaDAO() {
        return asistenciaDAO;
    }
    
    public DefaultTableModel consultarEmpleadosTodosTabla(){
        return getEmpleadoDAO().consultarEmpleadosTodosTabla();
    }

    public void setFrmDocenteAsistencia(frmDocenteAsistencia frmDocenteAsistencia) {
        this.frmDocenteAsistencia = frmDocenteAsistencia;
    }

    public frmDocenteAsistencia getFrmDocenteAsistencia() {
        return frmDocenteAsistencia;
    }

    public String registrarAsistenciaEmpleado(DefaultTableModel model, boolean asistencia, int usuario) {
        return getAsistencia_dDAO().registrarAsistenciaEmpleado(model, asistencia, usuario);
    }

    public void setAsistencia_dDAO(Asistencia_dDAO asistencia_dDAO) {
           this.asistencia_dDAO = asistencia_dDAO;
    }

    public Asistencia_dDAO getAsistencia_dDAO() {
        return asistencia_dDAO;
    }
    
    public  void borrarTablas(JTable tbl1,  JTable tbl2) {
        getLogica().borrarTablas(tbl1, tbl2);
    }

    public void setFrmMenu(frmMenu frmMenu) {
        this.frmMenu = frmMenu;
    }

    public frmMenu getFrmMenu() {
        return frmMenu;
    }
    
      public boolean consultarAsistenciaDelDia(String fecha) {
          return getAsistencia_dDAO().consultarAsistenciaDelDia(fecha);
      }
      public String actualizarClaveUsuario(String clave, String id){
          return  getUsuarioDAO().actualizarClaveUsuario(clave, id);
      }

    public void setFrmGrupos(frmGrupos frmGrupos) {
        this.frmGrupos = frmGrupos;
    }

    public frmGrupos getFrmGrupos() {
        return frmGrupos;
    }
    
    public DefaultTableModel consultarMatriculaSinSeccion(){
        return getMatriculaDAO().consultarMatriculaSinSeccion();
    }

    public void setFrmInscripcion(frmInscripcion frmInscripcion) {
        this.frmInscripcion = frmInscripcion;
    }

    public frmInscripcion getFrmInscripcion() {
        return frmInscripcion;
    }
   
    public  int  llenarCodigoAlumno(){
        return getAlumnoDAO().llenarCodigoAlumno();
    }

    public void setRequisitosVO(RequisitosVO requisitosVO) {
        this.requisitosVO = requisitosVO;
    }

    public void setRequisitosDAO(RequisitosDAO requisitosDAO) {
       this.requisitosDAO = requisitosDAO;
    }

    public RequisitosVO getRequisitosVO() {
        return requisitosVO;
    }

    public RequisitosDAO getRequisitosDAO() {
        return requisitosDAO;
    }

    public void setFrmUsuario(frmUsuario frmUsuario) {
        this.frmUsuario = frmUsuario;
         }

    public frmUsuario getFrmUsuario() {
        return frmUsuario;
    }
    
    
}
