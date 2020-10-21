package Day07.Homework;

import java.util.ArrayList;
import java.util.List;

public class Collection3 {
    public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();

        doubleList.add(88.5);
        doubleList.add(39.2);
        doubleList.add(77.1);
        doubleList.add(56.8);
        doubleList.add(89.0);
        doubleList.add(99.0);
        doubleList.add(59.5);

        for (Double score : doubleList) {
            System.out.println(score);
        }

        System.out.println("------------------");

        for (Double score : doubleList) {
            if (score < 60) System.out.println(score);
        }

        System.out.println("------------------");

        int count = 0;
        double sum = 0;
        for (Double score : doubleList) {
            if (score < 60) {
                count++;
                sum += score;
            }
        }
        System.out.println(sum / count);

        System.out.println("------------------");

        double highest = 0.0;
        for (Double score : doubleList) {
            if (score >= highest) {
                highest = score;
            }
        }
        System.out.println(highest);
    }
}
