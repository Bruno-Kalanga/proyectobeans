/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
//<editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import models.DetalleHospital;
import models.Doctor;
import models.Hospital;
import repositories.Repository02Hospital;

//</editor-fold>
public class ControllerHospital {

    private HttpSession session;
    Repository02Hospital repo;

    public ControllerHospital() {
        this.repo = new Repository02Hospital();
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getHospitales() throws SQLException {
        ArrayList<Hospital> hospitales = this.repo.getHospitales();
        String html = "";
        for (Hospital h : hospitales) {
            html += "<tr>";
            html += "<td>" + h.getNombre() + "</td>";
            html += "<td>" + h.getDireccion() + "</td>";
            html += "<td>" + h.getTelefono() + "</td>";
            html += "<td>" + h.getCamas() + "</td>";
            html += "<td>";
            html += "<a href='webcontroller07detalleshospital.jsp?idhospital=";
            html += h.getCodigo() + "'>Detalles</a>";
            html += "</td>";
            html += "<td>";
            html += "<a href='webcontroller07doctoreshospital.jsp?idhospital=";
            html += h.getCodigo() + "'>Doctores</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void insertarHospital(String nombre, String direccion,
            String tlf, int camas) throws SQLException {
        this.repo.insertHospital(nombre, direccion, tlf, camas);
    }

    public String getDetalleHospital(int idhospital) throws SQLException {
        DetalleHospital detalle = this.repo.getDetalleHospital(idhospital);
        String html = "<h1>Personas: " + detalle.getPersonas() + "</h1>";
        html += "<h1>Suma salarial: " + detalle.getSumaSalarial() + "</h1>";
        html += "<h1>Media salarial: " + detalle.getMediaSalarial() + "</h1>";
        return html;
    }

    public String getFilasDoctores(int idhospital) throws SQLException {
        ArrayList<Doctor> doctores = this.repo.getDoctores(idhospital);
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "<td>" + doc.getIdHospital() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void incrementarSalarioDoctores(int incremento, int idhospital)
            throws SQLException {
        this.repo.incrementarSalarioDoctores(incremento, idhospital);
    }

    public String getFilasDoctores() throws SQLException {
        ArrayList<Doctor> doctores = this.repo.getDoctores();

        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "<td>" + doc.getIdHospital() + "</td>";
            html += "<td>";
            html += "<a href='webcontroller08almacenarsessiondoctoresv1.jsp?iddoctor=";
            html += doc.getIdDoctor() + "'>Almacenar</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getFilasDoctoresv2() throws SQLException {
        ArrayList<Doctor> doctores = this.repo.getDoctores();
        ArrayList<String> doctoressession = (ArrayList) session.getAttribute("DOCTORES");
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "<td>" + doc.getIdHospital() + "</td>";
            if (doctoressession == null) {
                html += "<td>";
                html += "<a href='webcontroller08almacenarsessiondoctoresv2.jsp?iddoctor=";
                html += doc.getIdDoctor() + "'>Almacenar</a>";
                html += "</td>";
            } else if (doctoressession.contains(String.valueOf(doc.getIdDoctor())) == false) {
                html += "<td>";
                html += "<a href='webcontroller08almacenarsessiondoctoresv2.jsp?iddoctor=";
                html += doc.getIdDoctor() + "'>Almacenar</a>";
                html += "</td>";
            } else {
                html += "<td>Almacenado</td>";
            }

            html += "</tr>";
        }
        return html;
    }

    public String getDoctoresSession(ArrayList<String> codigos)
            throws SQLException {
        if (codigos.size() == 0) {
            //NO TENEMOS NADA ALMACENADO
            return "NO EXISTEN DOCTORES";
        }
        ArrayList<Doctor> doctores = this.repo.getDoctoresHospital(codigos);
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String almacenarDoctorSession(String iddoctor) {
        //MANEJAMOS LA SESSION MANUALMENTE
        ArrayList<String> codigos;
        //PREGUNTAMOS SI EXISTE ALGO EN SESSION
        if (session.getAttribute("DOCTORES") == null) {
            codigos = new ArrayList<>();
        } else {
            codigos = (ArrayList) session.getAttribute("DOCTORES");
        }
        if (codigos.contains(iddoctor) == false) {
            //AÑADIMOS EL NUEVO DOCTOR A LA SESSION
            codigos.add(iddoctor);
            //ALMACENAMOS EL NUEVO VALOR DE SESSION
            session.setAttribute("DOCTORES", codigos);
        }
        return "Doctores almacenados : " + codigos.size();
    }

    public String getDoctoresSession()
            throws SQLException {
        //PREGUNTAMOS SI TENEMOS DATOS EN SESSION
        if (session.getAttribute("DOCTORES") == null) {
            //NO TENEMOS NADA ALMACENADO
            return "";
        }
        ArrayList<String> codigos = (ArrayList) session.getAttribute("DOCTORES");
        ArrayList<Doctor> doctores = this.repo.getDoctoresHospital(codigos);
        String html = "";
        for (Doctor doc : doctores) {
            html += "<tr>";
            html += "<td>" + doc.getApellido() + "</td>";
            html += "<td>" + doc.getEspecialidad() + "</td>";
            html += "<td>" + doc.getSalario() + "</td>";
            html += "<td>";
            html += "<a href='webcontroller08doctoressessionv2.jsp?eliminar=";
            html += doc.getIdDoctor() + "'>Eliminar de sesion</a>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void eliminarDoctorSession(String iddoctor) {
        //recuperamos la lista de session
        ArrayList<String> doctores = (ArrayList) session.getAttribute("DOCTORES");
        doctores.remove(iddoctor);
        //comprobar si sigue habiendo lista
        if (doctores.size() == 0) {
            //si no hay doctores borramos la sesion
            session.setAttribute("DOCTORES", null);
        } else {
            //almacenamos la nueva lista
            session.setAttribute("DOCTORES", doctores);
        }
    }

}
