<%-- 
    Document   : web01primerejemplo
    Created on : 25-ene-2021, 17:47:37
    Author     : Kuro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean01"
             class="beans.Bean01PrimerEjemplo" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Primer Java Beans</h1>
        
        <form method="post">
            <label>Introduzca nombre</label>
            <input type="text" name="cajanombre"/>
            <button type="submit">
                Mostrar
            </button>
        </form>
        <hr/>
        <%
        String nombre = request.getParameter("cajanombre");
        if (nombre != null){
            %>
            <%=bean01.getSaludo(nombre)%>
            <%
        }else{
            //revisar
            %>
            <%=bean01.getSaludo()%>
            <%
        }
        %>
    </body>
</html>
