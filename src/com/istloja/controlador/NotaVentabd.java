
package com.istloja.controlador;

import com.istloja.conexionbd.ConexionBaseDatos;
import com.istloja.modelo.NotaVenta;
import com.istloja.utilidad.Utilidades;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class NotaVentabd {
    public Utilidades utilidades;

    public NotaVentabd() {
        utilidades = new Utilidades();
    }
    public boolean registrarNotaVenta(NotaVenta notaVenta) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql;
        sql = "INSERT INTO `bdejercicio1`.`nota_venta` (`numero_nota_venta`, `persona_id_persona`, `fecha_venta`, `sub_total`, `iva`, `total_venta`, `tipo_pago`) VALUES  ('" + notaVenta.getNumero_nota_venta()+ "', '" + notaVenta.getPersona_id_persona()+ "', '" + utilidades.devolverFecha(notaVenta.getFecha_venta()) + "', '" + notaVenta.getSub_total()+ "', '" + notaVenta.getIva() + "', '" + notaVenta.getTotal_venta()+ "', '" + notaVenta.getTipo_pago()+ "');";
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

}
