package Day10.Homework;

import java.util.Arrays;

public class Stream3 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 2, 3, 2, 2, 4, 2};
        Arrays.stream(arr).distinct().forEach(System.out::println);
    }
}
