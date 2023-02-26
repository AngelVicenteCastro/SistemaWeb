<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MacPlayHome</title>

    <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/f903041418.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap');

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-decoration: none;
    font-family: 'Open Sans', sans-serif;
}

body{
    margin-left: 80px;
    margin-top: 80px;
    transition: margin-left 300ms cubic-bezier(0.785, 0.135, 0.15, 0.86);
}

main{
    padding: 20px;
}

header{
    width: 100%;
    height: 80px;
    background: #f5f5f5;
    display: flex;
    align-items: center;
    position: fixed;
    top: 0;
    z-index: 200;
}
.fondo_dinero_caja div {
  background-color: green;
  opacity: 0.6;
}

.icon__menu{
    width: 50px;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    transform: translateX(10px);
}

.icon__menu i{
    font-size: 20px;
    cursor: pointer;
    position: absolute;
}

.menu__side{
    width: 80px;
    height: 100%;
    background: #1783db;
    position: fixed;
    top: 0;
    left: 0;
    color: white;
    font-size: 18px;
    z-index: 300;
    overflow: hidden;
    overflow-y: scroll;
    border-right: 20px solid #1783db;
    transition: all 300ms cubic-bezier(0.785, 0.135, 0.15, 0.86);
}

/*Ocultar scroll para chrome, safari y opera*/
.menu__side::-webkit-scrollbar{
    display: none;
}

/*Ocultar scroll para IE, Edge y Firefox*/
.menu__side{
    -ms-overflow-style: none;
    scrollbar-width: none;
}


.name__page{
    padding: 20px 30px;
    display: flex;
    align-items: center;
    margin-top: 10px;
}

.name__page i{
    width: 20px;
    margin-right: 20px;
}

.options__menu{
    padding: 20px 30px;
    position: absolute;
    top: 80px;
}

.options__menu a{
    color: #ffffffb2;
    cursor: default;
    display: block;
    position: relative;
    transition: color 300ms;
}

.options__menu a:hover{
    color: white;
}

.options__menu .option{
    padding: 20px 0px;
    display: flex;
    align-items: center;
    position: relative;
}

.options__menu .option i{
    width: 20px;
    margin-right: 20px;
    cursor: pointer;
}

.options__menu .option h4{
    font-weight: 300;
    cursor: pointer;
}

a.selected{
    color: #fff;
}

.selected:before{
    content: '';
    width: 3px;
    height: 80%;
    background: white;
    position: absolute;
    top: 10%;
    left: -30px;
}

/*Clases para usar en JavaScript*/

.body_move{
    margin-left: 250px;
}

.menu__side_move{
    width: 250px;
}


@media screen and (max-width: 760px){
    .body_move{
        margin-left: 0px;
    }

    .menu__side_move{
        width: 80px;
        left: -80px;
    }
}
    </style>
</head>


<body id="body">
    
    <header>
        <div class="icon__menu">
            <i class="fas fa-bars" id="btn_open"></i>
        </div>
    </header>

    <div class="menu__side" id="menu_side">

        <div class="name__page">
            <i class="fa-sharp fa-solid fa-apple-whole"></i>
            <h4>Mac Play</h4>
        </div>

        <div class="options__menu">	

            <a href="#" class="selected">
                <div class="option">
                    <i class="fas fa-home" title="Inicio"></i>
                    <h4>Inicio</h4>
                </div>
            </a>

            <a href="#">
                <div class="option">
                    <i class="fas fa-cart-shopping" title="Ventas"></i>
                    <h4>Ventas</h4>
                </div>
            </a>
            
            <a href="#">
                <div class="option">
                   <i class="fa-sharp fa-solid fa-table" title="Inventario"></i>
                    <h4>Inventario</h4>
                </div>
            </a>

            <a href="#">
                <div class="option">
                    <i class="far fa-id-badge" title="Empleados"></i>
                    <h4>Empleados</h4>
                </div>
            </a>

            <a href="#">
                <div class="option">
                    <i class="fa-sharp fa-solid fa-cash-register" title="Caja"></i>
                    <h4>Caja</h4>
                </div>
            </a>

            <a href="#">
                <div class="option">
                    <i class="fa-sharp fa-solid fa-circle-info" title="Nosotros"></i>
                    <h4>Datos Negocio</h4>
                </div>
            </a>

        </div>

    </div>

    <main>
   <div class="container text-left">
   <div class="row justify-content-start">
   <div class="col-4">
        <div class="card" style="width: 18rem;">
  		<img src="https://cdn-icons-png.flaticon.com/512/1807/1807659.png" class="card-img-top" alt="...">
  			<div class="card-body">
    		<h5 class="card-title">$ 5,002.50</h5>
    		<p class="card-text">Dinero en caja</p>
    		<a href="#" class="btn btn-primary">Ir a sección caja</a>
  		</div>
  		</div>
  		</div>
  		<div class="col-4">
  		<div class="card" style="width: 18rem;">
  		<img src="https://www.pngkey.com/png/detail/414-4144576_agotado.png" width="280" height="280" class="card-img-top" alt="..." >
  			<div class="card-body">
    		<h5 class="card-title">15</h5>
    		<p class="card-text">Productos agotados</p>
    		<a href="#" class="btn btn-primary">Ir a sección productos</a>
  		</div>
		</div>
		</div>
		<div class="col-4">
  		<div class="card" style="width: 18rem;">
  		<img src="https://w7.pngwing.com/pngs/485/891/png-transparent-computer-icons-free-bitcoin-ethereum-classic-cash-payment-logo-cash-payment-bitcoin-faucet.png" width="280" height="280" class="card-img-top" alt="...">
  			<div class="card-body">
    		<h5 class="card-title">$ 8,526.50</h5>
    		<p class="card-text">Por ventas del dia</p>
    		<a href="#" class="btn btn-primary">Ir a sección ventas</a>
  		</div>
		</div>
		</div>
		</div>
		<br>
		<br>
		<div class="row justify-content-start">
   		<div class="col-4">
        <div class="card" style="width: 18rem;">
  		<img src="https://cdn-icons-png.flaticon.com/512/1807/1807659.png" class="card-img-top" alt="...">
  			<div class="card-body">
    		<h5 class="card-title">$ 5,002.50</h5>
    		<p class="card-text">Dinero en caja</p>
    		<a href="#" class="btn btn-primary">Ir a sección caja</a>
  		</div>
  		</div>
  		</div>
  		<div class="col-4">
  		<div class="card" style="width: 18rem;">
  		<img src="https://www.pngkey.com/png/detail/414-4144576_agotado.png" width="280" height="280" class="card-img-top" alt="..." >
  			<div class="card-body">
    		<h5 class="card-title">15</h5>
    		<p class="card-text">Productos agotados</p>
    		<a href="#" class="btn btn-primary">Ir a sección productos</a>
  		</div>
		</div>
		</div>
		<div class="col-4">
  		<div class="card" style="width: 18rem;">
  		<img src="https://w7.pngwing.com/pngs/485/891/png-transparent-computer-icons-free-bitcoin-ethereum-classic-cash-payment-logo-cash-payment-bitcoin-faucet.png" width="280" height="280" class="card-img-top" alt="...">
  			<div class="card-body">
    		<h5 class="card-title">$ 8,526.50</h5>
    		<p class="card-text">Por ventas del dia</p>
    		<a href="#" class="btn btn-primary">Ir a sección ventas</a>
  		</div>
		</div>
		</div>
		</div>
		</div>
        </main>

    <script type="text/javascript">
  //Ejecutar función en el evento click
    document.getElementById("btn_open").addEventListener("click", open_close_menu);

    //Declaramos variables
    var side_menu = document.getElementById("menu_side");
    var btn_open = document.getElementById("btn_open");
    var body = document.getElementById("body");

    //Evento para mostrar y ocultar menú
        function open_close_menu(){
            body.classList.toggle("body_move");
            side_menu.classList.toggle("menu__side_move");
        }

    //Si el ancho de la página es menor a 760px, ocultará el menú al recargar la página

    if (window.innerWidth < 760){

        body.classList.add("body_move");
        side_menu.classList.add("menu__side_move");
    }

    //Haciendo el menú responsive(adaptable)

    window.addEventListener("resize", function(){

        if (window.innerWidth > 760){

            body.classList.remove("body_move");
            side_menu.classList.remove("menu__side_move");
        }

        if (window.innerWidth < 760){

            body.classList.add("body_move");
            side_menu.classList.add("menu__side_move");
        }

    });
    </script>
</body>
</html>