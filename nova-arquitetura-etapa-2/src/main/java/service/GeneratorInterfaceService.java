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

        generatorTab.add(headerLabel);
        generatorTab.add(musicTextInput);
        generatorTab.add(playMusicButton);

        String data[][]={ {"(letra A)","Nota Lá"},
                {"(Letra B)","Nota Si"},
                {"(Letra C)","Nota Dó"},
                {"(Letra D)","Nota Ré"},
                {"(Letra E)","Nota Mi"},
                {"(Letra F)","Nota Fá"},
                {"(Letra G)","Nota Sol"},
                {"(Letras a,b,c,d,e,f,g) ","Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, Silêncio ou pausa"},
                {"Caractere Espaço", "Aumenta volume para o DOBRO do volume; Se não puder aumentar, volta ao volume default (de início)"},
                {"Caractere !", "Trocar instrumento para o instrumento General MIDI #114 (Agogo)"},
                {"Qualquer outra letra vogal (O ou o, I ou i , U ou u)", "Trocar instrumento para o instrumento General MIDI #7 (Harpsichord)"},
                {"Qualquer outra letra consoant (todas consoantes exceto as que são notas)", "Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, Silêncio ou pausa"},
                {"Dígito par ou impar Trocar instrumento para o instrumento","General MIDI cujo numero é igual ao valor do instrumento ATUAL + valor do dígito"},
                {"Caractere ? ou .","Aumenta UMA oitava; Se não puder, aumentar, volta à oitava default (deinício)"},
                {"Caractere NL (nova linha)","Trocar instrumento para o instrumento General MIDI #15 (Tubular Bells)"},
                {"Caractere ; (ponto e vírgula)","Trocar instrumento para o instrumento General MIDI #76 (Pan Flute)"},
                {"Caractere ,","Trocar instrumento para o instrumento General MIDI #20 (Church Organ)"},
                {"ELSE","Se caractere anterior era NOTA (A a G), repete nota; Caso contrário, Silêncio ou pausa"},
        };

        String column[]={"Texto","Informação Musical ou Ação"};

        JTable jt = new JTable(data, column);
        jt.setBounds(30,40,200,300);
        JScrollPane sp = new JScrollPane(jt);
        instructionsTab.add(sp);

        setVisible(true);
    }

    public static void playMusic(String text) {

        GenerateMusicResponse generatorResponse = new GenerateMusicResponse(text);
        generatorResponse.textProcessing();
    }
}
