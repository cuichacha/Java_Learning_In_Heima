package Day09.Homework;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

public class MapQuestion3 {
    public static void main(String[] args) {
        LinkedHashMap<String, String[]> linkedHashMap = new LinkedHashMap<>();
        String[] student1 = {"1", "1"};
        String[] student2 = {"2", "2"};
        String[] student3 = {"3", "3"};
        String[] student4 = {"4", "4"};
        linkedHashMap.put("001", student1);
        linkedHashMap.put("001", student2);
        linkedHashMap.put("003", student3);
        linkedHashMap.put("004", student4);

        linkedHashMap.forEach(new BiConsumer<String, String[]>() {
            @Override
            public void accept(String s, String[] strings) {
                System.out.println(s + "---" + Arrays.toString(strings));
            }
        });
    }
}
