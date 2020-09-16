package homework3;

import java.util.Arrays;

public class FirstMethod implements Sort{


    public FirstMethod(){
    }

    public Person[] sortArray(Person[] people){
        Person[]temp = new Person[people.length];
        System.arraycopy(people,0,temp,0,people.length);
        Arrays.sort(temp, new PersonComparatorBySex().thenComparing(new PersonComparatorByAgeAndName()));
        return temp;
    }
    public  void showRes(Person[]people){
        System.out.println(Arrays.toString(people));
    }

}
