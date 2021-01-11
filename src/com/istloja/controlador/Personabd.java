
package com.istloja.controlador;
import com.istloja.modelo.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.istloja.conexionbd.ConexionBaseDatos;

public class Personabd {
    
public boolean registrarPersona(Persona persona) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        //INSERT INTO `ejercicio`.`persona` (`id_persona`, `cedula`, `nombre`, `apellido`, `direccion`, `correo`, `telefono`) VALUES ('1', '1104268899', 'John', 'Solano', 'Loja', 'jpsolanoc@gmail.com', '072587392');
          String sql="INSERT INTO `bdejercicio1`.`persona` (`id_persona`, `cedula`, `nombre`, `apellido`, `direccion`, `correo`, `telefono`) VALUES ('"+String.valueOf(persona.getId_persona())+"', '"+persona.getCedula()+"', '"+persona.getNombre()+"', '"+persona.getApellido()+"', '"+persona.getDireccion()+"', '"+persona.getCorreo()+"', '"+persona.getTelefono()+"');"; 
      
        try {
            ConexionBaseDatos  conexion = new ConexionBaseDatos();
            con = conexion.conexionbd();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return registrar;
    }
     public boolean eliminarPersona(Persona persona) {
     boolean resultado = false;
       Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql = "DELETE FROM `bdejercicio1`.`persona`  WHERE ("+String.valueOf(persona.getId_persona())+"')";
    try {
            ConexionBaseDatos  conexion = new ConexionBaseDatos();
            con = conexion.conexionbd();
            stm = con.createStatement();
            stm.execute(sql);
            resultado = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return resultado;
}
     public boolean actualizarPersona(Persona persona) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        //INSERT INTO `ejercicio`.`persona` (`id_persona`, `cedula`, `nombre`, `apellido`, `direccion`, `correo`, `telefono`) VALUES ('1', '1104268899', 'John', 'Solano', 'Loja', 'jpsolanoc@gmail.com', '072587392');
          String sql="UPDATE `bdejercicio1`.`persona` SET `id_persona` = '1', `cedula` = '1900694375', `nombre` = 'ERIC W', `apellido` = 'JIMENEZ P', `direccion` = 'ZUMBI V', `correo` = 'ewjimenez@tecnologicoloja.con', `telefono` = '1900694365' WHERE (`id_persona` = '2');"; 
      
        try {
            ConexionBaseDatos  conexion = new ConexionBaseDatos();
            con = conexion.conexionbd();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
        }
        return registrar;
}
}
      
    