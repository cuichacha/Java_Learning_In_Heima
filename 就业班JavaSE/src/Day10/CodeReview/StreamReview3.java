package Day10.CodeReview;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamReview3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.stream(arr).max().stream().count());

        System.out.println(Stream.of(1, 2, 3, 4, 5, 6).findFirst().map(num -> num * 2).get());
    }
}
