package api.message.error.business;

public enum LivroBusinessMessage {
    LIVRO_JA_CADASTRADO("Já existe um livro cadastrado com esse título."),
    AUTOR_NAO_ENCONTRADO("É necessário informar um autor previamente cadastrado."),
    LIVRO_NAO_INSERIDO("Não foi possível inserir o livro."),
    LIVRO_NAO_ENCONTRADO_POR_ID("Não foi possível encontrar o livro com o ID fornecido."),
    LIVRO_NAO_ENCONTRADO_POR_TITULO("Não foi possível encontrar o livro com o titulo fornecido."),
    LIVRO_NAO_PODE_SER_EXCLUIDO("Não foi possível excluir o livro com o id fornecido."),
    LIVROS_NAO_ENCONTRADOS("Não foi possível encontrar livros cadastrados."),
        LIVROS_NAO_ENCONTRADOS_POR_AUTOR("Não foi possível encontrar livros cadastrados para o autor informado.");
    private final String message;
    LivroBusinessMessage(String message){
        this.message =message;
    }

    public String getMessage(){
        return message;
    }
}
