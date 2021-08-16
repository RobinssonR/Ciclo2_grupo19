package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

import javax.swing.JButton;

//Modelos (acceso y objetos contenedores)
import model.dao.*;
import model.vo.*;

//Librerías para bases de datos
import java.sql.SQLException;

import view.Consulta1GUI;
import view.Consulta2GUI;
import view.Consulta3GUI;

// importar vista GUI

import view.VistaGUI;
import view.VistaRequerimientosReto4;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class ControladorRequerimientosReto4 implements ActionListener {    

    private final Consulta1_19Dao consulta1_19Dao;
    private final Consulta2_19Dao consulta2_19Dao;
    private final Consulta3_19Dao consulta3_19Dao;
    private final VistaGUI vistaGUI;
    private final VistaRequerimientosReto4 vistaRequerimientosReto4;
    private Consulta1GUI consulta1gui;
    private Consulta2GUI consulta2gui;
    private Consulta3GUI consulta3gui;
    


    public ControladorRequerimientosReto4(){
        this.consulta1_19Dao = new Consulta1_19Dao();
        this.consulta2_19Dao = new Consulta2_19Dao();
        this.consulta3_19Dao = new Consulta3_19Dao();
        this.vistaGUI = new VistaGUI();
        this.vistaRequerimientosReto4 = new VistaRequerimientosReto4();
        
    }

    public ArrayList <Consulta1VO_19> realizarConsulta1 () throws SQLException{

        return this.consulta1_19Dao.consulta1DAO();

    }
    
    
    // requerimiento2

    public ArrayList <Consulta2VO_19> realizarConsulta2 () throws SQLException {
        return this.consulta2_19Dao.consulta2DAO();
    }

    // requerimiento3

    public ArrayList <Consulta3VO_19> realizarConsulta3 () throws SQLException {
        return this.consulta3_19Dao.consulta3DAO();
    }

    public void iniciarAplicacion() {
        this.vistaGUI.elaborarGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
       String actionComand =  ((JButton)e.getSource()).getActionCommand();
       switch (actionComand){
           case "Requerimiento1" :

           try{

            this.consulta1gui  = new Consulta1GUI(this.realizarConsulta1(),this);


           }catch (SQLException excepcion){
               System.err.println(excepcion);

           }

           break;

           case "Requerimiento2":

           try{

            this.consulta2gui  = new Consulta2GUI(this.realizarConsulta2(),this);


           }catch (SQLException excepcion){
               System.err.println(excepcion);

           }
           
           break;

           case "Requerimiento3":
           try{

            this.consulta3gui  = new Consulta3GUI(this.realizarConsulta3(),this);


           }catch (SQLException excepcion){
               System.err.println(excepcion);

           }
           break;
       }
        
    }

}
