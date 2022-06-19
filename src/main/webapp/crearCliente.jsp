
<%@page import="modelos.Cliente"%>
<%@page import="modelos.Usuario"%>
<%@page import="modelos.Ciudad"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@page import="modelos.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crear Cliente</title>
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
        if (request.getAttribute("permiso") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        List<Ciudad> ciudades = (List<Ciudad>) request.getAttribute("ciudades");
        System.out.println("Ciudad " + ciudades.get(0).getNombre());
    %>
    <body method="GET" action="ClienteServlet" class="body" bgcolor="#e0766e">
        <form class="div_reg">
            <h1 class="login_title">Crear Cliente</h1>

            <h3 class="login_text">ID</h3>
            <input type="text" name="ID_cliente" class="entrada" value="" placeholder="ID del cliente" required>

            <h3 class="login_text">Nombre</h3>
            <input type="text" name="nombre" class="entrada" value="" placeholder="Juan" required>

            <h3 class="login_text">Apellido paterno</h3>
            <input type="text" name="ape_pat" class="entrada" value="" placeholder="Perez" required>

            <h3 class="login_text">Apellido materno</h3>
            <input type="text" name="ape_mat" class="entrada" value="" placeholder="Lopez" required>

            <h3 class="login_text">Nacimiento</h3>
            <input type="date" name="f_nacimiento" class="entrada" value="" required>

            <h3 class="login_text">Calle</h3>
            <input type="text" name="calle" class="entrada" value="" placeholder="AV. de las letras" required>

            <h3 class="login_text">Numero</h3>
            <input type="number" name="numero" class="entrada" value="" placeholder="60" required>

            <h3 class="login_text">Colonia</h3>
            <input type="text" name="colonia" class="entrada" value="" placeholder="Col. literatura" required>

            <h3 class="login_text">Ciudad</h3>
            <select type="text" name="ciudad_id" class="entrada" value="" required>
                <% for (int i = 0; i < ciudades.size(); i++) {%>
                <option value="<%= ciudades.get(i).getCiudad_ID()%>" > <%out.print(ciudades.get(i).getNombre());%></option>
                <%}%>
            </select>

            <h3 class="login_text">Telefono</h3>
            <input type="number" name="telefono" class="entrada" value="" placeholder="Numeo de telefono" required>

            <h3 class="login_text">Ocupacion</h3>
            <input type="text" name="ocupacion" class="entrada" value="" placeholder="Ocupacion" required>

            <input type="hidden" name="operacion" value="CREAR" />
            <input class="but_env" type="submit" value="Crear"/>    
        </form>
        <div class="div_buton_com">
            <a href="menu.jsp" class="but_com">Cancelar</a>
        </div>
    </body>
</html>
