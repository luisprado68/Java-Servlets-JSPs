<%-- 
    Document   : index
    Created on : 10 jun. 2021, 19:44:25
    Author     : Luis
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>Hola Mundo JSPs</title>
    </head>
    <body>
        <h1>Hola Mundo JSPs</h1>
        <ul>
            <li><% out.print("Hola mundo desde Scriplets"); %></li>
            <li>${"Hola mundo con expression language (EL)"}</li>
            <li><%= "Hola mundo con expresiones" %></li>
            <li><c:out value="Hola mundo con JSL"/> </li>
        </ul>

    </body>
</html>
