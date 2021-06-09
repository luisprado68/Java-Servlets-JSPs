
function validarForma(forma) {
    
    var usuario = forma.usuario;
    if(usuario.value == "" || usuario.value == "escribir usuario"){
        alert("Debes ingresar un nombre de usuario!");
        usuario.focus();
        usuario.select();
        return false;
    }
    var password = forma.password;
    if(password.value == "" || password.value.length < 3){
        alert("Debe ingresar un password mayor a 3 caracteres");
        password.focus();
        password.select();
        return false;
    }
    var tecnologias = forma.tecnologia;
    var checkseleccionado = false;
    
    for (var i = 0; i < tecnologias.length; i++) {
        if(tecnologias[i].checked){
            checkseleccionado = true;
        }
    }
    if(!checkseleccionado){
        alert("Debe seleccionar una tecnologia!");
        return false;
    }
     var generos = forma.genero;
     
     var radioSeleccionado = false;
     
     for (var i = 0; i < generos.length; i++) {
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero!");
        return false;
    }
    
    var ocupacion = forma.ocupacion;
    if(ocupacion.value == ""){
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    
    alert("Formulario valido enviando datos al servidor");
    return true;
}

