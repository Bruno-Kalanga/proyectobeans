<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerhospital"
             class="controllers.ControllerHospital"
             scope="request"/>
<jsp:useBean id="controllersession"
             class="controllers.ControllerSession"
             scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Almacenar doctores v1</h1>
        <a href="webcontroller08doctoressessionv1.jsp">
            Mostrar doctores session
        </a>
        <%
        String iddoctor = request.getParameter("iddoctor");
        if (iddoctor != null){
            controllersession.getListadoctores().add(iddoctor);
            %>
            <h2 style="color:blue">
                Doctores almacenados: 
                <%=controllersession.getListadoctores().size()%>
            </h2>
            <%
        }
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                    <th>Salario</th>
                    <th>Hospital</th>
                </tr>
            </thead>
            <tbody>
                <%=controllerhospital.getFilasDoctores()%>
            </tbody>
        </table>   
    </body>
</html>