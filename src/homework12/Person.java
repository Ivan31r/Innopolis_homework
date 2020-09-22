package homework12;

public class Person {
    private  int age;
    private String name;
    private boolean sex;

    public Person(int age, String name, boolean sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
