<%-- 
    Document   : prueba
    Created on : 13/06/2022, 10:26:44 PM
    Author     : MARIANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca</title>

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
    
    .bib_mar {
        color: azure;
        margin-top: 10vh;
        text-align: center;
        font-weight: 800;
        font-size: 4rem;
    }
    
    .slogan {
        color: azure;
        margin-top: 20px;
        text-align: center;
        font-weight: 300;
        font-size: 2rem;
    }
    
    .div_buton_com {
        align-items: center;
        display: flex;
    }
    
    .img_index {
        width: 30vw;
        height: auto;
        margin-left: 35vw;
    }
    
    .but_com {
        color: azure;
        text-decoration: none;
        margin-top: vh;
        margin-left: 42vw;
        text-align: center;
        padding: 15px 60px;
        background-color: #61332f;
        border-radius: 25px;
        font-size: 2rem;
    }
</style>

<body class="body" bgcolor="#e0766e">
    <h1 class="bib_mar">BIBLIOTECA MARIANITA</h1>
    <H3 class="slogan">Todo esto sucedió, más o menos así...</H3>
    <img src="Diseño sin título.png" alt="" class="img_index">
    <div class="div_buton_com">
        <a href="login.jsp" class="but_com">Comienza</a>
    </div>
</body>

</html>
