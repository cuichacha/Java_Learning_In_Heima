package Day08.Code;

import java.util.Scanner;

public final class Day08_Code10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String originalString = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(originalString);
        String currentString = stringBuilder.reverse().toString();

        if (originalString.equals(currentString)) {
            System.out.println("是对称字符串");
        } else {
            System.out.println("不是对称字符串");
        }
    }

}
