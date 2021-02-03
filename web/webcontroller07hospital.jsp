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
       <form>
        <jsp:include page="includes/webmenuhospital.jsp"/>
        <main role="main" class="container">
        <div class="starter-template">
        <h1>Hospitales</h1>
        
            <table class="table table-primary">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Num.Camas</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaHospitales()%>
            </tbody>
        </table>
       </form>
        </div>
            <h1 id="mostrar">--</h1>
        </main><!-- /.container -->
        <jsp:include page="includes/webfooter.jsp"/>
    <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script>
        $(document).ready(function(){
            $("#linkeliminar").submit(function(){
                var hospcod = value.get("botoncheck");
                
            });
        });
    </script>
    </body>
</html>
