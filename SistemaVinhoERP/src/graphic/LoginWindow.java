package graphic;

import database.ConnectionFactory;
import database.dao.UsuarioDAO;
import database.model.UsuarioModel;
import util.HashUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class LoginWindow extends JFrame {

    private JLabel lblTitulo, lblUsuario, lblSenha;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;


    public LoginWindow(){
        setTitle("Tela de Login"); // titulo
        setSize(300, 500); // tamanho da tela
        setLocationRelativeTo(null); // vai ser responsavel por deixa a tela no meio
        setDefaultCloseOperation(EXIT_ON_CLOSE); // o sistema vai se responsabilizar por matar o processo na maquina, caso nao tenha o processo ia continuar sendo executado
        setLayout(null); // significa que os componentes vão ser colocados manualmente, o layout fazia isso automaticamente
        componentesCriar();
        setVisible(true); //

    }

    private void componentesCriar(){
        lblTitulo = new JLabel("Sistema Vinhos");
        lblTitulo.setBounds(35,20, 280, 30);
        lblTitulo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        getContentPane().add(lblTitulo);

        lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setBounds(10, 70, 80, 30);
        getContentPane().add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(80, 70, 200, 30);
        getContentPane().add(txtUsuario);

        lblSenha = new JLabel("Senha: ");
        lblSenha.setBounds(10, 100, 80, 30);
        getContentPane().add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(80, 100, 200, 30);
        getContentPane().add(txtSenha);

        btnEntrar = new JButton(new AbstractAction("ENTRAR") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = txtSenha.getText();

                if(usuario.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo <Usuário> obrigatório!");
                    txtUsuario.requestFocus();
                    return;
                }

                if(senha.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo <Senha> obrigatória!");
                    txtSenha.requestFocus();
                    return;
                }


                try{
                    Connection conexao = ConnectionFactory.getConnection("localhost", 5432, "controlevinhos", "postgres", "123456");
                    if(conexao != null){

                        UsuarioModel usuarioModel = new UsuarioModel();
                        usuarioModel.setUsuario(usuario);
                        //usuarioModel.setSenha(HashUtils.criarMD5(senha));
                        usuarioModel.setSenha(HashUtils.criarMD5(senha));

                        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
                        if(!usuarioDAO.selectByUsuarioESenha(usuarioModel)){
                            JOptionPane.showMessageDialog(null, "Usuário ou Senha invalida!");
                            return;
                        }

                        new MenuPrincipal(conexao).setVisible(true);
                        dispose();
                    }

                } catch (SQLException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Não foi possivel conectar no banco de dados: " + ex.getMessage());
                }
            }
        });
        btnEntrar.setBounds(80, 130, 200, 30);
        getContentPane().add(btnEntrar);
    }



    public static void main(String[] args){

        JWindow splashScreen = new JWindow();

        JLabel label = new JLabel("Carregando Sistema de Vinhos...", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));

        splashScreen.setSize(300, 100);
        splashScreen.setLocationRelativeTo(null);
        splashScreen.setVisible(true);

        SwingUtilities.invokeLater(() -> {

            try{
                Thread.sleep(1000);
                new LoginWindow();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            } finally {
                splashScreen.setVisible(false);
                splashScreen.dispose();
            }



        });




    }

}
