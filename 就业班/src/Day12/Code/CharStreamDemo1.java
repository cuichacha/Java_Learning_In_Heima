package Day12.Code;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharStreamDemo1 {
    public static void main(String[] args) {
        String s1 = "垃圾";

        byte[] bytes1 = s1.getBytes();
        System.out.println(Arrays.toString(bytes1));

        try {
            byte[] bytes2 = s1.getBytes("gbk");
            System.out.println(Arrays.toString(bytes2));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] bytes3 = {-27, -98, -125, -27, -100, -66};
        byte[] bytes4 = {-64, -84, -69, -8};
        String s2 = new String(bytes3);
        System.out.println(s2);

        try {
            String s3 = new String(bytes4, "gbk");
            System.out.println(s3);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
