package Banco.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Douglas on 09/11/2016.
 */
public class ConnectionFactory {
    public static Connection createConnection() {
        String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
        String usuario = "root";
        String senha = "imortal10";

        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }
}
