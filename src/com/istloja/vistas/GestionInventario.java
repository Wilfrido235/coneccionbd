/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.vistas;

import com.istloja.modelo.Inventario;
import com.istloja.utilidad.Utilidades;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author danielmora
 */
public class GestionInventario {

    private JTextField txtCodigo_proInventario;
    private JTextField txtDescripcionInventario;
    private JTextField txtcatidadInventario;
    private JTextField txtPrecios_compraInventario;
    private JTextField TextPrecio_compraConIva;
    private JTextField TextPrecio_mayorista;
    private JTextField TextPrecio_clienteFijo;
    private JTextField TextPrecio_clienteNormal;
    private JDateChooser jDateInventario;
    private Utilidades utilidades;
    private JFrame frameGestionContable;

    public GestionInventario(JTextField txtcodigoProductoInvntario, JTextField txtdescripcionInventario, JTextField txtcatidadInventario, JTextField txtprecioCompraInvntario_sinIva, JTextField txtprecioCompraInvntario_conIva, JTextField txtprecioMayoristaInventario, JTextField txtPrecioClienteFijo, JTextField txtPrecioClienteNormal, JDateChooser jDateInventario, Utilidades utilidades, JFrame frameGestionContable) {
        this.txtCodigo_proInventario = txtcodigoProductoInvntario;
        this.txtDescripcionInventario = txtdescripcionInventario;
        this.txtcatidadInventario = txtcatidadInventario;
        this.txtPrecios_compraInventario = txtprecioCompraInvntario_sinIva;
        this.TextPrecio_compraConIva = txtprecioCompraInvntario_conIva;
        this.TextPrecio_mayorista = txtprecioMayoristaInventario;
        this.TextPrecio_clienteFijo = txtPrecioClienteFijo;
        this.TextPrecio_clienteNormal = txtPrecioClienteNormal;
        this.jDateInventario = jDateInventario;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
    }

    public JTextField getTxtCodigo_proInventario() {
        return txtCodigo_proInventario;
    }

    public void setTxtCodigo_proInventario(JTextField txtCodigo_proInventario) {
        this.txtCodigo_proInventario = txtCodigo_proInventario;
    }

    public JTextField getTxtDescripcionInventario() {
        return txtDescripcionInventario;
    }

    public void setTxtDescripcionInventario(JTextField txtDescripcionInventario) {
        this.txtDescripcionInventario = txtDescripcionInventario;
    }

    public JTextField getTxtcatidadInventario() {
        return txtcatidadInventario;
    }

    public void setTxtcatidadInventario(JTextField txtcatidadInventario) {
        this.txtcatidadInventario = txtcatidadInventario;
    }

    public JTextField getTxtPrecios_compraInventario() {
        return txtPrecios_compraInventario;
    }

    public void setTxtPrecios_compraInventario(JTextField txtPrecios_compraInventario) {
        this.txtPrecios_compraInventario = txtPrecios_compraInventario;
    }

    public JTextField getTextPrecio_compraConIva() {
        return TextPrecio_compraConIva;
    }

    public void setTextPrecio_compraConIva(JTextField TextPrecio_compraConIva) {
        this.TextPrecio_compraConIva = TextPrecio_compraConIva;
    }

    public JTextField getTextPrecio_mayorista() {
        return TextPrecio_mayorista;
    }

    public void setTextPrecio_mayorista(JTextField TextPrecio_mayorista) {
        this.TextPrecio_mayorista = TextPrecio_mayorista;
    }

    public JTextField getTextPrecio_clienteFijo() {
        return TextPrecio_clienteFijo;
    }

    public void setTextPrecio_clienteFijo(JTextField TextPrecio_clienteFijo) {
        this.TextPrecio_clienteFijo = TextPrecio_clienteFijo;
    }

    public JTextField getTextPrecio_clienteNormal() {
        return TextPrecio_clienteNormal;
    }

    public void setTextPrecio_clienteNormal(JTextField TextPrecio_clienteNormal) {
        this.TextPrecio_clienteNormal = TextPrecio_clienteNormal;
    }

    public JDateChooser getjDateInventario() {
        return jDateInventario;
    }

    public void setjDateInventario(JDateChooser jDateInventario) {
        this.jDateInventario = jDateInventario;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public JFrame getFrameGestionContable() {
        return frameGestionContable;
    }

    public void setFrameGestionContable(JFrame frameGestionContable) {
        this.frameGestionContable = frameGestionContable;
    }

    public void limpiarInventario() {
        txtCodigo_proInventario.setText("");
        txtDescripcionInventario.setText("");
        txtcatidadInventario.setText("");
        txtPrecios_compraInventario.setText("");
        TextPrecio_compraConIva.setText("");
        TextPrecio_mayorista.setText("");
        TextPrecio_clienteFijo.setText("");
        TextPrecio_clienteNormal.setText("");
        jDateInventario.setCalendar(null);

    }

    public Inventario guardarEditarInventario(boolean isEditar) {

        if (txtCodigo_proInventario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo código no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCodigo_proInventario.requestFocus();
            return null;
        }
        if (txtDescripcionInventario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo descripción no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);

            txtDescripcionInventario.requestFocus();
            return null;
        }
        if (txtcatidadInventario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo cantidad no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcatidadInventario.requestFocus();
            return null;
        }
        if (txtPrecios_compraInventario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo precio cliente sin iva no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtPrecios_compraInventario.requestFocus();
            return null;
        }

        if (TextPrecio_compraConIva.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo precio cliente con iva no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            TextPrecio_compraConIva.requestFocus();
            return null;
        }
        if (TextPrecio_mayorista.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo precio venta Mayorista no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            TextPrecio_mayorista.requestFocus();
            return null;
        }
        if (TextPrecio_clienteFijo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo precio Cliente Fijo venta no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            TextPrecio_clienteFijo.requestFocus();
            return null;
        }
        if (TextPrecio_clienteNormal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Precio Cliente Normal no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            TextPrecio_clienteNormal.requestFocus();
            return null;
        }
        
        Inventario inventario = new Inventario();
        inventario.setCodigo_pro(txtCodigo_proInventario.getText());
        inventario.setDescripcion(txtDescripcionInventario.getText());
        inventario.setCan_productos(txtcatidadInventario.getText());
        inventario.setPrecio_compra_sin_iva(Double.parseDouble(txtPrecios_compraInventario.getText()));
        inventario.setPrecio_compra_con_iva(Double.parseDouble(TextPrecio_compraConIva.getText()));
        inventario.setPrecio_mayorista(Double.parseDouble(TextPrecio_mayorista.getText()));
        inventario.setPrecio_cliente_fijo(Double.parseDouble(TextPrecio_clienteFijo.getText()));
        inventario.setPrecio_cliente_normal(Double.parseDouble(TextPrecio_clienteNormal.getText()));
        inventario.setFecha_caducidad(new Date());
        if (isEditar) {
            inventario.setFecha_actualizacion(new Date());
        }else{
            inventario.setFecha_registro(new Date());
        }
        return inventario;
    }

}
