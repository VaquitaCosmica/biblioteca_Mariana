
<%@page import="modelos.Editorial"%>
<%@page import="modelos.Categoria"%>
<%@page import="modelos.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelos.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crear Libro</title>
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
            margin-left: 7vw;
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
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        List<Autor> autores = (List<Autor>) request.getAttribute("autores");
        List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
        List<Editorial> editoriales = (List<Editorial>) request.getAttribute("editoriales");
        System.out.println("Autor: " + autores.get(0).getNombre());
    %>
    <body  method="GET" action="LibroServlet" class="body" bgcolor="#e0766e">
        <form class="div_reg">
            <h1 class="login_title">Crear Libro</h1>
            <h3 class="login_text">ID</h3>
            <input type="text" name="id" class="entrada" value="" required >
            <h3 class="login_text">Título</h3>
            <input type="text" name="titulo" class="entrada" value="" required>
            <h3 class="login_text">Categoría</h3>
            <select type="text" name="categoria" class="entrada" value="" required>
                <% for (int i = 0; i < categorias.size(); i++) {%>
                <option value="<%= categorias.get(i).getId_categoria()%>" > <%out.print(categorias.get(i).getId_categoria());%></option>
                <%}%>
            </select>
            <h3 class="login_text">Anaquel</h3>
            <input type="number" name="anaquel" class="entrada" value="" required>
            <h3 class="login_text">Idioma</h3>
            <select type="text" name="idioma" class="entrada" value="" required>
                <option value="value1">Espanol</option>
                <option value="value2">Ingles</option>
                <option value="value3">Frances</option>
                <option value="value4">Alemán</option>
            </select>
            <h3 class="login_text">Paginas</h3>
            <input type="number" name="paginas" class="entrada" value="" required>
            <h3 class="login_text">Autor</h3>
            <select type="text" name="autor" class="entrada" value="" required>
                <% for (int i = 0; i < autores.size(); i++) {%>
                <option value="<%= autores.get(i).getId_Autor()%>" > <%out.print(autores.get(i).getId_Autor());%></option>
                <%}%>
            </select>
            <h3 class="login_text">Año</h3>
            <input type="number" name="anio" class="entrada" value="" required>
            <h3 class="login_text">Editorial</h3>
            <select type="text" name="editorial" class="entrada" value="" required>
                <% for (int i = 0; i < editoriales.size(); i++) {%>
                <option value="<%= editoriales.get(i).getRazon_social()%>" > <%out.print(editoriales.get(i).getRazon_social());%></option>
                <%}%>
            </select>
            <input type="hidden" name="operacion" value="CREAR" />
            <input class="but_env" type="submit" value="Crear"/>           

        </form>
        <div class="div_buton_com">
            <a href="menu.jsp" class="but_com">Cancelar</a>
        </div>
    </body>

</html>