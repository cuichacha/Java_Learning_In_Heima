package Day09.Homework;

import java.util.HashMap;
import java.util.Scanner;

public class MapQuestion8_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] charArr = str.toCharArray();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < charArr.length; i++) {
            if ((charArr[i] >= 'a' && charArr[i] <= 'z' ) || (charArr[i] >= 'A' && charArr[i] <= 'Z')) {
                add(hashMap, "字母");
            } else if (charArr[i] >= '0' && charArr[i] <= '9') {
                add(hashMap, "数字");
            } else if (charArr[i] == ' ') {
                add(hashMap, "空格");
            } else {
                add(hashMap, "其他");
            }
        }
        System.out.println(hashMap);
    }

    private static HashMap<String, Integer> add(HashMap<String, Integer> hashMap, String key) {
        Integer integer = hashMap.get(key);
        if (integer != null) {
            hashMap.put(key, integer + 1);
        } else {
            hashMap.put(key, 1);
        }
        return hashMap;
    }
}
