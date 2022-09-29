 import models.MusicInputHandler;
 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;

 import static org.junit.jupiter.api.Assertions.assertEquals;

 public class MusicInputHandlerTest {

     @Test
     @DisplayName("Should return correct jfugue String for correct input")
     public void test_whenCorrectInputIsGiven_thenTextProcessing_shouldReturnJFugueString() {
         // When
         final String input = "CDEFG";
         // Model (sut) setup
         final MusicInputHandler sut = new MusicInputHandler(input);
         // Then
         final String output = sut.textProcessing();
         // Should
         final String expectedOutput = "C5a63 D5a63 E5a63 F5a63 G5a63 ";
         assertEquals(expectedOutput, output);
     }

     @Test
     @DisplayName("Should return String with incorrect characters when input has any")
     public void test_whenIncorrectInputIsGiven_thenTextProcessing_shouldReturnIncorrectCharactersString() {
         // When
         final String input = "CDE[F`G";
         // Model (sut) setup
         final MusicInputHandler sut = new MusicInputHandler(input);
         // Then
         sut.textProcessing();
         final String output = sut.getInputErrorChars();
         // Should
         final String expectedOutput = "[ ` ";
         assertEquals(expectedOutput, output);
     }
 }
