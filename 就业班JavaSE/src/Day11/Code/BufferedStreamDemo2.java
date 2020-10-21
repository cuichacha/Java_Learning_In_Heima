package Day11.Code;

import java.io.*;

public class BufferedStreamDemo2 {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users/willdufresne/Downloads/股社区.mp4"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/willdufresne/Movies/股社区.mp4"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
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
