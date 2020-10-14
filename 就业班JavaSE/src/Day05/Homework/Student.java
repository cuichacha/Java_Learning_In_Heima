package Day05.Homework;

import java.util.Objects;

public class Student {
    private String name;
    private String gender;
    private int age;

    public Student() {
    }

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age);
    }
}

class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student("啦啦啦", "男", 0);
        Student student2 = new Student();
        student2.setName("啦啦啦");
        student2.setGender("男");
        student2.setAge(0);

        System.out.println(student1.equals(student2));
    }
}