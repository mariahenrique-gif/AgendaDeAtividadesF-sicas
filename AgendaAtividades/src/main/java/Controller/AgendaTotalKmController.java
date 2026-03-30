package Controller;

import br.ufpb.dcx.MH.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaTotalKmController implements ActionListener {
    private Agenda agenda;
    private JFrame janela;

    public AgendaTotalKmController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janela, "Mês [1-12]:"));
        JOptionPane.showMessageDialog(janela, "Total de km: " + agenda.totalQuilometrosPorMes(mes));
    }
}