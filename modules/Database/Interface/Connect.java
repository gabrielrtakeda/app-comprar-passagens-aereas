package project.modules.Database.Interface;

import java.sql.Connection;

public interface Connect {

public Connection getConnection();

public void closeConnection();
}
