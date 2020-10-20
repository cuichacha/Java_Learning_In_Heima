package Day07.Code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("111");
        collection.add("222");
        collection.add("222");
        collection.add("333");
        collection.add("4444");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("222")) {
                iterator.remove();

            }
        }
        System.out.println(collection);
    }

}
