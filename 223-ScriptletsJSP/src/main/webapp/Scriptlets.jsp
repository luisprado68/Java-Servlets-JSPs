

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Scriptlets</title>
    </head>
    <body>
        <h1>JSP Scriptlets</h1>
        <br>
        <%-- Scriptlet para enviar informacion al navegador --%>
        <%
            out.print("Saludos desde un scriptlet");
         %>
         <%-- Scriptlet para manipular los objetos implicitos --%>
         
         <%
             String nombreAplicacion = request.getContextPath();
             out.print("Nombre de la aplicacion: " + nombreAplicacion);
         %>
         <br>
         <%-- Scriptlet con codigo condicionado --%>
         <%
             if(session != null && session.isNew()){
         %>
         La sesion es nueva
         <%
             }else if(session != null){
         %>
          La sesion no es nueva
          <%
             }
         %>
         <br>
         <a href="index.html">Inicio</a>
    </body>
</html>
