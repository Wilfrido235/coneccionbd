
package com.istloja.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBaseDatos {
 
   public static Connection con;
    //declaramos los datos de conexion
    private static final String user = "root";
    private static final String pass = "dj1234,.-";
    private static final String url = "jdbc:mysql://localhost:3306/bdejercicio1? nm   useUnicode=true&use"
              + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    PreparedStatement ps;
    
     public Connection conexionbd() {
        Connection con = null;
         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
             con=(Connection)DriverManager.getConnection(url,user,pass);
             
             if(con!=null){
            System.out.println("Conexion exitosa");
             }
             
        } catch(Exception e){
        System.out.println("Error de conexion"+e);
        }   
               return con;
        }
}
   
 
