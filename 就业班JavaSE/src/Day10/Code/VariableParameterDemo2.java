package Day10.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VariableParameterDemo2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        System.out.println(list);
//        list.add(6);  源码中进行了方法重写，所有涉及修改的方法，直接抛异常，没其他的
//                      具体的实现类，是ImmutableCollections
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3));
        System.out.println(arrayList);
        arrayList.add(4);
        System.out.println(arrayList);


        Set<Integer> set = Set.of(1, 2, 3, 4, 5);

        Map<String, Integer> map = Map.of("1", 1, "2", 2);

    }

}
