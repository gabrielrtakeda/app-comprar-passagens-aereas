package project.modules.Database.Drivers;

import project.modules.Database.Interface.Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public abstract class MysqlConnect implements Connect {

// atributo
public Connection conn;

// construtor
    public MysqlConnect() {
        conn = null;
        String url = "jdbc:mysql://127.0.0.1:3306/"; // localizacao do servidor
        String dbName = "projeto_integrado"; // nome do banco de dados
        String driver = "com.mysql.jdbc.Driver"; // nome do driver de conexao
        String userName = "alunos"; // nome do usuario do banco
        String password = "usjt@but2010"; // respectiva senha
        // String url = "jdbc:mysql://localhost:8889/"; // localizacao do servidor
        // String userName = "root"; // nome do usuario do banco
        // String password = "root"; // respectiva senha

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
                "Erro...",
                JOptionPane.WARNING_MESSAGE
            );
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
