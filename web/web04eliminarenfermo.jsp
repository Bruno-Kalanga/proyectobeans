<%-- 
    Document   : web04eliminarenfermo
    Created on : 25-ene-2021, 20:07:19
    Author     : Kuro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="enfermos" class="beans.Bean04EliminarEnfermo"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String dato = request.getParameter("cajainscripcion");
        if (dato != null){
            int inscripcion = Integer.parseInt(dato);
            enfermos.borrarEnfermo(inscripcion);
        }
        %>
        <h1>Eliminar enfermos</h1>
        <%=enfermos.tablaEnfermos()%>
        <hr/>
        <form method="post">
            <label>Numero de inscripcion :</label>
            <input type="number" name="cajainscripcion" required/>
            <button type="submit">
                Eliminar
            </button>
        </form>
    </body>
</html>
