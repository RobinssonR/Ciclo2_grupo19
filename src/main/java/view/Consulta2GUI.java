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


public class Consulta2GUI extends JFrame {
    
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    // atributos

    private JTable jtTablaConsulta2;

    public Consulta2GUI(ArrayList<Consulta2VO_19> construcciones, ControladorRequerimientosReto4 controlador){

        //Titulo 

    setTitle("Consulta 2");

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    String [] encabezadosColumnas = {"ID Proyecto", "Área Máxima"};

    jtTablaConsulta2 = new JTable (this.formatoConstrucciones(construcciones, encabezadosColumnas.length),encabezadosColumnas);


    JScrollPane sp = new JScrollPane(jtTablaConsulta2);
    JPanel panel = new JPanel();
    panel.add(sp);
    panel.setBorder(new TitledBorder("Construcciones con 2 habitaciones"));
    getContentPane().add(panel);
    setSize(600, 500);
    setLocationRelativeTo(null);
    setVisible(true);

    }

    public String [][] formatoConstrucciones(ArrayList<Consulta2VO_19> construcciones, int numeroColumnas){

        String [][] filas = new String [construcciones.size()] [numeroColumnas];

        for (int i = 0; i < filas.length; i++) {
            filas [i][0] = String.valueOf(construcciones.get(i).getIdProyecto());
            filas [i][1] = String.valueOf(construcciones.get(i).getAreaMax());
    
        }

        return filas;

    }

    


    
}
