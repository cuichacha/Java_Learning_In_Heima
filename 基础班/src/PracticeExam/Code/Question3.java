package PracticeExam.Code;

import java.util.Scanner;

public final class Question3 {

    public static void main(String[] args) {

        while (true) {
            System.out.println("请输入字符串，输入end退出程序");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("end")) {
                System.out.println("程序结束");
                break;
            } else {
                char[] chars = input.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] >= 'A' && chars[i] <= 'Z') {
                        String tempString = String.valueOf(input.charAt(i)).toLowerCase();
                        chars[i] = tempString.charAt(0);
                    } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                        String tempString = String.valueOf(input.charAt(i)).toUpperCase();
                        chars[i] = tempString.charAt(0);
                    } else {
                        chars[i] = '*';
                    }
                }
                System.out.println(String.valueOf(chars));
            }
        }
    }
}
