package Day07.Code;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("111");
        list.add("222");
        list.add("333");

//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        list.remove("111");
        System.out.println(list);

        System.out.println(list.remove(0));


        System.out.println(list.set(0, "999"));
        System.out.println(list);

        System.out.println(list.get(0));
    }
}
