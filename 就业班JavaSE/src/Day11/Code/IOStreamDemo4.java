package Day11.Code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamDemo4 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("/Users/willdufresne/Downloads/Beginner_Level_Certificate.pdf");
            fileOutputStream = new FileOutputStream("/Users/willdufresne/Movies/Beginner_Level_Certificate.pdf");
            int b = 0;
            while (b != -1) {
                b = fileInputStream.read();
                fileOutputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null && fileOutputStream != null) {
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
