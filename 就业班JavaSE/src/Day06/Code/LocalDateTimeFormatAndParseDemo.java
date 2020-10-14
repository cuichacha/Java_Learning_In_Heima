package Day06.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatAndParseDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));

        String time = "2020年11月12日 13:14:15";
        System.out.println(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));
        
    }
}
