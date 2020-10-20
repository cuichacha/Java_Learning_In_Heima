package Day06.Code;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TryCatchExceptionDemo {
    public static void main(String[] args) {
        try {
            method();
        } catch (ParseException e) {
//        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
//            System.out.println("发生异常");
        }
        System.out.println("!!!");
        System.out.println("!!!");
        System.out.println("!!!");
        System.out.println("!!!");
    }

    private static void method() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.parse("2023年8与人19日");
    }
}
