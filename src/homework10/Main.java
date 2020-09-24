package homework10;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    private final static String Path = "D:/Innopolis/src/homework10/";

    public static void main(String[] args) {
        try {
            CreateClass createClass = new CreateClass("SomeClass");
            createClass.createBody();

            System.out.println("CREATE SOMECLASS");

            JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
            javac.run(null, System.out, System.err, "src/homework10/SomeClass.java");

            System.out.println("USE JAVAC");

            PersonalClassLoader classLoader = new PersonalClassLoader(Path + "SomeClass");

            System.out.println("USE CLASSLOADER");

            Class<?> someClass = classLoader.loadClass("SomeClass");
            Object instance = someClass.getConstructors()[0].newInstance();
            someClass.getMethods()[0].invoke(instance);
        } catch (IOException | InstantiationException | InvocationTargetException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
