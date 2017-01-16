/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Asistente;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author User
 */
@WebServlet(name = "InsertarAsistente", urlPatterns = {"/InsertarAsistente"})
public class InsertarAsistente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ArrayList<Asistente> asistentes = new ArrayList<>();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int conferencia =parseInt(request.getParameter("conferencia"));
        String correo = request.getParameter("correo");
        String json = new Gson().toJson("{resultado: "+Asistente.insertAsistente(cedula,nombre,apellido,conferencia,correo)+"}");
        response.setContentType("aplication/json");
        response.getWriter().write(json);*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
                String codTabla = "";
                
		// Obtengo los datos de la peticion
		String cedula = request.getParameter("cedula");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                //int conferencia =parseInt(request.getParameter("conferencia"));
                String correo = request.getParameter("correo");
                int id = 1;
                int conf = 2;
                String json = new Gson().toJson("{resultado: "+Asistente.insertAsistente(cedula,nombre,apellido,conf,correo)+"}");
                response.setContentType("aplication/json");
                response.getWriter().write(json);
                

		// Compruebo que los campos del formulario tienen datos para añadir a la tabla
		if (!cedula.equals("") && !nombre.equals("") && !apellido.equals("") && !correo.equals("")) {
			// Creo el objeto persona y lo añado al arrayList
			Asistente asistente = new Asistente(id, cedula, nombre, apellido, conf, correo);
			asistentes.add(asistente);
		}
                
                
		for(int i=0; i<asistentes.size(); i++){
                        
			Asistente asistente = asistentes.get(i);
			out.println("<tr>");
                        codTabla = codTabla + "<th>"+asistente.getId()+"</th>";
                        codTabla = codTabla + "<td>"+asistente.getCedula()+"</td>";
			codTabla = codTabla + "<td>"+asistente.getNombre()+"</td>";			
			codTabla = codTabla + "<td>mundo</td>";
                        codTabla = codTabla + "<td>"+asistente.getConferencia()+"</td>";
			codTabla = codTabla + "<td>"+asistente.getCorreo()+"</td>";
                        codTabla = codTabla + "<td><a href=\"#\"data-toggle=\"modal\" data-target=\"#modalUsuarios\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>";
			codTabla = codTabla + "<td><a class=\"eliminar \"href=\"#\"data-toggle=\"modal\" data-target=\"#modalEliminar\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>";
                        codTabla = codTabla + "</tr>";
		}
                System.out.println(codTabla);
                response.setContentType("text/plain");
                response.getWriter().write(codTabla);
		

	
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}