package homework3;

import java.util.Arrays;

public class SecondMethod implements Sort{

    public Person[] sortArray(Person[] people) {
        if (people.length<=1){
            return people;
        }
        Person[] firstHalf = new Person[people.length/2];
        Person[] secondHalf = new Person[people.length-firstHalf.length];
        System.arraycopy(people,0,firstHalf,0,firstHalf.length);
        System.arraycopy(people,firstHalf.length,secondHalf,0,secondHalf.length);

        sortArray(firstHalf);
        sortArray(secondHalf);

        merge(firstHalf,secondHalf,people);
        return people;


    }

    private static void merge(Person[] firstPart,Person[] secondPart, Person[] people){
        int first=0;
        int second=0;
        int mergeCount = 0;
        while (first<firstPart.length && second<secondPart.length){
            if (firstPart[first].compareTo(secondPart[second])<0){
                people[mergeCount]=firstPart[first];
                first++;
            }else {
                people[mergeCount]=secondPart[second];
                second++;
            }
            mergeCount++;
        }
        System.arraycopy(firstPart,first,people,mergeCount,firstPart.length-first);
        System.arraycopy(secondPart,second,people,mergeCount,secondPart.length-second);
    }

    @Override
    public void showRes(Person[] people) {
        System.out.println(Arrays.toString(people));

    }
}
