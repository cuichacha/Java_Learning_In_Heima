package Day06.Code;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println(date1);

        Date date2 = new Date(0L);
        System.out.println(date2);

        System.out.println(date1.getTime());
        date1.setTime(3600L * 1000);
        System.out.println(date1.getTime());
    }
}
