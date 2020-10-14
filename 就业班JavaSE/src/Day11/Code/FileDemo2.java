package Day11.Code;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {
    public static void main(String[] args) throws IOException {
//        File file1 = new File("Macintosh HD/Users/willdufresne/Downloads/java.txt");
        File file1 = new File("/Users/willdufresne/Downloads/java.txt");
        System.out.println(file1.createNewFile());

        File file2 = new File("/Users/willdufresne/Downloads/aaa");
        System.out.println(file2.mkdirs());
    }
}
