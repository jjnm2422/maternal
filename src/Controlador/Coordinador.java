/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.AlumnoDAO;
import Modelo.Logica;
import VO.AlumnoVO;
import Vista.Login;

/**
 *
 * @author acjj
 */
public class Coordinador {


    private AlumnoDAO alumnoDAO;
    private Logica logica;
    private Login login;

    public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
       this.alumnoDAO = alumnoDAO;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public AlumnoDAO getAlumnoDAO() {
        return alumnoDAO;
    }

    public Logica getLogica() {
        return logica;
    }

    public Login getLogin() {
        return login;
    }

    public String registrarAlumno(AlumnoVO alumnoVO) {
        return getAlumnoDAO().registrarAlumno();
    }

    public VO.AlumnoVO consultarAlumno(String consulta) {
        return getAlumnoDAO().consultarAlumno(consulta);
    }

    public String eliminarAlumno(String id) {
        return getAlumnoDAO().eliminarAlumno(id);
    }
    
}
