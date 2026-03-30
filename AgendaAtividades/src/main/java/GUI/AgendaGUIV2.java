package GUI;

import br.ufpb.dcx.MH.agenda.Agenda;
import br.ufpb.dcx.MH.agenda.AgendaMH;

import javax.swing.*;
import java.awt.*;

public class AgendaGUIV2 extends JFrame {
    JLabel linha1, linha2;
    ImageIcon capaImg = new ImageIcon(getClass().getResource("/imgs/Capa.jpg"));

    // Todos os botões
    JButton botaoCadastrar, botaoPesquisarData, botaoPesquisarTipo,
            botaoRemover, botaoListar, botaoTotalHoras, botaoTotalKm,
            botaoSalvar, botaoRecuperar;

    Agenda agenda = new AgendaMH();

    public AgendaGUIV2() {
        // Look and Feel moderno
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 14));
            UIManager.put("Label.font", new Font("Segoe UI", Font.BOLD, 16));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Sistema de Academia - Agenda de Exercícios");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(245, 245, 245));

        // Título
        linha1 = new JLabel("Agenda de Exercícios", JLabel.CENTER);
        linha1.setForeground(new Color(0, 102, 204));
        linha1.setFont(new Font("Segoe UI", Font.BOLD, 28));

        // Imagem da capa
        linha2 = new JLabel(capaImg, JLabel.CENTER);

        // Criando todos os botões (brancos padrão)
        botaoCadastrar = new JButton("Cadastrar Atividade");
        botaoPesquisarData = new JButton("Pesquisar por Data");
        botaoPesquisarTipo = new JButton("Pesquisar por Tipo");
        botaoRemover = new JButton("Remover Atividade");
        botaoListar = new JButton("Listar Atividades");
        botaoTotalHoras = new JButton("Total de Horas por Mês");
        botaoTotalKm = new JButton("Total de Km por Mês");
        botaoSalvar = new JButton("Salvar Dados");
        botaoRecuperar = new JButton("Recuperar Dados");

        // Painel de botões em coluna
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBackground(new Color(255, 255, 255));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Dimension tamanhoBotao = new Dimension(220, 45);
        JButton[] botoes = {botaoCadastrar, botaoPesquisarData, botaoPesquisarTipo,
                botaoRemover, botaoListar, botaoTotalHoras, botaoTotalKm,
                botaoSalvar, botaoRecuperar};

        for (JButton b : botoes) {
            b.setMaximumSize(tamanhoBotao);
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            b.setBackground(Color.WHITE);
            painelBotoes.add(b);
            painelBotoes.add(Box.createRigidArea(new Dimension(0, 12)));
        }

        // Painel lateral com margem
        JPanel painelDireita = new JPanel(new BorderLayout());
        painelDireita.setBackground(new Color(245, 245, 245));
        painelDireita.add(painelBotoes, BorderLayout.NORTH);

        // Layout principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(linha1, BorderLayout.NORTH);
        getContentPane().add(linha2, BorderLayout.CENTER);
        getContentPane().add(painelDireita, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AgendaGUIV2().setVisible(true);
        });
    }
}