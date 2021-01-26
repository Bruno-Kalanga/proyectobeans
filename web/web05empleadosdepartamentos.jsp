<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="empdept" class="beans.Bean05EmpleadosDepartamento"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/webhead.jsp"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="includes/webmenu05empdept.jsp"/>
        <main role="main" class="container">
        <div class="starter-template">
        <h1>Web Empleados Departamento</h1>
        <%
        String dato = request.getParameter("departamento");
        if (dato != null){
            int departamento = Integer.parseInt(dato);
            %>
            <%=empdept.getEmpleados(departamento)%>
            <%
        }
        %>
        </div>
        </main><!-- /.container -->
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
