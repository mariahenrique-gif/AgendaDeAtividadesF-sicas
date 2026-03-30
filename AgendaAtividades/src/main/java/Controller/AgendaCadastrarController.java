package Controller;

import br.ufpb.dcx.MH.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaCadastrarController implements ActionListener {
    private Agenda agenda;
    private JFrame janela;

    public AgendaCadastrarController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janela, "Nome da atividade:");
        int dia = Integer.parseInt(JOptionPane.showInputDialog(janela, "Dia [1-31]:"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janela, "Mês [1-12]:"));
        String tipo = JOptionPane.showInputDialog(janela, "Tipo:");
        String dificuldade = JOptionPane.showInputDialog(janela, "Dificuldade:");
        double km = Double.parseDouble(JOptionPane.showInputDialog(janela, "Quilometragem:"));
        int duracao = Integer.parseInt(JOptionPane.showInputDialog(janela, "Duração (minutos):"));

        boolean cadastrou = agenda.cadastraAtividade(nome, dia, mes, tipo, dificuldade, km, duracao);
        if (cadastrou) {
            JOptionPane.showMessageDialog(janela, "Atividade cadastrada!");
        } else {
            JOptionPane.showMessageDialog(janela, "Atividade não cadastrada. Verifique se já existe.");
        }
    }
}