package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    //Definir variables con los nombres correspondientes a la BD
     private String database_name = "scv_database";  
    private String user = "adminscv@mecanica-mysql-server2022";
    private String password = "Admin1234";
    private String url = "jdbc:mysql://mecanica-mysql-server2022.mysql.database.azure.com:3306/" + database_name; //establecer conexión
    Connection conn =null;
    
    public Connection getConnection(){
        //Exepciones para cuando nos estemenos conectando BD
        try{
            //obtener valor del Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtener la conexión
            conn = DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException e){
           System.err.println("Ha ocurrido un ClassNotFoundException" + e.getMessage());
        }catch(SQLException e){
            System.err.println("Ha ocurrido un SQLExeption" + e.getMessage());
        }
        return conn;
    }
}
