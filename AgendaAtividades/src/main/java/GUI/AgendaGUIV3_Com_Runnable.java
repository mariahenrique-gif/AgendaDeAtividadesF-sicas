package GUI;

import javax.swing.*;

public class AgendaGUIV3_Com_Runnable {
    public static void main(String[] args) {
        // Inicializa a GUI no Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame janela = new AgendaGUIV3ComMenu(); // usa a versão com menu
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}