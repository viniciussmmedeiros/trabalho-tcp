package models;

import org.jfugue.player.Player;

public class GenerateMusicResponse {

    private final String text;
    private String textMusic = "";

    public GenerateMusicResponse(String text) {
        this.text = text;
    }

    public void textProcessing() {
        // mapeamento para conseguir os caracteres reconhecidos pelo JFugue
        KeyMapper mapping = new KeyMapper();
        Player player = new Player();
        // player.play("T290 I30 F F F F A# A# A# A# G# G# G# G# C# C# C# C#");
        // System.out.println("aqui ?");

        for (char ch : this.text.toCharArray()) {
            String jfugueKey = mapping.getMusicalAction((Character.toString(ch)));
            // System.out.println(jfugueKey);
            textMusic += jfugueKey + " ";
        }

        // System.out.println(textMusic);
        player.play(textMusic);
    }
}
