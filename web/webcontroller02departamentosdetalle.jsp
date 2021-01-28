<%-- 
    Document   : webcontroller02departamentosdetalle
    Created on : 27-ene-2021, 19:40:42
    Author     : Kuro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdept" class="controllers.Controller01Departamentos"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Detalles Dept</h1>
        <form method="post">
            <label>Departamentos</label>
            <select name="selectdept">
                <%=controllerdept.getSelectDept()%>
            </select>
            <button type="submit">
                Ver detalles
            </button>
        </form>
        <%
        String dato = request.getParameter("selectdept");
        if (dato != null){
            int deptno = Integer.parseInt(dato);
            %>
            <%=controllerdept.getDetallesDepartamento(deptno)%>
            <%
        }
        %>
    </body>
</html>
