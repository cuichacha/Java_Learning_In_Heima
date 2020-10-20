package Day11.Code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class IOStreamDemo6 {
    // 读取写入中文字符串文本文档

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("/Users/willdufresne/Downloads/a.txt");
            fileOutputStream = new FileOutputStream("/Users/willdufresne/Movies/a.txt");
            byte[] bytes = new byte[10];
            ArrayList<Byte> arrayList = new ArrayList<>();
            int len;
            int sum = 0;
//            String str = null;
            while ((len = fileInputStream.read(bytes)) != -1) {
                for (byte aByte : bytes) {
                    arrayList.add(aByte);
                }
                sum += len;
//                fileOutputStream.write(bytes, 0, len);
//                str = new String(bytes, 0, len);
            }
            byte[] newBytes = new byte[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                newBytes[i] = arrayList.get(i);
            }
            String s = new String(newBytes, 0, newBytes.length);
//            System.out.println(s);
//            fileOutputStream.write(newBytes); // 这里的错误原因，是没有转成字符串，直接写出来就是一堆byte
            System.out.println(sum);
            System.out.println(arrayList.size());
            fileOutputStream.write(s.getBytes());
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
