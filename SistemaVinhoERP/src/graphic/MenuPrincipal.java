package graphic;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class MenuPrincipal extends JFrame {

    private JDesktopPane desktopPane;
    private Connection connection;
    public MenuPrincipal(Connection connection){
        this.connection = connection;
        setTitle("Sistema para controle de Vinhos");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new DesktopComFundo("/home/peterson/Documentos/PROJETOS-REAIS/Java/SistemaVinhoERP/vinhosFundo.jpg");
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuSistema = new JMenu("Sistema");
            JMenuItem itemUsuario = new JMenuItem("Usuário");
        menuSistema.add(itemUsuario);

        JMenu menuCadastro = new JMenu("Cadastro");
            JMenuItem itemPaises = new JMenuItem("Países");
            JMenuItem itemRegioes = new JMenuItem("Regiões");
            JMenuItem itemViniculas = new JMenuItem("viniculas");
            JMenuItem itemUvas = new JMenuItem("Uvas");
            JMenuItem itemVinho = new JMenuItem("itemVinho");

        menuCadastro.add(itemPaises);
        menuCadastro.add(itemRegioes);
        menuCadastro.add(itemViniculas);
        menuCadastro.add(itemUvas);
        menuCadastro.add(itemVinho);

        JMenu menuRelatorio = new JMenu("relatório");
            JMenuItem itemRelatorioVenda = new JMenuItem("Relatório de Venda");
        menuRelatorio.add(itemRelatorioVenda);

        menuBar.add(menuSistema);
        menuBar.add(menuCadastro);
        menuBar.add(menuRelatorio);

        setJMenuBar(menuBar);
    }

    static class DesktopComFundo extends JDesktopPane{
        private Image imagemFundo;

        public DesktopComFundo(String caminhoImagem) {

            this.imagemFundo = new ImageIcon(caminhoImagem).getImage();

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagemFundo, 0,0, getWidth(), getHeight(), this);
        }
    }


}
