package Day11.Code;

import java.io.*;

public class BufferedStreamDemo1 {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users/willdufresne/Downloads/股社区.mp4"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/willdufresne/Movies/股社区.mp4"));
            int b = 0;
            while (b != -1) {
                b = bufferedInputStream.read();
                bufferedOutputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null && bufferedOutputStream != null) {
                try {
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
