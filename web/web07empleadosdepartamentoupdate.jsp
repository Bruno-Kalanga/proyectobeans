<jsp:useBean id="bean07" class="beans.Bean07EmpleadosDepartamentoUpdate"
             scope="request"/>
<jsp:useBean id="bean06" class="beans.Bean06EmpleadosDepartamentosLista"
             scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
          <%=bean06.getDepartamentos()%>  
        </ul>
        <hr/>
        <%
        String dato = request.getParameter("departamento");
        if (dato != null){
            int departamento = Integer.parseInt(dato);
            %>
            <table border="6">
                <thead>
                    <tr>
                        <th>Apellido</th>
                        <th>Oficio</th>
                        <th>Salario</th>
                    </tr>
                    <%=bean06.getEmpleados(departamento)%>
                </thead>
            </table>
            <%
        }
        %>
    </body>
</html>
