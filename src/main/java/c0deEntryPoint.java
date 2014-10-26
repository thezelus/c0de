import cardGame.exceptions.EmptyDeckException;
import cardGame.util.GamePlay;
import shuffler.Shuffler;

import java.util.Arrays;

public class c0deEntryPoint {
    public static void main(String[] args) {
        try {
            GamePlay.start();
        } catch (EmptyDeckException e) {
            throw new RuntimeException(e.getMessage(), e);
        }


        System.out.println("\n Shuffler result with n = 18");
        System.out.println(Arrays.toString(Shuffler.shuffle(18)));

    }
}
