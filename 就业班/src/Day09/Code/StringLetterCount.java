package Day09.Code;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class StringLetterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String input = scanner.nextLine();

        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (treeMap.containsKey(c)) {
                treeMap.put(c, (treeMap.get(c) + 1));
            } else {
                treeMap.put(c, 1);
            }
        }

        Set<Character> set = treeMap.keySet();
        for (Character character : set) {
            System.out.print(character + "(" +treeMap.get(character)+ ")");
        }
    }
}
