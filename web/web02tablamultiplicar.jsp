<%-- 
    Document   : web02tablamultiplicar
    Created on : 25-ene-2021, 18:14:51
    Author     : Kuro
--%>
<jsp:useBean id="beantabla" 
             class="beans.Bean02TablaMultiplicar" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla de Multiplicar</h1>
        <form method="post">
            <label>Introduzca numero</label>
            <input type="number" name="cajanumero"/>
            <button type="submit">
                Mostrar tabla
            </button>
        </form>
        <hr/>
        <%
        String dato = request.getParameter("cajanumero");
        if (dato != null){
            int numero = Integer.parseInt(dato);
            %>
            <%=beantabla.getTabla(numero)%>
            <%
        }
        %>
    </body>
</html>
