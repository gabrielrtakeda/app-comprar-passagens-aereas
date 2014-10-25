package project.modules.Airplane.DataAccessObject;

import project.modules.Application.Entity.AbstractEntity;
import project.modules.Database.DatabaseConnect;
import project.modules.Airplane.Entity.SeatEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class SeatDAO extends DatabaseConnect
{
    private String table = "`Assento`";
    private PreparedStatement preparedStatement;

    public Boolean register(SeatEntity seatEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO " + table);
        query.append(" (   `idAeronave`");
        query.append("   , `classe`");
        query.append("   , `localizacao`");
        query.append("   , `status`");
        query.append(") VALUES (?, ?, ?, ?);");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setInt(   1, seatEntity.getAirplaneId());
            preparedStatement.setString(2, seatEntity.getKind());
            preparedStatement.setString(3, seatEntity.getLocation());
            preparedStatement.setString(4, seatEntity.getStatus());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }

    // public Boolean update(SeatEntity seatEntity)
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
    //         preparedStatement.setString(1, seatEntity.getDescription());
    //         preparedStatement.setString(2, seatEntity.getAbbreviation());
    //         preparedStatement.setString(3, seatEntity.getAddress());
    //         preparedStatement.setString(4, seatEntity.getAbbreviation());
    //         preparedStatement.executeUpdate();
    //         result = true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     closeConnection();
    //     return result;
    // }

    // public List<AbstractEntity> consultBy(String column, String search)
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
    //             SeatEntity seatEntity = new SeatEntity();
    //             entities.add(
    //                 seatEntity.setId(resultSet.getInt("idAeroporto"))
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

    // public Boolean delete(SeatEntity seatEntity)
    // {
    //     Boolean result = false;
    //     StringBuilder query = new StringBuilder();
    //     query.append("DELETE FROM " + table);
    //     query.append(" WHERE `idAeroporto` = ?");
    //     try {
    //         preparedStatement = getConnection().prepareStatement(query.toString());
    //         preparedStatement.setInt(1, seatEntity.getId());
    //         preparedStatement.executeUpdate();
    //         result = true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     closeConnection();
    //     return result;
    // }
}
