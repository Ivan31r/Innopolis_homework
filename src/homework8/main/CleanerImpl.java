package homework8.main;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CleanerImpl implements Cleaner {

    public CleanerImpl(){
    }


    /**
     * This method can clean your object by income parameters
     * @param object Can be is simple object as Map implementation
     * @param fieldsToCleanup Set of name of fields witch will be delete
     * @param fieldsToOutput Set of name of fields witch will be shown on console
     * @throws IllegalAccessException Could be in case invalid Set of fieldsToCleanup or fieldsToOutput
     */

    @Override
    public  void cleanUp(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput){
        try {
            if (object instanceof Map) {
                Map map = (Map) object;
                cleanMap(map, fieldsToCleanup, fieldsToOutput);
                return;
            }
            cleanNotMapObject(object, fieldsToCleanup);
            printFieldsAsString(object, fieldsToOutput);
        }catch (IllegalAccessException ex){
            ex.printStackTrace();
        }


    }


    /**
     * Inner method for objects. This method do default all primitive value
     * @param object Income object, not a Map implementation.
     * @param fieldsToCleanup Set with fields,which will have default value in object
     * @throws IllegalAccessException
     */

    private static void cleanNotMapObject(Object object, Set<String> fieldsToCleanup) throws IllegalAccessException {
        Class<?> userClass = object.getClass();

        Field[] fields = userClass.getDeclaredFields();

        for (String s : fieldsToCleanup) {
            if (!Arrays.stream(fields).map(Field::getName).collect(Collectors.toList()).contains(s)) {
                throw new IllegalArgumentException(" =( " + s);
            }
        }

        for (Field field : fields) {
            field.setAccessible(true);

        }
        for (Field field : fields) {
            if (fieldsToCleanup.contains(field.getName())) {
                Class<?> fieldType = field.getType();
                switch (fieldType.getName()) {
                    case "int":
                        field.setInt(object, 0);
                        break;
                    case "byte":
                        field.setByte(object, (byte) 0);
                        break;
                    case "short":
                        field.setShort(object, (short) 0);
                        break;
                    case "long":
                        field.setLong(object, 0);
                        break;
                    case "char":
                        field.setChar(object, (char) 0);
                        break;
                    case "double":
                        field.setDouble(object, 0.0);
                        break;
                    case "float":
                        field.setFloat(object, .0f);
                        break;
                    case "boolean":
                        field.setBoolean(object, false);
                        break;
                    default:
                        field.set(object, null);
                }
            }
        }
    }

    /**
     * Inner method for objects. This method print all value,which fieldsToOutput has.
     * @param object Income object, it could be any object.
     * @param fieldsToOutput Set with field
     * @throws IllegalAccessException
     */
    private static void printFieldsAsString(Object object, Set<String> fieldsToOutput) throws IllegalAccessException {
        Class<?> userClass = object.getClass();
        Field[] fields = userClass.getDeclaredFields();

        for (String s : fieldsToOutput) {
            if (!Arrays.stream(fields).map(Field::getName).collect(Collectors.toList()).contains(s)) {
                throw new IllegalArgumentException(" =( " + s);
            }
        }

        for (Field field : fields) {
            field.setAccessible(true);
        }
        for (Field field : fields) {
            if (fieldsToOutput.contains(field.getName())) {
                Class<?> fieldType = field.getType();
                switch (fieldType.getName()) {
                    case "int":
                        System.out.println("int =" + String.valueOf(field.get(object)));
                        break;
                    case "byte":
                        System.out.println("byte = " + String.valueOf(field.get(object)));
                        break;
                    case "short":
                        System.out.println("short = " + String.valueOf(field.get(object)));
                        break;
                    case "long":
                        System.out.println("long = " + String.valueOf(field.get(object)));
                        break;
                    case "char":
                        System.out.println("char = " + String.valueOf(field.get(object)));
                        break;
                    case "double":
                        System.out.println("double = " + String.valueOf(field.get(object)));
                        break;
                    case "float":
                        System.out.println("float = " + String.valueOf(field.get(object)));
                        break;
                    case "boolean":
                        System.out.println("boolean = " + String.valueOf(field.get(object)));
                        break;
                    default:
                        System.out.println(field.getType().getCanonicalName() + " = " + field.get(object).toString());
                }
            }

        }
    }

    /**
     * Method for delete keys from instance of Map implementation class.
     * @param map Income object,Map implementation,has key and value.
     * @param fieldsToCleanup Set with field for delete.
     * @param fieldsToOutput Set with field for printing.
     * @throws IllegalAccessException
     */
    private static void cleanMap(Map map, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) throws IllegalAccessException {

        for (String s : fieldsToCleanup) {
            if (!map.containsKey(s))
                throw new IllegalAccessException("No key");
        }
        for (String s : fieldsToOutput) {
            if (!map.containsValue(s)) {
                throw new IllegalAccessException("No value");
            }
        }


        StringBuilder stringBuilder = new StringBuilder("Map values : { ");
        Iterator<Map.Entry<?, ?>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<?, ?> entry = entryIterator.next();
            if (fieldsToCleanup.contains(entry.getKey())) {
                entryIterator.remove();
                continue;
            }
            if (fieldsToOutput.contains(entry.getValue())) {
                stringBuilder.append(entry.getValue()).append(" ");
            }
        }
        stringBuilder.append("}");
        System.out.println(stringBuilder);


    }

}
