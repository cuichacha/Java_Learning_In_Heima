package Day11.CodeReview;

import java.io.File;

public class FileReview2 {
    public static void main(String[] args) {
        File file = new File("/Users/willdufresne/Downloads/aaa");
        delete(file);
    }

    private static void delete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File insideFile : files) {
                if (insideFile.isFile()) {
                    insideFile.delete();
                } else {
                    delete(insideFile);
                }
            }
            file.delete();
        }
    }
}
