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
import javax.swing.*;
import java.awt.*;


public class Consulta1GUI extends JFrame {
    
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    // atributos

    private JTable jtTablaConsulta1;

    public Consulta1GUI(ArrayList<Consulta1VO_19> proyectos, ControladorRequerimientosReto4 controlador){

        //Titulo 

    setTitle("Consulta 1");

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    String [] encabezadosColumnas = {"ID Proyecto", "Fecha Inicio", "Constructora","Serial"};

    jtTablaConsulta1 = new JTable (this.formatoProyectos(proyectos, encabezadosColumnas.length),encabezadosColumnas);


    JScrollPane sp = new JScrollPane(jtTablaConsulta1);
    JPanel panel = new JPanel();
    panel.add(sp);
    panel.setBorder(new TitledBorder("Proyectos con ID menor a 15"));
    getContentPane().add(panel);
    setSize(600, 310);
    setLocationRelativeTo(null);
    setVisible(true);

    }

    public String [][] formatoProyectos(ArrayList<Consulta1VO_19> proyectos, int numeroColumnas){

        String [][] filas = new String [proyectos.size()] [numeroColumnas];

        for (int i = 0; i < filas.length; i++) {
            filas [i][0] = String.valueOf(proyectos.get(i).getIdProyecto());
            filas [i][1] = proyectos.get(i).getFechaInicio();
            filas [i][2] = proyectos.get(i).getConstrutora();
            filas [i][3] = proyectos.get(i).getSerial();
            
        }

        return filas;

    }

    


    
}
