/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;

import com.istloja.modelo.Persona;
import java.sql.Connection;
import java.sql.Statement;
import com.istloja.conexionbd.ConexionBaseDatos;
import com.istloja.utilidad.Utilidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johnp
 */
// Gestión entre la base de datos y el modelo que se tiene implementado en java.
public class Personabd {
    
    public Utilidades utilidades;

    public Personabd() {
        utilidades = new Utilidades();
    }
    
    // Registrar persona en la base de datos.
    public boolean registrarPersona(Persona persona) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql;
        if(persona.getFachaNacimiento()== null){
             sql = "INSERT INTO `bdejercicio1`.`persona` (`id_persona`,`cedula`, `nombre`, `apellido`, `direccion`, `correo`, `telefono`, `fecha_registro`,`genero`) VALUES('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "','"+ utilidades.devolverFecha(persona.getFecha_registro())+"','"+persona.getGenero()+"');";
        }else{
             sql = "INSERT INTO `bdejercicio1`.`persona` (`id_persona`,`cedula`, `nombre`, `apellido`, `direccion`, `correo`, `telefono`, `fecha_registro`,`genero`,`fecha_nacimineto`) VALUES('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "','"+ utilidades.devolverFecha(persona.getFecha_registro())+"','"+persona.getGenero()+"','"+ utilidades.devolverFecha(persona.getFachaNacimiento())+"');";
        }  
        try {
            //Es una instancia de la conexion previamente creada.
            ConexionBaseDatos conexion = new ConexionBaseDatos();
            con = conexion.conexionbd();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    }
    //ACtualizar la persona e la base de datos.
    public boolean actualizar(Persona persona) {
        // ConexionBaseDatos con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `bdejercicio1`.`persona` SET `cedula` = '" + persona.getCedula() + "', `nombre` = '" + persona.getNombre() + "', `apellido` = '" + persona.getApellido() + "', `direccion` = '" + persona.getDireccion() + "', `correo` = '" +persona.getCorreo() + "', `telefono` = '" + persona.getTelefono() + "',`fecha_registro` = '"+ persona.getFecha_registro()+"',`genero` = '"+persona.getGenero()+"', `fecha_actualizacion` = '" + utilidades.devolverFecha(persona.getFechaActualizacion()) +"' WHERE (`id_persona` = '" + persona.getId_persona() + "');";
        try {
            ConexionBaseDatos con = new ConexionBaseDatos();
            connect = con.conexionbd();
            //Puente entre la conexion y el codigo
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return actualizar;
    }
    //Eliminar una persona en base al ID de la persona seleccionada de la base de datos.
    public boolean eliminar(Persona persona) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `bdejercicio1`.`persona` WHERE (`id_persona` = '" + String.valueOf(persona.getId_persona()) + "');";
        try {
            connect = new ConexionBaseDatos().conexionbd();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
    //Sirve para traer todos los registros de persona de la base de datos 
    public List<Persona> obtenerPersonas() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM bdejercicio1.persona;";
        List<Persona> listaPersonas = new ArrayList<Persona>();
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setId_persona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaActualizacion(rs.getDate(10));
                c.setFachaNacimiento(rs.getDate(11));
                listaPersonas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return listaPersonas;
    }
    
    //Metodo para buscar una persona por cedula
    public Persona getPersonaCedula(String cedula) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Persona c = null;
        String sql = "SELECT * FROM bdejercicio1.persona where cedula like "+cedula+"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Persona();
                c.setId_persona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaActualizacion(rs.getDate(10));
                c.setFachaNacimiento(rs.getDate(11));
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return c;
    }
     public List<Persona> getPersonaCedulaLista(String cedula) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Persona> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM ejercicio.persona where cedula like '%" + cedula + "%';";
        try {
            co = new  ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setId_persona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaActualizacion(rs.getDate(10));
                c.setFachaNacimiento(rs.getDate(11));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return personasEncontradas;
    }
       public Persona getPersonaNombre(String nombre) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Persona c = null;
        String sql = "SELECT * FROM bdejercicio1.persona where nombre like "+nombre+";";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Persona();
                c.setId_persona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaActualizacion(rs.getDate(10));
                c.setFachaNacimiento(rs.getDate(11));
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return c;
       }
    //Metodo para buscar una persona por cedula
    public List<Persona> getPersonaNombreListo(String nombre) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Persona> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.persona where nombre like \"%"+nombre+"%\"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setId_persona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaActualizacion(rs.getDate(10));
                c.setFachaNacimiento(rs.getDate(11));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return personasEncontradas;
    }
 public List<Persona> getPersonaApellido(String apellido) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Persona> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.persona where apellido like \"%"+apellido+"%\"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setId_persona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaActualizacion(rs.getDate(10));
                c.setFachaNacimiento(rs.getDate(11));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return personasEncontradas;
    }
 public List<Persona> getPersonaCorreo(String correo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Persona> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.persona where correo like \"%"+correo+"%\"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setId_persona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFechaActualizacion(rs.getDate(10));
                c.setFachaNacimiento(rs.getDate(11));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return personasEncontradas;
    }


}
