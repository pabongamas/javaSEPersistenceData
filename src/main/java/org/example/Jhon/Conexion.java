package org.example.Jhon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private  static String url="jdbc:mysql://localhost:33060/mensajes_app";
    private  static String user="root";
    private static String pass="secret";
    public Connection get_connection(){
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(url,user,pass);
            if(connection!=null){
                System.out.println("se realizo conexion ");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
