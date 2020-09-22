package homework12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        List<Person> personList = new ArrayList<>();
        for (int i= 0;i<2000000000;i++){

            personList.add(new Person(i,"name" + i,new Random().nextBoolean()));
        }
        personList.forEach(System.out::println);
        scanner.nextLine();
    }
}
