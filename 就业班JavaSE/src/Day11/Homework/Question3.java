package Day11.Homework;

import java.io.*;

public class Question3 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        byte[] bytes = new byte[1024];

        try {
            bis = new BufferedInputStream(new FileInputStream("/Users/willdufresne/Downloads/股社区.mp4"));
            bos = new BufferedOutputStream(new FileOutputStream("/Users/willdufresne/MOvies/股社区.mp4"));
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null && bos != null) {
                try {
                    bis.close();
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
