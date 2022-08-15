package main.java.Classes;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * Rodem diretamente essa classe para testarem se o JFugue
 * está setado corretamente dentro do projeto na máquina
 * de vocês.
 */

public class JFugueTest {
    public static void main(String[] args) {
        Player player = new Player();
//        Pattern pattern =
        player.play("T290 C R Da100  R Ea127 R F G A B");
        /*
         C = Dó
         D = Ré
         E = Mi
         F = Fá
         G = Sol
         A = Lá
         B = Si
         R = Rest (pausa)
        */
    }
}
