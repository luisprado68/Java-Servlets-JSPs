<%-- Agregamos una declaracion --%>
<%!
    //Declaramos una variable con su metod get estos se incluyen dentro de clase de servlet
    private String usuario = "Luis Prado";
    public String getUsuario(){
        return this.usuario;
    }
    //Declaramos contador de visitas
    private int contadorVisitas = 1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de declaraciones JSP</title>
    </head>
    <body>
        <h1>Uso de declaraciones JSP</h1>
        Valor de el usuario por medio del atributo: <%= this.usuario%>
        <br>
        <br>
        Valor de el usuario por medio del metodo : <%= this.getUsuario() %>
        <br>
        <br>
        Contador visitas: <%= this.contadorVisitas++%>
    </body>
</html>
