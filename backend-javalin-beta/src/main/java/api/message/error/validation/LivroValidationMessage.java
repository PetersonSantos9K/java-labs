package api.message.error.validation;

public enum LivroValidationMessage {
    VALIDAR_STRING("É necessário informar um valor."),

    TAMANHO_MIN_TITULO_LIVRO("É necessário que o título tenha no mínimo 3 caractere."),
    TAMANHO_MAX_TITULO_LIVRO("É necessário que o título tenha no máximo 50 caracteres."),

    ANO_PUBLICACAO_NULL("O ano de publicação não pode ser nulo."),
    ANO_PUBLICACAO_INVALIDO("O ano de publicação deve ser maior que zero."),
    ANO_PUBLICACAO_FUTURO("O ano de publicacão não pode ser maior que o ano atual."),
    ID_LIVRO_NULL("O id do livro não pode ser nulo.");

    private final String message;

    LivroValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
