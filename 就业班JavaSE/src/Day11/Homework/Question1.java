package Day11.Homework;

import java.io.File;
import java.io.IOException;

public class Question1 {
    public static void main(String[] args) {
        File file = new File("/Users/willdufresne/Downloads/demo.txt");
        if (!file.exists()) {
            try {
                System.out.println(file.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.delete());
    }
}
