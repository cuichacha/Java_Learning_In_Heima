package Day08.CodeReview;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetReview1 {
    public static void main(String[] args) {
        Set<Student1> set = new TreeSet<>(new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                int result = o1.getAge() - o2.getAge();
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });

        System.out.println(addElement(set, new Student1("1", 1), new Student1("2", 2), new Student1("3", 3)));
    }

    private static <T> Set<T> addElement(Set<T> set, T t1, T t2, T t3) {
        set.add(t1);
        set.add(t2);
        set.add(t3);
        return set;
    }
}

class Student1 {
    private String name;
    private int age;

    public Student1() {
    }

    public Student1(String name, int age) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
