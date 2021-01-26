<%-- 
    Document   : web03tablaempleados
    Created on : 25-ene-2021, 19:37:32
    Author     : Kuro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beanemp"
             class="beans.Bean03TablaEmpleados" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla Empleados</h1>
        <form method="post">
            <label>Incremento salarial : </label>
            <input type="number" name="cajaincremento" required/>
            <button type="submit">
                Incrementar
            </button>
        </form>
        <hr/>
        <%
        String dato = request.getParameter("cajaincremento");
        if (dato != null) {
            int incremento = Integer.parseInt(dato);
            beanemp.incrementarSalarios(incremento);
        }
        %>
        <%=beanemp.getTablaEmpleados()%>
    </body>
</html>
