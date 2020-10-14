package PracticeExam.Code;

import java.util.Scanner;

public final class Question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("请输入长度在10到15之间的字符串");
            input = scanner.nextLine();
            if (input.length() < 10 || input.length() > 15) {
                System.out.println("您输入的字符串不符合要求，请重新输入");
            } else {
                break;
            }
        }

        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int numberCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                upperCaseCount++;
            } else if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                lowerCaseCount++;
            } else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                numberCount++;
            }
        }
        System.out.println("大写字母有" + upperCaseCount + "个");
        System.out.println("小写字母有" + lowerCaseCount + "个");
        System.out.println("数字有" + numberCount + "个");
    }

}
