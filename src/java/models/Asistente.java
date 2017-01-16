/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CltControl
 */
public class Asistente {
    public Connection conn=null;
    public Statement st=null;
    public PreparedStatement ps=null;
    public ResultSet rs=null;
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private int conferencia;
    private String correo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getConferencia() {
        return conferencia;
    }

    public void setConferencia(int conferencia) {
        this.conferencia = conferencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Asistente(int id, String cedula, String nombre,String apellido, int conferencia, String correo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.conferencia = conferencia;
        this.correo = correo;
    }
    public Asistente(){
        
    }
    
    public ArrayList<Asistente> getAsistente(){
        ArrayList<Asistente> lista = new ArrayList();
        try {
            conn=Conexion.obtener();
            st=conn.createStatement();
            rs=st.executeQuery("select * from asistente");
            while(rs.next()){
                
            lista.add(new Asistente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
            }
            return lista;
            
        } catch (SQLException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
}
