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

public class Consulta2_19Dao {
    public ArrayList<Consulta2VO_19> consulta2DAO() throws SQLException {

      ArrayList <Consulta2VO_19> respuesta2 = new ArrayList <Consulta2VO_19> ();

        Connection conexion = null;

        try {

            conexion =  JDBCUtilities.getConnection();

            String consulta2 = "SELECT p.ID_Proyecto, t.Area_Max " +
                               "FROM Proyecto p " +
                               "JOIN Tipo t " +
                               "USING (ID_Tipo) " +
                              "where p.Numero_Habitaciones = 2 ";
            

            PreparedStatement statement = conexion.prepareStatement(consulta2);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Consulta2VO_19 proyecto2  = new Consulta2VO_19();
                proyecto2.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                proyecto2.setAreaMax(resultSet.getInt("Area_Max"));
                respuesta2.add(proyecto2);

            }

            resultSet.close();
            statement.close();

        }catch (SQLException e){

        }finally {
            if (conexion != null){
                conexion.close();
            }
        }

        
         return respuesta2;   

       
        
   }  
}
