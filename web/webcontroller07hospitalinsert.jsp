<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller02Hospital"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/webhead.jsp"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="includes/webmenuhospital.jsp"/>
        <main role="main" class="container">
        <div class="starter-template">
        <h1>Insertar Hospital</h1>
        <form method="post">
            <table class="table table-hover">
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="cajanombre" requested/></td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td><input type="text" name="cajadireccion" requested/></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="cajatelefono" requested/></td>
                </tr>
                <tr>
                    <td>Numero camas</td>
                    <td><input type="number" name="cajacamas" requested/></td>
                </tr>
            </table>
            <button class="btn btn-primary" type="submit">
                Insertar
            </button>
        </form>
        <%
        String nombre = request.getParameter("cajanombre");
        if (nombre != null){
            String dir = request.getParameter("cajadireccion");
            String tlf = request.getParameter("cajatelefono");
            int camas = Integer.parseInt(request.getParameter("cajacamas"));
            controller.insertHospital(nombre, dir, tlf, camas);
            %>
            <jsp:forward page="webcontroller07hospital.jsp"/>
            <%
        }
        %>
        </div>
        </main><!-- /.container -->
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
