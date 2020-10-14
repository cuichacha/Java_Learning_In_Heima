package Day10.CodeReview;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class StreamReview1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        list.stream().map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                integer = integer * 2;
                return integer;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        list.stream().map(num -> num * 2).forEach(num -> System.out.println(num));
        list.stream().map(num -> num * 2).forEach(System.out::println);
    }
}
