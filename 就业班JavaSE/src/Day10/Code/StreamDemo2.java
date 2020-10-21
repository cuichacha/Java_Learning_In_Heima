package Day10.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(List.of("111", "122", "3", "12345"));
        arrayList.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3 && s.startsWith("1");
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
