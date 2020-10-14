package Day07.CodeReview;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorReview {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("111");
        arrayList.add("222");
        arrayList.add("333");
        arrayList.add("444");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}
