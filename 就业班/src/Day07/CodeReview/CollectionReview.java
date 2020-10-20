package Day07.CodeReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class CollectionReview {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("111");
        collection.add("222");
        collection.add("333");
        collection.add("444");
        collection.add("555");

        collection.remove("111");
        collection.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("222");
            }
        });

        System.out.println(Arrays.toString(collection.toArray()));
    }
}
