package homework7;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.readPropertiesAndInitializeField(new File("D:/Innopolis/src/homework7/input.properties"));
        gameOfLife.showGameField();
        gameOfLife.playGame();
        gameOfLife.showGameField();
        gameOfLife.writeProperties();

        System.out.println(Runtime.getRuntime().availableProcessors());





    }
}
