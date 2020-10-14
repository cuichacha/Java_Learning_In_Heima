package Day11.Code;

import java.io.File;
import java.io.IOException;

public class FileDemo5 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/willdufresne/Downloads/aaa");
        if (file.exists()) {
            new File(file + "a.txt").createNewFile();
        } else {
            file.mkdir();
            new File(file, "a.txt").createNewFile();
        }
    }
}
