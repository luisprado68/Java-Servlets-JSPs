<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core</h1>
        <%--Manipulacion de variables--%>
        <%--Definmos de variables--%>
        <c:set var="nombre" value="Luis Prado"/>
        <%--Desplegamos la variables--%>
        <c:out value="${nombre}"/>
        <br/>
        <br/>
        Variable codigo html:
        <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        <br/>
        <br/>
        Condigo condicional
        <c:set var="bandera" value="true"/>

        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>
        <br/>
        <br/>
        Condigo condicional switch
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    <br/>
                    Opcion 1 seleccionada
                </c:when>
                <c:when test="${param.opcion == 2}">
                <br/>
                Opcion 2 seleccionada
                </c:when>
                <c:otherwise>
                    <br/>
                    Opcion desconocida ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>
        <br/>
        <br/>
        Iteracion de arreglo
        <%
            String nombres[] = {"Luis","Celeste","Maria","Laura","Amadeo"};
            request.setAttribute("nombres", nombres);
        %>
        <br/>
        Lista de Nombres:
        <br/>
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>${persona}</li>
            </c:forEach> 
            
        </ul>
        <br/>
        <br/>
        <a href="index.jsp">Inicio</a>

        
    </body>
</html>
