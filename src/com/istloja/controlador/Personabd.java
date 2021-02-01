package com.istloja.controlador;

import com.istloja.modelo.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.istloja.conexionbd.ConexionBaseDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Personabd {

    public boolean registrarPersona(Persona persona) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        //INSERT INTO `ejercicio`.`persona` (`id_persona`, `cedula`, `nombre`, `apellido`, `direccion`, `correo`, `telefono`) VALUES ('1', '1104268899', 'John', 'Solano', 'Loja', 'jpsolanoc@gmail.com', '072587392');
        String sql = "INSERT INTO `bdejercicio1`.`persona` (`id_persona`, `cedula`, `nombre`, `apellido`, `direccion`, `correo`, `telefono`) VALUES ('" + String.valueOf(persona.getId_persona()) + "', '" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "');";

        try {
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

    public boolean eliminarPersona(Persona persona) {
        boolean eliminar = false;
        Statement stm = null;
        Connection connect = null;

        String sql = "DELETE FROM `bdejercicio1`.`persona`  WHERE (`id_persona` = '" + String.valueOf(persona.getId_persona()) + "')";
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

    public boolean actualizarPersona(Persona persona) {
        boolean actualizar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection connect = null;
        //INSERT INTO `ejercicio`.`persona` (`id_persona`, `cedula`, `nombre`, `apellido`, `direccion`, `correo`, `telefono`) VALUES ('1', '1104268899', 'John', 'Solano', 'Loja', 'jpsolanoc@gmail.com', '072587392');
        String sql = "UPDATE `bdejercicio1`.`persona` SET `cedula` = '" + persona.getCedula() + "', `nombres` = '" + persona.getNombre() + "', `apellidos` = '" + persona.getApellido() + "', `direccion` = '" + persona.getDireccion() + "', `correo` = '" + persona.getCorreo() + "', `telefono` = '" + persona.getTelefono() + "' WHERE (`idpersona` = '" + persona.getId_persona() + "');";

        try {
            ConexionBaseDatos con = new ConexionBaseDatos();
            connect = con.conexionbd();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }

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
                listaPersonas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaPersonas;
    }
 public Persona getPersonaCedula(String cedula) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Persona c = null;
        String sql = "SELECT * FROM bdejercicio1.persona where cedula like "+cedula+";";
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
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return c;
  
    }
   public Persona getPersonaTelelfono(String telefono) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Persona c = null;
        String sql = "SELECT * FROM bdejercicio1.persona where telefono = "+telefono+";";
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
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return c;
    }
}
