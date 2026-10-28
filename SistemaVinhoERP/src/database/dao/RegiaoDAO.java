package database.dao;

import database.model.RegiaoModel;

import java.sql.SQLException;
import java.util.List;

public class RegiaoDAO implements HelperDAO<RegiaoModel>{


    @Override
    public void insert(RegiaoModel regiaoModel) throws SQLException {

    }

    @Override
    public RegiaoModel selectById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void update(RegiaoModel regiaoModel) throws SQLException {

    }

    @Override
    public void deleteById(Long id) throws SQLException {

    }

    @Override
    public List<RegiaoModel> selectAll() throws SQLException {
        return List.of();
    }
}
