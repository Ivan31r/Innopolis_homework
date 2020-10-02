package homework8.main;


import java.util.Set;

public interface Cleaner {
    void cleanUp(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) throws IllegalAccessException;
}
