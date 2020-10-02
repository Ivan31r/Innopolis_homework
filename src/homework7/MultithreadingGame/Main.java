package homework7.MultithreadingGame;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game(Integer.parseInt(args[2]));
        game.readPropertiesAndInitializeField(new File("src/homework7/"+args[0]));
        game.showGameField();
        long start = System.currentTimeMillis();
        game.playGame();
        System.out.println("Total time with multithreading : " + (System.currentTimeMillis()-start) + " ms");
        game.showGameField();
        game.writeProperties(args[1]);

    }
}
