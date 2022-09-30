package models;

import static java.lang.Integer.parseInt;

import models.enums.KeyLookup;

public class KeyMapper {

    private final int INITIAL_VOLUME_VALUE = 63;
    final int VOLUME_MULTIPLICATION_FACTOR = 2;
    private final int PAN_FLUTE = 75;
    private final int CHURCH_ORGAN = 19;
    private final int TUBULAR_BELLS = 14;
    private final int AGOGO = 113;
    private final int HARPISCHORD = 6;
    private int volume = INITIAL_VOLUME_VALUE;
    private String currentNote = "";
    private int currentInstrument = 1;
    final int DEFAULT_OCTAVE = 4;
    private int currentOctave = DEFAULT_OCTAVE;
    final int MAXIMUM_OCTAVE = 8;

    public String getMusicalAction(String textFragment) {

        final String pauseOrRepeat = "abcdefg";
        final String pauseOrRepeatsConsonants = "hjklmnpqrstuvwxyzHJKLMNPQRSTUVWXYZ";
        final String changeToHarpsichord = "OoUuIi";
        final String digits = "123456789";

        switch (textFragment) {
            case " ":
                changeVolume();
                return " ";
            case "?":
                changeOctave();
                return " ";
            case "!":
                currentInstrument = AGOGO;
                return "I" + currentInstrument;
            case ";":
                currentInstrument = PAN_FLUTE;
                return "I" + currentInstrument;
            case ",":
                currentInstrument = CHURCH_ORGAN;
                return "I" + currentInstrument;
            case "\n":
                currentInstrument = TUBULAR_BELLS;
                return "I" + currentInstrument;
            default:
                final boolean isDigit = digits.contains(textFragment);
                final boolean shouldChangeToHarpsichord = changeToHarpsichord.contains(textFragment);
                final boolean shouldRepeat = pauseOrRepeat.contains(textFragment) || pauseOrRepeatsConsonants.contains(textFragment);

                if (isDigit) {
                    currentInstrument += parseInt(textFragment);
                    return "I" + currentInstrument;
                } else if (shouldChangeToHarpsichord) {
                    currentInstrument = HARPISCHORD;
                    return "I" + currentInstrument;
                } else if (shouldRepeat) {
                    if (!currentNote.isBlank()) {
                        return currentNote;
                    } else {
                        return " ";
                    }
                } else {
                    currentNote = getNote(textFragment);
                    return currentNote;
                }
        }

    }

    private void changeVolume() {
        if (volume <= INITIAL_VOLUME_VALUE) {
            volume *= VOLUME_MULTIPLICATION_FACTOR;
        } else {
            volume = INITIAL_VOLUME_VALUE;
        }
        currentNote = "";
    }

    private void changeOctave() {
        if (currentOctave < MAXIMUM_OCTAVE) {
            currentOctave++;
        } else {
            currentOctave = DEFAULT_OCTAVE;
        }
        currentNote = "";
    }

    private String getNote(String textFragment) {
        return KeyLookup.valueOf(textFragment) + Integer.toString(this.currentOctave) + "a" + this.volume;
    }
}
