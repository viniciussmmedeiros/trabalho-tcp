package models;

import org.jfugue.player.Player;

public class MusicInputHandler {

    private final String text;
    private String textMusic = "";
    private String inputErrorChars = "";

    public MusicInputHandler(String text) {
        this.text = text;
    }

    public String textProcessing() {
        KeyMapper mapping = new KeyMapper();

        for (char ch : this.text.toCharArray()) {
            try {
                String jfugueKey = mapping.getMusicalAction((Character.toString(ch)));

                textMusic += jfugueKey + " ";
            } catch(Exception error) {
                char lastChar = error.getMessage().charAt(error.getMessage().length() - 1);

                if(inputErrorChars.indexOf(lastChar) == -1) {
                    inputErrorChars += lastChar + " ";
                }
            }
        }

        return this.textMusic;
    }

    public void playTextMusic() {
        Player player = new Player();
        player.play(this.textMusic);
    }

    public String getInputErrorChars() {
        return this.inputErrorChars;
    }
}
