package api.message.error.business;

public enum AutorBusinessMessage {
    AUTOR_JA_CADASTRADO("Já existe um autor cadastrado com esse nome."),
    AUTOR_NAO_INSERIDO("Não foi possível inserir o autor."),
    AUTOR_NAO_ENCONTRADO_POR_ID("Não foi possível encontrar o autor com o ID fornecido."),
    AUTOR_NAO_ENCONTRADO_POR_NOME("Não foi possível encontrar o autor com o nome fornecido."),
    AUTOR_NAO_PODE_SER_EXCLUIDO("Não foi possível excluir o autor com o id fornecido."),
    AUTORES_NAO_ENCONTRADOS("Não foi possível encontrar autores cadastrados.");

    private final String message;
    AutorBusinessMessage(String message){
        this.message =message;
    }

    public String getMessage(){
        return message;
    }
}
