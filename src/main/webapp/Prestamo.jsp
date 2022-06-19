
<%@page import="modelos.Alquila"%>
<%@page import="java.util.List"%>
<%@page import="modelos.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Prestamos</title>
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
            margin-left: 9vw;
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
            table-layout: auto;
            width: 95%;
            border-collapse: collapse;
            margin-left: 2%;
        }

        th,
        td {
            padding: 20px;
        }

        .table-header {
            height: auto;
            width: 200px;
            align-items: center;
            align-content: center;
            text-align: center;
        }

        .celda {
            height: auto;
            width: 200px;
            align-items: center;
            align-content: center;
            text-align: center;
        }
    </style>
    <%
        List<Alquila> prestamos = (List<Alquila>) request.getAttribute("prestamos");
        if (prestamos == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    %>
    <body class="body" bgcolor="#e0766e">
        <div class="header">
            <div class="div_buton_reg1">
                <a href="menu.jsp" class="but_com">Regresar</a>
            </div>
            <div class="title">
                <h1>Prestamos</h1>
            </div>
            <div class="div_buton_reg1">
                <form method="GET" action="PrestamoServlet">
                    <input type="hidden" name="operacion" value="PRECREAR" />
                    <input class="but_com" type="submit" value="Nuevo"  href=""/>
                </form> 
            </div>           
        </div>
        <div class="fondo">

            <table>
                <tr class="table-header">
                    <th>ID</th>
                    <th>Fecha prestamo</th>
                    <th>Fecha devolución</th>
                    <th>Empleado</th>
                    <th>Libro</th>
                    <th>Cliente</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>

                <tr>
                    <% for (Alquila prestamo : prestamos) {%>
                    <td class="celda"> <%= prestamo.getId_alquiler()%>
                    </td>
                    <td class="celda"> <%= prestamo.getF_entrada()%>
                    </td>
                    <td class="celda"><%= prestamo.getF_salida()%> 
                    </td>
                    <td class="celda"> <%= prestamo.getID_empleada()%>
                    </td>
                    <td class="celda"> <%= prestamo.getId_libro()%>
                    </td>
                    <td class="celda"> <%= prestamo.getID_cliente()%>
                    </td>

                    <td class="celda">                        
                        <!-- TODO: Usar ACTUALIZAR para esto. -->                       
                        <form method="GET" action="PrestamoServlet">
                            <input type="hidden" name="operacion" value="PREACTUALIZAR" />
                            <input type="hidden" name="id_libro" value="<%= prestamo.getId_libro()%>" />
                            <input type="hidden" name="f_entrada" value="<%= prestamo.getF_entrada()%>" />
                            <input type="hidden" name="f_salida" value="<%= prestamo.getF_salida()%>" />
                            <input type="hidden" name="ID_cliente" value="<%= prestamo.getID_cliente()%>" />
                            <input type="hidden" name="ID_empleado" value="<%= prestamo.getID_empleada()%>" />
                            <input type="hidden" name="id_alquiler" value="<%= prestamo.getId_alquiler()%>" />
                            <input type="hidden" name="id_libro" value="<%= prestamo.getId_libro()%>" />

                            <input class="btn but_Editar" type="submit" value="Editar"/>
                        </form>
                    </td>
                    <td class="celda">

                        <form method="GET" action="PrestamoServlet">
                            <input type="hidden" name="operacion" value="ELIMINAR" />
                            <input type="hidden" name="id_alquiler" value="<%= prestamo.getId_alquiler()%>" />
                            <input class="but_Eliminar" type="submit" value="Eliminar" />
                        </form>
                    </td>
                </tr>
                <%}%>
        </div>
    </body>
</html>
