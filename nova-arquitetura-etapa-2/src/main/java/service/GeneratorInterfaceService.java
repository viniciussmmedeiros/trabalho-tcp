package service;

import controller.response.GenerateMusicResponse;

import javax.swing.*;
import java.awt.*;

public class GeneratorInterfaceService extends JFrame {

    public GeneratorInterfaceService() {

        super("Music Generator");
        JTabbedPane tabbedPaneContainer;
        JPanel generatorTab = new JPanel(new GridLayout(3, 3));
        JPanel instructionsTab = new JPanel();
        JPanel aboutTab = new JPanel();

        setSize(500, 500);
        setLocation(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

        tabbedPaneContainer = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        tabbedPaneContainer.addTab("Generator", generatorTab);
        tabbedPaneContainer.addTab("Instructions", instructionsTab);
        tabbedPaneContainer.addTab("About", aboutTab);

        getContentPane().add(tabbedPaneContainer);

        final JLabel headerLabel = new JLabel("Generate music using text!");
        headerLabel.setBounds(50, 50, 200, 30);
        JTextArea musicTextInput = new JTextArea();
        JButton playMusicButton = new JButton("Play Music");

        playMusicButton.addActionListener(click -> playMusic(musicTextInput.getText()));

        generatorTab.add(headerLabel);
        generatorTab.add(musicTextInput);
        generatorTab.add(playMusicButton);

        setVisible(true);
    }

    public static void playMusic(String text) {

        GenerateMusicResponse generatorResponse = new GenerateMusicResponse(text);
        generatorResponse.textProcessing();
    }
}
