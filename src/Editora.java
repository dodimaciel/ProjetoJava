import Banco.ConnectionFactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Douglas on 09/11/2016.
 */
public class Editora {
    public String nome;
    public String email;

    Scanner entrada = new Scanner(System.in);

    public void lerEditora() {
        System.out.println("Digite o nome da editora: ");
        nome = entrada.next();
        System.out.println("Digite o email da editora: ");
        email = entrada.next();
    }

    public void insere() {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO Editora(nome, email)" +
                    "VALUES ('" + this.nome + "', '" + this.email + "')";

            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando comando...");
            comando.execute();
            System.out.println("Fechando conexão...");
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            System.out.println("Abrindo conexão...");

            Connection conexao = ConnectionFactory.createConnection();
            String sql = "SELECT * FROM Editora;";
            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando Comando...");
            ResultSet resultado = comando.executeQuery();

            System.out.println("Resultados encontrados: \n");
            while (resultado.next()) {
                System.out.printf("Editora: %s  \nEmail: %s \nID: %d\n",
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getInt("id"));
            }

            System.out.println("\nFechando conexão...");
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            Connection conexao = ConnectionFactory.createConnection();
            System.out.println("Abrindo Conexão... ");
            String name;

            listar();
            System.out.println("Digite o nome desejado: ");
            name = entrada.next();
            String sql = "DELETE FROM Editora where nome = '" + name + "'";
            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando comando...");
            comando.execute();
            System.out.println("\nFechando Conexão...");
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            System.out.println("Abrindo Conexão");
            Connection conexao = ConnectionFactory.createConnection();

            listar();
            System.out.println("Digite o id da editora: ");
            int ide = entrada.nextInt();

                String sql = "UPDATE Editora SET nome, email " + "WHERE ";

                PreparedStatement comando = conexao.prepareStatement(sql);

                System.out.println("Executando Comando...");
                comando.execute();
                System.out.println("Fechando Conexão...");
                conexao.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
