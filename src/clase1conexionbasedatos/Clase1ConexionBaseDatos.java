
package clase1conexionbasedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Clase1ConexionBaseDatos {
 
   public static Connection con;
    //declaramos los datos de conexion
    private static final String base = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "dj1234,.-";
    private static final String url = "jdbc:mysql://localhost:3306/bdejercicio1? nm   useUnicode=true&use"
              + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    PreparedStatement ps;
    
     public Connection conexion() {
        Connection con = null;
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             con=(Connection)DriverManager.getConnection(url,user,pass);
             
             if(con!=null){
             JOptionPane.showMessageDialog(null,"Conexion exitosa");
             }
             
        } catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null,"Error de conexion"+e);
        }   
               return con;
        }
}
   
 
