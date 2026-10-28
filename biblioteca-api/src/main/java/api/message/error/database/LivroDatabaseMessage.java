package api.message.error.database;

public enum LivroDatabaseMessage {
    ERRO_INSERIR_LIVRO("Erro ao inserir livro no banco de dados."),
    ERRO_BUSCAR_LIVRO_ID("Erro ao buscar livro por id no banco de dados."),
    ERRO_EXCLUIR_LIVRO_ID("Erro ao excluir livro do banco de dados."),
    ERRO_BUSCAR_LIVROS_AUTOR("Erro ao buscar livros por autor no banco de dados."),
    ERRO_BUSCAR_LIVROS("Erro ao buscar livros no banco de dados"),
    ERRO_BUSCAR_LIVRO_NOME("Erro ao buscar livro por nome no banco de dados.");

    private final String message;
    LivroDatabaseMessage(String message){
        this.message =message;
    }

    public String getMessage(){
        return message;
    }
}
