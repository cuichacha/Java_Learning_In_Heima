package Day08.Code;

import java.util.Scanner;

public final class Day08_Code5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int numberCount = 0;

        System.out.println("");
        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upperCaseCount++;
            } else if (c >= 'a' && c <= 'z') {
                lowerCaseCount++;
            } else if (c >= '0' && c <= '9') {
                numberCount++;
            }
        }

        System.out.println(upperCaseCount);
        System.out.println(lowerCaseCount);
        System.out.println(numberCount);
    }
}
