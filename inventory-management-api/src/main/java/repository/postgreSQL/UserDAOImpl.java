package repository.postgreSQL;

import database.DbConnection;
import domain.User;
import exception.DataBaseException;
import repository.BaseDAO;
import repository.interfaces.UserDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO<User> {

    private String createUser = "";
    private String updateUSer = "";
    private String deleteUser = "";
    private String getUserById = "";
    private String getAllUsers = "";

    @Override
    public boolean add(User user) {

        try(var conn = DbConnection.getConnection();
            var ppst = conn.prepareStatement(createUser)){
        } catch (SQLException e) {
            throw new DataBaseException("");
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try(var conn = DbConnection.getConnection();
            var ppst = conn.prepareStatement(updateUSer)){
        } catch (SQLException e) {
            throw new DataBaseException("");
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        try(var conn = DbConnection.getConnection();
            var ppst = conn.prepareStatement(deleteUser)){
        } catch (SQLException e) {
            throw new DataBaseException("");
        }
        return false;
    }

    @Override
    public User findById(String id) {

        try(var conn = DbConnection.getConnection();
            var ppst = conn.prepareStatement(createUser)){
            return findOne(ppst);
        } catch (SQLException e) {
            throw new DataBaseException("");
        }
    }

    @Override
    public User findByEmail(String email) {

        

        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    protected User mapRow(ResultSet rs) throws SQLException {
        return null;
    }
}
