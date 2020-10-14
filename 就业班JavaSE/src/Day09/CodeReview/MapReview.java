package Day09.CodeReview;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapReview {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        map.replace("1", "9");
        map.remove("2");
        System.out.println(map.containsKey("2"));
        System.out.println(map.containsValue("9"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map);
        System.out.println("------------------------");

        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + "--" +map.get(s));
        }
        System.out.println("------------------------");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }
}
