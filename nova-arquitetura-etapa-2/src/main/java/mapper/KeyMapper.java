package mapper;

import java.util.HashMap;
import java.util.Map;


public class KeyMapper {

    public Map<String, String> textMapping = new HashMap<String, String>();

    private final int INITIAL_VOLUME_VALUE = 63;

    private int volume = INITIAL_VOLUME_VALUE;

    public KeyMapper() {

        // Key: Fragmento de string retirada do texto input
        // Value: String correspondente que é reconhecida pelo JFugue
        this.textMapping.put("A", "A");
        this.textMapping.put("B", "B");
        this.textMapping.put("C", "C");
        this.textMapping.put("D", "D");
        this.textMapping.put("E", "E");
        this.textMapping.put("F", "F");
        this.textMapping.put("G", "G");
//        this.textMapping.put("a", "");
//        this.textMapping.put("b", "");
//        this.textMapping.put("c", "");
//        this.textMapping.put("d", "");
//        this.textMapping.put("e", "");
//        this.textMapping.put("f", "");
//        this.textMapping.put("g", "");
    }

    /**
     * Função que recebe o fragmento de texto do input e retorna
     * a string reconhecida pelo JFugue.
     */
    public String getMusicalAction(String textFragment) {

        final int VOLUME_MULTIPLICATION_FACTOR = 2;

        // Dobra o volume ou retorna ao volume original ao usar " "
        if(textFragment.equals(" ")) {
            if(volume <= INITIAL_VOLUME_VALUE) {
                volume *= VOLUME_MULTIPLICATION_FACTOR;
                setVolume(volume);
            } else {
                volume = INITIAL_VOLUME_VALUE;
                setVolume(volume);
            }
            return " ";
        } else {
            // No JFugue, aumenta-se o ataque das notas com o formato (Nota)(a)(Valor). Ex: Ca50. Onde o máximo valor é 127.
            return String.format("%sa%d", this.textMapping.get(textFragment), this.volume);
        }
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
