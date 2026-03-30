package Controller;

import br.ufpb.dcx.MH.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaRecuperarController implements ActionListener {
    private Agenda agenda;
    private JFrame janela;

    public AgendaRecuperarController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            agenda.recuperarDados();
            JOptionPane.showMessageDialog(janela, "Dados recuperados com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(janela, "Erro ao recuperar dados: " + ex.getMessage());
        }
    }
}