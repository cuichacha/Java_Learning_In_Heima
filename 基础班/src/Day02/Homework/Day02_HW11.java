package Day02.Homework;

import java.util.Scanner;

public class Day02_HW11 {

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
            System.out.println("请输入工龄：");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成double
            if (checkNumber(str)) {
                num = Integer.parseInt(str);
                if (num >= 0 && num < 80) {
                    return num;
                } else {
                    System.out.println("请输入正确工龄！！");
                }

                // 如果输入的数字不符合要求，陷入输入无限循环
            } else {
                count++;
                if (count == 10) {
                    System.out.println("别输了，滚吧！");
                    return -1;
                }
                System.out.println("请输入正确工龄！！");
            }
        }
    }

    private void raiseSalary(int num) {
        int baseSalary = 3000;
        if (num >=0 && num <1) {
            int bonus = 200;
            System.out.println("您目前工作了" + num + "年，基本工资为" + baseSalary + "元, 应涨工资" + bonus + "元," +
                    "涨后工资" + (baseSalary + bonus) + "元");
        } else if (num >= 1 && num < 3) {
            int bonus = 500;
            System.out.println("您目前工作了" + num + "年，基本工资为" + baseSalary + "元, 应涨工资" + bonus + "元," +
                    "涨后工资" + (baseSalary + bonus) + "元");
        } else if (num >= 3 && num < 5) {
            int bonus = 1000;
            System.out.println("您目前工作了" + num + "年，基本工资为" + baseSalary + "元, 应涨工资" + bonus + "元," +
                    "涨后工资" + (baseSalary + bonus) + "元");
        } else if (num >= 5 && num < 10) {
            int bonus = 2500;
            System.out.println("您目前工作了" + num + "年，基本工资为" + baseSalary + "元, 应涨工资" + bonus + "元," +
                    "涨后工资" + (baseSalary + bonus) + "元");
        } else if (num >= 10 && num < 15) {
            int bonus = 3000;
            System.out.println("您目前工作了" + num + "年，基本工资为" + baseSalary + "元, 应涨工资" + bonus + "元," +
                    "涨后工资" + (baseSalary + bonus) + "元");
        } else {
            System.out.println("可以退休了");
        }
    }

    public static void main(String[] args) {
        int num;

        Day02_HW11 day02_HW11 = new Day02_HW11();
        num = day02_HW11.loop();
        day02_HW11.raiseSalary(num);
    }
}
