package homework7.oneThreadGame;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.readPropertiesAndInitializeField(new File("D:/Innopolis/src/homework7/input.properties"));
        gameOfLife.showGameField();
        long start = System.currentTimeMillis();
        gameOfLife.playGame();
        System.out.println("Total time without Multithreading : " + (System.currentTimeMillis()-start) +" ms\n");
        gameOfLife.showGameField();
        gameOfLife.writeProperties();






    }
}
