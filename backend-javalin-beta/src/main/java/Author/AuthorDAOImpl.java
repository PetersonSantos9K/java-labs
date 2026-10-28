package Author;

import api.message.error.database.DataBaseMessage;
import exception.DataBaseException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import util.JpaConfig;

import java.util.*;

public class AuthorDAOImpl implements AuthorDAO<AuthorModel> {


    @Override
    public AuthorModel insert(AuthorModel authorModel) {

        var em = JpaConfig.getEmf().createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(authorModel);
            em.getTransaction().commit();
            return authorModel;
        } catch ( PersistenceException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new DataBaseException(DataBaseMessage.ERROR_INSERT);
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<AuthorModel> findById(UUID id) {
        try (var em = JpaConfig.getEmf().createEntityManager()) {
            return Optional.ofNullable(em.find(AuthorModel.class, id));
        } catch (PersistenceException e) {
            throw new DataBaseException(DataBaseMessage.ERROR_QUERY);
        }
    }

    @Override
    public Optional<AuthorModel> findByName(String name) {
        try (var em = JpaConfig.getEmf().createEntityManager()) {

            AuthorModel author = em.createQuery("SELECT b FROM AuthorModel b WHERE b.name = :name", AuthorModel.class)
                    .setParameter("name", name)
                    .getSingleResult();

            return Optional.ofNullable(author);
        } catch (NoResultException e){
            return Optional.empty();
        } catch (PersistenceException e) {
            throw new DataBaseException(DataBaseMessage.ERROR_QUERY);
        }
    }

    @Override
    public void delete(UUID id) {
        var em = JpaConfig.getEmf().createEntityManager();
        try{

            em.getTransaction().begin();
            AuthorModel author = em.find(AuthorModel.class, id);
            if(author == null){
                em.getTransaction().rollback();
                throw new DataBaseException(DataBaseMessage.ERROR_NOT_EXIST);
            }
            em.remove(author);
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
    public List<AuthorModel> getAll(int page, int max) {
        List<AuthorModel> authorModels;
        try(var em = JpaConfig.getEmf().createEntityManager()){
            authorModels = em.createQuery("SELECT DISTINCT b FROM AuthorModel b ORDER BY b.name", AuthorModel.class)
                    .setFirstResult(page * max)
                    .setMaxResults(max)
                    .getResultList();
        }
        return authorModels;
    }
}
