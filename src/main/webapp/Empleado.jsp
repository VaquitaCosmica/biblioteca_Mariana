
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
        <title>Empleados</title>
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
            margin-left: 11vw;
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
        
        .div_buton_reg1 {
            align-items: flex-end;
            display: flex;
            margin-left: 13vw;
        }
    </style>
    <%
        List<Empleado> datos = (List<Empleado>) request.getAttribute("empleados");
        if (datos == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        System.out.println(datos.get(0).getUser());
    %>
    <body class="body" bgcolor="#e0766e">
        <div class="header">
            <div class="div_buton_reg1">
                <a href="menu.jsp" class="but_com">Regresar</a>
            </div>
            <div class="title">
                <h1>Empleado</h1>
            </div>
            <div class="div_buton_reg1">
                <form method="GET" action="EmpleadoServlet">
                    <input type="hidden" name="operacion" value="PRECREAR" />
                    <input class="but_com" type="submit" value="Nuevo"  href=""/>
                </form
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
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>

                <tr>
                    <% for (Empleado empleado : datos) {%>
                    <td class="celda">
                        <%= empleado.getID_empleado()%>
                    </td>
                    <td class="celda">
                        <%= empleado.getNombre()%>
                    </td>
                    <td class="celda">          
                        <%= empleado.getApe_pat()%>
                        </a>
                    </td>
                    <td class="celda">
                        <%= empleado.getApe_mat()%>
                    </td>
                    <td class="celda">
                        <%= empleado.getF_nacimiento()%>
                        </a>
                    </td>
                    <td class="celda">
                        <%= empleado.getCalle()%>
                    </td>
                    <td class="celda">
                        <%= empleado.getNumero()%>
                    </td>
                    <td class="celda">
                        <%= empleado.getColonia()%>
                    </td>
                    <td class="celda">
                        <%= empleado.getTelefono()%>
                    </td>
                    <td class="celda">
                        <%= empleado.getCiudad_id()%>
                    </td>
                    <td class="celda">
                        <%= empleado.getUser()%>
                    </td>                    
                    <td class="celda">                        
                        <!-- TODO: Usar ACTUALIZAR para esto. -->                       
                        <form method="GET" action="EmpleadoServlet">
                            <input type="hidden" name="operacion" value="PREACTUALIZAR" />
                            <input type="hidden" name="ID_empleado" value="<%= empleado.getID_empleado()%>" />
                            <input type="hidden" name="nombre" value="<%= empleado.getNombre()%>" />
                            <input type="hidden" name="ape_pat" value="<%= empleado.getApe_pat()%>" />
                            <input type="hidden" name="ape_mat" value="<%= empleado.getApe_mat()%>" />
                            <input type="hidden" name="f_nacimiento" value="<%= empleado.getF_nacimiento()%>" />
                            <input type="hidden" name="calle" value="<%= empleado.getCalle()%>" />
                            <input type="hidden" name="numero" value="<%= empleado.getNumero()%>" />
                            <input type="hidden" name="colonia" value="<%= empleado.getColonia()%>" />
                            <input type="hidden" name="telefono" value="<%= empleado.getTelefono()%>" />
                            <input type="hidden" name="ciudad_id" value="<%= empleado.getCiudad_id()%>" />
                            <input type="hidden" name="user" value="<%= empleado.getUser()%>" />
                            <input class="btn but_Editar" type="submit" value="Editar"/>
                        </form>
                    </td>
                    <td class="celda">
                        <form method="GET" action="EmpleadoServlet">
                            <input type="hidden" name="operacion" value="ELIMINAR" />
                            <input type="hidden" name="id" value="<%= empleado.getID_empleado()%>" />
                            <input class="but_Eliminar" type="submit" value="Despedir" />
                        </form>
                    </td>
                </tr>
                <%}%>
        </div>
    </body>

</html>
