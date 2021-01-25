
package clase1conexionbasedatos;

import com.istloja.controlador.Personabd;
import javax.swing.JOptionPane;
import com.istloja.modelo.Persona;
import com.istloja.vistas.GestionPersona;
import com.istloja.vistas.GestionPersonaV1;

public class conectar {
    public static void main (String[] args)
    {
// TODO code application logic here
        Personabd personabd = new Personabd();
        //System.out.println("PERSONAS: "+personabd.obtenerPersonas() );
//        for (Persona arg : personabd.obtenerPersonas()) {
//            System.out.println(arg);
//        }
//        Persona persona = new Persona(4,"110425555","John Patricio EJE2","Solano","Loja","jpsolanoc@gmail.com","0979256768");
//        if (personabd.registrarPersona(persona)) {
//            System.out.println("Persona registrada en la base de datos.");
//        }else{
//            System.out.println("Error al guardar los datos.");
//        }
//        Personabd persona = new Personabd(1);
//        if (personabd.eliminarPersona(persona)) {
//            System.out.println("Persona Eliminada del sistema.");
//        } else {
//            System.out.println("No se pudo eliminar");
//        }
//        GestionPersona gestionPersona = new GestionPersona();
        GestionPersonaV1 gestionPersonav1 = new GestionPersonaV1();

    }
    
}
