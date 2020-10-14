package Day02.Code;

import java.util.Scanner;

public class Day02_Code7 {

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
            System.out.println("请输入数字：");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成double
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
                System.out.println("请输入整数！！");
            }
        }
    }

    private void evenOrOdd(int num) {
        if (num % 2 == 0) {
            System.out.println("数字" + num + "是偶数");
        } else {
            System.out.println("数字" + num + "是奇数");
        }
    }

    public static void main(String[] args) {
        int num;

        Day02_Code7 day02_Code7 = new Day02_Code7();
        num = day02_Code7.loop();
        day02_Code7.evenOrOdd(num);
    }
}






//    public static void main(String[] args) {
//
//        boolean flag = true;
//        int num = 0;
//
//        Scanner scanner = new Scanner(System.in);
//        while (flag) {
//            System.out.println("请输入一个年龄：");
//            String str = scanner.nextLine();
//            // 如果第一个字符是数字或者负号，就验证后面的字符
//            if(Character.isDigit(str.charAt(0)) || Character.hashCode(str.charAt(0)) == 45) {
//                // 遍历输入的字符串，如果有一个字符不是数字，就陷入输入循环
//                for(int i=1;i<str.length();i++){
//                    if(!Character.isDigit(str.charAt(i))) {
//                        System.out.println("请输入整数！！");
//                        break;
//                    } else if (i == (str.length() - 1)) {
//                        num = Integer.parseInt(str);
//                        if (num <=0 || num >= 120) {
//                            System.out.println("请输入正常年龄！！");
//                            break;
//                        } else if (num < 18) {
//                            System.out.println("不可以上网吧！");
//                            flag = false;
//                        } else {
//                            System.out.println("可以上网吧。");
//                            flag = false;
//                        }
//                    }
//                }
//            } else {
//                System.out.println("请输入整数！！");
//            }
//        }
//    }
