<%@page import="daos.UsuarioDAO"%>
<%@page import="modelos.Usuario"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Biblioteca</title>
    </head>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@100;200;300;400;500;600;700&display=swap');
        * {
            margin: 0;
            box-sizing: border-box;
        }

        .body {
            align-items: center;
            font-family: 'Josefin Sans', sans-serif;
        }

        .header {
            padding: 30px;
            background-color: #e0766e;
            margin-bottom: 20px;
            color: azure;
            text-align: center;
        }

        .bib_mar {
            text-align: center;
            font-weight: 800;
            font-size: 3rem;
        }

        .slogan {
            margin-top: 20px;
            text-align: center;
            font-weight: 300;
            font-size: 1.5rem;
        }

        .elemento-menu {
            display: flex;
            justify-content: space-evenly;
            align-items: center;
            flex-wrap: wrap;
        }

        .elemento-menu-boton {
            border-style: none;
            padding: 20px;
            align-items: center;
            min-width: 20vw;
            min-height: 20vh;
            margin: 30px;
            text-align: center;
            background-color: #fac9c5;
            border-radius: 25px;
            font-size: 2rem;
            text-decoration: none;
        }

        .menu-texto {
            text-decoration: none;
            color: black;
            font-weight: 400;
            font-size: 2rem;
        }

        .elemento-menu-boton img {
            height: 7vh;
            width: auto;
        }

        .img-menu {
            height: 7vh;
            width: auto;
        }

        .but_env {
            color: azure;
            text-decoration: none;
            position: absolute;
            margin-top: 15px;
            margin-left: 12vw;
            text-align: center;
            padding: 15px 60px;
            background-color: #61332f;
            border-radius: 25px;
            font-size: 2rem;
            border-color: #61332f;
            border-style: none;
        }

        .but_com {
            color: azure;
            text-decoration: none;
            margin-left: 0;
            text-align: center;
            padding: 15px 60px;
            background-color: #61332f;
            border-radius: 25px;
            font-size: 1rem;
        }

    </style>
    <!-- Se encarga de mostrar en un menú las diferentes tablas a las que se les puede llamar-->                       
    <%
        List<Usuario> datos = (List<Usuario>) request.getAttribute("users");
    %>
    <body class="body">
        <div class="div_reg">

        </div>
        <div class="header">
            <h1 class="bib_mar">BIBLIOTECA MARIANITA</h1>
            <H3 class="slogan">Todo esto sucedió, más o menos así...</H3>            
        </div>        
        <div class="menu">
            <div class="elemento-menu">
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="LIBRO">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Libros"/> </div>
                </form>
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="PRESTAMO">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Prestamos"/> </div>
                </form>
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="MOBILIARIO">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Mobiliario"/> </div>
                </form>
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="MANTENIMIENTO">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Mantenimiento"/> </div>
                </form>
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="CLIENTE">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Clientes"/> </div>
                </form>
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="EMPLEADO">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Empleados"/> </div>
                </form>
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="AUTOR">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Autores"/> </div>
                </form>
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="DESEMPLEADO">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Desempleados"/> </div>
                </form>
                <form method="GET" action="MenuServlet">
                    <input type="hidden" name="Tipo" value="USUARIO">
                    <div> <input class="elemento-menu-boton" src="Diseño sin título.png" type="submit" value="Usuarios"/> </div>
                </form>
            </div>
        </div>
        <form method="GET" action="logoutServlet">
            <input class="but_com" type="submit" value="Cerrar sesion"  href=""/>
        </form
    </body>

</html>
