package Day06.Homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChangeFormat {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        dateFormat1();
        dateFormat2();
    }

    private static void dateFormat1() {
        while (true) {
            System.out.println("请输入日期");
            String date = scanner.nextLine();
            try {
                System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(new SimpleDateFormat("yyyy-MM-dd").parse(date)));
                break;
            } catch (ParseException e) {
//                e.printStackTrace();
                System.out.println("请输入正确格式的日期");
            }
        }
    }

    private static void dateFormat2() {
        while (true) {
            try {
                System.out.println("请输入日期");
                String date = scanner.nextLine();
                System.out.println(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
                break;
            } catch (Exception e) {
//            e.printStackTrace();
                System.out.println("请输入正确格式的日期");
            }
        }
    }
}
