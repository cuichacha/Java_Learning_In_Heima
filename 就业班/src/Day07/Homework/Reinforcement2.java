package Day07.Homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Reinforcement2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println(listTest1(arrayList, 3));
        System.out.println(listTest2(arrayList, 3));
        System.out.println(listTest3(arrayList, 3));
        System.out.println(listTest4(arrayList, 3));
        System.out.println(listTest5(arrayList, 3));

        Reinforcement2 reinforcement2 = new Reinforcement2();
        System.out.println(reinforcement2.listTest6(arrayList, 3));
        System.out.println(reinforcement2.index);

    }

    private static int listTest1(ArrayList<Integer> arrayList, Integer findInteger) {
        for (Integer integer : arrayList) {
            if (findInteger.equals(integer)) {
                return arrayList.indexOf(integer);
            }
        }
        return -1;
    }

    private static int listTest2(ArrayList<Integer> arrayList, Integer findInteger) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (findInteger.equals(arrayList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private static int listTest3(ArrayList<Integer> arrayList, Integer findInteger) {
//        int index = -1;
        final int[] index = {-1};
        arrayList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                if (findInteger.equals(integer)) {
                    index[0] = arrayList.indexOf(integer);
                }
            }
        });
        return index[0];
    }

    private static int listTest4(ArrayList<Integer> arrayList, Integer findInteger) {
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (findInteger.equals(integer)) {
                return arrayList.indexOf(integer);
            }
        }
        return -1;
    }

    private static int listTest5(ArrayList<Integer> arrayList, Integer findInteger) {
        ListIterator<Integer> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            Integer integer = listIterator.next();
            if (findInteger.equals(integer)) {
                return arrayList.indexOf(integer);
            }
        }
        return -1;
    }

    int index = -1;
    public int listTest6(ArrayList<Integer> arrayList, Integer findInteger) {
//        final int[] index = {-1};
//        final int index = -1;
            arrayList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                if (findInteger.equals(integer)) {
                    index = arrayList.indexOf(integer);
                }
            }
        });
        return index;
    }

}