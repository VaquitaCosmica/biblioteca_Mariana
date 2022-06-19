
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
        <title>Actualizar préstamos</title>
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

        if (request.getParameter("id_alquiler") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        Alquila prestamo = new Alquila();
        prestamo.setF_entrada(Date.valueOf(request.getParameter("f_entrada")));
        prestamo.setF_salida(Date.valueOf(request.getParameter("f_salida")));
        prestamo.setID_cliente(Integer.parseInt(request.getParameter("ID_cliente")));
        prestamo.setID_empleada(Integer.parseInt(request.getParameter("ID_empleado")));
        prestamo.setId_alquiler(request.getParameter("id_alquiler"));
        prestamo.setId_libro(request.getParameter("id_libro"));

        List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
        List<Libro> libros = (List<Libro>) request.getAttribute("libros");
        List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
    %>
    <body  class="body" bgcolor="#e0766e">
        <form method="GET" action="PrestamoServlet"  class="div_reg">
            <h1 class="login_title">Editar Préstamos</h1>
            <h3 class="login_text">ID</h3>
            <input type="text" name="id_alquiler" class="entrada" value="<%= prestamo.getId_alquiler()%>" placeholder="1706220829">

            <h3 class="login_text">Fecha prestamo</h3>
            <input type="date" name="f_salida" class="entrada" value="<%= prestamo.getF_entrada()%>">

            <h3 class="login_text">Fecha Devolucion</h3>
            <input type="date" name="f_entrada" class="entrada" value="<%= prestamo.getF_salida()%>">

            <h3 class="login_text">Empleado</h3>
            <select type="text" name="ID_empleado" class="entrada" value="<%= prestamo.getID_empleada()%>" >
                <option value="<%= prestamo.getID_empleada()%>" selected ><%= prestamo.getID_empleada()%></option>
                <% for (int i = 0; i < empleados.size(); i++) {%>
                <option value="<%=empleados.get(i).getID_empleado()%>" > <%out.print(empleados.get(i).getNombre());%></option>
                <%}%>
            </select>

            <h3 class="login_text">Libro</h3>
            <select type="text" name="id_libro" class="entrada" value="" >
                <option value="<%= prestamo.getId_libro()%>" selected ><%=prestamo.getId_libro()%></option>
                <% for (int i = 0; i < libros.size(); i++) {%>
                <option value="<%=libros.get(i).getId_libro()%>" > <%out.print(libros.get(i).getTitulo());%></option>
                <%}%>
            </select>
            <h3 class="login_text">Cliente</h3>
            <select type="text" name="ID_cliente" class="entrada" value="" >
                <option value="<%= prestamo.getID_cliente()%>" selected ><%=prestamo.getID_cliente()%></option>
                <% for (int i = 0; i < clientes.size(); i++) {%>
                <option value="<%=clientes.get(i).getID_cliente()%>" > <%out.print(clientes.get(i).getNombre());%></option>
                <%}%>
            </select>
            <input type="hidden" name="antiguoId" value="<%=prestamo.getId_alquiler()%>">
            <input type="hidden" name="operacion" value="ACTUALIZAR" />
            <input class="but_env" type="submit" value="Actualizar"/>          
        </form>
        <div class="div_buton_com">
            <a href="menu.jsp" class="but_com">Cancelar</a>
        </div>
    </body>

</html>