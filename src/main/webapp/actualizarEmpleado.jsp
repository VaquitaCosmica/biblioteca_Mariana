
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
        <title>Actualizar Empleado</title>
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
        Empleado empleado = new Empleado();
        empleado.setUser(request.getParameter("user"));
        empleado.setTelefono(request.getParameter("telefono"));
        empleado.setNumero(Integer.parseInt(request.getParameter("numero")));
        empleado.setNombre(request.getParameter("nombre"));
        empleado.setID_empleado(Integer.parseInt(request.getParameter("ID_empleado")));
        empleado.setF_nacimiento(Date.valueOf(request.getParameter("f_nacimiento")));
        empleado.setColonia(request.getParameter("colonia"));
        empleado.setCiudad_id(request.getParameter("ciudad_id"));
        empleado.setCalle(request.getParameter("calle"));
        empleado.setApe_pat(request.getParameter("ape_pat"));
        empleado.setApe_mat(request.getParameter("ape_mat"));

        if (request.getParameter("user") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        List<Ciudad> ciudades = (List<Ciudad>) request.getAttribute("ciudades");
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        System.out.println("Ciudad " + ciudades.get(0).getNombre());
    %>
    <body method="GET" action="EmpleadoServlet" class="body" bgcolor="#e0766e">
        <form class="div_reg">
            <h1 class="login_title">Actualizar Empleado</h1>

            <h3 class="login_text">ID</h3>
            <input type="text" name="ID_empleado" class="entrada" value="<%= empleado.getID_empleado()%>" placeholder="ID del empleado">

            <h3 class="login_text">Nombre</h3>
            <input type="text" name="nombre" class="entrada" value="<%= empleado.getNombre()%>" placeholder="Juan">

            <h3 class="login_text">Apellido paterno</h3>
            <input type="text" name="ape_pat" class="entrada" value="<%= empleado.getApe_pat()%>" placeholder="Perez">

            <h3 class="login_text">Apellido materno</h3>
            <input type="text" name="ape_mat" class="entrada" value="<%= empleado.getApe_mat()%>" placeholder="Lopez">

            <h3 class="login_text">Nacimiento</h3>
            <input type="date" name="f_nacimiento" class="entrada" value="<%= empleado.getF_nacimiento()%>">

            <h3 class="login_text">Calle</h3>
            <input type="text" name="calle" class="entrada" value="<%= empleado.getCalle()%>" placeholder="AV. de las letras">

            <h3 class="login_text">Numero</h3>
            <input type="number" name="numero" class="entrada" value="<%= empleado.getNumero()%>" placeholder="60">

            <h3 class="login_text">Colonia</h3>
            <input type="text" name="colonia" class="entrada" value="<%= empleado.getColonia()%>" placeholder="Col. literatura">

            <h3 class="login_text">Ciudad</h3>
            <select type="text" name="ciudad_id" class="entrada" value="<%= empleado.getCiudad_id()%>">
                <option value="<%=empleado.getCiudad_id()%>" selected ><%=empleado.getCiudad_id()%></option>
                <% for (int i = 0; i < ciudades.size(); i++) {%>
                <option value="<%= ciudades.get(i).getCiudad_ID()%>" > <%out.print(ciudades.get(i).getNombre());%></option>
                <%}%>
            </select>

            <h3 class="login_text">Telefono</h3>
            <input type="number" name="telefono" class="entrada" value="<%= empleado.getTelefono()%>" placeholder="">

            <h3 class="login_text">Usuario</h3>
            <select type="text" name="user" class="entrada" value="<%= empleado.getUser()%>">
                <option value="<%=empleado.getUser()%>" selected ><%=empleado.getUser()%></option>
                <% for (int i = 0; i < usuarios.size(); i++) {%>
                <option value="<%= usuarios.get(i).getUser()%>" > <%out.print(usuarios.get(i).getUser());%></option>
                <%}%>
            </select>
            <input type="hidden" name="antiguoId" value="<%=empleado.getID_empleado()%>" >
            <input type="hidden" name="operacion" value="ACTUALIZAR" />
            <input class="but_env" type="submit" value="Actualizar"/>    

        </form>
        <div class="div_buton_com">
            <a href="menu.jsp" class="but_com">Cancelar</a>
        </div>
    </body>

</html>
