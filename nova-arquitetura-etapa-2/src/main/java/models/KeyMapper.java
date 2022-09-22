package models;

import static java.lang.Integer.parseInt;

import models.enums.KeyLookup;

public class KeyMapper {

    private final int INITIAL_VOLUME_VALUE = 63;
    private final int PAN_FLUTE = 75;
    private final int CHURCH_ORGAN = 19;
    private final int TUBULAR_BELLS = 14;
    private final int AGOGO = 113;
    private final int HARPISCHORD = 6;
    private int volume = INITIAL_VOLUME_VALUE;
    private String currentNote = "";
    private int currentInstrument = 1;
    private int currentOctave = 5;

    public String getMusicalAction(String textFragment) {

        final int VOLUME_MULTIPLICATION_FACTOR = 2;
        final int DEFAULT_OCTAVE = 5;
        final int MAXIMUM_OCTAVE = 10;
        final String pauseOrRepeat = "abcdefg";
        final String pauseOrRepeatsConsonants = "hjklmnpqrstuvwxyzHJKLMNPQRSTUVWXYZ";
        final String changeToHarpsichord = "OoUuIi";
        final String digits = "123456789";

        if(textFragment.equals(" ")) {
            if(volume <= INITIAL_VOLUME_VALUE) {
                volume *= VOLUME_MULTIPLICATION_FACTOR;
            } else {
                volume = INITIAL_VOLUME_VALUE;
            }

            currentNote = "";
            return " ";
        } else if(textFragment.equals("!")) {
            currentInstrument = AGOGO;

            return "I" + currentInstrument;
        } else if(textFragment.equals("?")) {
            if(currentOctave < MAXIMUM_OCTAVE) {
                currentOctave++;
            } else {
                currentOctave = DEFAULT_OCTAVE;
            }

            currentNote = "";
            return " ";
        } else if(textFragment.equals(";")) {
            currentInstrument = PAN_FLUTE;

            return "I" + currentInstrument;
        } else if(textFragment.equals(",")) {
            currentInstrument = CHURCH_ORGAN;

            return "I" + currentInstrument;
        } else if(textFragment.equals("\n")) {
            currentInstrument = TUBULAR_BELLS;

            return "I" + currentInstrument;
        } else if(changeToHarpsichord.contains(textFragment)) {
            currentInstrument = HARPISCHORD;

            return "I" + currentInstrument;
        } else if(digits.contains(textFragment)) {
            currentInstrument += parseInt(textFragment);

            return "I" + currentInstrument;
        } else {
            if(pauseOrRepeat.contains(textFragment) || pauseOrRepeatsConsonants.contains(textFragment)) {
                if(!currentNote.isBlank()) {
                    return currentNote;
                } else {
                    return " ";
                }
            }
        }

        // No JFugue, aumenta-se o ataque das notas com o formato (Nota)(a)(Valor). Ex: Ca50. Onde o valor máximo é 127.
        currentNote = String.format("%s%da%d", KeyLookup.valueOf(textFragment), this.currentOctave, this.volume);
        System.out.println(currentNote);

        return currentNote;
    }
}
