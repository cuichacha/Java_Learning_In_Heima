package Day02.Homework;

import java.util.Scanner;

public class Day02_HW6 {

    private boolean checkNumber(String str) {
        // 如果第一个字符，是数字，或者负号，开始从第二个字符遍历字符串
        if (Character.hashCode(str.charAt(0)) == 45 || Character.isDigit(str.charAt(0))) {
            // 遍历输入的字符串，如果有一个字符不是数字，就返回false
            for (int i = 1; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                } else if (i == (str.length() - 1)) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private int loop() {
        int num;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入整数1-12：");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成double
            if (checkNumber(str)) {
                num = Integer.parseInt(str);
                if (num >= 1 && num <= 12) {
                    return num;
                } else {
                    System.out.println("请输入正确数字！！");
                }

                // 如果输入的数字不符合要求，陷入输入无限循环
            } else {
                count++;
                if (count == 10) {
                    System.out.println("别输了，滚吧！");
                    return -1;
                }
                System.out.println("请输入正确数字！！");
            }
        }
    }

    private void quarters(int num) {
        switch (num) {
            case 1:
            case 2:
            case 3:
                System.out.println("第一季度");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("第二季度");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("第三季度");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("第四季度");
                break;
        }
    }

    public static void main(String[] args) {
        int num;

        Day02_HW6 day02_HW6 = new Day02_HW6();
        num = day02_HW6.loop();
        day02_HW6.quarters(num);
    }
}