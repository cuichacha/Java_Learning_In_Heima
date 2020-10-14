package Day05.Homework;

import java.util.*;

public class Day05_HW {

    private String input() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

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
//        double num2;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入整数" + sequence + ": ");
            // 键盘录入
            String str = input();
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
//            } else if (checkNumber2(str)) {
//                num2 = Double.parseDouble(str);
//                return num2;
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
            System.out.println("请输入数字" + sequence + ": ");
            // 键盘录入
            String str = input();
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

    private int loop3() {
        int num;
//        double num2;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入整数： ");
            // 键盘录入
            String str = input();
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
//            } else if (checkNumber2(str)) {
//                num2 = Double.parseDouble(str);
//                return num2;
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

    private void print() {
        int num = loop3();
        for (int i = 1; i <= num; i++) {
            System.out.println("HelloWorld");
        }
    }

    private int findMin(int a, int b) {
        return Math.min(a, b);
    }

    private double findMin(double a, double b) {
        return Math.min(a, b);
    }

    private byte findMin(byte a, byte b) {
        byte min;
        if (a <= b) {
            min = a;
        } else {
            min = b;
        }
        return min;
    }

    private long findMin(long a, long b) {
        return Math.min(a, b);
    }

    private double findMax(double a, double b, double c) {
        return Math.max(Math.max(a, b), c);
    }

    private int[] findMinAndMax(int[] arr) {
        // 对数组中的元素按从小到大进行排序
        for (int j = 0; j <= arr.length; j++) {
            for (int i = 0; i <= arr.length - 2; i++) {
                int temp;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        int[] array = new int[2];
        array[0] = arr[0];
        array[1] = arr[arr.length - 1];
        return array;
    }

    private void printMinAndMax(int[] arr) {
        findMinAndMax(arr);
        System.out.println("数组中的最小值为：" + arr[0]);
        System.out.println("数组中的最大值为：" + arr[1]);
    }

    // 打印随机生成数组并输出最小的元素
    private void printArray() {
        System.out.println("请输入数组中的数");
        int[] arr = new int[5];
        // 循环遍历数组，调用loop1方法，收集用户输入的数字保存到数组里
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = loop1(i + 1);
        }

        // 遍历数组输出元素
        System.out.print("数组中存放的整数依次为： ");
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }

        // 对数组中的元素按从小到大进行排序
        for (int j = 0; j <= arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                int temp;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("------------");

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }

        // 输出数组中的最小值
        System.out.println("数组中的最小值为： " + arr[0]);
    }

    // 生成随机数组
    private int[] generateRandomArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }

    // 打印随机生成数组
    private void printRandomArray(int[] arr) {
        System.out.print("随机生成的数组中的元素依次为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 打印两个数中较小的数
    private void printMin() {
        System.out.println("求两个数中较小的数");
        double num = findMin(loop2(1), loop2(2));
        if (num == (int) num) {
            System.out.println("较小的数为： " + (int) num);
        } else {
            System.out.println("较小的数为： " + num);
        }
    }

    // 打印三个数中较大的数
    private void printMax() {
        System.out.println("求三个数中较大的数");
        double num = findMax(loop2(1), loop2(2), loop2(3));
        if (num == (int) num) {
            System.out.println("较大的数为： " + (int) num);
        } else {
            System.out.println("较大的数为： " + num);
        }
    }

    // 逢7过
    private void passSeven() {
        for (int i = 1; i <= 100; i++) {
            if (i % 7 != 0 && i % 10 != 7 && i / 10 != 7) {
                System.out.print(i + " ");
            } else {
                System.out.print("过 ");
            }
        }
        System.out.println();
    }

    // 斐波拉契数列
    private void rabbitCount() {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println("第20个月的🐰子对数为：" + arr[19]);
    }

    // 寻找个位十位不为7的偶数
    private void evenAndNotSeven(int[] arr) {
        List list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] % 10 != 7 && arr[i] / 10 % 10 != 7) {
                list.add(arr[i]);
            }
        }
//        int[] array = new int[list.size()];
        Object[] objects = list.toArray();

        System.out.println("数组中个位和十位都不为7的偶数为：");
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i] + " ");
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
        System.out.println();
    }

    // 判断两个数组是否相同
    private boolean isSameArray(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    // 查找数组中的索引
    private void findIndex(int[] arr) {
        int num = loop3();
        System.out.println("此整数用于查找数组中的索引");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                System.out.println(i);
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] demoArr = {19, 28, 37, 46, 50};
        Day05_HW day05_hw = new Day05_HW();
        day05_hw.print();
        System.out.println("---------------");
        day05_hw.printMin();
        System.out.println("---------------");
        day05_hw.printMax();
        System.out.println("---------------");
        day05_hw.printArray();
        System.out.println("---------------");
        day05_hw.printRandomArray(day05_hw.generateRandomArray(arr));
        System.out.println("---------------");
        day05_hw.passSeven();
        System.out.println("---------------");
        day05_hw.rabbitCount();
        int[] array ={7,68,27,75,67,171,78,76,57,88,787,788,42};
        day05_hw.evenAndNotSeven(array);
        System.out.println("---------------");
        int[] randomArray1 = day05_hw.generateRandomArray(arr1);
        int[] randomArray2 = day05_hw.generateRandomArray(arr2);
        System.out.print("随机生成的数组1为");
        day05_hw.printRandomArray(randomArray1);
        System.out.println("---------------");
        System.out.print("随机生成的数组2为");
        day05_hw.printRandomArray(randomArray2);
        System.out.println("---------------");
        if (day05_hw.isSameArray(randomArray1, randomArray2)) {
            System.out.println("两数组相同");
        } else {
            System.out.println("两数组不同");
        }
        System.out.println("---------------");
        day05_hw.findIndex(demoArr);
    }
}
