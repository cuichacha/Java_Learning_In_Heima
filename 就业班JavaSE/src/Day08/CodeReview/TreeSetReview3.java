package Day08.CodeReview;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetReview3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串");
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();
        String str4 = scanner.nextLine();
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.length() - o2.length();
                result = result == 0 ? o1.compareTo(o2) : result;
                return result;
            }
        });

        System.out.println(addElement(set, str1, str2, str3, str4));


    }

    private static <T> Set<T> addElement(Set<T> set, T t1, T t2, T t3, T t4) {
        set.add(t1);
        set.add(t2);
        set.add(t3);
        set.add(t4);
        return set;
    }
}
