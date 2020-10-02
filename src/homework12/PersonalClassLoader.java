package homework12;

import java.util.ArrayList;
import java.util.List;

public class PersonalClassLoader {
    private List<Class<?>> classList = new ArrayList<>();

    public void classLoader() throws ClassNotFoundException {
        ClassLoader classLoader = new ClassLoader() {
            public Class<?> loadClass(String classNameWithPackage) throws ClassNotFoundException {
                if (!classNameWithPackage.contains("ClassToLoad")) {
                    return super.loadClass(classNameWithPackage);
                }
                final byte[] bytes = new byte[]{-54, -2, -70, -66, 0, 0, 0, 52, 0, 17, 10, 0, 4, 0, 13, 8, 0,
                        14, 7, 0, 15, 7, 0, 16, 1, 0, 6, 60, 105, 110, 105, 116, 62, 1, 0, 3, 40, 41,
                        86, 1, 0, 4, 67, 111, 100, 101, 1, 0, 15, 76, 105, 110, 101, 78, 117, 109, 98,
                        101, 114, 84, 97, 98, 108, 101, 1, 0, 8, 116, 111, 83, 116, 114, 105, 110, 103,
                        1, 0, 20, 40, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114,
                        105, 110, 103, 59, 1, 0, 10, 83, 111, 117, 114, 99, 101, 70, 105, 108, 101, 1, 0,
                        16, 67, 108, 97, 115, 115, 84, 111, 76, 111, 97, 100, 46, 106, 97, 118, 97, 12, 0,
                        5, 0, 6, 1, 0, 14, 84, 101, 115, 116, 32, 99, 108, 97, 115, 115, 33, 33, 33, 33, 1,
                        0, 11, 67, 108, 97, 115, 115, 84, 111, 76, 111, 97, 100, 1, 0, 16, 106, 97, 118, 97,
                        47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 0, 33, 0, 3, 0, 4, 0, 0, 0, 0,
                        0, 2, 0, 1, 0, 5, 0, 6, 0, 1, 0, 7, 0, 0, 0, 29, 0, 1, 0, 1, 0, 0, 0, 5, 42, -73, 0,
                        1, -79, 0, 0, 0, 1, 0, 8, 0, 0, 0, 6, 0, 1, 0, 0, 0, 1, 0, 1, 0, 9, 0, 10, 0, 1, 0, 7,
                        0, 0, 0, 27, 0, 1, 0, 1, 0, 0, 0, 3, 18, 2, -80, 0, 0, 0, 1, 0, 8, 0, 0, 0, 6, 0, 1, 0,
                        0, 0, 1, 0, 1, 0, 11, 0, 0, 0, 2, 0, 12};
                Class<?> cl = defineClass(null, bytes, 0, bytes.length);
                resolveClass(cl);
                classList.add(cl);
                return cl;
            }
        };
        Class.forName("ClassToLoad", true, classLoader);
    }
}