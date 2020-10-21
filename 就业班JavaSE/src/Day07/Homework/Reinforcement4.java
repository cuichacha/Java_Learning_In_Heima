package Day07.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Reinforcement4 {
    public static void main(String[] args) {
        Person person1 = new Person("1", 1, 160.0);
        Person person2 = new Person("2", 2, 165.0);
        Person person3 = new Person("3", 3, 170.0);
        Person person4 = new Person("4", 4, 175.0);
        Person person5 = new Person("5", 5, 180.0);

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

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
}

class Person {
    private String name;
    private int age;
    private double height;

    public Person() {
    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}