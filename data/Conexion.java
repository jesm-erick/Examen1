package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection connectSQLite() {
        Connection conecty = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:items.db?foreign_keys=on;maxconnection=1";
            conecty = DriverManager.getConnection(dbURL); 
            System.out.println("ok conexión" );          
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión" + e);
        }
        return conecty;
    }
    
    
}
