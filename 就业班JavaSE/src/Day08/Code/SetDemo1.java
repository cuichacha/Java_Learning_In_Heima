package Day08.Code;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
    public static void main(String[] args) {
        Set<String> set1 = new TreeSet();
        set1.add("555");
        set1.add("111");
        set1.add("222");
        set1.add("222");

        Iterator<String> iterator = set1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String s : set1) {
            System.out.println(s);
        }

        System.out.println("-----------------");

        Set<Character> set2 = new TreeSet<>();
        set2.add('E');
        set2.add('j');
        set2.add('M');

        for (Character character : set2) {
            System.out.println(character);
        }

    }
}
