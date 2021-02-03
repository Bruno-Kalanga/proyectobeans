<%-- 
    Document   : webcontroller05bupdatedept
    Created on : 28-ene-2021, 18:58:38
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
        String dato2 = request.getParameter("cajanum");
        if (dato2 != null){
            int newdeptno = Integer.parseInt(dato2);
            String nom = request.getParameter("cajanom");
            String loc = request.getParameter("cajaloc");
            int deptno = Integer.parseInt(request.getParameter("cajadept"));
            controller.modificarDepartamento(deptno, nom, loc, newdeptno);
        }
        %>
        <h1>Modificar Departamentos</h1>
        <form method="post">
            <table border="5">
            <thead>
                <tr>
                    <th>Numero</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                    <th>Accion</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaDeptButton()%>
            </tbody>
        </table>
        </form>
        <hr/>
        <%
        String dato = request.getParameter("cajabutton");
        if (dato != null) {
            int deptno = Integer.parseInt(dato);
            String nom = controller.getDepartamento(deptno).getNombre();
            String loc = controller.getDepartamento(deptno).getLocalidad();
            %>
            <form method="post" id="formularioedicion" style="display: show">
                <table border="5">
                    <thead>
                        <tr>
                            <th colspan="3">Departamento <%=deptno%></th>
                        </tr>
                        <tr>
                            <th>Datos</th><th>Antiguos</th><th>Nuevos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Numero</td>
                            <td><%=deptno%></td>
                            <td><input type="number" name="cajanum" required/></td>
                        </tr>
                        <tr>
                            <td>Nombre</td>
                            <td><%=nom%></td>
                            <td><input type="text" name="cajanom" required/></td>
                        </tr>
                        <tr>
                            <td>Localidad</td>
                            <td><%=loc%></td>
                            <td><input type="text" name="cajaloc" required/></td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="3">
                                <button type="submit" style="width:100%" name="cajadept" value="<%=deptno%>">
                                    Modificar
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <button type="button" style="width:100%" name="botoncancelar">
                                    Cancelar
                                </button>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </form>
            <%
        }
        %>
        <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function() {
                //opcion para boton tipo button
                //con submit no funciona
                //EN EL FORMULARIO (ID NECESARIO) EL STYLE="DISPLAY:NONE"
                $("button[name=botoncancelar]").click(function()
                       $("#formularioedicion").hide();
                        
                );
            });
        </script>
    </body>
</html>
