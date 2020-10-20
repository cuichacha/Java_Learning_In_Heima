package Day11.Code;

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {
        File file1 = new File("/Users/willdufresne/Downloads/java.txt");
        System.out.println(file1.delete());

        File file2 = new File("/Users/willdufresne/Downloads/aaa");
        System.out.println(file2.delete());
    }
}
