package view;

import controller.ControladorRequerimientosReto4;
import model.vo.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;


public class Consulta3GUI extends JFrame {
    
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    // atributos

    private JTable jtTablaConsulta3;

    public Consulta3GUI(ArrayList<Consulta3VO_19> pBancolombia, ControladorRequerimientosReto4 controlador){

        //Titulo 

    setTitle("Consulta 3");

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    String [] encabezadosColumnas = {"ID Proyecto", "Nombre_Apellido Líder"};

    jtTablaConsulta3 = new JTable (this.formatoPbancolombia(pBancolombia, encabezadosColumnas.length),encabezadosColumnas);


    JScrollPane sp = new JScrollPane(jtTablaConsulta3);
    JPanel panel = new JPanel();
    panel.add(sp);
    panel.setBorder(new TitledBorder("Proyectos pertenecientes a Bancolombia"));
    getContentPane().add(panel);
    setSize(600, 500);
    setLocationRelativeTo(null);
    setVisible(true);

    }

    public String [][] formatoPbancolombia(ArrayList<Consulta3VO_19> pBancolombia, int numeroColumnas){

        String [][] filas = new String [pBancolombia.size()] [numeroColumnas];

        for (int i = 0; i < filas.length; i++) {
            filas [i][0] = String.valueOf(pBancolombia.get(i).getIdProyecto());
            filas [i][1] = pBancolombia.get(i).getNombreApellido();
    
        }

        return filas;

    }

    


    
}
