package Day08.Code;

import java.util.Scanner;

public final class Day08_Code2 {
    public static void main(String[] args) {
        String username = "admin";
        String password = "000000";

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i <= 3; i++) {
            System.out.println("请输入用户名：");
            String scannerUsername = scanner.nextLine();
            System.out.println("请输入密码：");
            String scannerPassword = scanner.nextLine();
            if (scannerUsername.equals(username) && scannerPassword.equals(password)) {
                System.out.println("登陆成功");
            } else {
                System.out.println("您输入的账号或密码有误");
            }
        }
    }
}
