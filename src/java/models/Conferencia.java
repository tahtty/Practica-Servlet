/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Conferencia {
    public Connection conn=null;
    public Statement st=null;
    public PreparedStatement ps=null;
    public ResultSet rs=null;
    private int  id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    

    public Conferencia() {
      SimpleDateFormat par =new SimpleDateFormat("dd-MM-yy");
        this.id =0;
        this.nombre =" ";
        try {
            this.fecha =par.parse("15-01-2017");
        } catch (ParseException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.descripcion =" ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getFechaS(){
       return fecha.toString();
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAgregar() {
        return descripcion;
    }

    public void setAgregar(String agregar) {
        this.descripcion = agregar;
    }

    public Conferencia(int id, String nombre, Date fecha, String agregar) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = agregar;
    }
    
    public static ArrayList<Conferencia> getConferencia(){
        ArrayList<Conferencia> lista = new ArrayList();
        try {
            DataSource base= getBase();
            Connection con=base.getConnection();
            Statement sta=con.createStatement();
            ResultSet rsa=sta.executeQuery("select * from conferencia");
            while(rsa.next()){
            lista.add(new Conferencia(rsa.getInt(1),rsa.getString(2),rsa.getDate(3),rsa.getString(4)));
            }   
            con.close();
            return lista; 
        } catch (SQLException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (NamingException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
    }
    /*
    public ArrayList<Conferencia> getConferencia(){
        ArrayList<Conferencia> lista = new ArrayList();
        try {
            conn=Conexion.obtener();
            st=conn.createStatement();
            rs=st.executeQuery("select * from conferencia");
            while(rs.next()){
            lista.add(new Conferencia(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4)));
            }
            return lista;
            
        } catch (SQLException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
   */
        
    public static void setConferencia(Conferencia conf){
//        de la base
    }
    
    public static boolean deleteConferencia(String id){
        
        return false;
    }
    
    public boolean eliminar(String id){
        try {
            conn=Conexion.obtener();
            st=conn.createStatement();
            st.executeUpdate("delete from conferencia where idConferencia="+id);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conferencia.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
        return false;
    }

    private static DataSource getBase() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/base");
    }
    
    
}
