package Day11.Code;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamDemo1 {
    public static void main(String[] args) throws IOException {
//        File file = new File("/Users/willdufresne/Downloads/a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/willdufresne/Downloads/a.txt", true);
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write("\r".getBytes());
        byte[] bytes = {97, 98, 99, 100, 101, 102, 103, 104};
        fileOutputStream.write(bytes);
        fileOutputStream.write("\r".getBytes());
        fileOutputStream.write(bytes, 2, 5);
        fileOutputStream.close();
    }
}
