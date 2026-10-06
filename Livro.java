/**
 * POO I - Atividade Pratica JCF
 *
 * @author gustavohenrique 
*/

public class Livro {
    private String isbn;
    private String titulo;
    private int anoPublicacao;

    public Livro(String isbn, String titulo, int anoPublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " || Título: " + titulo + " || Ano: " + anoPublicacao;
    }
}
