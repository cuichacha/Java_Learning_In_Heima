package Day08.Code;

import java.util.Comparator;
import java.util.TreeSet;

public class SetDemo3 {
    public static void main(String[] args) {
        TreeSet<Teacher> treeSet = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                int result = o1.getAge() - o2.getAge();
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });

        Teacher teacher1 = new Teacher("zhangsan", 23);
        Teacher teacher2 = new Teacher("lisi", 27);
        Teacher teacher3 = new Teacher("wangwu", 21);
        Teacher teacher4 = new Teacher("zhaoliu", 23);

        treeSet.add(teacher1);
        treeSet.add(teacher2);
        treeSet.add(teacher3);
        treeSet.add(teacher4);

        System.out.println(treeSet);
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
