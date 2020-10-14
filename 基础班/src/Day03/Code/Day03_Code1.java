package Day03.Code;

import java.util.Scanner;

public class Day03_Code1 {

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
            System.out.println("请输入数字1-7：");
            // 键盘录入
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成double
            if (checkNumber(str)) {
                num = Integer.parseInt(str);
                if (num >= 1 && num <= 7) {
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

    private void weekdays(int num) {
	switch (num) {
		case 1: 
			System.out.println("星期一");
			break;

		case 2: 
			System.out.println("星期二");
			break;
		case 3: 
			System.out.println("星期三");
			break;
		case 4: 
			System.out.println("星期四");
			break;
		case 5: 
			System.out.println("星期五");
			break;
		case 6: 
			System.out.println("星期六");
			break;
		case 7: 
			System.out.println("星期日");
			break;
	}        
    }

    public static void main(String[] args) {
        int num;

        Day03_Code1 day03_Code1 = new Day03_Code1();
        num = day03_Code1.loop();
        day03_Code1.weekdays(num);
    }
}
