/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pablo
 */
public class Principal{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
       //Corra el menu no este main 
        try {
            String cadenaConexion = "jdbc:mysql://localhost/clubnautico?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(cadenaConexion, "root", "1234");
            Statement statement = connection.createStatement();
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
