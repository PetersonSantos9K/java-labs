package dto.response;

public class AutorResponseDTO {

    private String id;
    private String nome;
    private String nacionalidade;

    public AutorResponseDTO(String id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}
