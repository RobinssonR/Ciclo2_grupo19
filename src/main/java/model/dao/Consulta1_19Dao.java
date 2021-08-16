package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;

public class Consulta1_19Dao {
    public ArrayList<Consulta1VO_19> consulta1DAO() throws SQLException {

        ArrayList <Consulta1VO_19> respuesta = new ArrayList <Consulta1VO_19> ();

        Connection conexion = null;

        try {

            conexion =  JDBCUtilities.getConnection();

            String consulta = "SELECT ID_Proyecto, "+
                                      "Fecha_Inicio,"+
                                      "Constructora, " +
                                      "Serial " +
                              "FROM Proyecto p " +
                              "WHERE p.ID_Proyecto < 15";


            PreparedStatement statement = conexion.prepareStatement(consulta);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Consulta1VO_19 proyecto  = new Consulta1VO_19();
                proyecto.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                proyecto.setFechaInicio(resultSet.getString("Fecha_Inicio"));
                proyecto.setConstrutora(resultSet.getString("Constructora"));
                proyecto.setSerial(resultSet.getString("Serial"));

                respuesta.add(proyecto);

            }

            resultSet.close();
            statement.close();

        }catch (SQLException e){

        }finally {
            if (conexion != null){
                conexion.close();
            }
        }

        
         return respuesta;   

    }  
}
