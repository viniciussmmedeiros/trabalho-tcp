package main.java.Classes;

import org.jfugue.player.Player;

/**
 * Essa classe percorre e processa o texto input para gerar
 * a música.
 */

public class TextHandler {
    private final String text;

    public TextHandler(String text) {
        this.text = text;
    }

    public void textProcessing () {
        // mapeamento para conseguir os caracteres reconhecidos pelo JFugue
        ProcessingMapping mapping = new ProcessingMapping();
        Player player = new Player();

        for(char charInput: this.text.toCharArray()) {
            String jfugueKey = mapping.getMusicalAction((Character.toString(charInput)));
            player.play(jfugueKey);
        }
    }
}
