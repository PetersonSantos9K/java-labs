package repository.postgreSQL;

import database.ConnectionFactory;
import repository.BaseDAO;
import repository.interfaces.AutorDAO;
import exception.DataBaseException;
import api.message.error.database.AutorDatabaseMessage;
import model.AutorModel;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class AutorDAOImpl extends BaseDAO<AutorModel> implements AutorDAO<AutorModel> {


    private final String INSERIR_AUTOR = "INSERT INTO autores(id, nome, nacionalidade) VALUES (?, ?,?)";
    private final String BUSCAR_AUTOR_ID = "SELECT * FROM autores WHERE id = ?";
    private final String EXCLUIR_AUTOR_ID = "DELETE FROM autores WHERE id = ?";
    private final String BUSCAR_AUTORES = "SELECT * FROM autores";
    private final String BUSCAR_AUTOR_NOME = "SELECT * FROM autores WHERE UPPER(nome) = UPPER(?)";

    @Override
    public boolean inserir(AutorModel autorModel)  {
        try(var conn = ConnectionFactory.getConnection();
            var pstInserirAutor = conn.prepareStatement(INSERIR_AUTOR)
        ){

            pstInserirAutor.setString(1, autorModel.getId());
            pstInserirAutor.setString(2, autorModel.getNome());
            pstInserirAutor.setString(3, autorModel.getNacionalidade());

            return pstInserirAutor.executeUpdate() > 0;
        } catch(SQLException ex){
            throw new DataBaseException(
                    500,
                    AutorDatabaseMessage.ERRO_INSERIR_AUTOR.getMessage(),
                    ex
            );
        }
    }

    @Override
    public Optional<AutorModel> buscarPorId(String id) {

        try(var conn = ConnectionFactory.getConnection();
            var pstBuscarAutorId = conn.prepareStatement(BUSCAR_AUTOR_ID)
        ){

            pstBuscarAutorId.setString(1, id);

            AutorModel autorModel = findOne(pstBuscarAutorId);
            return Optional.ofNullable(autorModel);
        } catch (SQLException ex) {
            throw new DataBaseException(
                    500,
                    AutorDatabaseMessage.ERRO_BUSCAR_AUTOR_ID.getMessage(),
                    ex
            );
        }
    }

    @Override
    public Optional<AutorModel> buscarPorNome(String nome){

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstBucarAutorNome = conn.prepareStatement(BUSCAR_AUTOR_NOME)
        ){
            pstBucarAutorNome.setString(1, nome);

            AutorModel autorModel = findOne(pstBucarAutorNome);
            return Optional.ofNullable(autorModel);
        } catch (SQLException ex){
            throw new DataBaseException(
                    500,
                    AutorDatabaseMessage.ERRO_BUSCAR_AUTOR_NOME.getMessage(),
                    ex
            );
        }
    }

    @Override
    public boolean excluir(String id) {
        try(var conn = ConnectionFactory.getConnection();
            var pstExcluirAutorId = conn.prepareStatement(EXCLUIR_AUTOR_ID)
        ){
            pstExcluirAutorId.setString(1, id);
            return pstExcluirAutorId.executeUpdate() > 0;

        } catch (SQLException ex) {
            throw new DataBaseException(
                    500,
                    AutorDatabaseMessage.ERRO_EXCLUIR_AUTOR_ID.getMessage(),
                    ex
            );
        }
    }

    @Override
    public List<AutorModel> selectAll(){
        try(var conn = ConnectionFactory.getConnection();
            var pstBuscarAutores = conn.prepareStatement(BUSCAR_AUTORES)
        ){
            return findAll(pstBuscarAutores);
        } catch (SQLException ex){
            throw new DataBaseException(
                    500,
                    AutorDatabaseMessage.ERRO_BUSCAR_AUTORES.getMessage(),
                    ex
            );
        }

    }

    @Override
    protected AutorModel mapRow(ResultSet rs) throws SQLException{
        return new AutorModel(
                rs.getString("id"),
                rs.getString("nome"),
                rs.getString("nacionalidade")
        );
    }

}
