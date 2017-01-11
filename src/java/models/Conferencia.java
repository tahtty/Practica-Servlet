/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CltControl
 */
public class Conferencia {
    private int id;
    private String nombre;
    private Date fecha;
    private String agregar;

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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAgregar() {
        return agregar;
    }

    public void setAgregar(String agregar) {
        this.agregar = agregar;
    }

    public Conferencia(int id, String nombre, Date fecha, String agregar) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.agregar = agregar;
    }
    
    public static List<Conferencia> getConferencia() {
        ArrayList<Conferencia> lista = new ArrayList<>();
//        lista.add(new Conferencia("Marco Calderon", "mcalderon@example.com", "Desarrollador"));
//        lista.add(new Conferencia("Jorge Forlan", "jforlan@example.com", "Arquitecto"));
//        lista.add(new Conferencia("Luis Perez", "lperez@example.com", "Contador"));
        return lista;
    }
    
    public static void setConferencia(){
//        de la base
    }
    
    
}
