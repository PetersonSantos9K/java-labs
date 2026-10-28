package database.dao;

import database.model.UsuarioModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO implements HelperDAO<UsuarioModel>{

    // Objeto de conexão com o banco de dados.
    private final Connection conexao;

    // comandos de acesso ao banco de dados
    private static final String SELECT_BY_USUARIO_SENHA =
            "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
    private static final String INSERT_USUARIO =
            "INSERT INTO usuario (usuario, senha, perfil) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID =
            "SELECT * FROM usuario WHERE id = ?";
    private static final String UPDATE_USUARIO =
            "UPDATE usuario SET senha = ?, perfil = ? WHERE id = ?";
    private static final String DELETE_USUARIO =
            "DELETE FROM usuario WHERE id = ?";

    private final PreparedStatement pstSelectByUsuarioSenha;
    private final PreparedStatement pstInsertUsuario;
    private final PreparedStatement pstSelectById;
    private final PreparedStatement pstUpdarteUsuario;
    private final PreparedStatement pstDeleteUsuario;



    public UsuarioDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;

        pstSelectByUsuarioSenha = this.conexao.prepareStatement(SELECT_BY_USUARIO_SENHA);
        pstInsertUsuario = this.conexao.prepareStatement(INSERT_USUARIO);
        pstSelectById = this.conexao.prepareStatement(SELECT_BY_ID);
        pstUpdarteUsuario = this.conexao.prepareStatement(UPDATE_USUARIO);
        pstDeleteUsuario = this.conexao.prepareStatement(DELETE_USUARIO);

    }

    // Verificar se existe usuário com login e senha
    public boolean selectByUsuarioESenha(UsuarioModel usuarioModel) throws SQLException {

        pstSelectByUsuarioSenha.setString(1, usuarioModel.getUsuario());
        pstSelectByUsuarioSenha.setString(2, usuarioModel.getSenha());
        ResultSet resultado = pstSelectByUsuarioSenha.executeQuery();

        return resultado != null && resultado.next();
    }

    @Override
    public UsuarioModel selectById(Long id) throws SQLException{
        pstSelectById.setLong(1, id);

        try(ResultSet resultado = pstSelectById.executeQuery()){
            if(resultado.next()){
                return new UsuarioModel(
                        resultado.getLong("id"),
                        resultado.getString("usuario"),
                        resultado.getString("senha"),
                        resultado.getString("perfil")
                );
            }
            return null;
        }
    }

    @Override
    public void insert(UsuarioModel usuario) throws SQLException {

        pstInsertUsuario.setString(1, usuario.getUsuario());
        pstInsertUsuario.setString(2, usuario.getSenha());
        pstInsertUsuario.setString(3, usuario.getPerfil());
        pstInsertUsuario.executeUpdate();
    }

    @Override
    public void update(UsuarioModel usuario) throws SQLException{
        pstUpdarteUsuario.setString(1, usuario.getSenha());
        pstUpdarteUsuario.setString(2, usuario.getPerfil());
        pstUpdarteUsuario.setLong(3, usuario.getId());
        pstUpdarteUsuario.executeUpdate();
    }

    @Override
    public void deleteById(Long id) throws  SQLException{

        pstDeleteUsuario.setLong(1, id);
        pstDeleteUsuario.executeUpdate();
    }

    public List<UsuarioModel> selectAll(){
        return List.of();
    }

}
