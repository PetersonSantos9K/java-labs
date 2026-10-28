package Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDAO<Type, TypeAuthor>{
    Optional<Type> insert(Type type);
    Optional<Type> findById(UUID id);
    Optional<Type> findByTitle(String title);
    void delete(UUID id);
    List<Type> getAll(int first, int max);
    List<Type> findBooksByAuthor(TypeAuthor authorModel);
}
