/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import com.istloja.modelo.Persona;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author johnp
 */
public class ModelTablePersona extends AbstractTableModel {
    //Arreglo con el nombre de las columnas
     public String[] m_colNames = {"CÉDULA", "NOMBRES", "APELLIDOS", "DIRECCIÓN", "CORREO", "TELEFONO"};

    public List<Persona> personas;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionContable gestionContable;
    public ModelTablePersona(List<Persona> personas,GestionContable gestionContable) {
        this.personas = personas;
        this.gestionContable = gestionContable;
    }

    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona macData = personas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return macData.getCedula();
            case 1:
                return macData.getNombre();
            case 2:
                return macData.getApellido();
            case 3:
                return macData.getDireccion();
            case 4:
                return macData.getCorreo();
            case 5:
                return macData.getTelefono();
        }
        System.out.println("Select Persona?" + macData.toString());
        return new String();
    }

    //Sirve para definir los nombres de las columnas
    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionContable.clickPersona(personas.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.\
    }
    
    

}
