package Author;

import java.util.UUID;

public class AuthorResponseDTO {

    private UUID id;
    private String nome;
    private String nacionalidade;

    public AuthorResponseDTO(UUID id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}
