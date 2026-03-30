package Controller;

import br.ufpb.dcx.MH.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaListarController implements ActionListener {
    private Agenda agenda;
    private JFrame janela;

    public AgendaListarController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(janela, agenda.listarAtividades());
    }
}