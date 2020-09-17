package homework3;

import java.util.Arrays;

public class SecondMethod implements Sort {

    /**
     * This method sort income array by sex,age and name parameters.
     * @param people1 income array.
     */
    @Override
    public void sortArray(Person[] people1) {
        sortArrayBySex(people1);
        int manCount = getManCount(people1);
        Person[] manArray = new Person[manCount];
        Person[] womanArray = new Person[people1.length - manCount];

        System.arraycopy(people1, 0, manArray, 0, manCount);
        System.arraycopy(people1, people1.length - manCount, womanArray, 0, womanArray.length);
        sortArrayByAge(manArray);
        sortArrayByAge(womanArray);
        sortArrayByName(manArray);
        sortArrayByName(womanArray);

        System.arraycopy(manArray, 0, people1, 0, manArray.length);
        System.arraycopy(womanArray, 0, people1, people1.length - manArray.length, womanArray.length);


    }


    private void sortArrayByAge(Person[] people1) {
        for (int i = 0; i < people1.length; i++) {
            for (int j = 0; j < people1.length - 1; j++) {
                if (people1[j].getAge() < people1[j + 1].getAge()) {
                    swap(j, j + 1, people1);
                }
            }
        }
    }

    private void sortArrayByName(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length - 1; j++) {
                if (people[j].getAge() == people[j + 1].getAge()) {
                    if (people[j].getName().compareTo(people[j + 1].getName()) < 0) {
                        swap(j, j + 1, people);
                    }
                }
            }
        }
    }

    private static void swap(int firstIndex, int secondIndex, Person[] people) {
        Person old = people[firstIndex];
        people[firstIndex] = people[secondIndex];
        people[secondIndex] = old;
    }

    private void sortArrayBySex(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSex() == Sex.MAN) {
                continue;
            }
            for (int j = i + 1; j < people.length; j++) {
                if (people[j].getSex() == Sex.MAN) {
                    swap(i, j, people);
                    break;
                }
            }
        }
    }


    private int getManCount(Person[] people) {
        int manCount = 0;
        for (Person person : people) {
            if (person.getSex().equals(Sex.WOMAN)) {
                break;
            }
            manCount++;
        }
        return manCount;
    }
}
