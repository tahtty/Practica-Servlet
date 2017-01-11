/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author CltControl
 */
public class Asistente {
    private int id;
    private String cedula;
    private String nombre;
    private Conferencia conferencia;
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

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Asistente(int id, String cedula, String nombre, Conferencia conferencia, String correo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.conferencia = conferencia;
        this.correo = correo;
    }
    
    
}
