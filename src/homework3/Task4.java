package homework3;

import java.io.IOException;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) throws IOException, InterruptedException {

        PeopleGenerator peopleGenerator = new PeopleGenerator();
        Person[] peopleForFirstMethod = peopleGenerator.generatePeopleArray(30);
        Person[] peopleForSecondMethod = peopleGenerator.generatePeopleArray(30);


        FirstMethod firstMethod = new FirstMethod();
        SecondMethod secondMethod = new SecondMethod();

        long start = System.currentTimeMillis();
        firstMethod.sortArray(peopleForFirstMethod);
        System.out.println("First method take = " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        secondMethod.sortArray(peopleForSecondMethod);
        System.out.println("Second method take = " + (System.currentTimeMillis() - start) + " ms");


    }


}
