package repository.interfaces;

public interface UserDAO <Type>{
    boolean add(Type type);
    boolean update(Type type);
    boolean delete(String id);
    Type findById(String id);
    Type findByEmail(String email);
    Type findByUsername(String username);
}
