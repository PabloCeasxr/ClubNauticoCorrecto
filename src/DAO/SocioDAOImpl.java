/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author pablo
 */
import capa.ConnectionFactory;
import capa.Socio;
import capa.SocioDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author lv1013
 */
public class SocioDAOImpl  {

    private final ConnectionFactory connectionFactory;

    public SocioDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public Socio find(int id) throws Exception {
        final String sql = "SELECT id, nombre, direccion "
                + "FROM socio WHERE id = ?";

        try (Connection connection = this.connectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Socio(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("direccion"));
                }

                return null;
            }
        }
    }

    public List<Socio> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Socio socio) throws Exception {
        final String sql = "INSERT INTO socio (nombre, direccion) "
                + "VALUES (?, ?)";
        try (
                Connection connection = this.connectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, socio.getNombre());
            statement.setString(2, socio.getAge());
            int id = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            socio.setId(id);
        }
    }

    public boolean eliminarSocio(int id) {
        try {
            Connection connection = this.connectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String delete = String.format("Delete from socios where id = %s", id);
            statement.executeUpdate(delete);
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public void actualizarSocio(Socio socio) {
        try {
            Connection connection = this.connectionFactory.getConnection();
            Statement comando = connection.createStatement();
            String update = String.format("UPDATE socios SET "
                    + "socios.curp = '%s', socios.nombre = '%s' WHERE socios.idsocios = %s;",
                    socio.getAge(), socio.getNombre(), socio.getId());
            comando.executeUpdate(update);
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public int updateNumBarcos(int socioId) throws  SQLException{
        final String sql = "{?= CALL actualizarNumBarcos(?)}";
        try (Connection connection = this.connectionFactory.getConnection()){
            CallableStatement statement = connection.prepareCall(sql);{
            statement.setInt(1, socioId);
        }
            try (ResultSet resulSet = statement.executeQuery()){
                // No se puede establecer los parametros para la posicion
//                if (resultSet.next()) {
//                    return resultSet.getInt(1);
//                }
            }
                
            
        }
        return 0;
    }

    
}
    
