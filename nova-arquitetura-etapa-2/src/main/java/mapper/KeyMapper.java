package mapper;

import enums.KeyLookup;

public class KeyMapper {

    private final int INITIAL_VOLUME_VALUE = 63;

    private int volume = INITIAL_VOLUME_VALUE;

    private String currentNote = "";

    public String getMusicalAction(String textFragment) {

        final int VOLUME_MULTIPLICATION_FACTOR = 2;
        final String pauseOrRepeat = "abcdefg";
        final String pauseOrRepeatsConsonants = "hjklmnpqrstuvwxyzHJKLMNPQRSTUVWXYZ";
        final String changeToHarpsichord = "OoUuIi";
        final String digits = "123456789";

        // Dobra o volume ou retorna ao valor original ao usar " "
        if(textFragment.equals(" ")) {
            if(volume <= INITIAL_VOLUME_VALUE) {
                volume *= VOLUME_MULTIPLICATION_FACTOR;
            } else {
                volume = INITIAL_VOLUME_VALUE;
            }
            currentNote = "";
            return " ";
        } else if(textFragment.equals("!")) {
            // Troca para MIDI #114 (agogo)
        } else if(textFragment.equals("?")) {
            // Aumenta uma oitava ou volta para o padrão se não puder aumentar
        } else if(textFragment.equals(";")) {
            // Troca para MIDI #76 (Pan Flute)
        } else if(textFragment.equals(",")) {
            // Troca para MIDI #20 (Church Organ)
        } else if(textFragment.equals("CRLF")) {
            // Troca para MIDI @15 (Tubular Bells)
        } else if(changeToHarpsichord.contains(textFragment)) {
            // Troca para MIDI #7 (Harpsichord)
        } else if(digits.contains(textFragment)) {
            // Troca para MIDI #Atual+Dígito
        } else {
            // Casos das letras mínusculas, consoante exceto nota e ELSE são iguais...
            if(pauseOrRepeat.contains(textFragment) || pauseOrRepeatsConsonants.contains(textFragment)) {
                if(!currentNote.isBlank()) {
                    return currentNote;
                } else {
                    return " ";
                }
            }

            return " ";
        }

        // No JFugue, aumenta-se o ataque das notas com o formato (Nota)(a)(Valor). Ex: Ca50. Onde o valor máximo é 127.
        currentNote = String.format("%sa%d", KeyLookup.valueOf(textFragment), this.volume);

        return currentNote;
    }
}
