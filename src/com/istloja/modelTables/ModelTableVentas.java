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
public class ModelTableVentas extends AbstractTableModel {
    
    private String[] m_colNames = {"CANTIDAD", "DESCRIPCIÓN", "SUB TOTAL", "TOTAL"};
    private List<Inventario> inventario;
    private ComunicacionVistaModelosTablas comunicacionPersona;
    
    private GestionContable gContable;
    
    
    public ModelTableVentas(List<Inventario> inventario,GestionContable gContable) {
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
                return gContable.cantidadproductoVenta();
            case 1:
                return inventarios.getDescripcion();
            case 2:
                return inventarios.getPrecio_cliente_normal();
            case 3:
                return gContable.cantidadproductoVenta() * inventarios.getPrecio_cliente_normal(); 
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
