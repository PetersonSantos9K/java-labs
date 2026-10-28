package api.message.sucess;

public enum AutorSuccessMessage {

    // varios enums de mensagens de sucesso para as operações relacionadas a autores

    AUTORES_ENCONTRADOS_SUCESS("Autores encontrados com sucesso."),
    AUTOR_ENCONTRADO_POR_ID_SUCESS("Autor encontrado por ID com sucesso."),
    AUTOR_ENCONTRADO_POR_NOME_SUCESS("Autor encontrado por nome com sucesso."),
    AUTOR_CADASTRADO_SUCESS("Autor cadastrado com sucesso."),
    AUTOR_EXCLUIDO_SUCESS("Autor removido com sucesso");

    private final String message;
    AutorSuccessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
