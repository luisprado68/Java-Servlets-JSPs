
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/db664936e9.js" crossorigin="anonymous"></script>
        <title>Control de Clientes</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"></jsp:include>
        
       
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
              method="POST" class="was-validated">
            
            <jsp:include page="/WEB-INF/paginas/comunes/botonesEdicion.jsp"></jsp:include>
            <section id="details">
                <div class="container">
                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Cliente</h4>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}"/>
                                </div>
                                <div class="form-group">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}"/>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" required value="${cliente.email}"/>
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Telefono</label>
                                    <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}"/>
                                </div>
                                <div class="form-group">
                                    <label for="saldo">Saldo</label>
                                    <input type="number" class="form-control" name="saldo" required value="${cliente.saldo}" step="any"/>
                                </div>
                            </div>
                        </div>
                    </div>   
                </div>
            </section>
        </form>
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"></jsp:include>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </body>
</html>