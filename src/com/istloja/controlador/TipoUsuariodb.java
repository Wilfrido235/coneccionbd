/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;
import com.istloja.modelo.TipoUsuario;
import java.sql.Connection;
import java.sql.Statement;
import com.istloja.conexionbd.ConexionBaseDatos;
import java.sql.SQLException;

/**
 *
 * @author johnp
 */
// Gestión entre la base de datos y el modelo que se tiene implementado en java.
public class TipoUsuariodb {

    // Registrar tipoUsuario en la base de datos.
    public boolean registrarTipoUsuario(TipoUsuario tipoUsuario) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql = "INSERT INTO `ejercicio`.`tipo_usuario` (`tipo_usuario_sistema`, `id_persona_sistema`, `contrasenia`) VALUES ("
                + "'"+tipoUsuario.getPersonaIdPersonaSistema()+"', "
                + "'"+tipoUsuario.getPersonaIdPersonaSistema()+"', "
                + "'"+tipoUsuario.getPersonaIdPersonaSistema()+"');";
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

    //ACtualizar la tipoUsuario e la base de datos.
    public boolean actualizar(TipoUsuario tipoUsuario) {
        // Conexion con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "";
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

    //Eliminar una tipoUsuario en base al ID de la tipoUsuario seleccionada de la base de datos.
    public boolean eliminar(TipoUsuario tipoUsuario) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `ejercicio`.`tipoUsuario` WHERE (`idtipoUsuario` = '" + String.valueOf(tipoUsuario.getIdTipoUsuario()) + "');";
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

 



}
