package main.java.Classes;

import org.jfugue.player.Player;

public class TextHandler {
    private final String text;

    public TextHandler(String text) {
        this.text = text;
    }

    public void textProcessing () {
        ProcessingMapping mapping = new ProcessingMapping();
        Player player = new Player();
        for(char ch: this.text.toCharArray()) {
            String jfugueKey = mapping.getMusicalAction((Character.toString(ch)));
            player.play(jfugueKey);
        }
    }
}
