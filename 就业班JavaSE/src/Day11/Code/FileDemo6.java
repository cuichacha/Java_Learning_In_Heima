package Day11.Code;

import java.io.File;

public class FileDemo6 {
    public static void main(String[] args) {
        File file = new File("/Users/willdufresne/Downloads/aaa");
//        System.out.println(file.delete());
        deleteFile(file);
    }

    private static void deleteFile(File file) {
        File[] files = file.listFiles();
        for (File insideFiles : files) {
            if (insideFiles.isFile()) {
                insideFiles.delete();
            } else {
                deleteFile(insideFiles);
            }
        }
        System.out.println(file.delete());
    }
}
