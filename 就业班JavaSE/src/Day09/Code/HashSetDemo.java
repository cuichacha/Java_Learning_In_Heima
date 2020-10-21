package Day09.Code;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Teacher> hashSet = new HashSet<>();
        Teacher teacher1 = new Teacher("1", 1);
        Teacher teacher2 = new Teacher("2", 2);
        Teacher teacher3 = new Teacher("3", 2);
        Teacher teacher4 = new Teacher("1", 1);

        hashSet.add(teacher1);
        hashSet.add(teacher2);
        hashSet.add(teacher3);
        hashSet.add(teacher4);

        System.out.println(hashSet);
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
}
