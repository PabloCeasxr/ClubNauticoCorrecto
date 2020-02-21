/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import capa.Barco;
import capa.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class BarcosDAOImpl {
        private final ConnectionFactory connectionFactory;
        public BarcosDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
        
     public void guardarBarco(Barco barco){
        try{
            Connection connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String insert = String.format("INSERT INTO barcos(barcos.matricula, barcos.nombre, barcos.numamarre, barcos.cuota, barcos.idsocios) VALUES('%s','%s','%s','%s','%s');", barco.getMatricula(), barco.getNombre(), barco.getNumAmarre(), barco.getCuota(), barco.getIdsocios());
            statement.executeUpdate(insert);
            connection.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());            
        }
    }
    
    public void actualizarBarco(Barco barco){
        try{
            Connection connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String update = String.format("UPDATE BARCOS SET barcos.matricula = '%s', barcos.nombre = '%s', barcos.numamarre = %d, barcos.cuota = %f, barcos.idsocios = %d WHERE barcos.idbarcos = %d;", 
                    barco.getMatricula(), barco.getNombre(), barco.getNumAmarre(), barco.getCuota(), barco.getIdsocios(), barco.getIdbarcos());
            statement.executeUpdate(update);
            connection.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());            
        }
    }
    
    public boolean eliminarBarco(int idBarco){
        try{
            Connection connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String delete = String.format("delete from barcos where barcos.idbarcos = %s", idBarco);
            statement.executeUpdate(delete);
            connection.close();
            return true;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());     
            return false;
        }
    }
     public List<Barco> obtenerBarcos(String textoBusqueda){
        ArrayList<Barco> barcos = new ArrayList<>();
       Connection connection = null;
        try{
            connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultado;
               if(textoBusqueda == null){
                resultado = statement.executeQuery("");
            }else{
                resultado = statement.executeQuery("");
            }           
            while(resultado.next()){
              
            }            
            return barcos;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }finally{
            try{
                connection.close();
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
        }
    }
    
}
