package service;

import repository.interfaces.GenericDAO;
import dto.response.AutorResponseDTO;
import api.message.error.business.AutorBusinessMessage;
import api.message.error.validation.AutorValidationMessage;
import model.AutorModel;
import exception.AutorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AutorService extends BaseService<AutorResponseDTO, AutorModel> {

    private GenericDAO<AutorModel> autorDAO;
    public AutorService(GenericDAO<AutorModel> autorDAO){
        this.autorDAO = autorDAO;
    }

    public void criarAutor(final String nomeAutor,final String nacionalidadeAutor){

        String id = UUID.randomUUID().toString();
        String nomeFormatado = (nomeAutor != null) ? nomeAutor.trim() : null;
        String nacionalidadeFormatado = (nacionalidadeAutor != null) ? nacionalidadeAutor.trim() : null;

        validarDadosCriarAutor(nomeFormatado, nacionalidadeFormatado);

        autorDAO.buscarPorNome(nomeFormatado)
                .ifPresent(a -> {
                    throw new AutorException(
                            409,
                            AutorBusinessMessage.AUTOR_JA_CADASTRADO.getMessage()
                    );
                });

        boolean inserirAutor = autorDAO.inserir(new AutorModel(id, nomeFormatado, nacionalidadeFormatado));

        if(!inserirAutor){
            throw new AutorException(404, AutorBusinessMessage.AUTOR_NAO_INSERIDO.getMessage());
        }

    };

    public AutorResponseDTO buscarAutorPorId(final String id){

        String idFormatado = (id != null) ? id.trim() : null;
        validarString(idFormatado);

        Optional<AutorModel> autorModel = autorDAO.buscarPorId(idFormatado);
        return mapRow(
                autorModel.orElseThrow(() -> new AutorException(404, AutorBusinessMessage.AUTOR_NAO_ENCONTRADO_POR_ID.getMessage()))
        );
    }

    public AutorResponseDTO buscarAutorPorNome(final String nome){
        String nomeFormatado = (nome != null) ? nome.trim() : null;
        validarString(nomeFormatado);

        Optional<AutorModel> autorModel = autorDAO.buscarPorNome(nomeFormatado);
        return mapRow(
                autorModel.orElseThrow(() -> new AutorException(404,AutorBusinessMessage.AUTOR_NAO_ENCONTRADO_POR_NOME.getMessage()))
        );
    }

    public void excluirAutorPorId(String id){
        validarString(id);

        boolean excluirAutor = autorDAO.excluir(id.trim());
        if(!excluirAutor) {
            throw new AutorException(404, AutorBusinessMessage.AUTOR_NAO_PODE_SER_EXCLUIDO.getMessage());
        }
    }

    public List<AutorResponseDTO> listaDeAutores(){

        List<AutorModel> selectAll = autorDAO.selectAll();
        return mapList(selectAll);
    }

    private void validarString(String... validar){
        for(String s : validar){
            if(s == null || s.isBlank()){
                throw new AutorException(400, AutorValidationMessage.VALIDAR_STRING.getMessage());
            }
        }
    }

    private void validarDadosCriarAutor(String nomeFormatado, String nacionalidadeFormatado){

        validarString(nomeFormatado, nacionalidadeFormatado);

        if(nomeFormatado.length() < 3){
            throw new AutorException(400, AutorValidationMessage.TAMANHO_MIN_NOME_AUTOR.getMessage());
        }

        if(nomeFormatado.length() > 50){
            throw  new AutorException(400, AutorValidationMessage.TAMANHO_MAX_NOME_AUTOR.getMessage());
        }

        if(nacionalidadeFormatado.length() < 3){
            throw new AutorException(400, AutorValidationMessage.TAMANHO_MIN_NACIONALIDADE_AUTOR.getMessage());
        }

        if(nacionalidadeFormatado.length() > 50){
            throw  new AutorException(400, AutorValidationMessage.TAMANHO_MAX_NACIONALIDADE_AUTOR.getMessage());
        }
    }

    @Override
    protected AutorResponseDTO mapRow(AutorModel autorModel) {
        return new AutorResponseDTO(autorModel.getId(), autorModel.getNome(), autorModel.getNacionalidade());
    }
}
