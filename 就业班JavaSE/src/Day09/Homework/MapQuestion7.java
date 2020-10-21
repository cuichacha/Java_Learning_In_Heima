package Day09.Homework;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class MapQuestion7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (treeMap.containsKey(c)) {
                treeMap.put(c, treeMap.get(c) + 1);
            } else {
                treeMap.put(c, 1);
            }
        }
        treeMap.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                System.out.print(character + "(" + integer + ")");
            }
        });
    }
}
