package service;

import repository.interfaces.LivroDAO;
import dto.response.LivroResponseDTO;
import api.message.error.business.LivroBusinessMessage;
import api.message.error.validation.LivroValidationMessage;
import model.LivroModel;
import exception.LivroException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LivroService extends BaseService<LivroResponseDTO, LivroModel> {

    private LivroDAO<LivroModel> livroDAO;

    private AutorService autorService;
    public LivroService(final AutorService autorService, final LivroDAO<LivroModel> livroDAO){
        this.autorService = autorService;
        this.livroDAO = livroDAO;
    }

    public void criarLivro(String titulo, Integer anoPublicacao, String autorId) {

        String id = UUID.randomUUID().toString();
        String tituloFormatado = (titulo != null) ? titulo.trim() : null;
        String autorIdFormatado = (autorId != null) ? autorId.trim() : null;

        validarDadosCriarLivro(tituloFormatado, anoPublicacao, autorIdFormatado);

        autorService.buscarAutorPorId(autorId);

        livroDAO.buscarPorNome(tituloFormatado)
                .orElseThrow(() -> new LivroException(409, LivroBusinessMessage.LIVRO_JA_CADASTRADO.getMessage()));

        boolean inserirLivro = livroDAO.inserir(new LivroModel(id, tituloFormatado, anoPublicacao, autorIdFormatado));

        if (!inserirLivro) {
            throw new LivroException(404, LivroBusinessMessage.LIVRO_NAO_INSERIDO.getMessage());
        }
    }

    public LivroResponseDTO buscarLivroPorId(String id) {

        if (id == null) {
            throw new LivroException(400, LivroValidationMessage.VALIDAR_STRING.getMessage());
        }

        Optional<LivroModel> livroModel = livroDAO.buscarPorId(id.trim());
        return mapRow(
                livroModel.orElseThrow(() -> new LivroException(404, LivroBusinessMessage.LIVRO_NAO_ENCONTRADO_POR_ID.getMessage()))
        );
    }

    public LivroResponseDTO buscarLivroPorTitulo(String titulo) {
        validarString(titulo);
        Optional<LivroModel> livroModel = livroDAO.buscarPorNome(titulo.trim());

        return mapRow(
            livroModel.orElseThrow(() -> new LivroException(404, LivroBusinessMessage.LIVRO_NAO_ENCONTRADO_POR_TITULO.getMessage()))
        );
    }

    public void excluirLivroPorId(String id) {
        validarString(id);

        boolean excluirLivro = livroDAO.excluir(id.trim());
        if (!excluirLivro) {
            throw new LivroException(500, LivroBusinessMessage.LIVRO_NAO_PODE_SER_EXCLUIDO.getMessage());
        }
    }

    public List<LivroResponseDTO> listaDeLivros() {

        List<LivroModel> selectAll = livroDAO.selectAll();
        return mapList(selectAll);
    }

    public List<LivroResponseDTO> listaDeLivrosPorAutor(String autorId) {
        validarString(autorId);

        autorService.buscarAutorPorId(autorId);

        List<LivroModel> livrosPorAutor = livroDAO.buscarLivrosPorAutor(autorId.trim());
        return mapList(livrosPorAutor);
    }

    private void validarString(String... validar) {
        for (String s : validar) {
            if (s == null || s.isBlank()) {
                throw new LivroException(400, LivroValidationMessage.VALIDAR_STRING.getMessage());
            }
        }
    }

    private void validarDadosCriarLivro(String tituloFormatado, Integer anoPublicacao, String autorIdFormatado) {

        validarString(tituloFormatado, autorIdFormatado);

        if (tituloFormatado.length() < 3) {
            throw new LivroException(400, LivroValidationMessage.TAMANHO_MIN_TITULO_LIVRO.getMessage());
        }

        if (tituloFormatado.length() > 50) {
            throw new LivroException(400,LivroValidationMessage.TAMANHO_MAX_TITULO_LIVRO.getMessage());
        }

        if (anoPublicacao == null) {
            throw new LivroException(400,LivroValidationMessage.ANO_PUBLICACAO_NULL.getMessage());
        }

        if (anoPublicacao < 1) {
            throw new LivroException(400, LivroValidationMessage.ANO_PUBLICACAO_INVALIDO.getMessage());
        }

        if(anoPublicacao > LocalDate.now().getYear()){
            throw new LivroException(400, LivroValidationMessage.ANO_PUBLICACAO_FUTURO.getMessage());
        }
    }

    @Override
    protected LivroResponseDTO mapRow(LivroModel row) {
        return new LivroResponseDTO(row.getId(), row.getTitulo(), row.getAnoPublicacao(), row.getAutorId());
    }

}