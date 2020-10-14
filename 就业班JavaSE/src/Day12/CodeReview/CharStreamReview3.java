package Day12.CodeReview;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamReview3 {
    public static void main(String[] args) {
        method1();
        System.out.println();
        method2();
    }

    private static void method2() {
        FileReader fileReader = null;
        int len;
        char[] chars = new char[1024];

        try {
            fileReader = new FileReader("/Users/willdufresne/Downloads/a.txt");
            while ((len = fileReader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
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
        FileReader fileReader = null;
        int ch;

        try {
            fileReader = new FileReader("/Users/willdufresne/Downloads/a.txt");
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
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
}
