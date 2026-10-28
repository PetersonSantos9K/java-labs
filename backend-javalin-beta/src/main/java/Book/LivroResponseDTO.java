package Book;

public class LivroResponseDTO {

    private String id;
    private String titulo;
    private int anoPublicacao;
    private String nomeAutor;

    public LivroResponseDTO(String id, String titulo, int anoPublicacao, String nomeAutor) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.nomeAutor = nomeAutor;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

}
