package project.modules.Airplane.DataAccessObject;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Database.DatabaseConnect;
import project.modules.Airplane.Entity.AirplaneEntity;
import project.modules.Airplane.Type.AirplaneEntityComboType;
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
        query.append("   , `familia`");
        query.append("   , `modelo`");
        query.append("   , `status`");
        query.append(" ) VALUES (?, ?, ?, ?);");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, airplaneEntity.getDescription());
            preparedStatement.setString(2, airplaneEntity.getFamily());
            preparedStatement.setString(3, airplaneEntity.getModel());
            preparedStatement.setString(4, airplaneEntity.getStatus());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    public Boolean update(AirplaneEntity airplaneEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("UPDATE " + table);
        query.append(" SET");
        query.append(" `descricao` = ?");
        query.append(", `familia` = ?");
        query.append(", `modelo` = ?");
        query.append(", `status` = ?");
        query.append(" WHERE `modelo` = ?");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(1, airplaneEntity.getDescription());
            preparedStatement.setString(2, airplaneEntity.getFamily());
            preparedStatement.setString(3, airplaneEntity.getModel());
            preparedStatement.setString(4, airplaneEntity.getStatus());
            preparedStatement.setString(5, airplaneEntity.getModel());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    public List<AbstractEntity> consult(String column, String search)
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
                              .setFamily(resultSet.getString("familia"))
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

    public List<AirplaneEntityComboType> loadComboType()
    {
        List<AirplaneEntityComboType> types = new ArrayList<AirplaneEntityComboType>();
        String query = "SELECT * FROM " + table + " ORDER BY `modelo` ASC;";
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                AirplaneEntityComboType airplaneEntity = new AirplaneEntityComboType();
                airplaneEntity.setId(resultSet.getInt("idAeronave"))
                              .setDescription(resultSet.getString("descricao"))
                              .setFamily(resultSet.getString("familia"))
                              .setModel(resultSet.getString("modelo"))
                              .setSeatsTotal(resultSet.getInt("assentosTotal"))
                              .setSeatsVacantTotal(resultSet.getInt("assentosVagosTotal"))
                              .setStatus(resultSet.getString("status"))
                              .setDateRegister(resultSet.getDate("dataCadastro"));

                types.add(airplaneEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return types;
    }

    public Boolean delete(AirplaneEntity airplaneEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM " + table);
        query.append(" WHERE `idAeronave` = ?");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setInt(1, airplaneEntity.getId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }
}
