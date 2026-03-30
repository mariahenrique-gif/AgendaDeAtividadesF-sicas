package GUI;

import br.ufpb.dcx.MH.agenda.Agenda;
import br.ufpb.dcx.MH.agenda.AgendaMH;
import Controller.*;

import javax.swing.*;
import java.awt.*;

public class AgendaGUIV3ComMenu extends JFrame {
    JLabel linha1, linha2;
    ImageIcon capaImg = new ImageIcon(getClass().getResource("/imgs/Capa.jpg"));
    Agenda agenda = new AgendaMH();
    JMenuBar barraDeMenu = new JMenuBar();

    public AgendaGUIV3ComMenu() {
        setTitle("Agenda de Exercícios");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(Color.white);

        // Título
        linha1 = new JLabel("Minha Agenda de Exercícios", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        // Imagem
        linha2 = new JLabel(capaImg, JLabel.CENTER);

        // Layout principal
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel()); // espaço vazio

        // --- Menus ---
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarAtividade = new JMenuItem("Cadastrar atividade");
        menuCadastrar.add(menuCadastrarAtividade);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarData = new JMenuItem("Pesquisar por data");
        JMenuItem menuPesquisarTipo = new JMenuItem("Pesquisar por tipo");
        menuPesquisar.add(menuPesquisarData);
        menuPesquisar.add(menuPesquisarTipo);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverAtividade = new JMenuItem("Remover atividade");
        menuRemover.add(menuRemoverAtividade);

        JMenu menuListar = new JMenu("Listar");
        JMenuItem menuListarAtividades = new JMenuItem("Listar atividades");
        menuListar.add(menuListarAtividades);

        JMenu menuRelatorios = new JMenu("Relatórios");
        JMenuItem menuTotalHoras = new JMenuItem("Total de horas por mês");
        JMenuItem menuTotalKm = new JMenuItem("Total de km por mês");
        menuRelatorios.add(menuTotalHoras);
        menuRelatorios.add(menuTotalKm);

        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuSalvar = new JMenuItem("Salvar dados");
        JMenuItem menuRecuperar = new JMenuItem("Recuperar dados");
        menuArquivo.add(menuSalvar);
        menuArquivo.add(menuRecuperar);

        // --- Ligando os itens de menu aos controllers ---
        menuCadastrarAtividade.addActionListener(new AgendaCadastrarController(agenda, this));
        menuPesquisarData.addActionListener(new AgendaSearchController(agenda, this, "data"));
        menuPesquisarTipo.addActionListener(new AgendaSearchController(agenda, this, "tipo"));
        menuRemoverAtividade.addActionListener(new AgendaRemoveController(agenda, this));
        menuListarAtividades.addActionListener(new AgendaListarController(agenda, this));
        menuTotalHoras.addActionListener(new AgendaTotalHorasController(agenda, this));
        menuTotalKm.addActionListener(new AgendaTotalKmController(agenda, this));
        menuSalvar.addActionListener(new AgendaSalvarController(agenda, this));
        menuRecuperar.addActionListener(new AgendaRecuperarController(agenda, this));

        // --- Adicionando menus na barra ---
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuListar);
        barraDeMenu.add(menuRelatorios);
        barraDeMenu.add(menuArquivo);

        setJMenuBar(barraDeMenu);
    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUIV3ComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}