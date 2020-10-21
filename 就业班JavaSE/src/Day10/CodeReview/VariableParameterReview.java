package Day10.CodeReview;

import java.util.*;

public class VariableParameterReview {
    public static void main(String[] args) {

        // 可变参数必须放在参数列表里的最后一个
        System.out.println(getSum(1, 2, 3));
        System.out.println(getSum(1, 2, 3, 4, 5));

        // 使用静态方法，创建的List，Set，Map集合是不可变的，底层创建的是ImmutableCollection类对象
        // 但是把静态方法创建的集合，作为参数，传递给集合子类的有参构造中，创建的集合就是可变的，相当于静态初始化

        List<Integer> list1 = List.of(1,2,3,4,5);
        List<Integer> list2 = new ArrayList(List.of(1,2,3));
        System.out.println(list1);
        System.out.println(list2);

        Set<Integer> set1 = Set.of(1,2,3,4,5);
        Set<Integer> set2 = new HashSet<>(Set.of(1,2,3));
        System.out.println(set1);
        System.out.println(set2);

        Map<String, Integer> map1 = Map.of("1", 1, "2", 2, "3", 3);
        Map<String, Integer> map2 = new HashMap<>(Map.of("1", 1, "2", 2));
        System.out.println(map1);
        System.out.println(map2);

        Map<String, Integer> map3 = Map.ofEntries(Map.entry("1", 1), Map.entry("2" , 2), Map.entry("3", 3));
        Map<String, Integer> map4 = new HashMap<>(Map.ofEntries(Map.entry("1", 1), Map.entry("2" , 2)));
        System.out.println(map3);
        System.out.println(map4);
    }

    private static int getSum(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
