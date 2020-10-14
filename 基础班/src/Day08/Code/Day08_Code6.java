package Day08.Code;

import java.util.Scanner;

public final class Day08_Code6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入手机号码");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.length() == 11) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9') {
                    System.out.println("您输入的号码有误");
                    break;
                } else {
                    String start = phoneNumber.substring(0, 3);
                    String end = phoneNumber.substring(7);
                    System.out.println(start + "****" + end);
                }
            }
        } else {
            System.out.println("您输入的号码有误");
        }
    }
}
