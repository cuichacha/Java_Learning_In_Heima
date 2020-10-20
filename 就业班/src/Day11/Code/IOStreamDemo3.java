package Day11.Code;

import java.io.FileInputStream;
import java.io.IOException;

public class IOStreamDemo3 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("/Users/willdufresne/Downloads/a.txt");
            int read = 0;
            while (read != -1) {
                read = fileInputStream.read();
                System.out.println((char)read);
            }
            // 特别注意！！这个read()方法，类似于iterator。调用时内部指针会后移一位，直接用不用变量不行，坑！！
//            while (fileInputStream.read() != -1) {
//                System.out.println((char) fileInputStream.read());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
