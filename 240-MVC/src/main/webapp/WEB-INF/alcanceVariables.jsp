
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance Variables</title>
    </head>
    <body>
        <h1>Alcance Variables</h1>
        <br/>
        Variable request:
        Base:${rectanguloRequest.base}
        Altura:${rectanguloRequest.altura}
        Area{rectanguloRequest.area}
        <br/><br/>
        Variable Session
        Base:${rectanguloSession.base}
        Altura:${rectanguloSession.altura}
        Area{rectanguloSession.area}
        <br/><br/>
        Variable Aplicacion
        Base:${rectanguloApplication.base}
        Altura:${rectanguloApplication.altura}
        Area{rectanguloApplication.area}
        <br/><br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
    </body>
</html>
