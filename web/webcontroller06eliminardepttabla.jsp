<%-- 
    Document   : webcontroller06eliminardepttabla
    Created on : 29-ene-2021, 17:14:53
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
        String dato = request.getParameter("eliminar");
        if(dato != null){
            int deptno = Integer.parseInt(dato);
            controller.eliminarDept(deptno);
        }
        %>
        <h1>Eliminar Departamento</h1>
        <form method="post" id="formeliminar">
            <table border="5">
                <thead>
                    <tr>
                        <th>Numero</th>
                        <th>Nombre</th>
                        <th>Localidad</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%=controller.getTablaEliminarDept()%>
                </tbody>
            </table>    
        </form>
        <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function(){
                $("#formeliminar").submit(function(){
                    var respuesta = 
                            confirm("¿Eliminar Departamento?");
                    if (respuesta == false){
                        return false;
                    }
                });
            });
        </script>
    </body>
</html>
