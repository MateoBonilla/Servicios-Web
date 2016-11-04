
package config;

import java.sql.Connection;
import java.sql.DriverManager; 

public class Conexion {
    
    public Connection getConexion() {
        Connection conexion = null;
        /*CORREGIR MATEO, creo que el driver es el mismo
        el URL si cambia y el usuario y la contra son los mismos
        */
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://johnfedb.cetojpwybnz3.us-west-2.rds.amazonaws.com:3306";
              //nombre de mi base de datos 
        String user = "johnfeuser";
        String password = "j0hnf3db";
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion correcta");
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return conexion;
    }
       
}
