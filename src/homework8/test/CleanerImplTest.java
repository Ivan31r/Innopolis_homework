package homework8.test;

import homework8.main.CleanerImpl;
import homework8.main.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class CleanerImplTest {

    @Test
    public void cleanUpObject() {
        User user = new User((short) 20,"Bob",true,'m');
        Set<String> fieldsToClean = new HashSet<>(){{
            add("name");
            add("age");
            add("sex");
        }};
        Set<String> fieldsToShow = new HashSet<>(){{
            add("ch");
        }};

        CleanerImpl cleaner = new CleanerImpl();
        cleaner.cleanUp(user,fieldsToClean,fieldsToShow);
        Assert.assertNull(user.getName());
    }
    @Test
    public void cleanUpMapImplementation(){
        Map<String,String> testMap = new HashMap<>(){{
           put("val1","10");
           put("val2","20");
           put("val3","30");
           put("val4","40");
        }};
        Set<String> keyToClean = new HashSet<>(){{
            add("val1");
            add("val2");
        }};
        Set<String> valueToShow = new HashSet<>(){{
            add("30");
            add("40");
        }};

        CleanerImpl cleaner = new CleanerImpl();
        cleaner.cleanUp(testMap,keyToClean,valueToShow);
        Assert.assertEquals(2,testMap.size());
    }
}