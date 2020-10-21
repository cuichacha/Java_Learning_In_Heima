package Day09.CodeReview;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMapReview {
    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.getAge() - o2.getAge();
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });
        Person person1 = new Person("1", 5);
        Person person2 = new Person("2", 2);
        Person person3 = new Person("3", 2);
        addElement(treeMap, person1, "1", person2, "2", person3, "3");

        treeMap.forEach(new BiConsumer<Person, String>() {
            @Override
            public void accept(Person person, String s) {
                System.out.println(person + "--" + s);
            }
        });
    }
    private static <K, V> TreeMap<K, V> addElement(TreeMap<K, V> treeMap, K k1, V v1, K k2, V v2, K k3, V v3) {
            treeMap.put(k1, v1);
            treeMap.put(k2, v2);
            treeMap.put(k3, v3);
            return treeMap;
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
