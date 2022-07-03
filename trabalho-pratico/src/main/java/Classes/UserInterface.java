package main.java.Classes;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class UserInterface extends JFrame{
    public UserInterface() {
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
        System.out.println(text); // Imprimindo o texto no terminal ao clique do botão, para fins de teste.
        /*
        * Aqui a lógica para processamento do texto -> música, deve estar aqui para
        * ser chamada ao clique do botão.
        * OBS: Possivelmente arquivo externo / outra classe. Apenas um placeholder.
        */

        TextHandler textHandler = new TextHandler(text);
        textHandler.textProcessing();
    }
}