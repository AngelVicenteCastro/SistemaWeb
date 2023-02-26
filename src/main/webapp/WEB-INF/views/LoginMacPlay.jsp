<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>MacPlay</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>

	
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"
	type="text/css">
<script lenguaje="JavaScript" type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">


   <style>
   * {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	font-family: 'Roboto', sans-serif;
}

body {
	background-image: url(https://images.pexels.com/photos/1532771/pexels-photo-1532771.jpeg?auto=compress&cs=tinysrgb&w=1600);
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
	background-attachment: fixed;
}

main {
	width: 100%;
	padding: 20px;
	margin: auto;
	margin-top: 100px;
}

.contenedor__todo {
	width: 100%;
	max-width: 800px;
	margin: auto;
	position: relative;
}

.caja__trasera {
	width: 100%;
	padding: 10px 20px;
	display: flex;
	justify-content: center;
	-webkit-backdrop-filter: blur(10px);
	backdrop-filter: blur(10px);
	background-color: rgba(0, 128, 255, 0.5);
}

.caja__trasera div {
	margin: 100px 40px;
	color: white;
	transition: all 500ms;
}

.caja__trasera div p, .caja__trasera button {
	margin-top: 30px;
}

.caja__trasera div h3 {
	font-weight: 400;
	font-size: 26px;
}

.caja__trasera div p {
	font-size: 16px;
	font-weight: 300;
}

.caja__trasera button {
	padding: 10px 40px;
	border: 2px solid #fff;
	font-size: 14px;
	background: transparent;
	font-weight: 600;
	cursor: pointer;
	color: white;
	outline: none;
	transition: all 300ms;
}

.caja__trasera button:hover {
	background: #fff;
	color: #46A2FD;
}

/*Formularios*/
.contenedor__login-register {
	display: flex;
	align-items: center;
	width: 100%;
	max-width: 380px;
	position: relative;
	top: -185px;
	left: 10px;
	/*La transicion va despues del codigo JS*/
	transition: left 500ms cubic-bezier(0.175, 0.885, 0.320, 1.275);
}

.contenedor__login-register form {
	width: 100%;
	padding: 80px 20px;
	background: white;
	position: absolute;
	border-radius: 20px;
}

.contenedor__login-register form h2 {
	font-size: 30px;
	text-align: center;
	margin-bottom: 20px;
	color: #46A2FD;
}
.contenedor__login-register form h5 {
	font-size: 10px;
	text-align: left;
	margin-bottom: 20px;
	color: #46A2FD;
}

.contenedor__login-register form input {
	width: 100%;
	margin-top: 20px;
	padding: 10px;
	border: none;
	background: #F2F2F2;
	font-size: 16px;
	outline: none;
}


.contenedor__login-register form button {
	padding: 10px 40px;
	margin-top: 40px;
	border: none;
	font-size: 14px;
	background: #46A2FD;
	font-weight: 600;
	cursor: pointer;
	color: white;
	outline: none;
}

.formulario__login {
	opacity: 1;
	display: block;
}

.formulario__register {
	display: none;
}

@media screen and (max-width: 850px) {
	main {
		margin-top: 50px;
	}
	.caja__trasera {
		max-width: 350px;
		height: 300px;
		flex-direction: column;
		margin: auto;
	}
	.caja__trasera div {
		margin: 0px;
		position: absolute;
	}

	/*Formularios*/
	.contenedor__login-register {
		top: -10px;
		left: -5px;
		margin: auto;
	}
	.contenedor__login-register form {
		position: relative;
	}
}   
   </style>

<script>


$(document).ready(function(){

	$('#btnLogin').on('click', function(){
		var empleado= {
			usuarioMP: $('#Username').val(),
			passwordMP: $('#Pass').val()
		}
		
		console.log(empleado.usuarioMP)
		console.log(empleado.passwordMP)
		
		$.ajax({
			type:"POST",
			url:"/SistemaWeb/Sistema/validarEmpleado",
			data:JSON.stringify(empleado),
			datatype:"JSON",
			contentType:'application/json',
			success: function (response){
				
				//alert(response.message)
				if (response.message == "Autorizado"){
					location.href = "/SistemaWeb/Sistema/Home";
				}else{
					alert(response.message)
				}
			},
		});
		
		
	});
	
	$('#btnAutorizarR').on('click', function(){
		var solicitud={
				usuarioMP: $('#usuarioA').val(),
				passwordMP: $('#passA').val()
		}
		$.ajax({
			type:"POST",
			url:"/SistemaWeb/Sistema/validarEmpleado",
			data:JSON.stringify(solicitud),
			datatype:"JSON",
			contentType:'application/json',
			success: function (response){
				
				//alert(response.message)
				if (response.message == "Autorizado"){
					var empleado= {
							nombreMP: $('#NombreUR').val(),
							usuarioMP: $('#UsuarioR').val(),
							passwordMP: $('#PassR').val(),
							edadMP: $('#EdadR').val(),
							fechaIngresoMP: $('#FechaR').val(),
							loginMP: 1
					}
					
					console.log(empleado)
					//console.log(trabajador.edad)
					//console.log(trabajador.salario)
					//console.log(trabajador.fechaIngreso)
					
					$.ajax({
						type:"POST",
						url:"/SistemaWeb/Sistema/insertarEmpleado",
						data:JSON.stringify(empleado),
						datatype:"JSON",
						contentType:'application/json',
						success: function (response){
							if (response.message == "Usuario Agregado"){
								alert(response.message)
								location.href = "/SistemaWeb/Sistema/LoginMacPlay";
							}else{
								alert(response.message)
							}
						},
					});
				}else{
					alert(response.message)
				}
			},
		});
		
		
		
		
	});
	
	$('#btnSRegistro').on('click', function(){
		document.getElementById('modalAutorizar').style.display = 'block'
	});
	$('#btnCerrarSol').on('click', function(){
		  document.getElementById('modalAutorizar').style.display = 'none'
				
		});

});

</script>
   
</head>
<body>

        <main>

            <div class="contenedor__todo">
                <div class="caja__trasera">
                    <div class="caja__trasera-login">
                        <h3>¿Ya eres usuario?</h3>
                        <p>Inicia sesión para entrar al sistema</p>
                        <button id="btn__iniciar-sesion">Iniciar Sesión</button>
                    </div>
                    <div class="caja__trasera-register">
                        <h3>¿Aún no eres usuario?</h3>
                        <p>Registrate para que puedas iniciar sesión</p>
                        <button id="btn__registrarse">Registrarse</button>
                    </div>
                </div>

                <!--Formulario de Login y registro-->
                <div class="contenedor__login-register">
                    <!--Login-->
                    <form action="" class="formulario__login">
                        <h2>Iniciar Sesión</h2>
                        <input type="text" id="Username" placeholder="Usuario">
                        <input type="password" id="Pass" placeholder="Contraseña">
                        <button  type="button" id="btnLogin" >Entrar</button>
                    </form>

                    <!--Register-->
                    <form action="" class="formulario__register">
                        <h2>Registrarse</h2>
                        <input type="text" id="NombreUR" placeholder="Nombre completo">
                        <input type="text" id="UsuarioR" placeholder="Nombre de Usuario">
                        <input type="text" id="EdadR" placeholder="Edad">
                        <input type="text"  id="FechaR" placeholder="Feche registro AAAA-MM-DD">
                        <input type="password" id="PassR" placeholder="Contraseña">
                        <button  type="button" id="btnSRegistro">Solicitar Registro</button>
                    </form>
                </div>
            </div>

        </main>

        <script type="text/javascript">
 //Ejecutando funciones
   document.getElementById("btn__iniciar-sesion").addEventListener("click", iniciarSesion);
   document.getElementById("btn__registrarse").addEventListener("click", register);
   window.addEventListener("resize", anchoPage);

   //Declarando variables
   var formulario_login = document.querySelector(".formulario__login");
   var formulario_register = document.querySelector(".formulario__register");
   var contenedor_login_register = document.querySelector(".contenedor__login-register");
   var caja_trasera_login = document.querySelector(".caja__trasera-login");
   var caja_trasera_register = document.querySelector(".caja__trasera-register");

       //FUNCIONES

   function anchoPage(){

       if (window.innerWidth > 850){
           caja_trasera_register.style.display = "block";
           caja_trasera_login.style.display = "block";
       }else{
           caja_trasera_register.style.display = "block";
           caja_trasera_register.style.opacity = "1";
           caja_trasera_login.style.display = "none";
           formulario_login.style.display = "block";
           contenedor_login_register.style.left = "0px";
           formulario_register.style.display = "none";   
       }
   }

   anchoPage();


       function iniciarSesion(){
           if (window.innerWidth > 850){
               formulario_login.style.display = "block";
               contenedor_login_register.style.left = "10px";
               formulario_register.style.display = "none";
               caja_trasera_register.style.opacity = "1";
               caja_trasera_login.style.opacity = "0";
           }else{
               formulario_login.style.display = "block";
               contenedor_login_register.style.left = "0px";
               formulario_register.style.display = "none";
               caja_trasera_register.style.display = "block";
               caja_trasera_login.style.display = "none";
           }
       }

       function register(){
           if (window.innerWidth > 850){
               formulario_register.style.display = "block";
               contenedor_login_register.style.left = "410px";
               formulario_login.style.display = "none";
               caja_trasera_register.style.opacity = "0";
               caja_trasera_login.style.opacity = "1";
           }else{
               formulario_register.style.display = "block";
               contenedor_login_register.style.left = "0px";
               formulario_login.style.display = "none";
               caja_trasera_register.style.display = "none";
               caja_trasera_login.style.display = "block";
               caja_trasera_login.style.opacity = "1";
           }
   }
   </script>
   
   <div class="modal" tabindex="-1" id="modalAutorizar">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Autorizar Registro</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <div class="input-group mb-3">
 		 <span class="input-group-text" id="basic-addon1">Usuario</span>
 		 <input id="usuarioA" type="text" class="form-control"  aria-label="Username" aria-describedby="basic-addon1">
	</div>
	
        <div class="input-group mb-3">
 		 <span class="input-group-text" id="basic-addon1">Contraseña</span>
 		 <input id="passA" type="password" class="form-control"  aria-label="Username" aria-describedby="basic-addon1">
	</div>
      <div class="modal-footer">
        <button id="btnCerrarSol" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button id="btnAutorizarR" type="button" class="btn btn-primary">Autorizar</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>