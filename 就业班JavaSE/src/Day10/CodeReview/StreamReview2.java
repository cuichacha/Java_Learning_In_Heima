package Day10.CodeReview;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReview2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 3, 5, 8, 8, 9, 10));
        list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).limit(5).skip(2).collect(Collectors.toSet()).stream().map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer *= 2;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        list.stream().filter(num -> num % 2 == 0).limit(5).skip(2).
                collect(Collectors.toList()).stream().
                distinct().map(num -> num * num).forEach(num -> System.out.println(num));

        Stream<String> stringStream = list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 != 0;
            }
        }).limit(6).skip(1).sorted().map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        });

        Stream<Integer> integerStream = list.stream().filter(num -> num % 2 != 0).limit(6).skip(1).sorted().map(num -> num + 1);

        System.out.println(Stream.concat(stringStream, integerStream).count());
    }
}
