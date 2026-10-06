import java.util.Scanner;

/**
 * POO I - Atividade Pratica JCF
 *
 * @author gustavohenrique
*/

public class Main {
    private static Livraria livraria = new Livraria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        montaMenu();
        scanner.close();
    }

    private static void montaMenu() {
        int opcao;
        do {
            System.out.println("\n=====| LIVRARIA |=====");
            System.out.println("Digite [1] para incluir livro");
            System.out.println("Digite [2] para buscar livro por título");
            System.out.println("Digite [3] para listar livros (maior ou igual ao ano de publicação informado)");
            System.out.println("Digite [4] para excluir livro por ISBN");
            System.out.println("Digite [5] para sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine().trim();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine().trim();
                    System.out.print("Ano de publicação: ");
                    int ano = lerInteiro();
                    if (livraria.incluirLivro(new Livro(isbn, titulo, ano)) == 1) {
                        System.out.println("Livro incluído com sucesso!");
                    } else {
                        System.out.println("Não foi possível incluir: ISBN já cadastrado.");
                    }
                    break;
                case 2:
                    System.out.print("Título: ");
                    Livro encontrado = livraria.buscarLivro(scanner.nextLine().trim());
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ano mínimo: ");
                    livraria.listarLivros(lerInteiro());
                    break;
                case 4:
                    System.out.print("ISBN: ");
                    if (livraria.excluirLivro(scanner.nextLine().trim()) == 1) {
                        System.out.println("Livro excluído com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado, nada foi excluído.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
