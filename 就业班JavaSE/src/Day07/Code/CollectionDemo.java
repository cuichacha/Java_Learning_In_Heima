package Day07.Code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("111");
        collection.add("222");
        collection.add("333");
        collection.add("4444");
        collection.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("222");
            }
        });
        System.out.println(collection);

        collection.remove("4444");
        System.out.println(collection);
        System.out.println(collection.contains("111"));
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        collection.clear();
        System.out.println(collection);
    }
}
