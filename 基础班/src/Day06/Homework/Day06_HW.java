package Day06.Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Day06_HW {
    public static void main(String[] args) {
        Day06_HW day06_hw = new Day06_HW();
        day06_hw.conversion();
        System.out.println("-----------------");
        day06_hw.printComplement();
        System.out.println("-----------------");
        day06_hw.swapValue();
        System.out.println("-----------------");
        int[] arr = {1, 2, 3, 4, 5};
        day06_hw.reverseArray(arr);
        System.out.println("-----------------");
        int[][] twoDimensionalArray = {{11, 22, 33}, {33, 44, 55}};
        day06_hw.iterateTwoDimensionalArray(twoDimensionalArray);
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

    private int loop1() {
        int num;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入一个十进制整数: ");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成int
            if (checkNumber(str)) {
                num = Integer.parseInt(str);
                return num;
//                if (num >= 1 && num <= 12) {
//                    return num;
//                } else {
//                    System.out.println("请输入正确数字！！");
//                }

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

    private int loop2(int sequence) {
        int num;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入整数" + sequence);
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成int
            if (checkNumber(str)) {
                num = Integer.parseInt(str);
                return num;
//                if (num >= 1 && num <= 12) {
//                    return num;
//                } else {
//                    System.out.println("请输入正确数字！！");
//                }

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

    private void conversion() {
        int num = loop1();
        System.out.print("数字" + num + "对应的二进制数为：");
        System.out.print(Integer.toBinaryString(num));
        System.out.println();
    }

    private void printComplement() {
        int num = loop1();

        if (num >= 0) {
            System.out.println("数字" + num + "的原码为" + Integer.toBinaryString(num));
            System.out.println("数字" + num + "的反码为" + Integer.toBinaryString(num));
            System.out.println("数字" + num + "的补码为" + Integer.toBinaryString(num));
        } else {
            String trueForm = Integer.toBinaryString(num);
            System.out.println("数字" + num + "的补码为：" + trueForm);
            char[] charArr = trueForm.toCharArray();

            for (int i = charArr.length - 1; i >= 0; i--) {
                if (charArr[i] == '1') {
                    charArr[i] = '0';
                    break;
                } else {
                    charArr[i] = '1';
                }
//                if (charArr[charArr.length - 1] == 1) {
//                    charArr[charArr.length - 1] = 0;
//                } else if (charArr[i] == 1) {
//                    number = i;
//                    charArr[i] = 0;
//                    break;
//                    }
//                }
//            for (int i = number + 1; i < charArr.length; i++) {
//                charArr[i] = 1;
            }

            System.out.print("数字" + num + "的反码为：");
            for (int i = 0; i < charArr.length; i++) {
                System.out.print(charArr[i]);
            }
            System.out.println();
            for (int i = 1; i < charArr.length; i++) {
                if (charArr[i] == '1') {
                    charArr[i] = '0';
                } else {
                    charArr[i] = '1';
                }
            }
            System.out.print("数字" + num + "的原码为：");
            for (int i = 0; i < charArr.length; i++) {
                System.out.print(charArr[i]);
            }
            System.out.println();
//            BigDecimal bigDecimal = new BigDecimal(charArr);
//            BigDecimal big = new BigDecimal(-1);
////            bigDecimal.add(big);
//            System.out.println(bigDecimal.add(big));
        }
    }

    private void swapValue() {
        int a = loop2(1);
        int b = loop2(2);
//        int temp = a;
//        a = b;
//        b = temp;
//        System.out.println(a + " " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    private void reverseArray(int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    private void iterateTwoDimensionalArray(int[][] tarr) {
        int sum = 0;
//        int[][] tarr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        for (int i = 0; i < tarr.length; i++) {
            for (int j = 0; j < tarr[i].length; j++) {
                System.out.println(tarr[i][j]);
                sum += tarr[i][j];
            }
        }
        System.out.println("数组中所有元素的和为：" + sum);
    }
}
