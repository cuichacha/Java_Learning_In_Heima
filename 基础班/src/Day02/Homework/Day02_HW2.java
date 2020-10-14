// 求三个数中的最大值
package Day02.Homework;

import java.util.Scanner;

public class Day02_HW2 {

    public static void main(String[] args) {
        double num1;
        double num2;
        double num3;

        Day02_HW2 day02_HW2 = new Day02_HW2();

        num1 = day02_HW2.loop(1);
        num2 = day02_HW2.loop(2);
        num3 = day02_HW2.loop(3);
        day02_HW2.comparison(num1, num2, num3);

    }

    private void comparison(double num1, double num2, double num3) {
        double max;
        if (num1 > num2) {
            if (num1 > num3) {
                max = num1;
            } else {
                max = num3;
            }
        } else {
            if (num2 > num3) {
                max = num2;
            } else {
                max = num3;
            }
        }
//        double tempMax = num1 > num2 ? num1 : num2;
//        double max = tempMax > num3 ? tempMax : num3;
        int maximum;
        if (max == (int) (max)) {
            maximum = (int) max;
            System.out.println("三个数字中较大的数为： " + maximum);
        } else {
            System.out.println("三个数字中较大的数为： " + max);
        }

    }
    private double loop(int i) {
        double num;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入数字" + i + "的值：");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成double
            if (checkNumber(str)) {
                num = Double.parseDouble(str);
                return num;
                // 如果输入的数字不符合要求，陷入输入无限循环
            } else {
                count++;
                if (count == 10) {
                    System.out.println("别输了，滚吧！");
                    return -1;
                }
                System.out.println("请输入数字！！");
            }
        }
    }


    private boolean checkNumber(String str) {
        int temp = 0;
        int index = 0;
        // 先判断第一个字符，第一个字符如果是小数点，就开始从第二个字符遍历字符串
        if (Character.hashCode(str.charAt(0)) == 46) {
            for (int i = 1; i < str.length(); i++) {
                // 如果从第二个字符开始，有任何不是数字的字符，返回false
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            // 如果第一个字符，是数字，或者负号，开始从第二个字符遍历字符串
        } else if (Character.hashCode(str.charAt(0)) == 45 || Character.isDigit(str.charAt(0))) {
            for (int i = 1; i < str.length(); i++) {
                // 如果遍历过程中，遇到小数点，记录下小数点个数
                if (Character.hashCode(str.charAt(i)) == 46) {
                    temp++;
                    // 如果遇到小数点，记录下小数点的位置
                    index = i;
                }
            }
            // 如果没有小数点，那么遍历字符串进行判断
            if (temp == 0) {
                for (int i = 1; i < str.length(); i++) {
                    // 有任何非数字的情况，返回false
                    if (!Character.isDigit(str.charAt(i))) {
                        return false;
                    }
                }
            }
            // 如果只有一个小数点，判断剩余字符是否为数字
            if (temp == 1) {
                // 遍历字符串小数点之前的字符，是否为数字
                for (int j = 1; j < str.indexOf(index); j++) {
                    if (Character.isDigit(str.charAt(j))) {
                        // 遍历字符串小数点之后的字符，是否为数字
                        for (int k = index; k < str.length(); k++) {
                            if (Character.isDigit(str.charAt(k))) {
                                return true;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
            // 如果超过一个小数点，返回false
            if (temp > 1) {
                return false;
            }
            // 如果第一个字符，不是数字，不是负号，不是小数点，那么直接返回false
        } else {
            return false;
        }
        // 上述情况全部排除之后，肯定是true，增加返回值
        return true;
    }
}
