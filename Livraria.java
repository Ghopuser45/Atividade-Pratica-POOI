import java.util.LinkedHashMap;
import java.util.Map;

/**
 * POO I - Atividade Pratica JCF
 *
 * @author gustavohenrique
*/

public class Livraria {
    private Map<String, Livro> livros;

    public Livraria() {
        this.livros = new LinkedHashMap<>();
    }

    public int incluirLivro(Livro livro) {
        if (livro == null || livros.containsKey(livro.getIsbn())) {
            return 0;
        }
        livros.put(livro.getIsbn(), livro);
        return 1;
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros.values()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void listarLivros(int ano) {
        boolean encontrou = false;
        for (Livro livro : livros.values()) {
            if (livro.getAnoPublicacao() >= ano) {
                System.out.println(livro);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro encontrado com ano maior ou igual à" + ano + ".");
        }
    }

    public int excluirLivro(String isbn) {
        return livros.remove(isbn) != null ? 1 : 0;
    }
}