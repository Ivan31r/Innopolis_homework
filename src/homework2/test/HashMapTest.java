package homework2.test;

import homework2.java.HashMap;
import org.junit.Assert;
import org.junit.Test;

public class HashMapTest {
    @Test
    public void testOfEmptyMap(){
        HashMap hashMap = new HashMap();
        hashMap.put("String1",1);
        Assert.assertEquals(1,hashMap.getElementsCounter());
    }
    @Test
    public void testPut5Elements(){
        HashMap hashMap = new HashMap();
        hashMap.put("name1",1);
        hashMap.put("name2",1);
        hashMap.put("name3",1);
        hashMap.put("name4",1);
        hashMap.put("name5",1);
        Assert.assertEquals(5,hashMap.getElementsCounter());
    }

    @Test
    public void testUpdateDataInHashMapWithValidKey(){
        HashMap hashMap = new HashMap();
        hashMap.put("name1",1);
        hashMap.put("name2",1);
        hashMap.put("name3",1);
        hashMap.put("name4",1);
        hashMap.put("name4",1);
        Assert.assertEquals(4,hashMap.getElementsCounter());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateDataInHashMapWithNOTaValidKey(){
        HashMap hashMap = new HashMap();
        hashMap.put("name1",1);
        hashMap.put("name2",1);
        hashMap.put("name3",1);
        hashMap.put("name4",1);
        hashMap.update("name44444",1);

    }
    @Test
    public void testGetElementByValidKey(){
        HashMap hashMap = new HashMap();
        hashMap.put("name1",1);
        hashMap.put("name2",1);
        hashMap.put("name3",1);
        hashMap.put("name4",1);
//        hashMap.get("name4");

        Assert.assertEquals(1,hashMap.get("name4"));
    }

}
