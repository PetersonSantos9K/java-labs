package database.dao;

import database.model.PaisModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO implements HelperDAO<PaisModel>{

    // Objeto de conexão com o banco de dados.
    private final Connection conexao;

    private static final String SELECY_BY_NOME = "SELECT * FROM pais WHERE nome = ?";
    private static final String INSERT = "INSERT INTO pais (nome) VALUES (?)";
    private static final String UPDATE = "UPDATE pais SET nome = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM pais WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM pais";
    private static final String SELECT_BY_ID = "SELECT * FROM pais WHERE id = ?";

    private final PreparedStatement pstSelectByNome;
    private final PreparedStatement pstInsert;
    private final PreparedStatement pstUpdate;
    private final PreparedStatement pstDelete;
    private final PreparedStatement pstSelectAll;
    private final PreparedStatement pstSelectById;

    public PaisDAO(final Connection conexao) throws SQLException {
        this.conexao = conexao;

        pstSelectByNome = conexao.prepareStatement(SELECY_BY_NOME);
        pstInsert = conexao.prepareStatement(INSERT);
        pstUpdate = conexao.prepareStatement(UPDATE);
        pstDelete = conexao.prepareStatement(DELETE);
        pstSelectAll = conexao.prepareStatement(SELECT_ALL);
        pstSelectById = conexao.prepareStatement(SELECT_BY_ID);
    }

    @Override
    public void insert(PaisModel pais) throws SQLException{
        pstInsert.setString(1, pais.getNome());
        pstInsert.executeUpdate();
    }

    @Override
    public void update(PaisModel pais) throws SQLException{
        pstUpdate.setString(1, pais.getNome());
        pstUpdate.setLong(2, pais.getId());
        pstUpdate.executeUpdate();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        pstDelete.setLong(1, id);
        pstDelete.executeUpdate();
    }

    @Override
    public PaisModel selectById(Long id) throws SQLException{
        pstSelectById.setLong(1, id);
        try(ResultSet resultado = pstSelectById.executeQuery()){

            if(resultado.next()){
                return mapRow(resultado);
            }


        }
        return null;
    }

    @Override
    public List<PaisModel> selectAll() throws SQLException{

        List<PaisModel> paises = new ArrayList<>();

        try(ResultSet resultado = pstSelectAll.executeQuery()){

            while(resultado.next()){
               paises.add(mapRow(resultado));
            }
        }

        return paises;
    }

    public PaisModel selectByNome(String nome) throws SQLException{
        pstSelectByNome.setString(1, nome);
        try(ResultSet resultado = pstSelectByNome.executeQuery()){

            if(resultado.next()){
                return mapRow(resultado);
            }

        }
        return null;
    }

    private PaisModel mapRow(ResultSet rs) throws SQLException {

        return new PaisModel(
                rs.getLong("id"),
                rs.getString("nome")
        );
    }

}
