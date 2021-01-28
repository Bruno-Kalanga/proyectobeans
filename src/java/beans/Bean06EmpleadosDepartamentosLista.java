package beans;
//<editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;
//</editor-fold>

public class Bean06EmpleadosDepartamentosLista {

    private Connection getConection() throws SQLException {
        String cadena
                = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        DriverManager.registerDriver(new OracleDriver());
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public String getDepartamentos() throws SQLException {
        Connection cn = this.getConection();
        String sql = "select * from dept";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String dept = "";
        while (rs.next()) {
            String dnom = rs.getString("DNOMBRE");
            String dnum = rs.getString("DEPT_NO");
            dept += "<li>";
            dept += "<a href='web07empleadosdepartamentoupdate.jsp?departamento=" + dnum + "'>" + dnom + "</a>";
            dept += "</li>";
        }
        rs.close();
        cn.close();
        return dept;
    }

    public String getEmpleados(int departamento) throws SQLException {
        Connection cn = this.getConection();
        String sql = "select * from emp where dept_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, departamento);
        ResultSet rs = pst.executeQuery();
        String html = "";
        while (rs.next()) {
            String ape = rs.getString("APELLIDO");
            String ofi = rs.getString("OFICIO");
            String sal = rs.getString("SALARIO");
            html += "<tr><td>" + ape + "</td>";
            html += "<td>" + ofi + "</td>";
            html += "<td>" + sal + "</td></tr>";
        }
        rs.close();
        cn.close();
        return html;
    }
}
