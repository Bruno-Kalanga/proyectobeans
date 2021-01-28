package controllers;
//<editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.SQLException;
import java.util.ArrayList;
import models.Departamento;
import repositories.Repository01Departamentos;
//</editor-fold>

public class Controller01Departamentos {

    //Estas clases son para los dibujos
    Repository01Departamentos repo;

    public Controller01Departamentos() {
        this.repo = new Repository01Departamentos();
    }

    public String getTablaDept() throws SQLException {

        ArrayList<Departamento> lista = repo.getDepartamentos();

        String html = "";
        for (Departamento d : lista) {
            html += "<tr>";
            html += "<td>" + d.getNumero() + "</td>";
            html += "<td>" + d.getNombre() + "</td>";
            html += "<td>" + d.getLocalidad() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getTablaDeptButton() throws SQLException {

        ArrayList<Departamento> lista = repo.getDepartamentos();

        String html = "";
        for (Departamento d : lista) {
            html += "<tr>";
            html += "<td>" + d.getNumero() + "</td>";
            html += "<td>" + d.getNombre() + "</td>";
            html += "<td>" + d.getLocalidad() + "</td>";
            html += "<td><button type='submit' name='cajabutton' style='width:100%' value='"
                    + d.getNumero() + "'>Detalles</button>";
            html += "</tr>";
        }
        return html;
    }

    public String getSelectDept() throws SQLException {

        ArrayList<Departamento> lista = repo.getDepartamentos();

        String html = "";
        for (Departamento d : lista) {
            html += "<option value='" + d.getNumero() + "'>";
            html += d.getNombre() + "</option>";
        }
        return html;
    }

    public String getDetallesDepartamento(int deptno) throws SQLException {
        Departamento dept = repo.buscarDepartamento(deptno);
        String html = "<h1>Numero : " + dept.getNumero() + "</h1><br>";
        html += "<h1>Nombre : " + dept.getNombre() + "</h1><br>";
        html += "<h1>Localidad : " + dept.getLocalidad() + "</h1><br>";
        return html;
    }

    public Departamento getDepartamento(int deptno) throws SQLException {
        Departamento dept = repo.buscarDepartamento(deptno);
        return dept;
    }

    public void eliminarDept(int deptno) throws SQLException {
        repo.eliminarDepartamento(deptno);
    }

    public void insertarDepartamento(int deptno, String nom, String loc) throws SQLException {
        this.repo.insertarDepartamento(deptno, nom, loc);
    }

    public void modificarDepartamento(int deptno, String nom, String loc, int newdeptno) throws SQLException {
        this.repo.modificarDepartamento(deptno, nom, loc, newdeptno);
    }
}
