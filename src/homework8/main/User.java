package homework8.main;

public class User {
    private short age;
    private String name;
    private boolean sex;
    private char ch;

    public User(short age, String name, boolean sex, char c) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.ch = c;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name=" + name  +
                ", sex=" + sex +
                ", c=" + ch +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public char getC() {
        return ch;
    }
}
