<%-- 
    Document   : expresiones
    Created on : 10 jun. 2021, 20:17:21
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con expresiones</title>
    </head>
    <body>
        <h1>JSP con expresiones</h1>
        Concatenacion: <%= "Saludos" + " "+"JSP" %>
        <br><!-- comment -->
        Operacion Matematica: <%= 2 * 3 / 2 %>
        <br>
        Session: <%= session.getId() %>
        <br>
        <br>
        <a href="index.html">Regresar al incio</a>
    </body>
</html>
