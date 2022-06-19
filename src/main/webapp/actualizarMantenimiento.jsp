
<%@page import="modelos.Mobiliario"%>
<%@page import="modelos.Cuida"%>
<%@page import="modelos.Cliente"%>
<%@page import="modelos.Empleado"%>
<%@page import="java.sql.Date"%>
<%@page import="modelos.Alquila"%>
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
        <title>Actualizar mantenimiento</title>
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
        if (request.getParameter("id_manto") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        Cuida cuidado = new Cuida();
        cuidado.setF_manto(Date.valueOf(request.getParameter("f_manto")));
        cuidado.setID_empleado(Integer.parseInt(request.getParameter("ID_empleado")));
        cuidado.setId_manto(request.getParameter("id_manto"));
        cuidado.setId_mobiliario(request.getParameter("id_mobiliario"));

        List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
        List<Mobiliario> mobiliario = (List<Mobiliario>) request.getAttribute("mobiliario");
        System.out.println("ESTOY EN actualixarmantenimiento.jsp, empleado: " + empleados.get(0).getNombre());

    %>
    <body  class="body" bgcolor="#e0766e">
        <form method="GET" action="MantenimientoServlet"  class="div_reg">
            <h1 class="login_title">Editar Mantenimiento</h1>
            <h3 class="login_text">ID</h3>
            <input type="text" name="id_manto" class="entrada" value="<%= cuidado.getId_manto()%>" placeholder="1706220829">

            <h3 class="login_text">Fecha mantenimiento</h3>
            <input type="date" name="f_manto" class="entrada" value="<%= cuidado.getF_manto()%>">

            <h3 class="login_text">Empleado</h3>
            <select type="text" name="ID_empleado" class="entrada" value="" >
                <option value="<%= cuidado.getID_empleado()%>" selected ><%= cuidado.getID_empleado()%></option>
                <% for (int i = 0; i < empleados.size(); i++) {%>
                <option value="<%=empleados.get(i).getID_empleado()%>" > <%out.print(empleados.get(i).getNombre());%></option>
                <%}%>
            </select>
            <h3 class="login_text">Mobiliario</h3>
            <select type="text" name="id_mobiliario" class="entrada" value="" >
                <option value="<%= cuidado.getId_mobiliario()%>" selected ><%= cuidado.getId_mobiliario()%></option>
                <% for (int i = 0; i < mobiliario.size(); i++) {%>
                <option value="<%=mobiliario.get(i).getId_mobiliario()%>" > <%out.print(mobiliario.get(i).getNombre());%></option>
                <%}%>
            </select>
            <input type="hidden" name="antiguoId" value="<%=cuidado.getId_manto()%>">
            <input type="hidden" name="operacion" value="ACTUALIZAR" />
            <input class="but_env" type="submit" value="Actualizar"/>          
        </form>
        <div class="div_buton_com">
            <a href="menu.jsp" class="but_com">Cancelar</a>
        </div>
    </body>

</html>