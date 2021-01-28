package beans;
//<editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

//</editor-fold>
public class Bean07EmpleadosDepartamentoUpdate {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena
                = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public void updateSalario(int departamento, int incremento) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "update emp set salario = salario + ? where dept_no = ?";
        PreparedStatement pst = cn.prepareCall(sql);
        pst.setInt(1, incremento);
        pst.setInt(2, departamento);
        pst.executeUpdate();
    }
}
