package api.message.error.database;

public enum AutorDatabaseMessage {
    ERRO_INSERIR_AUTOR("Erro ao inserir autor no banco de dados."),
    ERRO_BUSCAR_AUTOR_ID("Erro ao buscar autor por id no banco de dados."),
    ERRO_EXCLUIR_AUTOR_ID("Erro ao excluir autor do banco de dados."),
    ERRO_BUSCAR_AUTORES("Erro ao buscar os autores no banco de dados"),
    ERRO_BUSCAR_AUTOR_NOME("Erro ao buscar autor por nome no banco de dados.");

    private final String message;
    AutorDatabaseMessage(String message){
        this.message =message;
    }

    public String getMessage(){
        return message;
    }
}
