package Book;

import api.message.error.database.DataBaseMessage;
import exception.DataBaseException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import Author.AuthorModel;
import util.JpaConfig;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookDAOImpl implements BookDAO<BookModel, AuthorModel> {


    @Override
    public Optional<BookModel> insert(BookModel bookModel) {

        var em = JpaConfig.getEmf().createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(bookModel);
            em.getTransaction().commit();
            return Optional.ofNullable(bookModel);
        } catch (PersistenceException e){

            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }

            throw new DataBaseException(DataBaseMessage.ERROR_INSERT);
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<BookModel> findById(UUID id) {
        try(var em = JpaConfig.getEmf().createEntityManager()) {
            BookModel book = em.createQuery("SELECT b FROM BookModel b WHERE b.id = :id", BookModel.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.ofNullable(book);
        } catch (NoResultException e){
            return Optional.empty();
        } catch (PersistenceException e){
            throw new DataBaseException(DataBaseMessage.ERROR_QUERY);
        }
    }

    @Override
    public Optional<BookModel> findByTitle(String title) {
        try(var em = JpaConfig.getEmf().createEntityManager()) {
            BookModel book = em.createQuery("SELECT b FROM BookModel b WHERE b.title = :title", BookModel.class)
                    .setParameter("title", title)
                    .getSingleResult();
            return Optional.ofNullable(book);
        } catch (NoResultException e){
            return Optional.empty();
        } catch (PersistenceException e){
            throw new DataBaseException(DataBaseMessage.ERROR_QUERY);
        }
    }

    @Override
    public void delete(UUID id) {
        var em = JpaConfig.getEmf().createEntityManager();
        try{
            em.getTransaction().begin();
            BookModel book = em.find(BookModel.class, id);
            if(book == null){
                em.getTransaction().rollback();
                throw new DataBaseException(DataBaseMessage.ERROR_NOT_EXIST);
            }

            em.remove(book);
            em.getTransaction().commit();
        } catch (PersistenceException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new DataBaseException(DataBaseMessage.ERROR_DELETE);
        } finally {
            em.close();
        }
    }

    @Override
    public List<BookModel> getAll(int first, int max) {
        List<BookModel> bookModels;
        try(var em = JpaConfig.getEmf().createEntityManager()){
            bookModels = em.createQuery("SELECT b FROM BookModel b ORDER BY b.title", BookModel.class)
                    .setFirstResult(first)
                    .setMaxResults(max)
                    .getResultList();
        }
        return bookModels;
    }

    @Override
    public List<BookModel> findBooksByAuthor(AuthorModel authorModel) {

        List<BookModel> bookModels;
        try(var em = JpaConfig.getEmf().createEntityManager()){

            bookModels = em.createQuery("SELECT b FROM BookModel b WHERE b.author = :authorId ORDER BY b.title", BookModel.class)
                    .setParameter("authorId", authorModel)
                    .getResultList();
        }
        return bookModels;
    }
}
