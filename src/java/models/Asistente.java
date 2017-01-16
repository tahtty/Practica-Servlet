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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author CltControl
 */
public class Asistente {
    public static Connection conn=null;
    public static Statement st=null;
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
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
    
    public static String insertAsistente(String cedula,String nombre, String apellido,int conferencia, String correo){
        try {
            DataSource base= getBase();
            Connection con=base.getConnection();
            
           PreparedStatement psa=con.prepareStatement("insert into conferencia (Nombre,Fecha,Descripcion) values(?,?,?,?,?)");
            psa.setString(1,cedula);
            psa.setString(2,nombre);
            psa.setString(3,apellido);
            psa.setInt(4,conferencia);
            psa.setString(5,correo);
            psa.executeUpdate();
            
            con.close();
            
            return "Ingreso exitoso";
            
        } catch (SQLException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (NamingException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Falló ingreso";
    }
    
    public static String deleteAsistente(int id){
        try {
            DataSource base= getBase();
            Connection con=base.getConnection();
            con=Conexion.obtener();
             Statement stp=con.createStatement();
            stp.executeUpdate("delete from asistentes where idConferencia="+id);
            
            return "Se ha eliminado correctamente";
  
        } catch (SQLException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (NamingException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Falló la eliminación";
    }
    
    public static ArrayList<Asistente> getAsistente(){
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
    
     private static DataSource getBase() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/base");
    }
    
    
}
