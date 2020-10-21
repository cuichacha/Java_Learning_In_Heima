package Day10.Code;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        method1();

        method2();

        method3();

        method4();
    }

    private static void method4() {
        Stream.of(1, 2, 3, 4, 5).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    private static void method3() {
        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        System.out.println("-----------------------------------");
    }

    private static void method2() {
        Map<String, String> map = new HashMap<>(Map.of("1", "11", "2", "22"));
        map.keySet().stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        map.values().stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        map.entrySet().stream().forEach(new Consumer<Map.Entry<String, String>>() {
            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                System.out.println(stringStringEntry);
            }
        });
        System.out.println("-----------------------------------");
    }

    private static void method1() {
        List<String> list = new ArrayList<>(List.of("1", "2", "3"));
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("-----------------------------------");
    }
}
