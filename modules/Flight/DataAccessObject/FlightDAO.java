package project.modules.Flight.DataAccessObject;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Database.DatabaseConnect;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Airport.Entity.AirportEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class FlightDAO extends DatabaseConnect
{
    private String table = "`Voo`";
    private String airportTable = "`Aeroporto`";
    private PreparedStatement preparedStatement;

    public List<AbstractEntity> loadAirports()
    {
        List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
        String query = "SELECT * FROM " + airportTable + "ORDER BY idAeroporto ASC;";
        try {
            preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                AirportEntity airportEntity = new AirportEntity();
                airportEntity.setId(resultSet.getInt("idAeroporto"))
                             .setDescription(resultSet.getString("descricao"))
                             .setAbbreviation(resultSet.getString("sigla"))
                             .setAddress(resultSet.getString("endereco"))
                             .setDateRegister(resultSet.getDate("dataCadastro"));

                entities.add(airportEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return entities;
    }

    // public Boolean register(FlightEntity flightEntity)
    // {
    //     Boolean result = false;
    //     StringBuilder query = new StringBuilder();
    //     query.append("INSERT INTO " + table);
    //     query.append(" (`descricao`, `sigla`, `endereco`) VALUES");
    //     query.append(" (?, ?, ?);");
    //     try {
    //         preparedStatement = getConnection().prepareStatement(query.toString());
    //         preparedStatement.setString(1, flightEntity.getDescription());
    //         preparedStatement.setString(2, flightEntity.getAbbreviation());
    //         preparedStatement.setString(3, flightEntity.getAddress());
    //         preparedStatement.executeUpdate();
    //         result = true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     closeConnection();
    //     return result;
    // }

    // public Boolean update(FlightEntity flightEntity)
    // {
    //     Boolean result = false;
    //     StringBuilder query = new StringBuilder();
    //     query.append("UPDATE " + table);
    //     query.append(" SET `descricao` = ?");
    //     query.append(", `sigla` = ?");
    //     query.append(", `endereco` = ?");
    //     query.append(" WHERE `sigla` = ?");
    //     try {
    //         preparedStatement = getConnection().prepareStatement(query.toString());
    //         preparedStatement.setString(1, flightEntity.getDescription());
    //         preparedStatement.setString(2, flightEntity.getAbbreviation());
    //         preparedStatement.setString(3, flightEntity.getAddress());
    //         preparedStatement.setString(4, flightEntity.getAbbreviation());
    //         preparedStatement.executeUpdate();
    //         result = true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     closeConnection();
    //     return result;
    // }

    // public List<AbstractEntity> consult(String column, String search)
    // {
    //     List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
    //     StringBuilder query = new StringBuilder();
    //     query.append("SELECT * FROM " + table);
    //     query.append(" WHERE " + column + " LIKE ?");
    //     try {
    //         preparedStatement = getConnection().prepareStatement(query.toString());
    //         preparedStatement.setString(1, "%" + search + "%");
    //         ResultSet resultSet = preparedStatement.executeQuery();

    //         while(resultSet.next()) {
    //             FlightEntity flightEntity = new FlightEntity();
    //             entities.add(
    //                 flightEntity.setId(resultSet.getInt("idAeroporto"))
    //                              .setDescription(resultSet.getString("descricao"))
    //                              .setAbbreviation(resultSet.getString("sigla"))
    //                              .setAddress(resultSet.getString("endereco"))
    //                              .setDateRegister(resultSet.getDate("dataCadastro"))
    //             );
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     closeConnection();
    //     return entities;
    // }

    // public Boolean delete(FlightEntity flightEntity)
    // {
    //     Boolean result = false;
    //     StringBuilder query = new StringBuilder();
    //     query.append("DELETE FROM " + table);
    //     query.append(" WHERE `idAeroporto` = ?");
    //     try {
    //         preparedStatement = getConnection().prepareStatement(query.toString());
    //         preparedStatement.setInt(1, flightEntity.getId());
    //         preparedStatement.executeUpdate();
    //         result = true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     closeConnection();
    //     return result;
    // }
}
