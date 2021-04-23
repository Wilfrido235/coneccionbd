
package com.istloja.modelo;

import java.util.Date;

public class Venta2 {
    private int cantidadProducto;
    private String descripcion;
    private double subTotal;
    private double total;

    public Venta2(int cantidadProducto, String descripcion, double subTotal, double total) {
        this.cantidadProducto = cantidadProducto;
        this.descripcion = descripcion;
        this.subTotal = subTotal;
        this.total = total;
    }

    
    public Venta2() {
        
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta2{" + "cantidadProducto=" + cantidadProducto + ", descripcion=" + descripcion + ", subTotal=" + subTotal + ", total=" + total + '}';
    }

}