package Day06.Homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class BornDays {

    public static void main(String[] args) throws ParseException {
//        LocalDate localDate1 = LocalDate.now();
//        LocalDate localDate2 = LocalDate.now();
//
//        System.out.println(localDate1.equals(localDate2));

//        System.gc();

        long time1 = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入生日");
            String birthday1 = scanner.nextLine();
//            System.out.println("您已出生" + ((new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd").parse(birthday1).getTime())) / (1000 * 3600 * 24) + "天");
            try {
                System.out.println("您已出生" + ((new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd").parse(birthday1).getTime())) / (1000 * 3600 * 24) + "天");
                break;
            } catch (ParseException e) {
//                e.printStackTrace();
                System.out.println("请输入正确格式的生日");
            }
        }


        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        //
        long time3 = System.currentTimeMillis();
        while (true) {
            try {
                System.out.println("请输入生日");
                String birthday2 = scanner.nextLine();
                LocalDate birthdate = LocalDate.parse(birthday2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int count = 0;
                while (!birthdate.equals(LocalDate.now())) {
                    birthdate = birthdate.plusDays(1);
                    count++;
                }
                System.out.println("您已出生" + count + "天");
                break;
            } catch (RuntimeException e) {
//            e.printStackTrace();
                System.out.println("请输入正确格式的生日");
            }
        }
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);
    }
}
