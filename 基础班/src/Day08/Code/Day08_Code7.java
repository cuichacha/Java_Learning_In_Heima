package Day08.Code;

import java.util.Scanner;

public final class Day08_Code7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入字符串");
        String str = scanner.nextLine();

        String newString = str.replace("TMD", "***");
        System.out.println(newString);
    }
}
