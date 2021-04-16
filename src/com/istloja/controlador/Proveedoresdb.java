package com.istloja.controlador;

import com.istloja.modelo.Proveedores;
import com.istloja.conexionbd.ConexionBaseDatos;
import com.istloja.utilidad.Utilidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johnp
 */
public class Proveedoresdb {

    public Utilidades utilidades;

    public Proveedoresdb() {
        utilidades = new Utilidades();
    }
    // Registrar persona en la base de datos.

    public boolean registrarProveedor(Proveedores proveedor) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql;
        if (proveedor.getFechaVencimientoDeuda() == null) {
            sql = "INSERT INTO `bdejercicio1`.`proveedores` (`ruc`, `razon_social`, `tipo_actividad`, `nombre_representante_legal`, `apellido_representante_legal`, `telefono`, `correo`, `direccion`, `fecha_registro`)  VALUES ('" + proveedor.getRuc() + "', '" + proveedor.getRazonSocial() + "', '" + proveedor.getTipoActividad() + "', '" + proveedor.getNombre_representante_legal() + "', , '" + proveedor.getApellidos_representante_legal() + "', '" + proveedor.getTelefono() + "', '" + proveedor.getCorreo() + "', '" + proveedor.getDireccion() + "',, '" + utilidades.devolverFecha(proveedor.getFecha_registro()) + "');";
        } else {
            sql = "INSERT INTO `bdejercicio1`.`proveedores` (`ruc`, `razon_social`, `tipo_actividad`, `nombre_representante_legal`, `apellido_representante_legal`, `telefono`, `correo`, `direccion`, `fecha_registro`,`fecha_vecimiento_deuda`)  VALUES ('" + proveedor.getRuc() + "', '" + proveedor.getRazonSocial() + "', '" + proveedor.getTipoActividad() + "', '" + proveedor.getNombre_representante_legal() + "', , '" + proveedor.getApellidos_representante_legal() + "', '" + proveedor.getTelefono() + "', '" + proveedor.getCorreo() + "', '" + proveedor.getDireccion() + "',, '" + utilidades.devolverFecha(proveedor.getFecha_registro()) + "', '" + utilidades.devolverFecha(proveedor.getFechaVencimientoDeuda()) + "');";
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

    public boolean actualizarProveedores(Proveedores proveedor) {
        // ConexionBaseDatos con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `bdejercicio1`.`proveedores` SET `ruc` = '" + proveedor.getRuc() + "', `razon_social` = '" + proveedor.getRazonSocial() + "', `tipo_actividad` = '" + proveedor.getTipoActividad() + "', `nombre_representante_legal` = '" + proveedor.getNombre_representante_legal() + "', `apellido_representante_legal` = '" + proveedor.getApellidos_representante_legal() + "', `telefono` = '" + proveedor.getTelefono() + "', `correo` = '" + proveedor.getCorreo() + "',`direccion` = '" + proveedor.getDireccion() + "',`fecha_registro` ='" + utilidades.devolverFecha(proveedor.getFecha_registro()) + "',`fechaActualizacion`='" + utilidades.devolverFecha(proveedor.getFechaActualizacion()) + "', `fechaVecimientoDeuda` = '" + utilidades.devolverFecha(proveedor.getFechaVencimientoDeuda()) + "' WHERE `id_proveedores` = '" + proveedor.getIdProveedores() + "';";
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
    public boolean eliminarProveedores(Proveedores proveedor) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `bdejercicio1`.`proveedores` WHERE (`id_proveedores` = '" + proveedor.getIdProveedores() + "');";
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
    public List<Proveedores> obtenerProveedores() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM bdejercicio1.proveedores;";
        List<Proveedores> listaProveedores = new ArrayList<Proveedores>();
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
                listaProveedores.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaProveedores;
    }

    public Proveedores buscarCodigoProvedores(String ruc) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 
        Proveedores c = null;
        String sql = "SELECT * FROM bdejercicio1.proveedores  WHERE ruc LIKE " + ruc + ";";

        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
            }
            stm.close();
            rs.close();
            co.close();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return c;
    }

    public List<Proveedores> obtenerProvedoresRuc(String ruc) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.proveedores WHERE ruc LIKE \"%" + ruc + "%\"";

        List<Proveedores> listaprovedores = new ArrayList<Proveedores>();

        try {
            co = new ConexionBaseDatos().conexionbd();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
                listaprovedores.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listaprovedores;

    }
 public List<Proveedores> obtenerProvedoresNombre(String nombre) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.proveedores WHERE nombre_representante_legal LIKE \"%" + nombre + "%\"";

        List<Proveedores> listaprovedores = new ArrayList<Proveedores>();

        try {
            co = new ConexionBaseDatos().conexionbd();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
               Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
                listaprovedores.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listaprovedores;

    }

    public List<Proveedores> obtenerProvedoresApellido(String apellido) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.proveedores WHERE apellido_representante_legal LIKE \"%" + apellido + "%\"";

        List<Proveedores> listaprovedores = new ArrayList<Proveedores>();

        try {
            co = new ConexionBaseDatos().conexionbd();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
                listaprovedores.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listaprovedores;

    }

    public List<Proveedores> obtenerProvedoresDireccion(String direccion) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.proveedores WHERE direccion LIKE \"%" + direccion + "%\"";

        List<Proveedores> listaprovedores = new ArrayList<Proveedores>();

        try {
            co = new ConexionBaseDatos().conexionbd();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
                listaprovedores.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listaprovedores;

    }

    public List<Proveedores> obtenerProvedoresTelefono(String telefono) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.proveedores WHERE telefono LIKE \"%" + telefono + "%\"";

        List<Proveedores> listaprovedores = new ArrayList<Proveedores>();

        try {
            co = new ConexionBaseDatos().conexionbd();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
                listaprovedores.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listaprovedores;

    }

    public List<Proveedores> obtenerProvedoresCorreo(String correo) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.proveedores WHERE correo LIKE \"%" + correo + "%\"";

        List<Proveedores> listaprovedores = new ArrayList<Proveedores>();

        try {
            co = new ConexionBaseDatos().conexionbd();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
                listaprovedores.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listaprovedores;

    }

    public List<Proveedores> obtenerProvedoresRazonsocial(String servicio) {

        Connection co = null;
        Statement stm = null;//Sentencia sql para btener los resultados producidos por la base de datos 
        ResultSet rs = null; // ResultSet para ejecutar una consulta y examinar los resultados de la consulta en la base de datos 

        String sql = "SELECT * FROM bdEjercicio1.proveedores WHERE razon_social LIKE \"%" + servicio + "%\"";

        List<Proveedores> listaprovedores = new ArrayList<Proveedores>();

        try {
            co = new ConexionBaseDatos().conexionbd();

            stm = co.createStatement();
            rs = stm.executeQuery(sql);// sentencia que se va a ejecutar 
            while (rs.next()) {//El método next () de la interfaz ResultSet mueve el puntero del objeto actual (ResultSet) a la siguiente fila, desde la posición actual.

                // Estos para metros Tienes que ir en orden 
                Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombre_representante_legal(rs.getString(5));
                c.setApellidos_representante_legal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaActualizacion(rs.getDate(11));
                c.setFechaVencimientoDeuda(rs.getDate(12));
                listaprovedores.add(c); /// Agregamos los objetos obtenidos a mi listapersonas 

            }

            stm.close();// Cierra la Interfaz 

            rs.close();// Cierra el resultado 

            co.close();// Cuerra la conexion
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());

        }
        return listaprovedores;

    }

}
