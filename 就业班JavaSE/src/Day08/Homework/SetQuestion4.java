package Day08.Homework;

import java.util.LinkedHashSet;
import java.util.Objects;

public class SetQuestion4 {
    public static void main(String[] args) {
        LinkedHashSet<Teacher> linkedHashSet = new LinkedHashSet<>();
        Teacher teacher1 = new Teacher("1", 1);
        Teacher teacher2 = new Teacher("1", 1);
        Teacher teacher3 = new Teacher("3", 3);
        Teacher teacher4 = new Teacher("4", 4);
        linkedHashSet.add(teacher1);
        linkedHashSet.add(teacher2);
        linkedHashSet.add(teacher3);
        linkedHashSet.add(teacher4);
        System.out.println(linkedHashSet);
    }
}

class Teacher {
    private String name;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
