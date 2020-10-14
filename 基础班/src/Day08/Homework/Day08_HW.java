package Day08.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public final class Day08_HW {

    Scanner scanner = new Scanner(System.in);

    // 模拟用户登陆，3次机会
    private void userLogIn() {
        String userName = "admin";
        String passWord = "000000";

        for (int i = 1; i <= 3; i++) {
            System.out.print("请输入用户名：");
            String inputUserName = scanner.nextLine();
            System.out.print("请输入密码：");
            String inputPassWord = scanner.nextLine();

            while (true) {
                String captcha = generateCaptcha();
                System.out.println(captcha);
                System.out.print("请输入验证码（不区分大小写）：");
                String inputCaptcha = scanner.nextLine();
                if (captcha.equalsIgnoreCase(inputCaptcha)) {
                    break;
                } else {
                    System.out.println("您输入的验证码有误，请重新输入");
                }
            }

            if (userName.equals(inputUserName) && passWord.equals(inputPassWord)) {
                System.out.println("登陆成功! 5秒后跳转到登陆前页面......");
                break;
            } else {
                if (i != 3) {
                    System.out.println("您输入的账户密码有误，还剩" + (3 - i) + "次尝试机会");
                } else {
                    System.out.println("您的登陆机会已用完，账户自动删除。");
                }
            }
        }
    }

    // 随机生成一个验证码
    private String generateCaptcha() {
        Random random = new Random();
        int random1 = random.nextInt(9) + 48;
        int random2 = random.nextInt(25) + 65;
        int random3 = random.nextInt(25) + 65;
        int random4 = random.nextInt(9) + 48;
        char ch1 = (char) random1;
        char ch2 = (char) random2;
        char ch3 = (char) random3;
        char ch4 = (char) random4;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ch1).append(ch2).append(ch3).append(ch4);
        String captcha = stringBuilder.toString();
        return captcha;
    }

    // 遍历字符串方法1
    private void iterateString1() {
        System.out.println("请输入字符串");
        String string = scanner.nextLine();

        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }
    }

    // 遍历字符串方法1
    private void iterateString2() {
        System.out.println("请输入字符串");
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    // 输入字符串中的不同种类的字符数量
    private void charCount() {
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int numberCount = 0;
        System.out.println("请输入字符串");
        String string = scanner.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                upperCaseCount++;
            } else if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
                lowerCaseCount++;
            } else if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                numberCount++;
            }
        }
        System.out.println("字符串中大写字母有" + upperCaseCount + "个，小写字母有" + lowerCaseCount + "个，数字有" + numberCount + "个");
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

    private int loop(int sequence) {
        int num;
//        double num2;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入整数" + sequence + ": ");
            // 键盘录入
            String str = input();
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

    private String input() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    // 字符串拼接
    private void stringConcatenation() {
        System.out.println("录入一个整数数组");
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = loop(i + 1);
        }
        System.out.println("您输入的数组为");
        System.out.println(Arrays.toString(arr));

    }

    // 判断字符串是否对称
    private void symmetryString() {
        System.out.println("请输入一个字符串");
        String string = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(string);
        String reverse = stringBuilder.reverse().toString();

        if (string.equals(reverse)) {
            System.out.println("是对称字符串");
        } else {
            System.out.println("不是对称字符串");
        }
    }

    // 对手机号码部分数字屏蔽
    private void censorPhoneNumber() {
        System.out.println("请输入手机号");
        String phoneNumber = scanner.nextLine();

        if (checkPhoneNumber(phoneNumber)) {
            String frontPart = phoneNumber.substring(0, 3);
            String rearPart = phoneNumber.substring(7);
            System.out.println(frontPart + "****" + rearPart);
        } else {
            System.out.println("您输入的号码有误");
        }
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        char[] chars = phoneNumber.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9' || chars.length != 11) {
                return false;
            } else if (chars[0] != '1') {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    // 屏蔽敏感词
    private void beep() {
        System.out.println("请输入您想说的话");
        String speech = scanner.nextLine();
        String replace = speech.replace("TMD", "***");
        System.out.println(replace);
    }

    // 切割字符串
    private void splitString() {
        System.out.println("请输入学生信息");
        String studentInfo = scanner.nextLine();
        String[] splitedStudentInfo = studentInfo.split("，");
        Student student = new Student();
        student.setName(splitedStudentInfo[0]);
        student.setAge(splitedStudentInfo[1]);
        System.out.println(student.getName());
        System.out.println(student.getAge());
    }


    private void symmetryStringArray() {
        String[] stringArray = {"010", "3223", "666", "7890987", "123123"};
        int count = 0;
        for (int i = 0; i < stringArray.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(stringArray[i]);
            String reverse = stringBuilder.reverse().toString();

            if (stringArray[i].equals(reverse)) {
                System.out.println(stringArray[i] + "是对称字符串");
                count++;
            } else {
                System.out.println(stringArray[i] + "不是对称字符串");
            }
        }
        System.out.println("共有" + count + "个对称字符串");
    }

    private void randomStringReverse() {
        char[] chars = {'a', 's', 'd', 'f', 'a', 'd', '2', '3', '8'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(10);
            stringBuilder.append(chars[randomNumber]);
        }
        System.out.println("随机字符串为：" + stringBuilder);
        System.out.println("倒序字符串为：" + stringBuilder.reverse());
    }


    public static void main(String[] args) {
        Day08_HW day08_hw = new Day08_HW();
        day08_hw.userLogIn();
        day08_hw.iterateString1();
        day08_hw.iterateString2();
        day08_hw.charCount();
        day08_hw.stringConcatenation();
        day08_hw.symmetryString();
        day08_hw.censorPhoneNumber();
        day08_hw.beep();
        day08_hw.splitString();
        day08_hw.symmetryStringArray();
        day08_hw.randomStringReverse();
    }

    class Student {
        private String name;
        private String age;

        public Student() {
        }

        public Student(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}

