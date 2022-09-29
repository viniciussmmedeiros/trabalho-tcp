package views;

import javax.swing.*;
import java.awt.*;

public class AboutView extends JPanel {
    // Properties
    final JLabel header = new JLabel("Trabalho desenvolvido na disciplina Técnicas de Construção de Programas.", SwingConstants.CENTER);
    final JLabel groupMembers = new JLabel("Grupo: Eduardo Raupp Peretto, Lucas Portela Lopes, Matheus Stein de Aguiar e Vinícius Matté Medeiros.", SwingConstants.CENTER);

    // Init
    public AboutView() {
        super(new GridLayout(2, 1));
        setupView();
    }

    // Setup
    private void setupView() {
        add(header);
        add(groupMembers);
    }
}
