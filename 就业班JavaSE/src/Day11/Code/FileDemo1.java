package Day11.Code;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        method1();

        method2();

        method3();

        method4();
    }

    private static void method4() {
        File file1 = new File("/Users");
        String path = "willdufresne/Downloads";
        File file = new File(file1, path);
        System.out.println(file);
    }

    private static void method3() {
        String path1 = "/Users";
        String path2 = "willdufresne/Downloads";
        File file= new File(path1, path2);
        System.out.println(file);
    }

    private static void method2() {
        String path1 = "Macintosh HD/Users";
        String path2 = "willdufresne/Downloads";
        File file= new File(path1, path2);
        System.out.println(file);
    }

    private static void method1() {
        String path = "Macintosh HD/Users/willdufresne/Downloads";
        File file = new File(path);
        System.out.println(file);
    }
}
