/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import com.istloja.modelo.Inventario;
import com.istloja.modelo.ProductoVenta;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JIMENEZ
 */
public class ModelTableVentas extends AbstractTableModel {
        //Arreglo con el nombre de las columnas
    public String[] m_colNames = {"CANTIDAD", "DESCRIPCION", "SUB TOTAL", "TOTAL"};

    public List<ProductoVenta> productoVenta;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionContable gestionContable;
    public ModelTableVentas(List<ProductoVenta> productosv,GestionContable gestionContable) {
        this.productoVenta = productosv;
        this.gestionContable = gestionContable;
    }

    @Override
    public int getRowCount() {
        return productoVenta.size();
    }

    @Override
    public int getColumnCount() {
       return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductoVenta p = productoVenta.get(rowIndex);
        switch (columnIndex){
            case 0:
                return p.getCantidad();
            case 1:
                return p.getDescripcion();
            case 2:
                return p.getSubTotal();
            case 3:
                return p.getTotal();
        }
        return new String();
    }
     @Override
     public String getColumnName(int column){
    return m_colNames[column];
}
     @Override
     public boolean isCellEditable(int rowIndex, int columnIndex){
        gestionContable.clickProductoVentas(productoVenta.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);
     }

    public List<ProductoVenta> getProductoVenta() {
        return productoVenta;
    }

    public void setProductoVenta(List<ProductoVenta> productoVenta) {
        this.productoVenta = productoVenta;
    }
     
}
