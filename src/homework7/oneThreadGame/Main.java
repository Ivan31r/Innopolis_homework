package homework7.oneThreadGame;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String s = args[0];
        int a = Integer.parseInt(args[2]);
        GameOfLife gameOfLife = new GameOfLife(a);
        gameOfLife.readPropertiesAndInitializeField(new File("src/homework7/"+s));
        gameOfLife.showGameField();
        long start = System.currentTimeMillis();
        gameOfLife.playGame();
        System.out.println("Total time without Multithreading : " + (System.currentTimeMillis()-start) +" ms\n");
        gameOfLife.showGameField();
        gameOfLife.writeProperties(args[1]);






    }
}
