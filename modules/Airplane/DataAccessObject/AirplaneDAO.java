package project.modules.Airplane.DataAccessObject;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Database.DatabaseConnect;
import project.modules.Airplane.Entity.AirplaneEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AirplaneDAO extends DatabaseConnect
{
    private String table = "`Aeronave`";
    private PreparedStatement preparedStatement;

    public Boolean register(AirplaneEntity airplaneEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO " + table);
        query.append(" (   `descricao`");
        query.append("   , `categoria`");
        query.append("   , `modelo`");
        query.append("   , `assentosTotal`");
        query.append("   , `assentosVagosTotal`");
        query.append("   , `status`");
        query.append(" ) VALUES (?, ?, ?, ?, ?, ?);");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, airplaneEntity.getDescription());
            preparedStatement.setString(2, airplaneEntity.getCategory());
            preparedStatement.setString(3, airplaneEntity.getModel());
            preparedStatement.setInt(   4, airplaneEntity.getSeatsTotal());
            preparedStatement.setInt(   5, airplaneEntity.getSeatsVacantTotal());
            preparedStatement.setString(6, airplaneEntity.getStatus());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    // public Boolean update(AirplaneEntity airplaneEntity)
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
    //         preparedStatement.setString(1, airplaneEntity.getDescription());
    //         preparedStatement.setString(2, airplaneEntity.getAbbreviation());
    //         preparedStatement.setString(3, airplaneEntity.getAddress());
    //         preparedStatement.setString(4, airplaneEntity.getAbbreviation());
    //         preparedStatement.executeUpdate();
    //         result = true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     closeConnection();
    //     return result;
    // }

    public List<AbstractEntity> consultBy(String column, String search)
    {
        List<AbstractEntity> entities = new ArrayList<AbstractEntity>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM " + table);
        query.append(" WHERE " + column + " LIKE ?");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                AirplaneEntity airplaneEntity = new AirplaneEntity();
                airplaneEntity.setId(resultSet.getInt("idAeronave"))
                              .setDescription(resultSet.getString("descricao"))
                              .setCategory(resultSet.getString("categoria"))
                              .setModel(resultSet.getString("modelo"))
                              .setSeatsTotal(resultSet.getInt("assentosTotal"))
                              .setSeatsVacantTotal(resultSet.getInt("assentosVagosTotal"))
                              .setStatus(resultSet.getString("status"))
                              .setDateRegister(resultSet.getDate("dataCadastro"));

                entities.add(airplaneEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return entities;
    }

    // public Boolean delete(AirplaneEntity airplaneEntity)
    // {
    //     Boolean result = false;
    //     StringBuilder query = new StringBuilder();
    //     query.append("DELETE FROM " + table);
    //     query.append(" WHERE `idAeroporto` = ?");
    //     try {
    //         preparedStatement = getConnection().prepareStatement(query.toString());
    //         preparedStatement.setInt(1, airplaneEntity.getId());
    //         preparedStatement.executeUpdate();
    //         result = true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     closeConnection();
    //     return result;
    // }
}
