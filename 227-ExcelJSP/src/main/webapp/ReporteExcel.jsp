<%-- Directiva para manejo de expeciones --%>
<%@page errorPage="WEB-INF/ManejoErrores.jsp" %>
<%-- Directiva para importar la clase y clase date --%>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<%-- Directiva para tipo de contenido excel ponemos inline(para redirigir el atributo de error) --%>
<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1 Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis basica de java</td>
                <%-- Generamos un error --%>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
            <tr>
                <td>2 Programacion con  Java</td>
                <td>Pondremos en practica los conceptos de la POO </td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
        </table>
    </body>
</html>
