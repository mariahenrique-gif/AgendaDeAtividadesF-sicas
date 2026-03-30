package Controller;

import br.ufpb.dcx.MH.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaSalvarController implements ActionListener {
    private final Agenda agenda;
    private final JFrame janela;

    public AgendaSalvarController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            agenda.salvarDados();
            JOptionPane.showMessageDialog(janela, "Dados salvos com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(janela, "Erro ao salvar dados: " + ex.getMessage());
        }
    }
}