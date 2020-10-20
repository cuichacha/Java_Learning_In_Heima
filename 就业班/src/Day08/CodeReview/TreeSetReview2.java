package Day08.CodeReview;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetReview2 {
    public static void main(String[] args) {
        Set<Student2> set = new TreeSet<>();

        System.out.println(addElement(set, new Student2("1", 1), new Student2("2", 2), new Student2("3", 3)));

    }

    private static <T> Set<T> addElement(Set<T> set, T t1, T t2, T t3) {
        set.add(t1);
        set.add(t2);
        set.add(t3);
        return set;
    }
}

class Student2 implements Comparable<Student2> {
    private String name;
    private int age;

    public Student2() {
    }

    public Student2(String name, int age) {
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
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student2 o) {
        int result = this.getAge() - o.getAge();
        result = result == 0 ? this.getName().compareTo(o.getName()) : result;
        return result;
    }
}
