package model ;

public class AutorModel {

    private String id;
    private String nome;
    private String nacionalidade;

    public AutorModel(String id, String nome, String nacionalidade) {
        this.id = id;
        this.nacionalidade = nacionalidade;
        this.nome = nome;
    }

    public AutorModel(String nome, String nacionalidade){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public AutorModel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
