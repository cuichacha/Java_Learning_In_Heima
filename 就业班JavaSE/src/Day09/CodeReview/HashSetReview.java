package Day09.CodeReview;

import java.util.HashSet;
import java.util.Objects;

public class HashSetReview {
    public static void main(String[] args) {
        HashSet<Student> hashSet = new HashSet<>();
        Student student1 = new Student("1", 1);
        Student student2 = new Student("1", 1);
        Student student3 = new Student("3", 3);
        Student student4 = new Student("4", 4);

        System.out.println(addElement(hashSet, student1, student2, student3, student4));
    }

    private static <T> HashSet<T> addElement(HashSet<T> hashSet, T t1, T t2, T t3, T t4) {
        hashSet.add(t1);
        hashSet.add(t2);
        hashSet.add(t3);
        hashSet.add(t4);
        return hashSet;
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
