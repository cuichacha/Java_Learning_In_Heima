package Day12.Code;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamDemo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileWriter fileWriter = null;
//        char[] chars = new char[1024];

        try {
            fileWriter = new FileWriter("/Users/willdufresne/Downloads/a.txt");
            System.out.println("请输入用户名");
            String username = scanner.nextLine();
            fileWriter.write(username);
            fileWriter.write("\r");
            System.out.println("请输入密码");
            String password = scanner.nextLine();
            fileWriter.write(password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
