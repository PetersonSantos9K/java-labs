package Author;

import api.message.error.business.AuthorBusinessMessage;
import api.message.error.validation.ValidationMessage;
import exception.AuthorException;
import exception.ValidationException;
import jakarta.validation.constraints.NotNull;
import util.MapService;

import java.util.List;
import java.util.UUID;

public class AuthorService extends MapService<AuthorResponseDTO, AuthorModel> {

    AuthorDAO<AuthorModel> repository;

    public AuthorService(AuthorDAO<AuthorModel> dao){
        repository = dao;
    }

    public AuthorResponseDTO createAuthor(final String name, final String nationality){
        checkParams(name, nationality);
        return mapRow(repository.insert(new AuthorModel(name.trim(), nationality.trim())));
    }

    public AuthorResponseDTO findById(final UUID id){
        return repository.findById(id)
                .map(this::mapRow)
                .orElseThrow(() -> new AuthorException(AuthorBusinessMessage.NOT_FOUND));
    };

    public AuthorResponseDTO findByName(final String name){
        checkParams(name);
        return repository.findByName(name.trim())
                .map(this::mapRow)
                .orElseThrow(() -> new AuthorException(AuthorBusinessMessage.NOT_FOUND));
    };

    public void delete(UUID id){
        repository.delete(id);
    }

    public List<AuthorResponseDTO> getAll(int first, int max){
        return repository.getAll(first, max).stream().map(this::mapRow).toList();
    }



    private static void checkParams(String... values){

        for(String value : values){
            if(value == null){
                throw new ValidationException(ValidationMessage.REQUIRED_VALUE);
            }
            if(value.isBlank()){
                throw new ValidationException(ValidationMessage.REQUIRED_VALUE);
            }

            if(value.length() < 3){
                throw new ValidationException(ValidationMessage.VALUE_TOO_SHORT);
            }

            if(value.length() > 50){
                throw new ValidationException(ValidationMessage.VALUE_TOO_LONG);
            }
        }
    }

    @Override
    protected AuthorResponseDTO mapRow(@NotNull AuthorModel authorModel) {
        return new AuthorResponseDTO(authorModel.getId(), authorModel.getName(), authorModel.getNationality());
    }
}
