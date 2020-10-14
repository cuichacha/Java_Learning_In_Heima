package Day12.CodeReview;

import java.io.UnsupportedEncodingException;

public class CharStreamReview1 {
    public static void main(String[] args) {
        String str1 = "叽里呱啦";
        byte[] utf8Bytes = str1.getBytes();
        try {
            byte[] gbkBytes = str1.getBytes("GBK");
            System.out.println(new String(utf8Bytes));
            System.out.println(new String(gbkBytes, "GBK"));
            System.out.println(new String(utf8Bytes, "GBK"));
            System.out.println(new String(gbkBytes));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
