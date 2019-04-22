/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.AlumnoDAO;
import DAO.AsistenciaADAO;
import DAO.Asistencia_dDAO;
import DAO.DireccionDAO;
import DAO.EmpleadoDAO;
import DAO.MatriculaDAO;
import DAO.NotaDAO;
import DAO.PagoDAO;
import DAO.RegistroPagoDAO;
import DAO.RepresentanteDAO;
import DAO.RequisitosDAO;
import DAO.UsuarioDAO;
import DAO.VariablesDAO;
import Modelo.Logica;
import VO.AlumnoVO;
import VO.RepresentanteVO;
import VO.RequisitosVO;
import VO.UsuarioVO;
import Vista.frmAjustes;
import Vista.frmAsistencia;
import Vista.frmdocente;
import Vista.frmLoginRecuperacion;
import Vista.frmLogin;
import Vista.frmDocenteAsistencia;
import Vista.frmGrupos;
import Vista.frmInscripcion;
import Vista.frmMenu;
import Vista.frmMenuReportes;
import Vista.frmNotas;
import Vista.frmPago;
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
    private frmAjustes frmAjustes;
    private VariablesDAO variablesDAO;
    private frmdocente frmDocente;
    private NotaDAO notaDAO;
    private frmNotas frmNotas;
    private frmPago frmPago;
    private PagoDAO pagoDAO;
    private RegistroPagoDAO registroPagoDAO;
    private frmMenuReportes frmMenuReportes;
    private DireccionDAO direccionDAO;

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
    
       public VO.MatriculaVO consultarMatriculaPorAlumno(String parametro) {
          return  getMatriculaDAO().consultarMatriculaPorAlumno(parametro);
       }
       public String actualizarEstatusAlumno(boolean estatus) {
           return getAlumnoDAO().actualizarEstatusAlumno(estatus);
       }
       
        public String actualizarPago(VO.PagoVO pagoVO, String id) {
            return getPagoDAO().actualizarPago(pagoVO, id);
        }
       
       public DefaultTableModel consultarEmpleadosCedulaTabla(String cedula){
           return getEmpleadoDAO().consultarEmpleadosCedulaTabla(cedula);
       }

    public Logica getLogica() {
        return logica;
    }

    public frmLogin getLogin() {
        return login;
    }
    
    public String registrarEmpleado(VO.EmpleadoVO empleadoVO) {
        return getEmpleadoDAO().registrarEmpleado(empleadoVO);
    }
    
     public String registrarUsuario(VO.UsuarioVO usuarioVO) {
         return getUsuarioDAO().registrarUsuario(usuarioVO);
     }
    
     public VO.EmpleadoVO consultarEmpleado(String usuario) {
         return getEmpleadoDAO().consultarEmpleado(usuario);
     }
    
    public String actualizarRepresentante(VO.RepresentanteVO representanteVO, String id_alumno, int tipo){
        return getRepresentanteDAO().actualizarRepresentante(representanteVO, id_alumno, tipo);
    }
    
    public String actualizarEmpleadoSinFoto(VO.EmpleadoVO empleadoVO, String id_empleado){
        return getEmpleadoDAO().actualizarEmpleadoSinFoto(empleadoVO, id_empleado);
    }
    
    public String actualizarEmpleadoConFoto(VO.EmpleadoVO empleadoVO, String id_empleado){
        return getEmpleadoDAO().actualizarEmpleadoConFoto(empleadoVO, id_empleado);
    }
    
    public String eliminarEmpleado(String id_empleado){
        return getEmpleadoDAO().eliminarEmpleado(id_empleado);
    }
    
    public String eliminarAsistenciaDocente(String id_empleado){
        return getAsistencia_dDAO().eliminarAsistenciaDocente(id_empleado);
    }
    
     public String actualizarRequisitos(VO.RequisitosVO requisitosVO){
         return getRequisitosDAO().actualizarRequisitos(requisitosVO);
     }
    
    public int consultarCantidadDeAlumnoSeccion(String seccion){
        return getMatriculaDAO().consultarCantidadDeMatriculaSeccion(seccion);
    }

    public String registrarAlumno(AlumnoVO alumnoVO) {
        return getAlumnoDAO().registrarAlumno(alumnoVO);
    }
    
    public String actualizarAlumno(AlumnoVO alumnoVO, String id) {
        return getAlumnoDAO().actualizarAlumno(alumnoVO, id);
    }
    
    public String registrarRepresentante(VO.RepresentanteVO representanteVO) {
        return getRepresentanteDAO().registrarRepresentante(representanteVO) ;
    }
    
    public boolean validacionSoloNumerosYPunto(String entrada){
        return getLogica().validacionSoloNumerosYPunto(entrada);
    }
    
    public boolean validacionSoloLetrasEspacio(String entrada){
        return getLogica().validacionSoloLetrasEspacio(entrada);
    }
    
    public String actualizarMatricula(VO.MatriculaVO matriculaVO, String id_alumno){
        return getMatriculaDAO().actualizarMatricula(matriculaVO, id_alumno);
    }
    
    public String registrarMatricula(VO.MatriculaVO matriculaVO) {
        return getMatriculaDAO().registrarMatricula(matriculaVO);
    }
    
    public String registrarRequisitos(VO.RequisitosVO requisitosVO) {
        return  getRequisitosDAO().registrarRequisitos(requisitosVO);
    }
    
    public VO.RequisitosVO consultarRequisitos(String id_alumno) {
        return getRequisitosDAO().consultarRequisitos(id_alumno);
    }
    
    public DefaultTableModel consultarRepresentanteTabla(String cedula_representante) {
        return getRepresentanteDAO().consultarRepresentanteTabla(cedula_representante);
    }
    
     public VO.RepresentanteVO consultarRepresentante(String cedula, int tipo) {
         return getRepresentanteDAO().consultarRepresentante(cedula, tipo);
     }
    
    public String consultarUsuarioLogin(String usuario, String clave){
        return getUsuarioDAO().consultarUsuarioLogin(usuario, clave);
    }
    
     public VO.RepresentanteVO consultarRepresentantePorAlumno(String id_alumno, int tipo) {
         return getRepresentanteDAO().consultarRepresentantePorAlumno(id_alumno, tipo);
     }

    public VO.AlumnoVO consultarAlumno(String parametro) {
        return getAlumnoDAO().consultarAlumno(parametro);
    }

    public String eliminarAlumno(String id) {
        return getAlumnoDAO().eliminarAlumno(id);
    }
    
     public String eliminarRequisitos(String id_alumno){
         return getRequisitosDAO().eliminarRequisitos(id_alumno);
     }
     
      public String eliminarAsistencia(String id_alumno){
          return getAsistenciaDAO().eliminarAsistencia(id_alumno);
      }
    
     public String eliminarMatricula(String id) {
         return getMatriculaDAO().eliminarMatricula(id);
     }
     
      public String eliminarRepresentante(String id_alumno){
          return getRepresentanteDAO().eliminarRepresentante(id_alumno);
      }
    
    public boolean validacionCorreo(String entrada) {
        return getLogica().validacionCorreo(entrada);
    }

     public boolean validacionLimiteSoloNumeros(String entrada){
        return getLogica().validacionLimiteSoloNumeros(entrada);
    }
    
    public boolean validacionSoloLetras(String entrada){
        return getLogica().validacionSoloLetras(entrada);
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
    
    public DefaultTableModel consultarAlumnosTabla(String cedula_representante, String nombre){
        return getAlumnoDAO().consultarAlumnosTabla(cedula_representante, nombre);
    }
    public DefaultTableModel consultarAlumnosTablaPago(String cedula_representante, String nombre) {
        return getAlumnoDAO().consultarAlumnosTablaPago(cedula_representante, nombre);
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
    
    public DefaultTableModel añadirListaAsistentes(JTable tabla_origen, JTable tabla_destino, int fila) {
        return getLogica().añadirListaAsistentes(tabla_origen, tabla_destino, fila);
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
    
    public VO.UsuarioVO consultarUsuario(String nombre_usuario) {
        return getUsuarioDAO().consultarUsuario(nombre_usuario);
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
    
    public String registrarAsistenciaPorSeccion(DefaultTableModel model, String seccion, boolean asistencia, String id_usuario) {
        return getAsistenciaDAO().registrarAsistenciaPorSeccion(model, seccion, asistencia, id_usuario);
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

    public String registrarAsistenciaEmpleado(DefaultTableModel model, boolean asistencia, String id_usuario) {
        return getAsistencia_dDAO().registrarAsistenciaEmpleado(model, asistencia, id_usuario);
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
    
    public String actualizarUsuario(VO.UsuarioVO usuarioVO, String id_usuario) {
      return getUsuarioDAO().actualizarUsuario(usuarioVO, id_usuario);
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
   
    public  String  llenarCodigoAlumno(String cedula_representante){
        return getAlumnoDAO().llenarCodigoAlumno(cedula_representante);
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

    public void setFrmAjustes(frmAjustes frmAjustes) {
        this.frmAjustes = frmAjustes;
    }

    public frmAjustes getFrmAjustes() {
        return frmAjustes;
    }

    public void setVariablesDAO(VariablesDAO variablesDAO) {
        this.variablesDAO = variablesDAO;
    }

    public VariablesDAO getVariablesDAO() {
        return variablesDAO;
    }
     public String actualizarVariables(VO.VariablesVO variablesVO) {
         return getVariablesDAO().actualizarVariables(variablesVO);
     }
     
     public VO.VariablesVO consultarVariables() {
         return getVariablesDAO().consultarVariables();
     }
     
      public String actualizarPagoAumento(int mes_cambio, double precio_cuota) {
          return getPagoDAO().actualizarPagoAumento(mes_cambio, precio_cuota);
      }

    public String actualizarAlumnoSinFoto(AlumnoVO alumnoVO, String id) {
        return getAlumnoDAO().actualizarAlumnoSinFoto(alumnoVO, id);
    }

    public String actualizarRepresentanteSinFoto(RepresentanteVO representanteVO, String text, int tipo) {
        return getRepresentanteDAO().actualizarRepresentanteSinFoto(representanteVO, text, tipo);
    }

    public void setfrmDocente(frmdocente frmDocente) {
        this.frmDocente = frmDocente;
    }

    public frmdocente getFrmDocente() {
        return frmDocente;
    }

    public void setNotaDAO(NotaDAO notaDAO) {
        this.notaDAO = notaDAO;
    }

    public NotaDAO getNotaDAO() {
        return notaDAO;
    }  

    public void setFrmNotas(frmNotas frmNotas) {
       this.frmNotas = frmNotas;
    }

    public frmNotas getFrmNotas() {
        return frmNotas;
    }

    public void setFrmPago(frmPago frmPago) {
        this.frmPago = frmPago;
    }

    public frmPago getFrmPago() {
        return frmPago;
    }

    public void setPagoDAO(PagoDAO pagoDAO) {
        this.pagoDAO = pagoDAO;
    }
    
     public VO.PagoVO consultarPago(String id_alumno) {
         return getPagoDAO().consultarPago(id_alumno);
     }

    public PagoDAO getPagoDAO() {
        return pagoDAO;
    }

    public void setRegistroPagoDAO(RegistroPagoDAO registroPagoDAO) {
       this.registroPagoDAO = registroPagoDAO;
    }

    public RegistroPagoDAO getRegistroPagoDAO() {
        return registroPagoDAO;
    }
    
    public String registrarRegistroPago(VO.RegistroPagoVO registroPagoVO) {
        return getRegistroPagoDAO().registrarRegistroPago(registroPagoVO);
    }
    
     public int llenarCodigoRegistroPago() {
         return getRegistroPagoDAO().llenarCodigoRegistroPago();
     }

    public void setFrmMenuReportes(frmMenuReportes frmMenuReportes) {
        this.frmMenuReportes = frmMenuReportes;
    }

    public frmMenuReportes getFrmMenuReportes() {
        return frmMenuReportes;
    }

    public void setDireccionDAO(DireccionDAO direccionDAO) {
        this.direccionDAO = direccionDAO;
    }

    public DireccionDAO getDireccionDAO() {
        return direccionDAO;
    }
    
    public String registrarDireccion(VO.DireccionVO direccionVO) {
        return getDireccionDAO().registrarDireccion(direccionVO);
    }
    
    public VO.DireccionVO consultarDireccion(String id_alumno) {
        return getDireccionDAO().consultarDireccion(id_alumno);
    }
    
    public DefaultTableModel consultarUsuarioTabla() {
        return getUsuarioDAO().consultarUsuarioTabla();
    }
    
     public String actualizarDireccion(VO.DireccionVO direccionVO, String id) {
         return getDireccionDAO().actualizarDireccion(direccionVO, id);
     }
}
