import Banco.ConnectionFactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Douglas on 09/11/2016.
 */
public class Livro {
    public String titulo;
    public double preco;
    public int editora_id;

    public void ler() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o titulo do livro: ");
        titulo = entrada.nextLine();
        System.out.println("Digite o preço do livro: ");
        preco = entrada.nextDouble();
        System.out.println("Digite o id da Editora: ");
        editora_id = entrada.nextInt();

    }

    public void insere() {
        try {
            System.out.println("Abrindo Conexão...");
            Connection conexao = ConnectionFactory.createConnection();

            String sql = "INSERT INTO Livro(titulo, preco, editora_id)" +
                    "VALUES ('" + this.titulo + "', '" + this.preco + "'," + this.editora_id + ")";

            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando comando...");
            comando.execute();
            System.out.println("Fechando conexão...");
            conexao.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listar() {
        try {
            System.out.println("Abrindo conexão...");

            Connection conexao = ConnectionFactory.createConnection();
            String sql = "SELECT * FROM Livro;";
            PreparedStatement comando = conexao.prepareStatement(sql);

            System.out.println("Executando Comando...");
            ResultSet resultado = comando.executeQuery();

            System.out.println("Resultados encontrados: \n");
            while (resultado.next()) {
                System.out.printf("%d: %s - %f - %d\n",
                        resultado.getInt("id"),
                        resultado.getString("titulo"),
                        resultado.getDouble("preco"),
                        resultado.getInt("editora_id"));
            }

            System.out.println("\nFechando conexão...");
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
