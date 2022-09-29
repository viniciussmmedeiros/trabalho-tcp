package views;

import javax.swing.*;
import java.awt.*;

public class PlayerView extends JPanel {
    // Properties
    final JLabel headerLabel = new JLabel("Generate music using text!", SwingConstants.CENTER);
    public JTextArea musicTextInput = new JTextArea(20, 20);
    public JButton playMusicButton = new JButton("Play Music");
    public JButton openFileButton = new JButton("Open File");
    public JButton saveInFileButton = new JButton("Save in file (midi)");
    public JPanel buttonsPanel = new JPanel();
    public JLabel message = new JLabel("", SwingConstants.CENTER);

    public void setMessageArea(String text) {
        message.setText(text);
    }

    // Init
    public PlayerView() {
        super(new GridBagLayout());
        setupView();
    }

    // Setup
    private void setupView() {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.weightx = 1;
        constraint.weighty = 1;
        constraint.fill = GridBagConstraints.HORIZONTAL;
        add(headerLabel, constraint);

        constraint.gridy = 1;
        add(new JScrollPane(musicTextInput), constraint);

        constraint.gridy = 2;
        add(playMusicButton, constraint);

        constraint.gridy = 3;
        buttonsPanel.add(openFileButton);
        buttonsPanel.add(saveInFileButton);
        add(buttonsPanel, constraint);

        constraint.gridy = 4;
        add(message, constraint);
    }
}
