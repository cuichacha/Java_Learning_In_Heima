package Day11.Code;

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {
        File file1 = new File("a.txt");
        System.out.println(file1.getName());
        System.out.println(file1.exists());
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());

        File file2 = new File("/Users/willdufresne/Downloads/aaa");
        System.out.println(file2.getName());
        System.out.println(file2.exists());
        System.out.println(file2.isFile());
        System.out.println(file2.isDirectory());
    }
}
