
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el formulario</h1>
        Usuario: <%= request.getParameter("usuario")%>
        <br><!-- comment -->
        Password: <%= request.getParameter("password")%>
        <br>
        <br><!-- comment -->
        <a href="index.html">Volver al inicio</a>
                
    </body>
</html>
