
<%-- Directiva para indicar que es la pagina para manejo de errores --%>
<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
    </head>
    <body>
        <h1>Manejo de Errores</h1>
        <br/><!-- comment -->
        Ocurrio una excepcion: <%= exception.getMessage()%>
        <br/>
        <!-- Mostramos la pila de excepciones -->
        <textarea cols="30" rows="5">
            <pre>
                <% exception.printStackTrace(new PrintWriter(out)); %>
            </pre>
        </textarea>

    </body>
</html>
