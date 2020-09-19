package homework5.test;

import homework5.main.HashMapPart2;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class HashMapPart2Test {

    @Test
    public void putElementsWithDifferentKeys() {
        HashMapPart2<String, Integer> personalMap = new HashMapPart2<>();
        personalMap.put("Str1", 10);
        personalMap.put("Str2", 10);
        Assert.assertEquals(2, personalMap.size());

    }

    @Test
    public void putElementsWithEqualsKeys() {
        HashMapPart2<String, Integer> personalMap = new HashMapPart2<>();
        personalMap.put("Str1", 10);
        personalMap.put("Str1", 10);
        Assert.assertEquals(1, personalMap.size());

    }

    @Test
    public void getRightSize() {
        HashMapPart2<String, Integer> personalMap = new HashMapPart2<>();
        personalMap.put("Str1", 10);
        personalMap.put("Str2", 10);
        personalMap.put("Str2", 10);
        Assert.assertEquals(2, personalMap.size());
    }

    @Test
    public void checkIsEmptyMap() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        Assert.assertEquals(false, hashMapPart2.isEmpty());
    }

    @Test
    public void checkNotEmptyMap() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        Assert.assertFalse(hashMapPart2.isEmpty());
    }

    @Test
    public void containKeyTest() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        Assert.assertTrue(hashMapPart2.containsKey("Str1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void containKeyNegative() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 10);
        hashMapPart2.containsKey("Str3");
    }

    @Test
    public void containValuesPositiveResult() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        hashMapPart2.put("Str4", 40);
        Assert.assertTrue(hashMapPart2.containsValue(40));
    }

    @Test
    public void containValuesNegativeResult() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        hashMapPart2.put("Str4", 40);
        Assert.assertFalse(hashMapPart2.containsValue(70));
    }

    @Test
    public void getPositiveResultTest() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        Assert.assertEquals(20, (int) (hashMapPart2.get("Str2")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNegativeResult() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        hashMapPart2.get("Str5");
    }

    @Test
    public void removePositiveResult() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        Assert.assertEquals(10, (int) hashMapPart2.remove("Str1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNegativeResult() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        hashMapPart2.remove("Str4");
    }

    @Test
    public void putAllTest() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        HashMapPart2<String, Integer> hashMapPart = new HashMapPart2<>();
        hashMapPart.putAll(hashMapPart2);
        Assert.assertEquals(3, hashMapPart.size());

    }

    @Test
    public void clearAllTest() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        hashMapPart2.clear();
        Assert.assertEquals(0, hashMapPart2.size());
    }

    @Test
    public void getValues() {
        HashMapPart2<String, Integer> hashMapPart2 = new HashMapPart2<>();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        hashMapPart2.put("Str1", 10);
        hashMapPart2.put("Str2", 20);
        hashMapPart2.put("Str3", 30);
        Assert.assertEquals(list, hashMapPart2.values());
    }

}
