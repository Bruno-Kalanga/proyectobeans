package controllers;
//<editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.SQLException;
import java.util.ArrayList;
import models.Hospital;
import repositories.Repository02Hospital;

//</editor-fold>
public class Controller02Hospital {

    Repository02Hospital repo;

    public Controller02Hospital() {
        this.repo = new Repository02Hospital();
    }

    public String getTablaHospitales() throws SQLException {
        ArrayList<Hospital> hospitales = this.repo.getHospitales();
        String html = "";
        for (Hospital hosp : hospitales) {
            html += "<tr>";
            html += "<td>" + hosp.getCodigo() + "</td>";
            html += "<td>" + hosp.getNombre() + "</td>";
            html += "<td>" + hosp.getDireccion() + "</td>";
            html += "<td>" + hosp.getTelefono() + "</td>";
            html += "<td>" + hosp.getCamas() + "</td>";
            html += "<td><input type='radio' name='botoncheck' id='botoncheck'"
                    + " value='" + hosp.getCodigo() + "'</td>";
            html += "</tr>";
        }
        return html;
    }

    public void insertHospital(String nombre, String dir, String tlf,
            int camas) throws SQLException {
        this.repo.insertHospital(nombre, dir, tlf, camas);
    }

    public void borrarHospital(int hospcod) throws SQLException {
        this.repo.borrarHospital(hospcod);
    }

}
