package Day06.CodeReview;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeReview {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.of(2020, 10, 17, 13, 14, 15));
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().getYear());
        System.out.println(LocalDateTime.now().getMonth());
        System.out.println(LocalDateTime.now().getMonthValue());
        System.out.println(LocalDateTime.now().getDayOfYear());
        System.out.println(LocalDateTime.now().getDayOfMonth());
        System.out.println(LocalDateTime.now().getDayOfWeek());
        System.out.println(LocalDateTime.now().getHour());
        System.out.println(LocalDateTime.now().getMinute());
        System.out.println(LocalDateTime.now().getSecond());

        System.out.println(LocalDateTime.now().toLocalDate());
        System.out.println(LocalDateTime.now().toLocalTime());

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));
        String time = "2020年11月12日 13:14:15";
        System.out.println(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));

        System.out.println(LocalDateTime.now().plusYears(10));
        System.out.println(LocalDateTime.now().plusMonths(10));
        System.out.println(LocalDateTime.now().plusWeeks(10));
        System.out.println(LocalDateTime.now().plusDays(10));
        System.out.println(LocalDateTime.now().plusHours(10));
        System.out.println(LocalDateTime.now().plusMinutes(10));
        System.out.println(LocalDateTime.now().plusSeconds(100));
        System.out.println(LocalDateTime.now().plusNanos(100));

        System.out.println(LocalDateTime.now().minusYears(10));
        System.out.println(LocalDateTime.now().minusMonths(10));
        System.out.println(LocalDateTime.now().minusWeeks(10));
        System.out.println(LocalDateTime.now().minusDays(10));
        System.out.println(LocalDateTime.now().minusHours(10));
        System.out.println(LocalDateTime.now().minusMinutes(10));
        System.out.println(LocalDateTime.now().minusSeconds(100));
        System.out.println(LocalDateTime.now().minusNanos(100));

        System.out.println(LocalDateTime.now().withYear(1999));
        System.out.println(LocalDateTime.now().withMonth(10));
        System.out.println(LocalDateTime.now().withDayOfYear(100));
        System.out.println(LocalDateTime.now().withDayOfMonth(10));
        System.out.println(LocalDateTime.now().withHour(10));
        System.out.println(LocalDateTime.now().withMinute(10));
        System.out.println(LocalDateTime.now().withSecond(10));
        System.out.println(LocalDateTime.now().withNano(100));

        System.out.println(Period.between(LocalDate.now(), LocalDate.of(1999, 10, 10)));
        System.out.println(Period.between(LocalDate.now(), LocalDate.of(1999, 10, 10)).getYears());
        System.out.println(Period.between(LocalDate.now(), LocalDate.of(1999, 10, 10)).getMonths());
        System.out.println(Period.between(LocalDate.now(), LocalDate.of(1999, 10, 10)).getDays());

        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(5, 30, 45)));
        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(5, 30, 45)).getSeconds());
        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(5, 30, 45)).toDays());
        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(5, 30, 45)).toHours());
        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(5, 30, 45)).toMinutes());
        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(5, 30, 45)).toMillis());
        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(5, 30, 45)).toNanos());
        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(5, 30, 45)).toString());
    }
}
