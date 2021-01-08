
package clase1conexionbasedatos;

import javax.swing.JOptionPane;


public class conectar {
    public static void main (String[] args)
    {
       JOptionPane.showMessageDialog(null,"Iniciando la conexion con la base de datos...");
       Clase1ConexionBaseDatos conectar= new Clase1ConexionBaseDatos();
       conectar.conexion();
    }
}
