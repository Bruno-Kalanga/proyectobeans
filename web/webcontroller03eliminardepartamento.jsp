<%-- 
    Document   : webcontroller03eliminardepartamento
    Created on : 27-ene-2021, 20:36:02
    Author     : Kuro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller01" class="controllers.Controller01Departamentos"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String dato = request.getParameter("cajanumero");
        if (dato != null){
            int deptno = Integer.parseInt(dato);           
            controller01.eliminarDept(deptno);           
        }
        %>
        <h1>Eliminar Departamentos</h1>
        <hr/>
        <table border="9">
            <thead>
                <tr>
                    <th>Dept_no</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                </tr>
            </thead>
            <%=controller01.getTablaDept()%>
        </table>
        <hr/>
        <form method="post">
            <label>Numero de departamento a eliminar :</label><br>
            <input name="cajanumero"/>
            <button type="submit">
                Eliminar
            </button>
        </form>
    </body>
</html>
