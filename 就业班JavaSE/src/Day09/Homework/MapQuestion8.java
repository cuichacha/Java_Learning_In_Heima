package Day09.Homework;

import java.util.Scanner;

public class MapQuestion8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        String str = scanner.nextLine();
        int spaceCount = 0;
        int numberCount = 0;
        int letterCount = 0;
        int otherCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                spaceCount++;
            } else if (c >= 'a' && c <= 'z') {
                letterCount++;
            } else if (c >= 'A' && c <= 'Z') {
                letterCount++;
            } else if (c >= '0' && c <= '9') {
                numberCount++;
            }
        }
        otherCount = str.length() - (spaceCount + numberCount + letterCount);

        System.out.println("其他=" + otherCount + ", 空格=" + spaceCount + ", 字母=" + letterCount + ", 数字=" + numberCount);
    }
}
