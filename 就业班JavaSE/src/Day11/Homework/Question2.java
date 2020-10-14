package Day11.Homework;

import java.io.File;

public class Question2 {
    public static void main(String[] args) {
        File file = new File("/Users/willdufresne/Downloads");
        getAbsolutePath(file);
    }

    private static void getAbsolutePath(File file) {
        File[] files = file.listFiles();
        for (File insideFile : files) {
            if (insideFile.isFile()) {
                System.out.println(insideFile.getAbsolutePath());
            } else {
                getAbsolutePath(insideFile);
            }
        }
    }
}
