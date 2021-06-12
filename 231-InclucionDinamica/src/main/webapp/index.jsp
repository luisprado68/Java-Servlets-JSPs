

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inclucion Dinamica</title>
    </head>
    <body>
        <h1>Inclucion Dinamica</h1>
        <br/><!-- comment -->
        <jsp:include page="paginas/recursoPublicoJSP.jsp"></jsp:include>
        <br/><!-- se puede agrear parametros para pasar informacion a otro jsp -->
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"></jsp:param>
        </jsp:include>
    </body>
</html>
