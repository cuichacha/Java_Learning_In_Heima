package Day12.CodeReview;

import java.io.*;
import java.nio.charset.Charset;

public class PutStreamReview {
    public static void main(String[] args) {
//        method1();

//        method2();
    }

    private static void method2() {
        FileReader fileReader = null;
        FileWriter fileWriter1 = null;
        FileWriter fileWriter2 = null;
        int len;
        char[] chars = new char[1024];

        try {
            fileReader = new FileReader("/Users/willdufresne/Downloads/b.txt");
            while ((len = fileReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }

            fileReader = new FileReader("/Users/willdufresne/Downloads/b.txt", Charset.forName("GBK"));
            fileWriter1 = new FileWriter("/Users/willdufresne/Movies/b.txt", Charset.forName("GBK"));
            fileWriter2 = new FileWriter("/Users/willdufresne/Movies/a.txt");
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter1.write(chars, 0, len);
                fileWriter2.write(chars, 0, len);
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
            if (fileWriter1 != null) {
                try {
                    fileWriter1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void method1() {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter1 = null;
        OutputStreamWriter outputStreamWriter2 = null;
        int len;
        char[] chars = new char[1024];

        try {
            inputStreamReader = new InputStreamReader
                    (new FileInputStream("/Users/willdufresne/Downloads/b.txt")); // 此处默认UTF-8编码，所以会乱码
            while ((len = inputStreamReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }
            inputStreamReader = new InputStreamReader(new FileInputStream("/Users/willdufresne/Downloads/b.txt"), "GBK");
            outputStreamWriter1 = new OutputStreamWriter
                    (new FileOutputStream("/Users/willdufresne/Movies/b.txt"));
            outputStreamWriter2 = new OutputStreamWriter
                    (new FileOutputStream("/Users/willdufresne/Movies/a.txt"), "GBK");
            while ((len = inputStreamReader.read(chars)) != -1) {
                outputStreamWriter1.write(chars, 0, len);
                outputStreamWriter2.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter1 != null) {
                try {
                    outputStreamWriter1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter2 != null) {
                try {
                    outputStreamWriter2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
