<%-- 
    Document   : actualizarMobiliario
    Created on : 18/06/2022, 01:05:17 PM
    Author     : MARIANA
--%>

<%@page import="modelos.Mobiliario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mobiliario</title>
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

        .div_reg {
            min-height: max-content;
            margin-top: 5vh;
            margin-left: 30vw;
            margin-right: 30vw;
            background-color: white;
            padding: 30px;
            align-items: center;
            border-radius: 25px;
        }

        .login_title {
            text-align: center;
            color: #AD5A54;
            font-size: 3rem;
        }

        .login_text {
            margin-top: 25px;
            margin-left: 20px;
            font-weight: 500;
        }

        .div_buton_com {
            align-items: center;
            display: flex;
        }

        .entrada {
            margin-left: 20px;
            background-color: #fac9c5;
            border-color: #fac9c5;
            border-style: none;
            padding: 7px;
            width: 33vw;
        }

        .but_env {
            color: azure;
            text-decoration: none;
            position: absolute;
            margin-top: 15px;
            margin-left: 10vw;
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
            margin-top: 20vh;
            margin-left: 10px;
            text-align: center;
            padding: 15px 60px;
            background-color: #61332f;
            border-radius: 25px;
            font-size: 2rem;
        }

        .div_buton_reg {
            align-items: center;
            display: flex;
        }

        .but_reg {
            color: azure;
            text-decoration: none;
            margin-top: 20vh;
            margin-left: 65vw;
            text-align: center;
            padding: 15px 60px;
            background-color: #61332f;
            border-radius: 25px;
            font-size: 2rem;
        }
    </style>
    <%
        if (request.getParameter("id_mobiliario") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        Mobiliario mobiliario = new Mobiliario();
        mobiliario.setId_mobiliario(request.getParameter("id_mobiliario"));
        mobiliario.setNombre(request.getParameter("nombre"));
        mobiliario.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
    %>
    <body method="GET" action="MobiliarioServlet" class="body" bgcolor="#e0766e">
        <form class="div_reg">
            <h1 class="login_title">Actualizar Mobiliario</h1>

            <h3 class="login_text">ID</h3>
            <input type="text" name="id_mobiliario" class="entrada" value="<%= mobiliario.getId_mobiliario()%>">

            <h3 class="login_text">Nombre</h3>
            <input type="text" name="nombre" class="entrada" value="<%= mobiliario.getNombre()%>" placeholder="MobiliarioSexy">

            <h3 class="login_text">Cantidad</h3>
            <input type="number" name="cantidad" class="entrada" value="<%= mobiliario.getCantidad()%>" placeholder="1" >
            <input class="but_env" type="submit" value="Actualizar"/>   
            <input type="hidden" name="antiguoId" value="<%=mobiliario.getId_mobiliario()%>">
            <input type="hidden" name="operacion" value="ACTUALIZAR" />
        </form>
        <div class="div_buton_com">
            <a href="menu.jsp" class="but_com">Cancelar</a>
        </div>
    </body>

</html>
