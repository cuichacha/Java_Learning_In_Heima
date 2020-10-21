package Day06.Code;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThrowExceptionDemo {
    public static void main(String[] args) throws ParseException{
        method1();
        method2();
    }

    private static void method1() throws ArrayIndexOutOfBoundsException {
        int[] intArr = {1, 2, 3, 4, 5};
        System.out.println(intArr[5]);
    }

    private static void method2() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("1234");
        simpleDateFormat.parse("567");
    }
}
