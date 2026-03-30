package Controller;

import br.ufpb.dcx.MH.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaRemoveController implements ActionListener {
    private final Agenda agenda;
    private final JFrame janela;

    public AgendaRemoveController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janela, "Nome da atividade a remover:");
        agenda.removeAtividade(nome); // chamada direta
        JOptionPane.showMessageDialog(janela, "Atividade removida (se existia).");
    }
}