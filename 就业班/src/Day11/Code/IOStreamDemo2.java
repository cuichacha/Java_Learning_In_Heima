package Day11.Code;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamDemo2 {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/Users/willdufresne/Downloads/a.txt", true);
            fileOutputStream.write(97);
            fileOutputStream.write("\r".getBytes());
            byte[] bytes = {97, 98, 99, 100, 101, 102, 103, 104};
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
