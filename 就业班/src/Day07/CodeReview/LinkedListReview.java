package Day07.CodeReview;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListReview {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");
        linkedList.add("555");

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.addFirst("999");
        linkedList.addLast("999");

        System.out.println(Arrays.toString(linkedList.toArray(new String[linkedList.size()])));
    }
}
