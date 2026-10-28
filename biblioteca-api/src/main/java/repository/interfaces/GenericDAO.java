package repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericDAO <Type>{
     boolean inserir(Type type);
     Optional<Type> buscarPorId(String id);
     Optional<Type> buscarPorNome(String nome);
     boolean excluir(String id);
     List<Type> selectAll();
}
