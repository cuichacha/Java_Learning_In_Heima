package Day08.Code;

import java.util.TreeSet;

public class SetDemo2 {
    public static void main(String[] args) {
//        Student student1 = new Student("1", 11);
//        Student student2 = new Student("2", 22);
//        Student student3 = new Student("3", 33);

        Student student1 = new Student("zhangsan", 11);
        Student student2 = new Student("lisi", 22);
        Student student3 = new Student("wangwu", 33);
        Student student4 = new Student("zhaoliu", 33);

        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(student3);
        treeSet.add(student2);
        treeSet.add(student1);
        treeSet.add(student4);

        System.out.println(treeSet);
    }
}

class Student implements Comparable<Student> {
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
    public int compareTo(Student o) {
        int result = this.age - o.age;
        result = result == 0 ? this.name.compareTo(o.name) : result;
        return result;
    }
}
