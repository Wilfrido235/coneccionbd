/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import com.istloja.modelo.Persona;
import com.istloja.vistas.GestionContable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author johnp
 */
public class ModelTablePersonaV2 extends AbstractTableModel {

    private String[] m_colNames = {"CÉDULA", "NOMBRES", "APELLIDOS", "DIRECCIÓN", "CORREO", "TELEFONO","FECHA REGISTRO","GENERO"};
    private List<Persona> personas;
    private GestionContable gContable;
   

    public ModelTablePersonaV2(List<Persona> personas,GestionContable gContable) {
        this.personas = personas;
        this.gContable = gContable;
    }

    //Determina el número de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return personas.size();
    }

    //Determina el número de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona persona = personas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return persona.getCedula();
            case 1:
                return persona.getNombre();
            case 2:
                return persona.getApellido();
            case 3:
                return persona.getDireccion();
            case 4:
                return persona.getCorreo();
            case 5:
                return persona.getTelefono();
            case 6:
                return persona.getFecha_registro();
            case 7:
                return persona.getGenero();
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickPersona(personas.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
     
    
  

}
