package Day07.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Reinforcement3_1 {
    public static void main(String[] args) {
        ArrayList<Students> arrayList = new ArrayList<>();
        Students students1 = new Students("1", 1, "1");
        Students students2 = new Students("2", 2, "0");
        Students students3 = new Students("3", 3, "1");
        Students students4 = new Students("4", 4, "4");
        addElement(arrayList, students1, students2, students3, students4);
        int maxAge = -1;
        int index = -1;

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getAge() >= maxAge) {
                maxAge = arrayList.get(i).getAge();
                index = i;
            }
        }
        arrayList.get(index).setName("小猪佩奇");
        System.out.println(Arrays.toString(arrayList.toArray(arrayList.toArray(new Students[arrayList.size()]))));

        for (Students students : arrayList) {
            if (students.getAge() >= maxAge) {
                maxAge = students.getAge();
                index = arrayList.indexOf(students);
            }
        }

        arrayList.get(index).setName("111");
        System.out.println(Arrays.toString(arrayList.toArray(arrayList.toArray(new Students[arrayList.size()]))));

    }

    private static <T> ArrayList<T> addElement(ArrayList<T> arrayList, T t1, T t2, T t3, T t4) {
        arrayList.add(t1);
        arrayList.add(t2);
        arrayList.add(t3);
        arrayList.add(t4);
        return arrayList;
    }
}

