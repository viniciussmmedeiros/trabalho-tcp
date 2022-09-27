package models;

import org.jfugue.player.Player;

public class GenerateMusicResponse {

    private final String text;
    private String textMusic = "";

    public GenerateMusicResponse(String text) {
        this.text = text;
    }

    public void textProcessing() {
        KeyMapper mapping = new KeyMapper();
        Player player = new Player();

        for (char ch : this.text.toCharArray()) {
            String jfugueKey = mapping.getMusicalAction((Character.toString(ch)));

            textMusic += jfugueKey + " ";
        }

        player.play(textMusic);
    }
}
