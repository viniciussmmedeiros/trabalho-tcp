 import models.KeyMapper;
 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;

 import static java.lang.Integer.parseInt;
 import static org.junit.jupiter.api.Assertions.*;

 public class KeyMapperTest {

     @Test
     @DisplayName("Should return Do note when input is C")
     public void test_whenInputIsC_thenGetMusicalAction_shouldReturnCNote() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String input = "C";
         // Then
         final String output = sut.getMusicalAction(input);
         // Should
         final String expectedOutput = "C5a63";
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should return B note when input is B")
     public void test_whenInputIsB_thenGetMusicalAction_shouldReturnBNote() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String input = "B";
         // Then
         final String output = sut.getMusicalAction(input);
         // Should
         final String expectedOutput = "B5a63";
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should increase volume if input is space and its not maximum")
     public void test_whenInputSpaceAndVolumeIsNotMaximum_thenGetMusicalAction_shouldReturnNoteWithMaximumVolume() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper(); // KeyMapper has 2 volumes (63 and 128), and initiates with the lowest.
         // When
         final String increaseVolumeInput = " ";
         final String testNoteInput = "D";
         // Then
         sut.getMusicalAction(increaseVolumeInput);
         final String output = sut.getMusicalAction(testNoteInput);
         // Should
         final String expectedOutput = "D5a126"; // 126 represents the maximum volume
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should return to default volume when trying to increase maximum")
     public void test_whenInputSpaceAndVolumeIsMaximum_thenGetMusicalAction_shouldReturnNoteWithMinimumVolume() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper(); // KeyMapper has 2 volumes (63 and 128), and initiates with the lowest.
         // When
         final String increaseVolumeInput = " ";
         final String testNoteInput = "E";
         // Then
         sut.getMusicalAction(increaseVolumeInput); // Volume setting to maximum
         sut.getMusicalAction(increaseVolumeInput); // Volume setting back to minimum
         final String output = sut.getMusicalAction(testNoteInput);
         // Should
         final String expectedOutput = "E5a63"; // 126 represents the maximum volume
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should increase octave correctly if its not maximum")
     public void test_whenInputQuestionMark_thenGetMusicalAction_shouldReturnIncreasedOctaveNote() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper(); // KeyMapper has an initial octave of 5. Maximum is 10.
         // When
         final String increaseOctaveInput = "?";
         final String testNoteInput = "F";
         // Then
         sut.getMusicalAction(increaseOctaveInput);
         final String output = sut.getMusicalAction(testNoteInput);
         // Should
         final String expectedOutput = "F6a63"; // second char represents the current octave.
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should return to default octave when trying to increase maximum")
     public void test_whenOctaveIsMaximumAndInputQuestionMark_thenGetMusicalAction_shouldReturnNoteWithDefaultOctave() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper(); // KeyMapper has an initial octave of 5. Maximum is 10.
         // When
         final String increaseOctaveInput = "?";
         final String testNoteInput = "G";
         int numberOfOctavesToIncrease = 5;
         while(numberOfOctavesToIncrease>0) {
             sut.getMusicalAction(increaseOctaveInput);
             numberOfOctavesToIncrease -= 1;
         }
         // Then
         sut.getMusicalAction(increaseOctaveInput); // Increasing octave when octave is already on maximum
         final String output = sut.getMusicalAction(testNoteInput);
         // Should
         final String expectedOutput = "G5a63"; // second char represents the current octave.
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should change to agogo correctly")
     public void test_whenInputExclamationMark_thenGetMusicalAction_shouldReturnAgogoCode() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String setAgogoInput = "!";
         // Then
         final String output = sut.getMusicalAction(setAgogoInput);
         // Should
         final String agogoCode = "I113";
         assertEquals(agogoCode, output);
     }

     @Test
     @DisplayName("Should change to pan flute correctly")
     public void test_whenInputSemicolon_thenGetMusicalAction_shouldReturnFluteCode() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String setFluteInput = ";";
         // Then
         final String output = sut.getMusicalAction(setFluteInput);
         // Should
         final String fluteCode = "I75";
         assertEquals(fluteCode, output);
     }

     @Test
     @DisplayName("Should change to church organ correctly")
     public void test_whenInputComma_thenGetMusicalAction_shouldReturnOrganCode() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String setOrganInput = ",";
         // Then
         final String output = sut.getMusicalAction(setOrganInput);
         // Should
         final String organCode = "I19";
         assertEquals(organCode, output);
     }

     @Test
     @DisplayName("Should change to tubular bells correctly")
     public void test_whenInputNewLine_thenGetMusicalAction_shouldReturnTubularBellsCode() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String setTubularBellsInput = "\n";
         // Then
         final String output = sut.getMusicalAction(setTubularBellsInput);
         // Should
         final String tubularBellsCode = "I14";
         assertEquals(tubularBellsCode, output);
     }

     @Test
     @DisplayName("Should change to harpsichord correctly")
     public void test_whenInputI_thenGetMusicalAction_shouldReturnHarpsichordCode() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String setHarpsichordInput = "I";
         // Then
         final String output = sut.getMusicalAction(setHarpsichordInput);
         // Should
         final String harpsichordCode = "I6";
         assertEquals(harpsichordCode, output);
     }

     @Test
     @DisplayName("Should calculate new midi correctly when input is digit")
     public void test_whenInputIsDigit_thenGetMusicalAction_shouldReturnInstrumentCodeAddingInputNumber() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String addToMIDINumberInput = "8";
         // Then
         final String output = sut.getMusicalAction(addToMIDINumberInput);
         // Should
         final int INITIAL_MIDI_NUMBER = 1;
         final int expectedMIDINumber = INITIAL_MIDI_NUMBER + parseInt(addToMIDINumberInput);
         final String expectedOutput = "I" + expectedMIDINumber;
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should pause when last note doesnt exist and input is non note consonant")
     public void test_whenLastInputWasNotNoteAndInputIsNonNoteConsonant_thenGetMusicalAction_shouldReturnPause() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String nonVogalInput = "J";
         final String nonNoteInput = "!";
         sut.getMusicalAction(nonNoteInput);
         // Then
         final String output = sut.getMusicalAction(nonVogalInput);
         // Should
         final String expectedOutput = " ";
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should repeat last note if exists when input is non note consonant")
     public void test_whenLastInputWasNoteAndInputIsNonNoteConsonant_thenGetMusicalAction_shouldRepeatNote() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String nonNoteConsonantInput = "K";
         final String testNote = "A";
         sut.getMusicalAction(testNote);
         // Then
         final String output = sut.getMusicalAction(nonNoteConsonantInput);
         // Should
         final String expectedOutput = "A5a63";
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should change to Harpsichord when input is non note vogal")
     public void ShouldPauseWhenLastNoteDoesntExistAndInputIsNonNoteConsonant() {
         // Model (sut) setup
         final KeyMapper sut = new KeyMapper();
         // When
         final String nonNoteVogalInput = "U";
         // Then
         final String output = sut.getMusicalAction(nonNoteVogalInput);
         // Should
         final String harpsichordCode = "I6";
         assertEquals(harpsichordCode, output);
     }
 }
