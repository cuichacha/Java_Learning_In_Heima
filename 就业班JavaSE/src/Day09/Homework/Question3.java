package Day09.Homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class Question3 {
    public static void main(String[] args) {
        HashMap<HashMap<String, String>, HashMap<String, String>> hashMap = new HashMap<>();

        HashMap<String, String> baseClass = new HashMap<>();
        baseClass.put("001", "李晨");
        baseClass.put("002", "范冰冰");

        HashMap<String, String> employmentClass = new HashMap<>();
        employmentClass.put("001", "马云");
        employmentClass.put("002", "马化腾");

        hashMap.put(baseClass, employmentClass);

        hashMap.forEach(new BiConsumer<HashMap<String, String>, HashMap<String, String>>() {
            @Override
            public void accept(HashMap<String, String> stringStringHashMap, HashMap<String, String> stringStringHashMap2) {
                stringStringHashMap.forEach(new BiConsumer<String, String>() {
                    @Override
                    public void accept(String s, String s2) {
                        System.out.println(s + s2);
                    }
                });
                stringStringHashMap2.forEach(new BiConsumer<String, String>() {
                    @Override
                    public void accept(String s, String s2) {
                        System.out.println(s + s2);
                    }
                });
            }
        });

        Set<HashMap<String, String>> keySet = hashMap.keySet();
        for (HashMap<String, String> map : keySet) {
            map.forEach(new BiConsumer<String, String>() {
                @Override
                public void accept(String s, String s2) {
                    System.out.println(s + "--" + s2);
                }
            });
            HashMap<String, String> values = hashMap.get(map);
            values.forEach(new BiConsumer<String, String>() {
                @Override
                public void accept(String s, String s2) {
                    System.out.println(s + "--" + s2);
                }
            });
        }

        Set<Map.Entry<HashMap<String, String>, HashMap<String, String>>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<HashMap<String, String>, HashMap<String, String>>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            HashMap<String, String> anotherBaseClass = iterator1.next().getKey();
            Set<Map.Entry<String, String>> entries1 = anotherBaseClass.entrySet();
            Iterator<Map.Entry<String, String>> entry1Iterator = entries1.iterator();
            while (entry1Iterator.hasNext()) {
                Map.Entry<String, String> next = entry1Iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                System.out.println(key + "---" + value);
            }

            Iterator<Map.Entry<HashMap<String, String>, HashMap<String, String>>> iterator2 = entrySet.iterator();
            HashMap<String, String> anotherEmploymentClass = iterator2.next().getValue();
            Set<Map.Entry<String, String>> entries2 = anotherEmploymentClass.entrySet();
            Iterator<Map.Entry<String, String>> entry2Iterator = entries2.iterator();
            while (entry2Iterator.hasNext()) {
                Map.Entry<String, String> next = entry2Iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                System.out.println(key + "---" + value);
            }
        }
    }
}
