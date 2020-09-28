package homework7.test;

import homework7.MultithreadingGame.Game;
import homework7.oneThreadGame.GameOfLife;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class GameTest {

    @Test
    public void multithreadingGameQuicklyWHenOneThreadGame() throws IOException, InterruptedException {
        Game game = new Game();
        game.readPropertiesAndInitializeField(new File("D:/Innopolis/src/homework7/input.properties"));
        long start1 = System.currentTimeMillis();
        game.playGame();
        long end1 = System.currentTimeMillis()-start1;

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.readPropertiesAndInitializeField(new File("D:/Innopolis/src/homework7/input.properties"));
        long start2 = System.currentTimeMillis();
        game.playGame();
        long end2 = System.currentTimeMillis()-start2;

        System.out.println(end1);
        System.out.println(end2);

        Assert.assertTrue(end1>end2);

    }
}
