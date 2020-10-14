package Day07.Code;

import java.util.ArrayList;
import java.util.Iterator;

public class EnhancedForClassDemo {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("啦啦", 0));
        arrayList.add(new Student("嘟嘟", 0));
        arrayList.add(new Student("滴滴", 0));

        for (Student student : arrayList) {
            System.out.println(student);
        }

        Iterator<Student> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
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
}
