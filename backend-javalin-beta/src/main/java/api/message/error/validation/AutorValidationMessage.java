package api.message.error.validation;

public enum AutorValidationMessage {

    VALIDAR_STRING("É necessário informar um valor."),

    TAMANHO_MIN_NOME_AUTOR("É necessário que o nome tenha no mínimo 3 caracteres."),
    TAMANHO_MAX_NOME_AUTOR("É necessário que o nome tenha no máximo 50 caracteres."),

    TAMANHO_MIN_NACIONALIDADE_AUTOR("É necessário que a nacionalidade tenha no mínimo 3 caracteres."),
    TAMANHO_MAX_NACIONALIDADE_AUTOR("É necessário que a nacionalidade tenha no máximo 50 caracteres."),
    ID_AUTOR_NULL("Id invalido.");

    private final String message;
    AutorValidationMessage(String message){
        this.message =message;
    }

    public String getMessage(){
        return message;
    }
}
