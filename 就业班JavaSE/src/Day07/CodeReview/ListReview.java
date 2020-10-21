package Day07.CodeReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ListReview {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("333");
            }
        });

        list.set(0, "999");
        System.out.println(list.get(2));

        System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
    }
}
