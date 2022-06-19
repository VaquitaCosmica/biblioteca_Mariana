
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
        .div_reg{
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
    <!-- Se encarga de registrar un usuario-->                       
    <body class="body" bgcolor="#e0766e">
        <form action="ServletBiblioteca" method="GET"
              class="div_reg">
            <h1 class="login_title">Registro</h1>
            <h3 class="login_text">Escribe un nombre de usuario</h3>
            <input type="text" name="usuario" class="entrada" placeholder="Emplead@Sexy" required>
            <h3 class="login_text">Ingresa la contraseña</h3>
            <input type="password" name="contrasena" class="entrada" placeholder="SexyPassword" required>
            <input type="hidden" name="esRegistro" value="true"/>
            <div>
                <input type="submit" class="but_env" value="Entrar">                </div>
        </div>

    </form>
    <div class="div_buton_com">
        <a href="index.jsp" class="but_com">Regresar</a>
    </div>
</body>

</html>
