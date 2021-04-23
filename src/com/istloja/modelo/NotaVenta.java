
package com.istloja.modelo;

import java.util.Date;

public class NotaVenta {
    private int id_nota_venta;
    private String numero_nota_venta;
    private int persona_id_persona;
    private Date fecha_venta;
    private double sub_total;
    private double iva;
    private double total_venta;
    private int tipo_pago;

    public NotaVenta(int id_nota_venta, String numero_nota_venta, int persona_id_persona, Date fecha_venta, double sub_total, double iva, double total_venta, int tipo_pago) {
        this.id_nota_venta = id_nota_venta;
        this.numero_nota_venta = numero_nota_venta;
        this.persona_id_persona = persona_id_persona;
        this.fecha_venta = fecha_venta;
        this.sub_total = sub_total;
        this.iva = iva;
        this.total_venta = total_venta;
        this.tipo_pago = tipo_pago;
    }

    public NotaVenta() {
       
    }

    public int getId_nota_venta() {
        return id_nota_venta;
    }

    public void setId_nota_venta(int id_nota_venta) {
        this.id_nota_venta = id_nota_venta;
    }

    public String getNumero_nota_venta() {
        return numero_nota_venta;
    }

    public void setNumero_nota_venta(String numero_nota_venta) {
        this.numero_nota_venta = numero_nota_venta;
    }

    public int getPersona_id_persona() {
        return persona_id_persona;
    }

    public void setPersona_id_persona(int persona_id_persona) {
        this.persona_id_persona = persona_id_persona;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public int getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(int tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    @Override
    public String toString() {
        return "NotaVenta{" + "id_nota_venta=" + id_nota_venta + ", numero_nota_venta=" + numero_nota_venta + ", persona_id_persona=" + persona_id_persona + ", fecha_venta=" + fecha_venta + ", sub_total=" + sub_total + ", iva=" + iva + ", total_venta=" + total_venta + ", tipo_pago=" + tipo_pago + '}';
    }
    
    }
