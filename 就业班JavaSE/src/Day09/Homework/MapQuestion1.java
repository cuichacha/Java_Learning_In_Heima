package Day09.Homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapQuestion1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("邓超", "孙俪");
        map.put("李晨", "范冰冰");
        map.put("刘德华", "柳岩");
        map.put("黄晓明", "Baby");
        map.put("谢霆锋", "张柏芝");

        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + "--" + map.get(s));
        }
    }
}
