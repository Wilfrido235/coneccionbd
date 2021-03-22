/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import com.istloja.modelo.Inventario;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JIMENEZ
 */
public class ModelTableInventario extends AbstractTableModel {
    
    private String[] m_colNames = {"COD PRODUCTO", "DESCRIPCIÓN", "PRECIO COMPRA", "PRECIO VENTA", "CAN PRODUCTOS"};
    private List<Inventario> inventario;
    private GestionContable gContable;
    
    public ModelTableInventario(List<Inventario> inventario,GestionContable gContable) {
        this.inventario= inventario;
        this.gContable = gContable;
    }
    @Override
    public int getRowCount() {
        return inventario.size();
    }
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Inventario inventarios = inventario.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inventarios.getCodigo_pro();
            case 1:
                return inventarios.getDescripcion();
            case 2:
//                return inventarios.getCan_productos();
//            case 3:
//                return inventarios.getPrecio_compra_sin_iva();
//            case 4:
//                return inventarios.getPrecio_compra_con_iva();
//            case 5:
//                return inventarios.getPrecio_mayorista();
//            case 6:
//                return inventarios.getPrecio_cliente_fijo();
//            case 7:
//                return inventarios.getPrecio_cliente_normal();
            case 8:
                return inventarios.getFecha_caducidad();
//            case 9:
//                return inventarios.getFecha_registro();
//            case 10:
//                return inventarios.getFecha_actualizacion();
        }
        return new String();
    }
    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickInventario(inventario.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Inventario> getInventarios() {
        return inventario;
    }
    public void setInventarios(List<Inventario> inventarios) {
        this.inventario = inventarios;
    }
    
}
