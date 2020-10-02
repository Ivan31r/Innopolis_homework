package homework12;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OutOfMemory {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("What do you want, heap space or mata space?");
        System.out.println("1-HeapSpace");
        System.out.println("2-MetaSpace");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if ((a == 1)) {
            doJavaHeadSpace();
        } else if (a==2){
            doMetaspace();
        }else
            System.out.println("Wrong number");


    }


    public static void doJavaHeadSpace() {
        Random random = new Random();
        String name = "name";
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 50_000; i++) {
            people.add(new Person(i, name, random.nextBoolean()));
        }
        int age = 0;
        while (true) {
            people.add(50_000, new Person(age, name, random.nextBoolean()));
            age++;
            name += name;
            if (age % 500 == 0) {
                people.remove(1000);
            }
        }
    }

    public static void doMetaspace() throws ClassNotFoundException {
        PersonalClassLoader classLoader = new PersonalClassLoader();
        while (true) {
            classLoader.classLoader();
        }
    }

}
