package Controller;

import br.ufpb.dcx.MH.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaSearchController implements ActionListener {
    private final Agenda agenda;
    private final JFrame janela;
    private final String tipoPesquisa; // "data" ou "tipo"

    public AgendaSearchController(Agenda agenda, JFrame janela, String tipoPesquisa) {
        this.agenda = agenda;
        this.janela = janela;
        this.tipoPesquisa = tipoPesquisa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tipoPesquisa.equals("data")) {
            int dia = Integer.parseInt(JOptionPane.showInputDialog(janela, "Dia [1-31]:"));
            int mes = Integer.parseInt(JOptionPane.showInputDialog(janela, "Mês [1-12]:"));
            JOptionPane.showMessageDialog(janela, agenda.pesquisaAtividadesPorData(dia, mes));
        } else if (tipoPesquisa.equals("tipo")) {
            String tipo = JOptionPane.showInputDialog(janela, "Tipo da atividade:");
            JOptionPane.showMessageDialog(janela, agenda.pesquisaAtividadesPorTipo(tipo));
        }
    }
}