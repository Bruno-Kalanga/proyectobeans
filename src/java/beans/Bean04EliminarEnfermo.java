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
public class Bean04EliminarEnfermo {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena
                = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public void borrarEnfermo(int inscripcion) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "delete from enfermo where inscripcion = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, inscripcion);
        pst.executeUpdate();
        cn.close();
    }

    public String tablaEnfermos() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from enfermo";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String html = "<table border='6'>";
        html += "<tr><td>Inscripcion</td><td>Apellido</td></tr>";
        while (rs.next()) {
            html += "<tr>";
            html += "<td>" + rs.getString("inscripcion") + "</td>";
            html += "<td>" + rs.getString("apellido") + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }

}
