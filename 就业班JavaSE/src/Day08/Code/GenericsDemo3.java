package Day08.Code;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericsDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list1 = addElement(new ArrayList<>(), "111", "222");
        System.out.println(Arrays.toString(list1.toArray(new String[list1.size()])));

        ArrayList<Integer> list2 = addElement(new ArrayList<>(), 111, 222);
        System.out.println(Arrays.toString(list2.toArray(new Integer[list2.size()])));
    }

    private static <T> ArrayList<T> addElement(ArrayList<T> list, T t1, T t2) {
        list.add(t1);
        list.add(t2);
        return list;
    }
}
