package Day12.Code;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class PutStreamDemo1 {
    public static void main(String[] args) {
        method1();

        method2();
    }

    private static void method2() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("/Users/willdufresne/Downloads/a.txt", Charset.forName("gbk"));
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.println((char) c);
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
        }
    }

    private static void method1() {
        InputStreamReader is = null;
        try {
            is = new InputStreamReader(new FileInputStream("/Users/willdufresne/Downloads/a.txt"), "gbk");
            int c;
            while ((c = is.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
