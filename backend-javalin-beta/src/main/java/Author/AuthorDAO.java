package Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorDAO<Type>{
    Type insert(Type type);
    Optional<Type> findById(UUID id);
    Optional<Type> findByName(String name);
    void delete(UUID id);
    List<Type> getAll(int first, int max);
}
