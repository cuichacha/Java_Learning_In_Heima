package Day06.Code;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatePractice {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    private static long jiaTime;
    private static long piTime;

    static {
        try {
            jiaTime = simpleDateFormat.parse("2020年11月11日 0:03:47").getTime();
            piTime = simpleDateFormat.parse("2020年11月11日 0:10:11").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public DatePractice() throws ParseException {
    }

    public static void main(String[] args) throws ParseException {
        ifGet(jiaTime);
        ifGet(piTime);
    }

    private static void ifGet(long time) throws ParseException {
        long startTime = simpleDateFormat.parse("2020年11月11日 0:0:0").getTime();
        long endTime = simpleDateFormat.parse("2020年11月11日 0:10:0").getTime();
        if (time >= startTime && time <= endTime) {
            System.out.println("秒杀成功");
        } else {
            System.out.println("秒杀失败");
        }
    }
}
