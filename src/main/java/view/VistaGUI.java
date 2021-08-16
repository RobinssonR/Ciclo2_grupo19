package view;

import controller.ControladorRequerimientosReto4;
import model.vo.*;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.*;
import java.awt.Image;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.html.HTML;

import org.testng.reporters.jq.IPanel;


public class VistaGUI extends JFrame {
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    // atributos de interfaz gráfica

    private JButton botonRequerimiento1;
    private JButton botonRequerimiento2;
    private JButton botonRequerimiento3;

    public void elaborarGUI(){

        //Titulo 

    setTitle("Consulta Base de datos Constructores S.A.S");
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Instanciar componentes - botones por requerimiento

    ImageIcon icono1 = new ImageIcon("Imagenes/idproyectos.png");
    Image Imagen1 = icono1.getImage();
    icono1 = new ImageIcon(Imagen1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));  
    botonRequerimiento1 = new JButton(icono1);
    botonRequerimiento1.setFont(new Font ("TimesRoman",Font.BOLD,20));
    botonRequerimiento1.setBackground(Color.lightGray);
    botonRequerimiento1.addActionListener(controlador);
    botonRequerimiento1.setActionCommand("Requerimiento1");
    botonRequerimiento1.setText("ID Proyectos");

    ImageIcon icono2 = new ImageIcon("Imagenes/doshabitaciones.png");
    Image Imagen2 = icono2.getImage();
    icono2 = new ImageIcon(Imagen2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));  
    botonRequerimiento2 = new JButton(icono2);
    botonRequerimiento2.setFont(new Font ("TimesRoman",Font.BOLD,20));
    botonRequerimiento2.setBackground(Color.orange);
    botonRequerimiento2.addActionListener(controlador);
    botonRequerimiento2.setActionCommand("Requerimiento2");
    botonRequerimiento2.setText("Construcciones");



    ImageIcon icono3 = new ImageIcon("Imagenes/proyectos.png");
    Image Imagen = icono3.getImage();
    icono3 = new ImageIcon(Imagen.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));  
    botonRequerimiento3 = new JButton(icono3);
    botonRequerimiento3.setFont(new Font ("TimesRoman",Font.BOLD,20));
    botonRequerimiento3.setBackground(Color.lightGray);
    botonRequerimiento3.addActionListener(controlador);
    botonRequerimiento3.setActionCommand("Requerimiento3");
    botonRequerimiento3.setText("Proyectos Bancolombia");



    // adicion a contenedor intermedio


    JLabel instrucciones = new JLabel();
    instrucciones.setFont(new Font("TimesRoman",Font.ITALIC,25));
    instrucciones.setText("<html><center> Sistema de consultas Constructores S.A.S");

    JPanel panelRequerimientos = new JPanel();
    panelRequerimientos.add(instrucciones);
    panelRequerimientos.setLayout(new GridLayout(1,1));
    panelRequerimientos.add(botonRequerimiento1);
    panelRequerimientos.add(botonRequerimiento2);
    panelRequerimientos.add(botonRequerimiento3);
    
   
    // agregar contenedor intermedio a la ventana

    getContentPane().add(panelRequerimientos);
    
    // establecimiento de propiedades en el Frame

    setSize(1300, 250);
    setLocationRelativeTo(null);
    setVisible(true);


    }


    public static void consulta1(){
        System.out.println("-----Consulta 1-------"); 
        try{

            ArrayList<Consulta1VO_19> lista = controlador.realizarConsulta1();

            //Encabezado del resultado

            System.out.println("id_proyecto, Fecha_Inicio , Constructora , serial");
            
            //Cada VO cargado, mostrarlo en la vista

            for (Consulta1VO_19 consulta1vo_19 : lista){

                System.out.printf("%d" +" "+"%s"+ " " +"%s" + " " + "%s" +"%n",
                consulta1vo_19.getIdProyecto(),
                consulta1vo_19.getFechaInicio(),
                consulta1vo_19.getConstrutora(),
                consulta1vo_19.getSerial()
                );

            }
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }

   public static void consulta2(){
       System.out.println("-----Consulta 2-------"); 
       try{

          ArrayList<Consulta2VO_19> lista = controlador.realizarConsulta2();

            //Encabezado del resultado

            System.out.println("id_proyecto, area_max");
            
            
            //Cada VO cargado, mostrarlo en la vista

            for (Consulta2VO_19 consulta2vo_19 : lista){

                System.out.printf("%d" +" "+"%d"+ "%n",
                consulta2vo_19.getIdProyecto(),
                consulta2vo_19.getAreaMax()
                );

            }

            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }


   public static void consulta3(){
        System.out.println("-----Consulta 3-------"); 
        try{

            ArrayList<Consulta3VO_19> lista = controlador.realizarConsulta3();

            //Encabezado del resultado

            System.out.println("id_proyecto, nombreapellido");
            
            //Cada VO cargado, mostrarlo en la vista

            for (Consulta3VO_19 consulta3vo_19 : lista){

                System.out.printf("%d" +" "+"%s"+ "%n",
                consulta3vo_19.getIdProyecto(),
                consulta3vo_19.getNombreApellido()
                );

            }

            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
       }      
    }

}
