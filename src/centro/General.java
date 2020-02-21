/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class General {
    
    public boolean insertarSocio(String nombre, String apellido){
        boolean agrego =false;
        try{
             String connectionString= "jdbc:mysql://localhost:3306/clubNautico";
            Connection connection=DriverManager.getConnection(connectionString,"root","");
             Statement statement=connection.createStatement();
             statement.executeUpdate("INSERT INTO socios (DNI,nombre,apellido)VALUES('"+nombre+"'+'"+apellido+"')");
             connection.close();
             agrego =true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            agrego =false;
        }
        System.out.println("Se ha ingresado un socio");
        return agrego ;
}
    public DefaultTableModel consultaIDSocio(String id)
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        try{
            String connectionString ="jdbc:mysql://localhost:3306/clubNautico";
            Connection connection = DriverManager.getConnection(connectionString,"root","");
            Statement statement = connection.createStatement();
            String consulta = "SELECT id_socio AS ID, dni AS DNI, nombre AS Nombre, FROM socios WHERE ID="+id+"";
            ResultSet resultado= statement.executeQuery(consulta);
            
            while(resultado.next())
            {
                 Object [] fila = new Object[4];
                 for (int i=0;i<3;i++)
                    fila[i] = resultado.getObject(i+1);
                 modelo.addRow(fila);
            }
            connection.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
     public void consultarSocios(){
      try{
            String connectionString= "jdbc:mysql://localhost:3306/club_Nautico";
            Connection connection=DriverManager.getConnection(connectionString,"root","");
            Statement statement=connection.createStatement();
            String consulta="SELECT id_socio, dni, nombre, from socios";
            ResultSet resultado=statement.executeQuery(consulta);
            while(resultado.next()){
                System.out.println(resultado.getInt("id_socio")+resultado.getString("dni")+resultado.getString("nombre"));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public DefaultTableModel consultaNombreSocio(String nombre)
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");

        try{
            String connectionString ="jdbc:mysql://localhost:3306/clubNautico";
            Connection conexion = DriverManager.getConnection(connectionString,"root","");
            Statement statement = conexion.createStatement();
            String consulta = "SELECT id_socio AS ID, dni AS DNI, nombre AS Nombre, FROM socios WHERE Nombre LIKE ('%"+nombre+"%')";
            ResultSet resultado= statement.executeQuery(consulta);
            
            while(resultado.next())
            {
                 Object [] fila = new Object[4];
                 for (int i=0;i<3;i++)
                    fila[i] = resultado.getObject(i+1);
                 modelo.addRow(fila);
            }
            conexion.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    
 }
}
