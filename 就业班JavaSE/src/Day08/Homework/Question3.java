package Day08.Homework;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Question3 {
    public static void main(String[] args) {

        Student student1 = new Student("1", 1);
        Student student2 = new Student("2", 2);
        Class class1 = new Class();
        HashSet<Student> studentHashSet1 = class1.getStudentSet();
        studentHashSet1.add(student1);
        studentHashSet1.add(student2);
//        class1.setStudentSet(studentHashSet1);

        Student student3 = new Student("3", 3);
        Student student4 = new Student("4", 4);
        Class class2 = new Class();
        Set<Student> studentHashSet2 = class2.getStudentSet();
        studentHashSet2.add(student3);
        studentHashSet2.add(student4);

        Set<Class> classHashSet = new HashSet<>();
        classHashSet.add(class1);
        classHashSet.add(class2);

        for (Class aClass : classHashSet) {
            for (Student student : aClass.getStudentSet()) {
                System.out.println(student.getName() + "--" + student.getAge());
            }
        }
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

class Class {
    private HashSet<Student> studentSet;

    public Class() {
        studentSet = new HashSet<>();
    }

    public Class(HashSet<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public HashSet<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(HashSet<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
