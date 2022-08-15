package controller.response;

import mapper.KeyMapper;
import org.jfugue.player.Player;

public class GenerateMusicResponse {

    private final String text;

    public GenerateMusicResponse(String text) {
        this.text = text;
    }

    public void textProcessing () {
        // mapeamento para conseguir os caracteres reconhecidos pelo JFugue
        KeyMapper mapping = new KeyMapper();
        Player player = new Player();

        for(char ch: this.text.toCharArray()) {
            String jfugueKey = mapping.getMusicalAction((Character.toString(ch)));
            System.out.println(jfugueKey);
            player.play(jfugueKey);
        }
    }
}
