/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelo;

import java.util.Date;

/**
 *
 * @author johnp
 */
public class Persona {

    private int id_persona;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String telefono;
    private Date fecha_registro;
    private int genero;

    public Persona(int id_persona, String cedula, String nombre, String apellido, String direccion, String correo, String telefono, Date fecha_registro, int genero) {
        this.id_persona = id_persona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
        this.genero = genero;
    }

    public Persona() {
    }

    public Persona(int idPersona) {
        this.id_persona = idPersona;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", fecha_registro=" + fecha_registro + ", genero=" + genero + '}';
    }

}
