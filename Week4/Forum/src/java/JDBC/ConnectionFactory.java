package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static{
            try {
                    Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
	}
	
	public static Connection getConexao() {
            try {
                    String url = "jdbc:postgresql://localhost/forum";
                    Connection conexao = DriverManager.getConnection(
                                    url, "postgres", "chege");
                    return conexao;
            } catch (SQLException e) {
                    throw new RuntimeException("Erro ao conectar banco de dados", e);
            }
	}
    
}
