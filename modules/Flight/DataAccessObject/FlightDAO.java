package project.modules.Flight.DataAccessObject;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Database.DatabaseConnect;
import project.modules.Flight.Entity.FlightEntity;
import project.modules.Airplane.DataAccessObject.AirplaneDAO;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airport.DataAccessObject.AirportDAO;
import project.modules.Airport.Entity.AirportEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.List;
import java.util.ArrayList;

public class FlightDAO extends DatabaseConnect
{
    private String table = "`Voo`";
    private String airportTable = "`Aeroporto`";
    private PreparedStatement preparedStatement;

    /**
     * Data Access Objects
     */
    private AirplaneDAO daoAirplane() { return new AirplaneDAO(); }
    private AirportDAO daoAirport() { return new AirportDAO(); }

    public List<AbstractEntity> loadAirports()
    {
        List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
        String query = "SELECT * FROM " + airportTable + "ORDER BY `idAeroporto` ASC;";
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

    public Boolean register(FlightEntity flightEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO " + table);
        query.append("(   `idAeronave`");
        query.append("  , `idAeroportoOrigem`");
        query.append("  , `idAeroportoDestino`");
        query.append("  , `valor`");
        query.append("  , `status`");
        query.append("  , `dataPartida`");
        query.append(") VALUES (?, ?, ?, ?, ?, ?)");
        try {
            DateFormat departureDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setInt(   1, flightEntity.getAirplane().getId());
            preparedStatement.setInt(   2, flightEntity.getAirportOrigin().getId());
            preparedStatement.setInt(   3, flightEntity.getAirportDestination().getId());
            preparedStatement.setDouble(4, flightEntity.getPrice());
            preparedStatement.setString(5, flightEntity.getStatus());
            preparedStatement.setDate(  6, new Date(flightEntity.getDateDeparture().getTime()));
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    public Boolean update(FlightEntity flightEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("UPDATE " + table);
        query.append(" SET");
        query.append("    `idAeronave` = ?");
        query.append("  , `idAeroportoOrigem` = ?");
        query.append("  , `idAeroportoDestino` = ?");
        query.append("  , `valor` = ?");
        query.append("  , `status` = ?");
        query.append("  , `dataPartida` = ?");
        query.append(" WHERE `idVoo` = ?;");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setInt(   1, flightEntity.getAirplane().getId());
            preparedStatement.setInt(   2, flightEntity.getAirportOrigin().getId());
            preparedStatement.setInt(   3, flightEntity.getAirportDestination().getId());
            preparedStatement.setDouble(4, flightEntity.getPrice());
            preparedStatement.setString(5, flightEntity.getStatus());
            preparedStatement.setDate(  6, new Date(flightEntity.getDateDeparture().getTime()));
            preparedStatement.setInt(   7, flightEntity.getId());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    public List<AbstractEntity> consult(String[] columns, String[] searches)
    {
        Integer count = 0;
        String where = "";
        for (String column : columns) {
            where += count > 0 ? " AND " : "";
            where += column + " = '" + searches[count] + "'";
            count++;
        }

        List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
        String query = "SELECT * FROM " + table + " WHERE " + where;
        try {
            preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                AirplaneEntity
                    airplaneEntity =
                        daoAirplane().consult(resultSet.getInt("idAeronave"));

                AirportEntity
                    airportOriginEntity =
                        daoAirport().consult(resultSet.getInt("idAeroportoOrigem"));

                AirportEntity
                    airportDestinationEntity =
                        daoAirport().consult(resultSet.getInt("idAeroportoDestino"));

                FlightEntity flightEntity = new FlightEntity();
                flightEntity.setId(resultSet.getInt("idVoo"))
                            .setAirplane(airplaneEntity)
                            .setAirportOrigin(airportOriginEntity)
                            .setAirportDestination(airportDestinationEntity)
                            .setPrice(resultSet.getDouble("valor"))
                            .setStatus(resultSet.getString("status"))
                            .setDateDeparture(resultSet.getDate("dataPartida"))
                            .setDateRegister(resultSet.getDate("dataCadastro"));

                entities.add(flightEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return entities;
    }

    public Boolean delete(FlightEntity flightEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM " + table);
        query.append(" WHERE `idVoo` = ?");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setInt(1, flightEntity.getId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }
}
