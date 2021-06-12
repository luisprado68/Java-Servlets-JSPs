

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP para leer los valores del Javabeans</title>
    </head>
    <body>
        <h1>JSP para leer los valores del Javabeans</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        <br/>
        <br/>
        Valor Base: <jsp:getProperty name="rectangulo" property="base" />
        <br/>
        Valor Altura: <jsp:getProperty name="rectangulo" property="altura" />
        <br/>
        Valor Area: <jsp:getProperty name="rectangulo" property="area"/>
        <br/>
        <br/>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
