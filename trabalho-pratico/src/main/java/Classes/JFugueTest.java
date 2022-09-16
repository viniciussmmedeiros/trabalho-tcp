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
        player.play("T290 C5a50 C5a50 C6a50 C7a50 C8a50");
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
