package Day09.Homework;

import java.util.*;
import java.util.function.BiConsumer;

public class MapQuestion6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一串数字，用,隔开");
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        String numbers = scanner.nextLine();
        String[] numberArr = numbers.split(",");
        for (int i = 0; i < numberArr.length; i++) {
            int number = Integer.parseInt(numberArr[i]);
            if (map.containsKey(number)) {
                ArrayList<Integer> newArrayList = map.get(number);
                newArrayList.add(number);
                map.put(number, newArrayList);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(number);
                map.put(number, arrayList);
            }
        }
        map.forEach(new BiConsumer<Integer, ArrayList<Integer>>() {
            @Override
            public void accept(Integer integer, ArrayList<Integer> arrayList) {
                System.out.println(integer + "--" + Arrays.toString(arrayList.toArray()));
            }
        });
    }
}
