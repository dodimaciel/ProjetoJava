import java.util.Scanner;

/**
 * Created by Douglas on 09/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        /**Editora editora = new Editora();
         editora.lerEditora();
         editora.insere();**/

        Livro livro = new Livro();

        int opmaster = 0;
        Scanner tc = new Scanner(System.in);

        do {

            System.out.println(" *** Digite a opção desejada Master *** ");
            System.out.println("1 - LIVRO");
            System.out.println("2 - EDITORA");
            System.out.println("3 - SAIR");
            opmaster = tc.nextInt();

            switch (opmaster) {

                case 1:
                    int op = 0;
                    do {
                        System.out.println(" *** Digite a opção desejada *** ");
                        System.out.println(" --- 1 LER --- ");
                        System.out.println(" --- 2 LISTAR --- ");
                        System.out.println(" --- 3 SAIR --- ");
                        op = tc.nextInt();

                        switch (op) {
                            case 1:
                                livro.ler();
                                livro.insere();
                                break;
                            case 2:
                                livro.listar();
                                break;
                            case 3:
                                break;

                        }
                    } while (op != 3);
                    break;

                case 2:
                    Editora editora = new Editora();
                    do {
                        System.out.println(" *** Digite a opção desejada *** ");
                        System.out.println(" --- 1 LER --- ");
                        System.out.println(" --- 2 LISTAR --- ");
                        System.out.println(" --- 3 DELETAR ---");
                        System.out.println(" --- 4 UPDATE --- ");
                        System.out.println(" --- 5 SAIR --- ");
                        op = tc.nextInt();

                        switch (op) {
                            case 1:
                                editora.lerEditora();
                                editora.insere();
                                break;
                            case 2:
                                editora.listar();
                                break;
                            case 3:
                                editora.delete();
                                break;
                            case 4:
                                editora.update();
                                break;
                            case 5:
                                break;
                        }
                    } while (op != 5);
            }

        } while (opmaster != 3);
    }
}
