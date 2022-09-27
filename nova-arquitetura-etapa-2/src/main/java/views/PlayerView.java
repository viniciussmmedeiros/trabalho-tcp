package views;

import javax.swing.*;
import java.awt.*;

public class PlayerView extends JPanel {
    // Properties
    final JLabel headerLabel = new JLabel("Generate music using text!");
    public JTextArea musicTextInput = new JTextArea();
    public JButton playMusicButton = new JButton("Play Music");

    // Init
    public PlayerView() {
        super(new GridLayout(3, 3));
        setupView();
    }

    // Setup
    private void setupView() {
        headerLabel.setBounds(50, 50, 200, 30);
        add(headerLabel);
        add(musicTextInput);
        add(playMusicButton);
    }
}
