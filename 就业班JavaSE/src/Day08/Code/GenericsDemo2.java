package Day08.Code;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericsDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        String[] strings = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strings));
    }
}
