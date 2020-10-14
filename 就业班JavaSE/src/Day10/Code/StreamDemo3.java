package Day10.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(List.of("11", "222", "122", "233", "222", "122"));

        Stream<String> stream1 = arrayList.stream().limit(1);
        Stream<String> stream2 = arrayList.stream().limit(1);
        Stream<String> stream3 = arrayList.stream().limit(1);
        stream1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("-----------------------");

        Stream<String> stream4 = arrayList.stream().skip(2);
        Stream<String> stream5 = arrayList.stream().skip(2);
        Stream<String> stream6 = arrayList.stream().skip(2);
        stream4.forEach(s -> System.out.println(s));
        System.out.println("-----------------------");

        Stream<String> stream7 = Stream.concat(stream2, stream5);
        stream7.forEach(s -> System.out.println(s));
        System.out.println("-----------------------");

        Stream<String> stream8 = Stream.concat(stream3, stream6);
        stream8.distinct().forEach(s -> System.out.println(s));
        System.out.println("-----------------------");

    }
}
