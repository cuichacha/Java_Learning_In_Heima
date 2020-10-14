package Day07.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Reinforcement4_1 {
    public static void main(String[] args) {
        Person person1 = new Person("1", 1, 160.0);
        Person person2 = new Person("2", 2, 165.0);
        Person person3 = new Person("3", 3, 170.0);
        Person person4 = new Person("4", 4, 175.0);

        List<Person> list = new ArrayList<>();

        addElement(list, person1, person2, person3, person4);

        double maxHeight = 0;
        double minHeight = 1000;
        int maxHeightIndex = -1;
        int minHeightIndex = -1;

        ListIterator<Person> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            Person person = listIterator.next();
            double height = person.getHeight();
            if (height >= maxHeight) {
                maxHeight = height;
                maxHeightIndex = list.indexOf(person);
            }
        }

        while (listIterator.hasPrevious()) {
            Person person = listIterator.previous();
            double height = person.getHeight();
            if (height <= minHeight) {
                minHeight = height;
                minHeightIndex = list.indexOf(person);
            }
        }

        System.out.println("最高的人是" + list.get(maxHeightIndex).getName() + "，身高" + list.get(maxHeightIndex).getHeight());
        System.out.println("最矮的人是" + list.get(minHeightIndex).getName() + "，身高" + list.get(minHeightIndex).getHeight());
    }

    private static <T> List<T> addElement(List<T> list, T t1, T t2, T t3, T t4) {
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        return list;
    }
}

