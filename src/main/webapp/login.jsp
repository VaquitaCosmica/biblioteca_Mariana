<%-- 
    Document   : login
    Created on : 15/06/2022, 08:50:20 PM
    Author     : MARIANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Biblioteca Login</title>
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

        .div_login{
            max-height: 90vh;
            min-height: max-content;
            margin-top: 20vh;
            margin-left: 30vw;
            margin-right: 30vw;
            background-color: white;
            padding: 30px;
            align-items: center;
            border-radius: 25px;
        }

        .login_title{
            text-align: center;
            color: #AD5A54;
            font-size: 3rem;
        }

        .login_text{
            margin-top: 25px;
            margin-left: 20px;
            font-weight: 500;
        }
        .div_buton_com {
            align-items: center;
            display: flex;
        }

        .entrada{
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

        .but_reg{
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
    <!-- Se encarga de iniciar sesion con la cuenta de un usuario-->                       
    <body class="body" bgcolor="#e0766e">
        <form action="ServletBiblioteca" method="POST"
              class="div_login">
            <h1 class="login_title">Log in</h1>
            <h3 class="login_text">Ingresa tu usuario</h3>
            <input type="text" name="usuario" class="entrada" placeholder="Emplead@Sexy" required>
            <h3 class="login_text">Ingresa tu contraseña</h3>
            <input type="password" name="contrasena" class="entrada" placeholder="SexyPassword" required>
            <div>
                <input type="submit" class="but_env" value="Entrar">                </div>
        </form>
        <div class="div_buton_com">
            <a href="index.jsp" class="but_com">Regresar</a>
            <div class="div_buton_reg">
            <a href="registrar.jsp" class="but_reg">Registrar</a>
        </div>
        </div>
    </body>
</html>