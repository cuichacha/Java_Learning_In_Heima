package Day03.Code;

import java.util.Scanner;

public class Day03_Code9 {
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
            System.out.println("请输入1到100之间的一个整数：");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成int
            if (checkNumber(str)) {
                num = Integer.parseInt(str);
                if (num >= 1 && num <= 100) {
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

	public static void main(String[] args) {
        int num;

        Day03_Code9 day03_Code9 = new Day03_Code9();
        num = day03_Code9.loop();
        
    }
}