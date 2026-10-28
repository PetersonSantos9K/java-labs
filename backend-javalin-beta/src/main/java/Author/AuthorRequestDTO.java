package Author;

public class AuthorRequestDTO {

    private String nome;
    private String nacionalidade;

    public AuthorRequestDTO(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }


}
