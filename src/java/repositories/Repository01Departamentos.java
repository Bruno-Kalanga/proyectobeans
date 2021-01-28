package repositories;
//<editor-fold defaultstate="collapsed" desc="Imports">

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Departamento;
import oracle.jdbc.OracleDriver;

//</editor-fold>
public class Repository01Departamentos {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn
                = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    //el controller necesita una arraylist para pintar
    //se la proporciona el repositorio
    public ArrayList<Departamento> getDepartamentos() throws SQLException {
        ArrayList<Departamento> lista = new ArrayList<>();
        String sql = "select * from dept";
        Connection cn = this.getConnection();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            //por cada row hay que crear un nuevo objeto Departamento
            Departamento dept = new Departamento();
            int numero = rs.getInt("dept_no");
            String nombre = rs.getString("dnombre");
            String localidad = rs.getString("loc");
            dept.setNumero(numero);
            dept.setNombre(nombre);
            dept.setLocalidad(localidad);
            lista.add(dept);
        }
        rs.close();
        cn.close();
        return lista;
    }

    public Departamento buscarDepartamento(int deptno) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from dept where dept_no = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, deptno);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int numero = rs.getInt("dept_no");
        String nombre = rs.getString("dnombre");
        String localidad = rs.getString("loc");
        Departamento dept = new Departamento();
        dept.setNumero(numero);
        dept.setNombre(nombre);
        dept.setLocalidad(localidad);
        rs.close();
        cn.close();
        return dept;
    }

    public void eliminarDepartamento(int deptno) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "delete from dept where dept_no = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, deptno);
        pst.executeUpdate();
        cn.close();
    }

    public void insertarDepartamento(int deptno, String nom, String loc) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "insert into dept values (?,?,?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, deptno);
        pst.setString(2, nom);
        pst.setString(3, loc);
        pst.executeUpdate();
        cn.close();
    }

    public void modificarDepartamento(int deptno, String nom, String loc, int newdeptno) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "update dept set dept_no = ?, dnombre = ?, loc = ? where dept_no = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, newdeptno);
        pst.setString(2, nom);
        pst.setString(3, loc);
        pst.setInt(4, deptno);
        pst.executeUpdate();
        cn.close();
    }

}
