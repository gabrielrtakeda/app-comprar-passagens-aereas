package project.modules.Passage.DataAccessObject;

import project.modules.Database.DatabaseConnect;
import project.modules.Passage.Entity.PassageEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PassageDAO extends DatabaseConnect
{
    private String table = "`Passagem`";
    private PreparedStatement preparedStatement;

    // public Boolean register();
    // public Boolean update();
    // public PassageEntity consult(Integer id);
    // public List<PassageEntity> consult(String[] colums, String[] searches);
    // public Boolean delete();
}
