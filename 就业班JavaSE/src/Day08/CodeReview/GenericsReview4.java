package Day08.CodeReview;

import java.util.ArrayList;

public class GenericsReview4 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("11");
        arrayList1.add("22");
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(11);
        arrayList2.add(22);
        printList(arrayList1);
        printList(arrayList2);
    }

    private static void printList(ArrayList<?> arrayList) {
        for (Object o : arrayList) {
            System.out.println(o);
        }
    }
}
