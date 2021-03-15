/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;

import com.istloja.conexionbd.ConexionBaseDatos;
import com.istloja.modelo.Inventario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIMENEZ
 */
public class Inventariobd {
     public boolean registrarInventario(Inventario inventario) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        //INSERT INTO `ejercicio`.`persona` (`idpersona`, `cedula`, `nombres`, `apellidos`, `direccion`, `correo`, `telefono`) VALUES ('1', '1104268899', 'John', 'Solano', 'Loja', 'jpsolanoc@gmail.com', '072587392');
        String sql = "INSERT INTO `bdejercicio1`.`inventario` (`id_inventario`, `codigo_pro`, `can_productos`, `descripcion`, `precio_compra_sin_iva`, `precio_compra_con_iva`, `precio_mayorista`, `precio_cliente_fijo`, `precio_cliente_normal`, `fecha_caducidad`, `fecha_registro`, `fecha_actualizacion`) VALUES ('"+inventario.getCodigo_pro()+"', '"+inventario.getCan_productos()+"','"+inventario.getDescripcion()+"','"+inventario.getPrecio_compra_sin_iva()+"','"+inventario.getPrecio_compra_con_iva()+"','"+inventario.getPrecio_mayorista()+"','"+inventario.getPrecio_cliente_fijo()+"','"+inventario.getPrecio_cliente_normal()+"','"+inventario.getFecha_caducidad()+"','"+inventario.getFecha_registro()+"','"+inventario.getFecha_actualizacion()+"');";
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
     public boolean actualizarInventario(Inventario inventario) {
         System.out.println("Actualizar:"+ inventario);
        // ConexionBaseDatos con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `bdejercicio1`.`inventario` SET `codigo_pro` = '"+inventario.getCodigo_pro()+"',`can_productos` = '"+inventario.getCan_productos()+"',`descripcion` = '"+inventario.getDescripcion()+"', `precio_compra_sin_iva ` = '"+inventario.getPrecio_compra_sin_iva()+"', `precio_compra_sin_iva `= '"+inventario.getPrecio_compra_con_iva()+"', `precio_mayorista `= '"+inventario.getPrecio_mayorista()+"', `precio_cliente_fijo `= '"+inventario.getPrecio_cliente_fijo()+"', `precio_cliente_normal `= '"+inventario.getPrecio_cliente_normal()+"', `fecha_caducidad `= '"+inventario.getFecha_caducidad()+"', `fecha_registro `= '"+inventario.getFecha_registro()+"', `fecha_actualizacion `= '"+inventario.getFecha_actualizacion()+"' WHERE (`id_inventario` = '"+inventario.getId_inventario()+"');";
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
      public boolean eliminarInventario(Inventario inventario) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `bdejercicio1`.`inventario` WHERE (`id_inventario` = '"+inventario.getId_inventario()+"');";
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
       public List<Inventario> obtenerInventario() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM bdejercicio1.inventario;";
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario c = new Inventario();
                c.setId_inventario(rs.getInt(1));
                c.setCodigo_pro(rs.getString(2));
                c.setCan_productos(rs.getString(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio_compra_sin_iva(rs.getDouble(5));
                c.setPrecio_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_caducidad(rs.getDate(10));
                c.setFecha_registro(rs.getDate(11));
                c.setFecha_actualizacion(rs.getDate(12));
                listaInventario.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return listaInventario;
    }
     public List<Inventario> ObtenerCodigo_pro(String codigo_pro) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Inventario> inventarioEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.inventario where codigo_pro like \"%"+codigo_pro+"%\"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario c = new Inventario();
                c.setId_inventario(rs.getInt(1));
                c.setCodigo_pro(rs.getString(2));
                c.setCan_productos(rs.getString(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio_compra_sin_iva(rs.getDouble(5));
                c.setPrecio_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_caducidad(rs.getDate(10));
                c.setFecha_registro(rs.getDate(11));
                c.setFecha_actualizacion(rs.getDate(12));
                inventarioEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return inventarioEncontradas;
    }
     public List<Inventario> ObtenerDescripcion(String descripcion) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Inventario> inventarioEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.inventario where descripcion like \"%"+descripcion+"%\"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario c = new Inventario();
                c.setId_inventario(rs.getInt(1));
                c.setCodigo_pro(rs.getString(2));
                c.setCan_productos(rs.getString(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio_compra_sin_iva(rs.getDouble(5));
                c.setPrecio_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_caducidad(rs.getDate(10));
                c.setFecha_registro(rs.getDate(11));
                c.setFecha_actualizacion(rs.getDate(12));
                inventarioEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return inventarioEncontradas;
    }
}
