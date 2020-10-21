package Day09.Homework;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class MapQuestion2 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("柳岩", 2100);
        hashMap.put("张亮", 1700);
        hashMap.put("灭绝师太", 1800);
        hashMap.put("东方不败", 2600);
        hashMap.put("诸葛亮", 3800);

        hashMap.replace("柳岩", 2400);

        hashMap.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s + "-" + integer);
            }
        });
    }
}
