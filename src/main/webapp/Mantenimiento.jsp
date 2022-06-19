
<%@page import="modelos.Cuida"%>
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
        <title>Mantenimiento</title>
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
            margin-left: 7vw;
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
            margin-left: 7vw;
        }

        table {
            margin-top: 5px;
            table-layout: auto;
            width: 90%;
            border-collapse: collapse;
            margin-left: 5%;
        }

        th,td {
            padding: 25px;
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
        List<Cuida> mantenimientos = (List<Cuida>) request.getAttribute("mantenimientos");
        if (mantenimientos == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    %>
    <body class="body" bgcolor="#e0766e">
        <div class="header">
            <div class="div_buton_reg1">
                <a href="menu.jsp" class="but_com">Regresar</a>
            </div>
            <div class="title">
                <h1>Mantenimiento</h1>
            </div>
            <div class="div_buton_reg1">
                <form method="GET" action="MantenimientoServlet">
                    <input type="hidden" name="operacion" value="PRECREAR" />
                    <input class="but_com" type="submit" value="Nuevo"  href=""/>
                </form   
            </div>
        </div>
        <div class="fondo">
            <table>
                <tr class="table-header">
                    <th>ID</th>
                    <th>Fecha</th>
                    <th>Mobiliario</th>
                    <th>Empleado</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>

                <tr>
                    <% for (Cuida mantenimiento : mantenimientos) {%>
                    <td class="celda"> <%= mantenimiento.getId_manto()%>
                    </td>
                    <td class="celda"> <%= mantenimiento.getF_manto()%>
                    </td>
                    <td class="celda"><%= mantenimiento.getId_mobiliario()%> 
                    </td>
                    <td class="celda"> <%= mantenimiento.getID_empleado()%>
                    </td>

                    <td class="celda">                        
                        <!-- TODO: Usar ACTUALIZAR para esto. -->                       
                        <form method="GET" action="MantenimientoServlet">
                            <input type="hidden" name="operacion" value="PREACTUALIZAR" />
                            <input type="hidden" name="id_manto" value="<%=  mantenimiento.getId_manto()%>" />
                            <input type="hidden" name="f_manto" value="<%= mantenimiento.getF_manto()%>" />
                            <input type="hidden" name="id_mobiliario" value="<%= mantenimiento.getId_mobiliario()%>" />
                            <input type="hidden" name="ID_empleado" value="<%= mantenimiento.getID_empleado()%>" />
                            <input class="btn but_Editar" type="submit" value="Editar"/>
                        </form>
                    </td>
                    <td class="celda">

                        <form method="GET" action="MantenimientoServlet">
                            <input type="hidden" name="operacion" value="ELIMINAR" />
                            <input type="hidden" name="id_manto" value="<%= mantenimiento.getId_manto()%>" />
                            <input class="but_Eliminar" type="submit" value="Eliminar" />
                        </form>
                    </td>
                </tr>
                <%}%>
        </div>
    </body>
</html>
