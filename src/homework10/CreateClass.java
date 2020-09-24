package homework10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateClass {
    private final StringBuilder classBody = new StringBuilder();
    private final String path = "D:/Innopolis/src/homework10/SomeClass.java";
    private final String className;

    public CreateClass(String className) {
        this.className = className;
    }

    /**
     * Method for create class's body. We use BufferedReader to fill our body.
     *
     * @throws IOException Could be from BufferedReader.
     */
    public void createBody() throws IOException {
        classBody.append("package homework10;\n\n").append("public class ").append(className).append(" implements Worker {\n")
                .append("    @Override\n")
                .append("    public void doWork() {\n\t");


        System.out.println("Write method body");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        while (!(s = reader.readLine()).isEmpty()) {
            classBody.append(s);
        }

        classBody.append("\n").append("    }\n").append("}\n");
        reader.close();

        writeBodyToClassFormat();

    }

    private void writeBodyToClassFormat() {
        try {
            Files.write(Paths.get(path), classBody.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
