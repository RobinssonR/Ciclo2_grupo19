import util.JDBCUtilities;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;


import view.VistaRequerimientosReto4;
import view.VistaGUI;

import controller.ControladorRequerimientosReto4;
/**
 * Persistencia Proyectos Construcción
 *
 */
public class App_19 {
    public static void main( String[] args ){    
        
        
        // instanciar controlador e iniciar

        ControladorRequerimientosReto4 controladorGUI = new ControladorRequerimientosReto4();
        controladorGUI.iniciarAplicacion();

        //Casos de prueba 
        //Consulta 1
       // VistaRequerimientosReto4.consulta1();
        //System.out.println();
        //Consulta 2
       // VistaRequerimientosReto4.consulta2();
       // System.out.println();
        //Consulta 3
       // VistaRequerimientosReto4.consulta3();
       // System.out.println();
        //////////Fin de los llamados a los requerimientos

    }
}
