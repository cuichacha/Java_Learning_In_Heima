package Day07.Code;

import java.util.ArrayList;
import java.util.Iterator;

public class EnhancedForDemo {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("111");
        arrayList.add("222");
        arrayList.add("333");
        arrayList.add("444");
        arrayList.add("555");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            String s = arrayList.get(4);
            System.out.println(s);
            if (s.equals("555")) {
                arrayList.remove("555");
                break;
            }
        }
        System.out.println(1);

        for (String s : arrayList) {
            System.out.println(s);
            if (s.equals("555")) {
//                int i = arrayList.indexOf(s);
//                System.out.println(arrayList.get(i));
//                arrayList.remove(i);
//                arrayList.set(i, "999");
//                System.out.println(arrayList.get(i));
                arrayList.remove(s);
//                arrayList.iterator().next();
//                arrayList.iterator().remove();
            }
        }
        System.out.println(arrayList);
    }
}
