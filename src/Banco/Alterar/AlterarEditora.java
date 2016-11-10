package Banco.Alterar;

import Banco.ConnectionFactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Created by Douglas on 09/11/2016.
 */
public class AlterarEditora {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("Abrindo Conexão");
            Connection conexao = ConnectionFactory.createConnection();

            System.out.println("Digite o nome da editora: ");
            String nome = entrada.nextLine();
            System.out.println("Digite o email da editora");
            String email = entrada.nextLine();

            String sql = "INSERT INTO Editora (nome, email) " + "VALUES (?, ?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, nome);
            comando.setString(2, email);

            System.out.println("Executando Comando...");
            comando.execute();
            System.out.println("Fechando Conexão...");
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
