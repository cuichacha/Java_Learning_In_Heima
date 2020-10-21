package Day05.Code;

import java.util.Objects;

public class ObjectDemo {
    public static void main(String[] args) {
        Student student1 = new Student("啦啦", 0);
        System.out.println(student1);
        Student student2 = new Student("啦啦", 0);
        System.out.println(student1.equals(student2));
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

