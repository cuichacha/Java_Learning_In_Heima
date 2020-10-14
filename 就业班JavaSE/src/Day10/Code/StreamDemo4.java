package Day10.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>(List.of("11", "222", "122", "233", "222", "122"));
        System.out.println(arrayList1.stream().count());
        ArrayList<String> arrayList2 = new ArrayList<>(List.of("11", "222", "122", "233", "222", "122"));
        arrayList2.forEach(s -> System.out.println(s));

        ArrayList<Integer> arrayList3 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        arrayList3.add(10);
        arrayList3.add(10);
        arrayList3.add(10);
        arrayList3.add(10);
        System.out.println(arrayList3.stream().filter(number -> number % 2 == 0).collect(Collectors.toList()));
        System.out.println(arrayList3.stream().filter(number -> number % 2 == 0).collect(Collectors.toSet()));

        ArrayList<String> arrayList4 = new ArrayList<>(List.of("zhangsan,23", "lisi,24", "wangwu,25"));
        Map<String, Integer> map = arrayList4.stream().filter(s -> {
            String[] split = s.split(",");

            int age = Integer.parseInt(split[1]);

            return age >= 24;
        }).collect(Collectors.toMap(
                s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1])));
        System.out.println(map);

        ArrayList<String> arrayList5 = new ArrayList<>(List.of("zhangsan,23", "lisi,24", "wangwu,25"));
        System.out.println(arrayList5.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return Integer.parseInt(s.split(",")[1]) >= 24;
            }
        }).collect(Collectors.toMap(
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split(",")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split(",")[1]);
                    }
                })
        ));
    }
}
