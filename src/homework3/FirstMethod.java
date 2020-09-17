package homework3;

import java.util.Arrays;

public class FirstMethod implements Sort{


    public FirstMethod(){
    }

    /**
     * This method works with implements of Comparators.
     * We use PersonComparatorBySex and PersonComparatorByAgeAndName.
     * @param people
     */

    public void  sortArray(Person[] people){
        Arrays.sort(people, new PersonComparatorBySex().thenComparing(new PersonComparatorByAgeAndName()));
    }

}
