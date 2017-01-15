<%@page import="java.util.List"%>
<%@page import="models.Conferencia"%>

<%-- 
    Document   : conferencia
    Created on : 11-ene-2017, 10:53:19
    Author     : CltControl
--%>

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
            <li class="active"><a href="#">Conferencias</a></li>
            <li><a href="#">Inicio</a></li>
            <li><a href="#">Asistentes</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#about"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div> 
    </nav>
    <div class="container usuarios">
      <h2>Conferencias a realizarse</h2>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalUsuarios">Registrar Nueva</button>
      <table id="tablaUsuarios" class="table table-bordered table-striped">
        <thead>
          <tr>
            <th>#</th>
            <th>Id</th>
            <th >Nombre</th>
            <th>Fecha</th>
            <th>Descripcion</th>
            <th>Editar</th>
            <th>Eliminar</th>
          </tr>
        </thead>
        <tbody>
          <%
              List<Conferencia> cop = (List<Conferencia>) request.getAttribute("listaConferencias");
              int cont = 0;
              for(Conferencia c: cop){
                
          %>
          <tr>
            <th scope="row"><%= cont %></th>
            <td><%=c.getId()%></td>
            <td><%=c.getNombre()%></td>
            <td><%=c.getFechaS()%></td>
            <td><%=c.getAgregar()%></td>
            <td><a href="#"data-toggle="modal" data-target="#modalUsuarios"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
            <td>
               <a class="eliminar "href="#"data-toggle="modal" data-target="#modalEliminar"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
            </td>
          </tr>
           <%
              cont++;
            }
          %>
        </tbody>
      </table>
    </div>
  
      <!-- Modal -->
  <div class="modal fade" id="modalEliminar" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
          <form action="Conferencias" method="post" name="formulario"> 
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Eliminar</h4>
            </div>
            <div class="modal-body">
              <p>Seguro que desea eliminar este registro?</p>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
               <button type="submit" class="btn btn-primary">Eliminar</button>
               <input type="hidden" name="opcion" value="2">
               <input type="hidden" class="form-control id" name="key" value="">
            </div>
        </form>
      </div>
    </div>
  </div>
  <!-- Modal Ingresar -->
    <div class="modal fade" id="modalUsuarios" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form action="Conferencias" method="post">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">Ingresar Conferencia</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                  <input type="text" class="form-control" id="inputNombre" name="nombre" placeholder="Nombre de la conferencia">
                </div>
                <div class="form-group">
                  <input type="date" class="form-control" id="inputFecha" name="fecha" placeholder="Fecha de la conferencia">
                </div>
                <div class="form-group">
                    <textarea class="form-control" rows="5" id="comment" name="descripcion" placeholder="Descripcion de la conferencia"></textarea>
                </div>
                <div class="form-group">
                <input type="hidden" class="form-control" id="id" name="id" value="">
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-primary">Ingresar</button>
              <input type="hidden"  name="opcion" value="1">
            </div>
          </form>
        </div>
      </div>
    </div>
      <script>
          $(document).ready(function(){
            $(".eliminar").click(function(ev) {
            columnas = $($(ev.target).parents("tr")[0]).children();
            $(".id").val($(columnas[1]).html());
                console.log($(columnas[1]).html());
            });
          });
      </script>
    </body>
   
</html>
