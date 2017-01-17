<%-- 
    Document   : asistente
    Created on : Jan 15, 2017, 11:44:15 PM
    Author     : User
--%>

<%@page import="java.util.List"%>
<%@page import="models.Asistente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
         <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.css"/>
        <link rel="stylesheet" href="stylesheets/styles.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .id{
                display: none;
            }
            #registar a{
                color:white;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
     <nav class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Daw</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">Conferencias</a></li>
            <li><a href="#">Inicio</a></li>
            <li class="active"><a href="#">Asistentes</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#about"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div> 
    </nav>
    <div class="container usuarios">
      <h2>Asistentes a las conferencias</h2>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalAgregar" id="registar"><a href="#">Registrar Nuevo</a></button>
      <table id="tablaUsuarios" class="table table-bordered table-striped">
        <thead>
          <tr>
            <th>#</th>
            <th class="id">Id</th>
            <th>Cedula</th>
            <th >Nombre</th>
            <th>Apellido</th>
            <th>Conferencia</th>
            <th>Correo</th>
            <th>Editar</th>
            <th>Eliminar</th>
          </tr>
        </thead>
        <tbody>
          <!--<tr>
                Se llena con javascript 
          </tr>-->
        </tbody>
      </table>
    </div>
  
      <!-- Modal -->
  <div class="modal fade" id="modalAgregar" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
          <form action="Conferencia" method="post" name="formulario"> 
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Agregar Asistente</h4>
            </div>
            <div class="modal-body">
              <div class="form-group">
                  <select>
                   <!--
                    Aquí se debe llamar desde el JavaScript al Servlet AsistenteConferenciaServlet
                   -->
                  </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="inputCedula" name="cedula" placeholder="Cedula del asistente: ">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" id="inputNombre" name="nombre" placeholder="Nombre del asistente: ">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="inputApellido" name="apellido" placeholder="Apellido del asistente: ">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="inputCorreo" name="correo" placeholder="Correo del asistente: ">
                </div>
                <div class="form-group">
                <input type="hidden" class="form-control" id="id" name="id" value="">
                </div>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
               <button type="submit" class="btn btn-primary">Agregar</button>
               <input type="hidden" name="opcion" value="2">
            </div>
        </form>
      </div>
      
    </div>
  </div>
      
      <div class="modal fade" id="modalEliminar" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
          <form action="Conferencia" method="post" name="formulario"> 
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Eliminar</h4>
            </div>
            <div class="modal-body">
              <p>Seguro que desea eliminar este registro?</p>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
               <button type="submit" class="btn btn-primary borrar">Eliminar</button>
               <input type="hidden" name="opcion" value="2">
               <input type="hidden" class="form-control id" id="id" name="id" value="">
            </div>
        </form>
      </div>
      
    </div>
  </div>
      <script>
           $(document).ready(function(){
            //parte para eliminar
            $(eliminar).click(function(){
                    columnas = $($(event.target).parents("tr")[0]).children();
                    var id = $(columnas[0]).html();
                    $(".id").html(id);
                    data = {"id": id};   
                    $.ajax({  
                      type: "POST",  
                      url: "./BorrarAsistente",  
                      data: data,  
                      success: function(){
                          alert("Eliminado");
                          //funcion o parte donde se cargan los asistentes 
                      }                
                    });
            });
          });
      </script>
      <script src="Script/asistente.js"></script>
    </body>
</html>
