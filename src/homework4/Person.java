package homework4;

public class Person implements Comparable {
    private final int age;
    private final String name;
    private final String sex;

    public Person(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person " + "age=" + age + " name=" + name  + " sex=" + sex ;
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        int result =0;
        if (getSex().compareTo(person.getSex()) > 0) {
            result++;
        } else {
            result--;
        }
        if (getAge()>person.getAge()){
            result--;
        }else {
            result++;
        }
        if (getName().compareTo(person.getName())>0){
            result++;
        }else {
            result--;
        }
//        return getAge()>person.getAge()?-1 : 1;
//        return getName().compareTo(person.getName());
        return result;
    }


}
