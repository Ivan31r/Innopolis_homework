package homework4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class PeopleGenerator {
    private static String Path = "src/homework3/names.txt";

    public Person[] generatePeopleArray(int i) throws IOException {
        Person[] people = new Person[i];

        String[] names = readNames(Path);
        Random random = new Random();

        for (int j = 0; j < i; j++) {
            String name = names[random.nextInt(100)];
            int age = random.nextInt(100);
            boolean manOrWoman = random.nextBoolean();
            String sex = manOrWoman ? Sex.MAN : Sex.WOMAN;
            people[j]=new Person(age,name,sex);
        }

        return people;
    }

    private static String[] readNames(String PATH) throws IOException {
        Path paths = Paths.get("src/homework4/names.txt");
        List<String> list = Files.readAllLines(paths);
        String[] names = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            names[i] = list.get(i);
        }
        return names;
    }
}
