package Day10.Homework;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Question2 {
    public static void main(String[] args) {
        // 队伍1
        ArrayList<String> team1 = new ArrayList<>();
        team1.add("陈玄风");
        team1.add("梅超风");
        team1.add("风清扬");
        team1.add("解风");
        team1.add("风波恶");
        team1.add("陆乘风");
        team1.add("曲灵风");
        team1.add("武眠风");
        team1.add("冯默风");
        team1.add("陆小风");
        // 队伍2
        ArrayList<String> team2 = new ArrayList<>();
        team2.add("宋远桥");
        team2.add("俞莲舟");
        team2.add("俞岱岩");
        team2.add("张松溪");
        team2.add("张翠山");
        team2.add("殷梨亭");
        team2.add("莫声谷");

        Stream<String> stream1 = team1.stream().filter(s -> s.length() == 3 && s.endsWith("风")).limit(6);
        Stream<String> stream2 = team2.stream().filter(s -> s.startsWith("张")).skip(1);
        Stream.concat(stream1, stream2).forEach(System.out::println);
    }
}
