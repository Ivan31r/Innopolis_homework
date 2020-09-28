package homework7.MultithreadingGame;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        game.readPropertiesAndInitializeField(new File("D:/Innopolis/src/homework7/input.properties"));
        game.showGameField();
        long start = System.currentTimeMillis();
        game.playGame();
        System.out.println("Total time with multithreading : " + (System.currentTimeMillis()-start) + " ms");
        game.showGameField();

    }
}
