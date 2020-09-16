package homework3;

import java.io.IOException;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) throws IOException {

        FirstMethod firstMethod = new FirstMethod();
        PeopleGenerator peopleGenerator = new PeopleGenerator();
        long start = System.currentTimeMillis();
        Person[] people1 = peopleGenerator.generatePeopleArray(1000);
        Person[] sortPerson = firstMethod.sortArray(people1);

        System.out.println("First method took " + (System.currentTimeMillis()-start) + " ms");

        firstMethod.showRes(people1);
        firstMethod.showRes(sortPerson);

//        SecondMethod secondMethod = new SecondMethod();
//        PeopleGenerator peopleGenerator = new PeopleGenerator();
//        long start = System.currentTimeMillis();
//        Person[] people = peopleGenerator.generatePeopleArray(1000);
//        System.out.println(Arrays.toString(people));
//        secondMethod.sortArray(people);
//        System.out.println("Total time " + (System.currentTimeMillis()-start));
//        System.out.println(Arrays.toString(people));




    }


}
