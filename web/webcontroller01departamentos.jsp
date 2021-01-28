<%-- 
    Document   : webcontroller01departamentos
    Created on : 27-ene-2021, 17:44:44
    Author     : Kuro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller01departamento"
             class="controllers.Controller01Departamentos"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Departamentos Controller</h1>
        <table border="9">
            <thead>
                <tr>
                    <th>Numero</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                </tr>
            </thead>
            <tbody>
                <%=controller01departamento.getTablaDept()%>
            </tbody>
        </table>
    </body>
</html>
