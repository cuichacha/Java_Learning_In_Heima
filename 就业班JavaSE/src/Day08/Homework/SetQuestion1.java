package Day08.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SetQuestion1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();

        arrayList.add("a");
        arrayList.add("f");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("a");
        arrayList.add("d");

        hashSet.addAll(arrayList);
        arrayList.addAll(hashSet);

        System.out.println(Arrays.toString(hashSet.toArray(new String[hashSet.size()])));
    }
}
