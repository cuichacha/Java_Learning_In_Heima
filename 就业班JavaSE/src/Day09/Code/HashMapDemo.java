package Day09.Code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();

        map.put("001", "111");
        map.put("002", "222");
        map.put("003", "333");
        map.put("004", "444");
        map.put("005", "555");

        System.out.println(map);
        System.out.println(map.get("003"));
        map.put("002", "999");
        System.out.println(map.remove("004"));
        System.out.println(map);
        System.out.println(map.replace("001", "888"));
        System.out.println(map);
        System.out.println(map.containsKey("001"));
        System.out.println(map.containsValue("666"));
//        map.clear();

        Set<String> strings = map.keySet();
        for (String string : strings) {
            String s = map.get(string);
            System.out.println(string + "---" + s);
        }

        System.out.println("------------------------");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "--" + value);
        }

        System.out.println("------------------------");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + "-" + s2);
            }
        });
    }
}
