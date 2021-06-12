

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Modifica el Java Bean</title>
    </head>
    <body>
        <h1>JSP Modifica el Java Bean</h1><!-- scope request solo dura cuando se realiza la peticion -->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        <br/><!-- comment -->
        <br/>
        <%
            int baseValor = 10;
            int alturaValor = 15;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%= baseValor %>"/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%= alturaValor %>"/>
        <br/>
        Nuevo valor de base: <%= baseValor %>
        <br/>
        Nuevo valor de altura <%= alturaValor %>
        <br/>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
