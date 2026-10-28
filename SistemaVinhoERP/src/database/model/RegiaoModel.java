package database.model;

public class RegiaoModel {

    private Long id;
    private Long paisId;
    private String nome;

    public RegiaoModel(){};

    public RegiaoModel(Long id, Long paisId, String nome) {
        this.id = id;
        this.paisId = paisId;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
