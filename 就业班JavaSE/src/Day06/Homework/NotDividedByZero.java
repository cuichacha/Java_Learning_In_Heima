package Day06.Homework;

import java.util.Scanner;

public class NotDividedByZero {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println(inputNUmber(1) / inputNUmber(2));
                break;
            } catch (ArithmeticException e) {
//            e.printStackTrace();
                System.out.println("第二个整数不能为0，请重新输入");
            }
        }
    }

    private static int inputNUmber(int num) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第" + num + "个整数");
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (RuntimeException e) {
                System.out.println("请输入整数");
            }
        }
        return number;
    }
}
