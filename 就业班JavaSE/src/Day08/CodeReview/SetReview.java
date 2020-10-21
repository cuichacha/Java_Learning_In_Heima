package Day08.CodeReview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetReview {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("111");
        set1.add("111");
        set1.add("222");
        set1.add("333");

        Iterator<String> iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        for (String s : set1) {
            System.out.println(s);
        }

        Set<String> set2 = new TreeSet<>();
        set2.add("111");
        set2.add("111");
        set2.add("222");
        set2.add("333");

        Iterator<String> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        for (String s : set2) {
            System.out.println(s);
        }

    }
}
