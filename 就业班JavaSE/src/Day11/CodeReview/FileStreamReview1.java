package Day11.CodeReview;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamReview1 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        byte[] bytes = {97, 98, 99, 100};

        try {
            fos = new FileOutputStream("/Users/willdufresne/Downloads/a.txt", true);
            fos.write(bytes);
            fos.write("\r".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
