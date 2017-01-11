<%-- 
    Document   : home
    Created on : 11-ene-2017, 10:36:46
    Author     : CltControl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .content{
               background-color: lightgray;
               width: 25em; 
               height: 10rem;
            }
            ul{
                list-style: none;
                margin: 0px;
                padding: 0px;
                color: blue;
            }
            li{
                display: inline;
            }
            body {
                padding: 5rem;
                
            }
        </style>
    </head>
    <body>
        <ul>
            <li><a>Inicio |</a></li>
            <li><a>Conferencia |</a></li>
            <li><a>Asistentes</a></li>
        </ul>
        <div class="content">
        <p><strong>Bienvenido!</strong> El sistema<strong>ESPOL Conferencias</strong> le va a permitir gestionar
        todos los eventos realizados en la institucion
        </p>
        </div>
    </body>
</html>
