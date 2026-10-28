package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseDAO <Type>{

    protected List<Type> findAll(PreparedStatement pst) throws SQLException{
        List<Type> type = new ArrayList<>();
        try(ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                type.add(mapRow(rs));
            }

        }
        return type;
    };

    protected Type findOne(PreparedStatement pst) throws SQLException {
        try(ResultSet rs = pst.executeQuery()){
            if (rs.next()) {
                return mapRow(rs);
            }

        }
        return null;
    };

    protected abstract Type mapRow(ResultSet rs) throws SQLException;

}
