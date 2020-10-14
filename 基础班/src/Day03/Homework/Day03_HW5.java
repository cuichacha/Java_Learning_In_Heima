package Day03.Homework;

import java.util.Random;
import java.util.Scanner;

public class Day03_HW5 {
    private int generateNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        return randomNumber;
    }

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

    private void loop() {
        int num;
        int count = 0;
        int generateNumber = generateNumber();
        while (true) {
            // 提示用户输入数字
            System.out.println("请猜一个0-100之间的整数：");
            count++;
            if (count == 20) {
                System.out.println("别猜了，滚吧，笨蛋！");
                break;
            }
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成int
            if (checkNumber(str)) {
                num = Integer.parseInt(str);
                if (num < 0 || num > 100) {
                    System.out.println("请输入正确数字！！");
                    continue;
                }
                if (num > generateNumber) {
                    System.out.println("猜大了");
                } else if (num < generateNumber) {
                    System.out.println("猜小了");
                } else {
                    System.out.println("猜中了");
                    break;
                }

                // 如果输入的数字不符合要求，陷入输入无限循环
            } else {

                System.out.println("请输入正确数字！！");
            }
        }
    }

    public static void main(String[] args) {
        Day03_HW5 day03_HW5 = new Day03_HW5();
        day03_HW5.loop();
    }
}
