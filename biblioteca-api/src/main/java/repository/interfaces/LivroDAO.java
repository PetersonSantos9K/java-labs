package repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface LivroDAO<Type> extends GenericDAO<Type>{

    List<Type> buscarLivrosPorAutor(String autorId);
}
