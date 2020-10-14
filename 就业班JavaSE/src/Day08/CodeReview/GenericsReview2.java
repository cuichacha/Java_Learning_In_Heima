package Day08.CodeReview;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericsReview2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        addElement(arrayList, "1", "2", "3");
        System.out.println(Arrays.toString(arrayList.toArray(new String[arrayList.size()])));
    }

    private static <T> ArrayList<T> addElement(ArrayList<T> arrayList, T t1, T t2, T t3) {
        arrayList.add(t1);
        arrayList.add(t2);
        arrayList.add(t3);
        return arrayList;
    }
}
