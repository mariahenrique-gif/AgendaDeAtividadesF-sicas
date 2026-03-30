package GUI;

import br.ufpb.dcx.MH.agenda.Agenda;
import br.ufpb.dcx.MH.agenda.AgendaMH;
import Controller.*;

import javax.swing.*;
import java.awt.*;

public class AgendaGUIV3 extends JFrame {
    JLabel linha1, linha2;
    ImageIcon capaImg = new ImageIcon(getClass().getResource("/imgs/Capa.jpg"));

    // Botões
    JButton botaoCadastrar, botaoPesquisarData, botaoPesquisarTipo,
            botaoRemover, botaoListar, botaoTotalHoras, botaoTotalKm,
            botaoSalvar, botaoRecuperar;

    // Instância da agenda
    Agenda agenda = new AgendaMH();

    public AgendaGUIV3() {
        setTitle("Agenda de Exercícios");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);

        // Título
        linha1 = new JLabel("Minha Agenda de Exercícios", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        // Imagem
        linha2 = new JLabel(capaImg, JLabel.CENTER);

        // Criando botões
        botaoCadastrar = new JButton("Cadastrar Atividade");
        botaoPesquisarData = new JButton("Pesquisar por Data");
        botaoPesquisarTipo = new JButton("Pesquisar por Tipo");
        botaoRemover = new JButton("Remover Atividade");
        botaoListar = new JButton("Listar Atividades");
        botaoTotalHoras = new JButton("Total de Horas por Mês");
        botaoTotalKm = new JButton("Total de Km por Mês");
        botaoSalvar = new JButton("Salvar Dados");
        botaoRecuperar = new JButton("Recuperar Dados");

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));

        Dimension tamanhoBotao = new Dimension(200, 40);
        JButton[] botoes = {botaoCadastrar, botaoPesquisarData, botaoPesquisarTipo,
                botaoRemover, botaoListar, botaoTotalHoras, botaoTotalKm,
                botaoSalvar, botaoRecuperar};

        for (JButton b : botoes) {
            b.setMaximumSize(tamanhoBotao);
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            painelBotoes.add(b);
            painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Painel com margem
        JPanel painelDireita = new JPanel(new BorderLayout());
        painelDireita.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));
        painelDireita.add(painelBotoes, BorderLayout.NORTH);

        // Layout principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(linha1, BorderLayout.NORTH);
        getContentPane().add(linha2, BorderLayout.CENTER);
        getContentPane().add(painelDireita, BorderLayout.EAST);

        // 🔗 Ligando os botões aos controllers
        botaoCadastrar.addActionListener(new AgendaCadastrarController(agenda, this));
        botaoPesquisarData.addActionListener(new AgendaSearchController(agenda, this, "data"));
        botaoPesquisarTipo.addActionListener(new AgendaSearchController(agenda, this, "tipo"));
        botaoRemover.addActionListener(new AgendaRemoveController(agenda, this));
        botaoListar.addActionListener(new AgendaListarController(agenda, this));
        botaoTotalHoras.addActionListener(new AgendaTotalHorasController(agenda, this));
        botaoTotalKm.addActionListener(new AgendaTotalKmController(agenda, this));
        botaoSalvar.addActionListener(new AgendaSalvarController(agenda, this));
        botaoRecuperar.addActionListener(new AgendaRecuperarController(agenda, this));
    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUIV3();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}