<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVCS</h1>
        <br/>
        <br/>
        <div style="color: red">${mensaje}</div>
           <br/>
           <a href="${pageContext.request.contextPath}/ServletControlador">
           Link al servlet controlador sin parametros
           </a>
           <br/>
           <br/>
           <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">
           Link al servlet controlador para agregar las  variables
           </a>
           <br/>
           <br/>
           <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
           Link al servlet controlador para listar las  variables
           </a>
        
    </body>
</html>
