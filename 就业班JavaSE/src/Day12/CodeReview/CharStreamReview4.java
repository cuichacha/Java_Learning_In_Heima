package Day12.CodeReview;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamReview4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len;
        char[] chars = new char[1024];
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();

        try {
            fileWriter = new FileWriter("/Users/willdufresne/Downloads/a.txt");
            fileWriter.write(username);
            fileWriter.write("\n");
            fileWriter.write(password);
            fileWriter.write("\n");
            fileWriter.flush(); // 非常重要的一步！！！不然read不到任何数据！！！

            fileReader = new FileReader("/Users/willdufresne/Downloads/a.txt");
            fileWriter = new FileWriter("/Users/willdufresne/Movies/a.txt");
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(new String(chars, 0, len));
                System.out.println(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
