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
public class Proveedores {

    private int idProveedores;
    private String ruc;
    private String razonSocial;
    private String tipoActividad;
    private String nombre_representante_legal;
    private String apellidos_representante_legal;
    private String telefono;
    private String correo;
    private String direccion;
    private Date fechaVencimientoDeuda;
    private Date fecha_registro;
    private Date fechaActualizacion;

    public Proveedores() {
    }

    public Proveedores(int idProveedores, String ruc, String razonSocial, String tipoActividad, String nombre_representante_legal, String apellidos_representante_legal, String telefono, String correo, String direccion, Date fechaVencimientoDeuda, Date fecha_registro, Date fechaActualizacion) {
        this.idProveedores = idProveedores;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.tipoActividad = tipoActividad;
        this.nombre_representante_legal = nombre_representante_legal;
        this.apellidos_representante_legal = apellidos_representante_legal;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaVencimientoDeuda = fechaVencimientoDeuda;
        this.fecha_registro = fecha_registro;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getNombre_representante_legal() {
        return nombre_representante_legal;
    }

    public void setNombre_representante_legal(String nombre_representante_legal) {
        this.nombre_representante_legal = nombre_representante_legal;
    }

    public String getApellidos_representante_legal() {
        return apellidos_representante_legal;
    }

    public void setApellidos_representante_legal(String apellidos_representante_legal) {
        this.apellidos_representante_legal = apellidos_representante_legal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaVencimientoDeuda() {
        return fechaVencimientoDeuda;
    }

    public void setFechaVencimientoDeuda(Date fechaVencimientoDeuda) {
        this.fechaVencimientoDeuda = fechaVencimientoDeuda;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "idProveedores=" + idProveedores + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", tipoActividad=" + tipoActividad + ", nombre_representante_legal=" + nombre_representante_legal + ", apellidos_representante_legal=" + apellidos_representante_legal + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", fechaVencimientoDeuda=" + fechaVencimientoDeuda + ", fecha_registro=" + fecha_registro + ", fechaActualizacion=" + fechaActualizacion + '}';
    }

}
