package main.java.Classes;
import org.jfugue.player.Player;

/**
 * Rodem diretamente essa classe para testarem se o JFugue
 * está setado corretamente dentro do projeto na máquina
 * de vocês.
 */

public class JFugueTest {
    public static void main(String[] args) {
        Player player = new Player();
        player.play("C R D R E R F G A B");
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
