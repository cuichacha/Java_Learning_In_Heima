package Day07.Homework;

import java.util.ArrayList;
import java.util.ListIterator;

public class Collection2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("JavaEE企业级开发指南");
        list.add("Oracle高级编程");
        list.add("MySQL从入门到精通");
        list.add("Java架构师之路");

        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        while (listIterator.hasPrevious()) {
            listIterator.previous();
        }

        System.out.println("---------------------");

        while (listIterator.hasNext()) {
            String str = listIterator.next();
            if (str.length() < 10) {
                System.out.println(str);
            }
        }

        while (listIterator.hasPrevious()) {
            listIterator.previous();
        }

        System.out.println("---------------------");

        while (listIterator.hasNext()) {
            String str = listIterator.next();
            if (str.contains("Java")) {
                System.out.println(str);
            }
        }

        while (listIterator.hasPrevious()) {
            listIterator.previous();
        }

        System.out.println("---------------------");

        while (listIterator.hasNext()) {
            String str = listIterator.next();
            if (str.contains("Oracle")) {
                listIterator.remove();
            }
        }

        System.out.println("---------------------");

        for (String s : list) {
            System.out.println(s
            );
        }
    }
}
