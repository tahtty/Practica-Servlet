function cargarAsistentes() {
    url="Asistentes"
    $.getJSON(url,function(resp){        
        resp.forEach(function (elem, i){
            console.log(elem);
            $("#tablaUsuarios tbody").append($("<tr>")
                    .append($("<td>").text(i+1))
                    .append($("<td>", {"class":"id"}).text(elem.id))
                    .append($("<td>").text(elem.cedula))
                    .append($("<td>").text(elem.nombre))
                    .append($("<td>").text(elem.apellido))
                    .append($("<td>").text(elem.conferencia))
                    .append($("<td>").text(elem.correo))
                    .append($("<td>")
                        .append($("<a>",{"href":"#", "data-toggle":"modal", "data-target":"#modalAgregar"})
                            .append($("<span>",{"class":"glyphicon glyphicon-edit", "aria-hidden":"true"}))))
                    .append($("<td>")
                        .append($("<a>",{"class":"eliminar", "href":"#", "data-toggle":"modal", "data-target":"#modalEliminar"})
                            .append($("<span>",{"class":"glyphicon glyphicon-remove", "aria-hidden":"true"})))));                  
        });
    });
    $(".eliminar").click(function(ev) {
            //AQUI va la funcion para elimiar
                        
    });
}


$(document).ready(function(){
    cargarAsistentes();
    
});
/*<a href="#"data-toggle="modal" data-target="#modalUsuarios"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
<a class="eliminar "href="#"data-toggle="modal" data-target="#modalEliminar"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>*/