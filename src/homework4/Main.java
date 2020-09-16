package homework4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMapPart2<String,Integer> hashMapPart2 = new HashMapPart2<>();
        for (int i =0;i<100;i++){
            hashMapPart2.put("Str1 " +i,i*10);
        }
//        for (int i = 0;i<hashMapPart2.nodes.length;i++){
//            if (hashMapPart2.nodes[i]!=null)
//            System.out.println(hashMapPart2.nodes[i].key + " - " + hashMapPart2.nodes[i].value);
//        }
        System.out.println(hashMapPart2.size());
        System.out.println(hashMapPart2.get("Str1 15"));
        System.out.println(hashMapPart2.remove("Str1 15"));
//        Map<String,Integer> map = new HashMap<>();
    }
}
