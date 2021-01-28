<%-- 
    Document   : webcontroller04insertardepartamento
    Created on : 28-ene-2021, 16:47:53
    Author     : Kuro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller01Departamentos"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String loc = request.getParameter("cajalocalidad");
        String nom = request.getParameter("cajanombre");
        String dato = request.getParameter("cajanumero");
        if (dato != null){
            int deptno = Integer.parseInt(dato);
            controller.insertarDepartamento(deptno, nom, loc);
        }
        %>
        <h1>Insertar Departamentos</h1>
        <form method="post">
            <table border="9">
                <tr>
                    <td>Numero Departamento</td>
                    <td><input name="cajanumero" required/></td>
                </tr>
                <tr>
                    <td>Nombre Departamento</td>
                    <td><input name="cajanombre" required/></td>
                </tr>
                <tr>
                    <td>Localidad</td>
                    <td><input name="cajalocalidad" required/></td>
                </tr>
                <tr>
                    <td colspan="2">
                      <button type="submit">
                        Insertar
                      </button>
                    </td>
                </tr>
            </table>  
        </form>
        <hr/>
        <table border="9">
            <thead>
                <tr>
                    <th>Numero</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaDept()%>
            </tbody>
        </table>
    </body>
</html>
