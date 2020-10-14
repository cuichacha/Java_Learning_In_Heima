package Day03.Homework;

import java.util.Scanner;

public class Day03_HW6 {

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
            System.out.println("请输入一个整数：");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成int
            if (checkNumber(str)) {
                num = Integer.parseInt(str);

                return num;

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

    private void sum() {
        int num = loop();
        int sum1 = 0;
        int sum2 = 0;
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                if (i % 2 != 0) {
                    sum1 += i;
                }
            }
            System.out.println("1~该数字之间, 所有的奇数和为： " + sum1);
        } else if (num < 0) {
            for (int i = num; i <= 1; i++) {
                if (i % 2 != 0) {
                    sum2 += i;
                }
            }
            System.out.println("1~该数字之间, 所有的奇数和为： " + sum2);
        } else {
            System.out.println(1);
        }
    }

    public static void main(String[] args) {
        Day03_HW6 day03_HW6 = new Day03_HW6();
        day03_HW6.sum();
    }
}
