package project.modules.Airport.DataAccessObject;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Database.DatabaseConnect;
import project.modules.Airport.Entity.AirportEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AirportDAO extends DatabaseConnect
{
    private String table = "`Aeroporto`";
    private PreparedStatement preparedStatement;

    public Boolean register(AirportEntity airportEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO " + table);
        query.append(" (descricao, sigla, endereco) VALUES");
        query.append(" (?, ?, ?);");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, airportEntity.getDescription());
            preparedStatement.setString(2, airportEntity.getAbbreviation());
            preparedStatement.setString(3, airportEntity.getAddress());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    public List<AbstractEntity> consultBy(String column, String search)
    {
        List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM " + table);
        query.append(" WHERE " + column + " LIKE ?");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, "%" + search + "%");
            System.out.println(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                AirportEntity airportEntity = new AirportEntity();
                entities.add(
                    airportEntity.setId(resultSet.getInt("idAeroporto"))
                                 .setDescription(resultSet.getString("descricao"))
                                 .setAbbreviation(resultSet.getString("sigla"))
                                 .setAddress(resultSet.getString("endereco"))
                                 .setDateRegister(resultSet.getDate("dataCadastro"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return entities;
    }
}
