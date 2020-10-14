package Day04.Homework;

import java.util.Random;
import java.util.Scanner;

public class Day04_HW {

    private boolean checkNumber1(String str) {
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

    private boolean checkNumber2(String str) {
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

    private int loop1(int sequence) {
        int num;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入整数" + sequence + ": ");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成int
            if (checkNumber1(str)) {
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

    private double loop2(int sequence) {
        double num;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入分数" + sequence + ": ");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成double
            if (checkNumber2(str)) {
                num = Double.parseDouble(str);
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

    private void array() {
        int max1;
        double max2;
        int min1;
        double min2;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        double sum4 = 0;
        double avg1;
        double avg2;
        int number;
        int[] arr1 = new int[5];
        int[] arr2 = new int[10];
        int[] arr3 = new int[5];
        double[] arr4 = new double[6];

        // 循环遍历数组，调用loop1方法，收集用户输入的数字保存到数组里
        for (int i = 0; i <= arr1.length - 1; i++) {
            arr1[i] = loop1(i + 1);
        }

        // 遍历数组输出元素
        System.out.print("数组中存放的整数依次为： ");
        for (int i = 0; i <= arr1.length - 1; i++) {
            System.out.print(arr1[i] + " ");
        }

        // 对数组中的元素按从小到大进行排序
        for (int j = 0; j <= arr1.length - 1; j++) {
            for (int i = 0; i < arr1.length - 1; i++) {
                int temp;
                if (arr1[i] > arr1[i + 1]) {
                    temp = arr1[i];
                    arr1[i] = arr1[i + 1];
                    arr1[i + 1] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("------------");

        System.out.print("[");
        for (int i = 0; i < arr1.length; i++) {
            if(i == arr1.length - 1) {
                System.out.println(arr1[i] + "]");
            } else {
                System.out.print(arr1[i] + ", ");
            }
        }
//        System.out.print(arr1[arr1.length - 1]);
//        System.out.print("]");

//        System.out.println();
        System.out.println("------------");

        // 输出数组中的最小值
        min1 = arr1[0];
        System.out.println("数组中的最小值为： " + min1);

        // 输出数组中的最大值
        max1 = arr1[arr1.length - 1];
        System.out.println("数组中的最大值为： " + max1);

        // 循环遍历数组，求所有元素的和
        for (int i = 0; i <= arr1.length - 1; i++) {
            sum1 += arr1[i];
        }
        System.out.println("数组中所有元素的和为： " + sum1);

        // 求所有元素的平均数，并转成double格式
        avg1 = sum1 / (arr1.length * 1.0);
        System.out.println("数组中所有元素的平均值： " + avg1);

        // 循环遍历数组，输出所有偶数元素，及所有偶数元素与奇数元素的和
        System.out.print("数组中所有偶数元素为： ");
        for (int i = 0; i <= arr1.length - 1; i++) {
            if (arr1[i] % 2 == 0) {
                sum2 += arr1[i];
                System.out.print(arr1[i] + " ");
            } else {
                sum3 += arr1[i];
            }
        }
        System.out.println();
        System.out.println("数组中所有偶数元素的和为： " + sum2);
        System.out.println("数组中所有奇数元素的和为： " + sum3);

        System.out.println("---------------");

        // 根据用户输入的内容，确定随机数的生成范围，调用loop方法，防止无效输入
        Random random1 = new Random();
        System.out.println("请输入一个正整数代表随机数生成范围：");
        while (true) {
            number = loop1(1);
            if (number > 0) {
                break;
            } else {
                System.out.println("请输入正确数字！！");
            }
        }

        // 循环遍历数组，将随机生成的数字，放进数组中，成为元素
        System.out.print("数组中存放的整数依次为： ");
        for (int i = 0; i <= 9; i++) {
            int randomNumber1 = random1.nextInt(number);
            arr2[i] = randomNumber1;
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        // 循环遍历数字，输出数组中3的整数倍的元素
        System.out.print("数组中是3的整数倍的元素依次为： ");
        for (int i = 0; i <= 9; i++) {
            if (arr2[i] % 3 == 0) {
                System.out.print(arr2[i] + " ");
            }
        }
        System.out.println();
        System.out.println("---------------");

        // 要求用户输入数据，调用loop方法防止无效数据，使用i--，通过不结束循环，进行数据范围限制
        System.out.println("请输入5个1到60的整数：");

        for (int i = 0; i <= arr1.length - 1; i++) {
            int num = loop1(i + 1);
            if (num >= 1 && num <= 60) {
                arr3[i] = num;
            } else {
                System.out.println("请输入正确数字！！");
                i--;
            }
        }

        // 随机生成数字
        Random random2 = new Random();
        int randomNumber2 = random2.nextInt(9) + 2;
        System.out.println("随机生成的数字为： " + randomNumber2);

        // 循环遍历数组，输出数组中不能整除随机数的元素
        System.out.print("数组中不是随机数的整数倍的元素依次为： ");
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] % randomNumber2 != 0) {
                System.out.print(arr3[i] + " ");
            }
        }
        System.out.println();
        System.out.println("----------------");

        // 要求用户输入数据，调用loop方法防止无效数据，使用i--，通过不结束循环，进行数据范围限制
        System.out.println("请输入6个评委的分数（支持小数）");
        for (int i = 0; i <= arr4.length - 1; i++) {
            double num = loop2(i + 1);
            if (num >= 0 && num <= 100) {
                arr4[i] = num;
            } else {
                System.out.println("请输入正确数字！！");
                i--;
            }
        }

        // 求出数组中的最大值
        max2 = arr4[0];
        for (int i = 1; i < arr4.length; i++) {
            if (max2 < arr4[i]) {
                max2 = arr4[i];
            }
        }
//        System.out.println(max2);
        // 求出数组中的最小值
        min2 = arr4[0];
        for (int i = 1; i < arr4.length; i++) {
            if (min2 > arr4[i]) {
                min2 = arr4[i];
            }
        }
//        System.out.println(min2);
        // 求出数组中所有元素的和
        for (int i = 0; i < arr4.length; i++) {
            sum4 += arr4[i];
        }

        // 求出去除最大值与最小值的平均数
        avg2 = (sum4 - max2 - min2) / 4;
        System.out.println("平均分数为： " + avg2);

    }

    public static void main(String[] args) {
        Day04_HW day04_hw = new Day04_HW();
        day04_hw.array();
    }
}
