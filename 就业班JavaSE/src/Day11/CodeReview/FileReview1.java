package Day11.CodeReview;

import java.io.File;
import java.io.IOException;

public class FileReview1 {
    public static void main(String[] args) {
        File file1 = new File("/Users/willdufresne/Downloads/a.txt");
        File file2 = new File("/Users/willdufresne/Downloads/aaa");

        try {
            System.out.println(file1.createNewFile());
            System.out.println(file2.mkdirs());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file1.isDirectory());
        System.out.println(file2.isFile());

        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getName());

        System.out.println(file1.delete());
        System.out.println(file2.delete());
    }
}
