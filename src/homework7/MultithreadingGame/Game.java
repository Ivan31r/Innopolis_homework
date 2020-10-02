package homework7.MultithreadingGame;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    public final char aliveCell;
    private final char deadCell;
    public char[][] gameField;
    private int length;
    private int width;
    private final char willBeAlive = '✅';
    private final char willBeDead = '☠';
    private int changes;
    private final int maxStepCounter;
    private int currentStep;


    public Game(int maxStepCounter) {
        aliveCell = '✖';
        deadCell = '⯐';
        this.maxStepCounter=maxStepCounter;
    }

    /**
     * Read data for initialize our figure and size of game field.
     *
     * @param file properties file with income data
     * @throws IOException
     */
    public void readPropertiesAndInitializeField(File file) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(file));
        length = Integer.parseInt(properties.getProperty("length"));
        width = Integer.parseInt(properties.getProperty("width"));

        gameField = new char[length][width];

        fill();

        for (int i = 1; i < properties.size() / 2; i++) {
            int x = Integer.parseInt(properties.getProperty("x" + i));
            int y = Integer.parseInt(properties.getProperty("y" + i));
            gameField[x][y] = '✖';
        }

    }

    /**
     * Method for writing of final position of our figure.
     */
    public void writeProperties(String path) {
        try (PrintWriter printWriter = new PrintWriter("src/homework7/"+path)) {
            Properties properties = new Properties();
            int x = 1;
            int y = 1;

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (gameField[i][j] == aliveCell) {
                        properties.setProperty("x" + x, String.valueOf(i));
                        properties.setProperty("y" + y, String.valueOf(j));


                        x++;
                        y++;
                    }
                }
            }
            properties.store(printWriter, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void fill() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                gameField[i][j] = '⯐';
            }
        }
    }

    /**
     * Display of our figure.
     */
    public void showGameField() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Main method in this class. Do next loop, until we will touch the wall.
     */

    public void playGame() throws InterruptedException {
        do {
            nextLoop();
        } while (changes != 0 && currentStep<maxStepCounter);
    }

    private void nextLoop() throws InterruptedException {
        int core = Runtime.getRuntime().availableProcessors();
        int parts = gameField.length / core;
        int startIndex = 0;
        changes = 0;

        ExecutorService service = Executors.newFixedThreadPool(core);

        for (int i = 0; i < core; i++) {
            if (parts - i == 1) {
                parts = gameField.length;
            }

            int finalStartIndex = startIndex;
            int finalParts = parts;
            int finalI = i;
            service.execute(() -> doNextLoop(finalStartIndex, finalParts * (finalI + 1)));
            startIndex += parts;
        }


        service.shutdown();
        service.awaitTermination(5, TimeUnit.MINUTES);


        setAliveValue();
        currentStep++;


    }

    private void doNextLoop(int start, int end) {
        for (; start < end; start++) {
            for (int y = 0; y < length; y++) {
                checkCell(start, y);
            }
        }
    }


    private boolean innerCheck(int x, int y) {
        return gameField[x][y] == aliveCell || gameField[x][y] == willBeDead;
    }

    private void checkCell(int x, int y) {
        int counter = 0;

        if (checkLimit(x, y + 1) && (innerCheck(x, y + 1))) {
            counter++;
        }
        if (checkLimit(x, y - 1) && (innerCheck(x, y - 1))) {
            counter++;
        }
        if (checkLimit(x - 1, y) && (innerCheck(x - 1, y))) {
            counter++;
        }
        if (checkLimit(x + 1, y) && (innerCheck(x + 1, y))) {
            counter++;
        }
        if (checkLimit(x + 1, y + 1) && (innerCheck(x + 1, y + 1))) {
            counter++;
        }
        if (checkLimit(x + 1, y - 1) && (innerCheck(x + 1, y - 1))) {
            counter++;
        }
        if (checkLimit(x - 1, y + 1) && (innerCheck(x - 1, y + 1))) {
            counter++;
        }
        if (checkLimit(x - 1, y - 1) && (innerCheck(x - 1, y - 1))) {
            counter++;
        }

        if (counter == 3 && gameField[x][y] == deadCell) {
            gameField[x][y] = willBeAlive;
            changes++;
            return;
        }
        if ((counter > 3 || counter < 2) && (gameField[x][y] == aliveCell)) {
            gameField[x][y] = willBeDead;
            changes++;
        }
    }


    private boolean checkLimit(int x, int y) {
        return x >= 0 && y >= 0 && x < length && y < width;
    }

    private void setAliveValue() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (gameField[i][j] == willBeAlive) {
                    gameField[i][j] = aliveCell;
                }
                if (gameField[i][j] == willBeDead) {
                    gameField[i][j] = deadCell;
                }
            }

        }
    }
}