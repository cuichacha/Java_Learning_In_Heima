package Day06.Code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat();
        System.out.println(simpleDateFormat1.format(date1));

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(date1));

        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat3.format(date1));

        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(simpleDateFormat4.format(date1));

        SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(simpleDateFormat5.format(date1));

        String date2 = "2020-1-1";
        System.out.println(simpleDateFormat3.parse(date2));

        String date3 = "2020年1月1日";
        System.out.println(simpleDateFormat5.parse(date3));
    }
}
