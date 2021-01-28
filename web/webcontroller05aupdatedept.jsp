<%-- 
    Document   : webcontroller05aupdatedept
    Created on : 28-ene-2021, 17:48:54
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
        String dato = request.getParameter("cajaoldnum");
        if (dato != null){
            int deptno = Integer.parseInt(dato);
            String nom = request.getParameter("cajanombre");
            String loc = request.getParameter("cajalocalidad");
            int newdeptno = Integer.parseInt(request.getParameter("cajanewnum"));
            controller.modificarDepartamento(deptno, nom, loc, newdeptno);
        }
        %>
        <h1>Modificar Departamento</h1>
        <hr/>
        <form method="post">
            <table border="1">
                <tr>
                    <td>Numero de departamento a modificar</td>
                    <td><input name="cajaoldnum" required/></td>
                </tr>
                <tr>
                    <td>Nuevo numero de departamento</td>
                    <td><input name="cajanewnum" required/></td>
                </tr>
                <tr>
                    <td>Nuevo nombre de departamento</td>
                    <td><input name="cajanombre" required/></td>
                </tr>
                <tr>
                    <td>Nueva localidad de departamento</td>
                    <td><input name="cajalocalidad" required/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" style="width: 100%">
                            Modificar
                        </button>
                    </td>
                </tr>
            </table>
        </form>
        <hr/>
        <table border="5">
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
