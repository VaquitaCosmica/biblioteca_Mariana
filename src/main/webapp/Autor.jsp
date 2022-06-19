<%@page import="modelos.Autor"%>
<%@page import="daos.UsuarioDAO"%>
<%@page import="modelos.Usuario"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Autores</title>
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

        .title{
            height: 10vh;
            margin-top: 10px;
            margin-left: 28vw;
            align-items: center;
            text-align: center;
            font-size: 2.5rem;
            color: azure;
        }

        .fondo{
            background-color: azure;
            min-height: 80vh;
            margin: 5vh;
            margin-top: 3vh;
            border-radius: 20px;

        }
        table {
            margin-top: 5px;
            table-layout: fixed;
            width: 90%;
            border-collapse: collapse;
            margin-left: 5%;
        }

        thead th:nth-child(1) {
            width: 30%;
        }

        thead th:nth-child(2) {
            width: 20%;
        }

        thead th:nth-child(3) {
            width: 15%;
        }

        thead th:nth-child(4) {
            width: 35%;
        }

        th, td {
            padding: 20px;

        }

        .contenedor.row {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
        }

        .btn {
            font-size: 18px;
            font-weight: 400;
            text-align: center;
            outline: none;
            border: none;
            padding: 0.6rem 1.4rem;
            border-radius: 5px;
            cursor: pointer;
        }

        button.btn-primario, input.btn-primario {
            background-color: #007bff;
            color: #ffffff;
        }

        button.btn-error, input.btn-error {
            background-color: #dc3545;
            color: #ffffff;
        }

        td.td-acciones {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
            gap: 16px;
        }

        @media (min-width: 1224px) {
            .contenedor {
                max-width: 1200px;
            }
        }

        table {
            border-collapse: collapse;
        }

        tr.table-header {
            border-bottom: 1px solid black;
        }

        td.td-acciones > a.btn-editar {
            background-color: #f0ab00;
            color: #61332f;
            font-size: 18px;
            font-weight: 400;
            text-align: center;
            outline: none;
            border: none;
            padding: 0.6rem 1.4rem;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn_crear{
            margin-top: 10px;
            margin-left: 80vw;
            margin-right: 5px;
        }
        .header{
            display: flex;
            justify-content:flex-start;
            flex-wrap: wrap;
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
        .div_buton_reg {
            align-items: center;
            display: flex;
            margin-left: 30px;
        }

        .but_Editar {
            background-color: #fac9c5;
            color: black;
            font-size: 18px;
            font-weight: 400;
            text-align: center;
            outline: none;
            border: none;
            padding: 0.6rem 1.4rem;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

    </style>
    <%
        List<Autor> datos = (List<Autor>) request.getAttribute("autores");
        if (datos == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    %>
    <body class="body" bgcolor="#e0766e">
        <div class="header">
            <div class="div_buton_reg">
                <a href="menu.jsp" class="but_com">Regresar</a>
            </div>
            <div class="title">
                <h1>Autor</h1>
            </div>
        </div>


        <div class="fondo">
            <div class="nuevo">
                <form method="GET" action="crearAutor.jsp">
                    <input type="hidden" name="permiso" value="true"/>
                    <input class="btn btn_crear" type="submit" value="Nuevo"/>
                </form>
            </div>
            <table>
                <tr class="table-header">
                    <th>ID (seudónimo)</th>
                    <th>Nombre</th>

                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>

                <tr>
                    <% for (Autor autor : datos) {%>
                    <td class="celda">
                      <%= autor.getId_Autor()%></td>
                    <td class="celda">
                      <%= autor.getNombre()%></td>
                    <td class="celda">
                        <!-- TODO: Usar ACTUALIZAR para esto. -->                       
                        <form method="GET" action="AutorServlet">
                            <input type="hidden" name="operacion" value="PREACTUALIZAR" />
                            <input type="hidden" name="id_autor" value="<%= autor.getId_Autor()%>"/>
                            <input type="hidden" name="nombre" value="<%= autor.getNombre()%>"/>
                            <input class="btn but_Editar" type="submit" value="Editar"/>
                        </form>     
                    </td>

                    <td class="celda">
                        <!-- TODO: Usar DELETE para esto. -->
                        <form method="GET" action="AutorServlet">
                            <input type="hidden" name="operacion" value="ELIMINAR" />
                            <input type="hidden" name="id_autor" value="<%= autor.getId_Autor()%>"/>
                            <input class="btn btn-error" type="submit" value="Eliminar"/>
                        </form>
                    </td>
                </tr>
                <%}%>
        </div>
    </body>
</html>