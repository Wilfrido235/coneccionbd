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
    
    private String[] m_colNames = {"codigo_pro", "descripcion", "precios_compra", "precio_venta", "can_productos"};
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
                return inventarios.getCan_productos();
            case 1:
                return inventarios.getDescripcion();
            case 2:
                return inventarios.getPrecios_compra();
            case 3:
                return inventarios.getPrecio_venta();
            case 4:
                return inventarios.getCan_productos();
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

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
