package homework10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersonalClassLoader extends ClassLoader {
    private final String PATH;

    public PersonalClassLoader(String Path) {
        PATH = Path;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            if (name.toLowerCase().contains("someclass")) {
                final byte[] bytes = Files.readAllBytes(Paths.get(PATH + ".class"));
                return defineClass(null, bytes, 0, bytes.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
