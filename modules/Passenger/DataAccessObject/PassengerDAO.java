package project.modules.Pessenger.DataAccessObject;

import project.modules.Database.DatabaseConnect;
import project.modules.Passenger.Entity.PassengerEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDAO extends DatabaseConnect
{
    private String table = "`Passageiro`";
    private PreparedStatement preparedStatement;

    public Boolean register(PassengerEntity passengerEntity)
    {
        Boolean result = false;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO " + table);
        query.append(" (");
        query.append("     `formaTratamento`");
        query.append("   , `nomeCompleto`");
        query.append("   , `genero`");
        query.append("   , `dataNascimento`");
        query.append("   , `perfil`");
        query.append("   , `cpf`");
        query.append("   , `email`");
        query.append("   , `telefone`");
        query.append("   , `responsavel`) VALUES");
        query.append(" (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        try {
            preparedStatement = getConnection().prepareStatement(query.toString());
            preparedStatement.setString(    1, passengerEntity.getSalutation());
            preparedStatement.setString(    2, passengerEntity.getFullName());
            preparedStatement.setString(    3, String.valueOf(passengerEntity.getGender()));
            preparedStatement.setDate(      4, new Date(passengerEntity.getDateBirth().getTime()));
            preparedStatement.setString(    5, passengerEntity.getProfile());
            preparedStatement.setLong(      6, passengerEntity.getCpf());
            preparedStatement.setString(    7, passengerEntity.getEmail());
            preparedStatement.setString(    8, passengerEntity.getPhone());
            preparedStatement.setBoolean(   9, passengerEntity.getResponsible());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result;
    }
    // public Boolean update();
    // public PassengerEntity consult(Integer id);
    // public List<PassengerEntity> consult(String[] columns, String[] values);
    // public Boolean delete();
}
