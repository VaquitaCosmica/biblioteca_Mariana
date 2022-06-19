
<%@page import="modelos.Desempleado"%>
<%@page import="modelos.Empleado"%>
<%@page import="modelos.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Desempleados</title>
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

        .title {
            height: 10vh;
            margin-top: 10px;
            margin-left: 28vw;
            align-items: center;
            text-align: center;
            font-size: 2.5rem;
            color: azure;
        }

        .fondo {
            background-color: azure;
            min-height: 80vh;
            margin: 5vh;
            margin-top: 3vh;
            border-radius: 20px;
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

        .but_Eliminar {
            background-color: red;
            color: azure;
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

        .btn_crear {
            margin-top: 0px;
            margin-left: 80vw;
            margin-right: 5px;
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

        .header {
            display: flex;
            justify-content: flex-start;
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

        .div_buton_reg1 {
            align-items: flex-end;
            display: flex;
            margin-left: 13vw;
        }

        table {
            margin-top: 5px;
            max-width: 95vw;
            table-layout: fixed;
            width: 95%;
            border-collapse: collapse;
            margin-left: 0;
            font-size: 1rem;
        }

        th,
        td {
            padding: 20px;
        }

        .table-header {
            height: auto;
            width: 180px;
            align-items: center;
            align-content: center;
            text-align: center;
            font-size: 1rem;
        }

        .celda {
            height: auto;
            width: 180px;
            align-items: center;
            align-content: center;
            text-align: center;
            font-size: 1rem;
        }
    </style>
    <%
        List<Desempleado> datos = (List<Desempleado>) request.getAttribute("desempleados");
        if (datos == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        System.out.println(datos.get(0).getUser());
    %>
    <body class="body" bgcolor="#e0766e">
        <div class="header">
            <div class="div_buton_reg">
                <a href="menu.jsp" class="but_com">Regresar</a>
            </div>
            <div class="title">
                <h1>Desempleado</h1>
            </div>
        </div>
        <div class="fondo">

            <table>
                <tr class="table-header">
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido paterno</th>
                    <th>Apellido materno</th>
                    <th>Nacimiento</th>
                    <th>Calle</th>
                    <th>Numero</th>
                    <th>Colonia</th>
                    <th>Telefono</th>
                    <th>Ciudad</th>
                    <th>Usuario</th>
                </tr>

                <tr>
                    <% for (Desempleado desempleado : datos) {%>
                    <td class="celda">
                        <%= desempleado.getID_empleado()%>
                    </td>
                    <td class="celda">
                        <%= desempleado.getNombre()%>
                    </td>
                    <td class="celda">          
                        <%= desempleado.getApe_pat()%>
                        </a>
                    </td>
                    <td class="celda">
                        <%= desempleado.getApe_mat()%>
                    </td>
                    <td class="celda">
                        <%= desempleado.getF_nacimiento()%>
                        </a>
                    </td>
                    <td class="celda">
                        <%= desempleado.getCalle()%>
                    </td>
                    <td class="celda">
                        <%= desempleado.getNumero()%>
                    </td>
                    <td class="celda">
                        <%= desempleado.getColonia()%>
                    </td>
                    <td class="celda">
                        <%= desempleado.getTelefono()%>
                    </td>
                    <td class="celda">
                        <%= desempleado.getCiudad_id()%>
                    </td>
                    <td class="celda">
                        <%= desempleado.getUser()%>
                    </td>     
                </tr>
                <%}%>
        </div>
    </body>

</html>
