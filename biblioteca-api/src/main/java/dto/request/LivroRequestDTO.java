package dto.request;

public class LivroRequestDTO {

    private String titulo;
    private int anoPublicacao;
    private int autorId;

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getAutorId() {
        return autorId;
    }

}
