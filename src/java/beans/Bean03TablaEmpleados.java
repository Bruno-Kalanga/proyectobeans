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

public class Bean03TablaEmpleados {

    //los metodos internos son privados y para la pagina publicos
    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena
                = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn
                = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public String getTablaEmpleados() throws SQLException {
        Connection cn = this.getConnection();
        Statement st = cn.createStatement();
        String sql = "select * from emp";
        ResultSet rs = st.executeQuery(sql);
        String html = "<table border='1'>";
        while (rs.next()) {
            html += "<tr>";
            html += "<td>" + rs.getString("apellido") + "</td>";
            html += "<td>" + rs.getString("oficio") + "</td>";
            html += "<td>" + rs.getString("salario") + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        rs.close();
        cn.close();
        return html;
    }

    public void incrementarSalarios(int incremento) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "update emp set salario = salario + ?";
        PreparedStatement pst = cn.prepareCall(sql);
        pst.setInt(1, incremento);
        pst.executeUpdate();
        cn.close();
    }

}
