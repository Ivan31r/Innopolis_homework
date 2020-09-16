package homework3;

import java.util.Comparator;

public class PersonComparatorByAgeAndName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge()==o2.getAge()){
            if (o1.getName().equals(o2.getName())){
                throw new RuntimeException("Identical age and name");
            }
            return o1.getName().compareTo(o2.getName());
        }else
            return o2.getAge()-o1.getAge();
    }
}
