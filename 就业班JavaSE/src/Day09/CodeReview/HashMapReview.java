package Day09.CodeReview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

public class HashMapReview {
    public static void main(String[] args) {
        HashMap<Teacher, String> hashMap = new HashMap<>();
        Teacher teacher1 = new Teacher("1", 1);
        Teacher teacher2 = new Teacher("2", 2);
        Teacher teacher3 = new Teacher("3", 3);
        addElement(hashMap, teacher1, "1", teacher2, "2", teacher3, "3");

        Set<Teacher> teacherSet = hashMap.keySet();
        for (Teacher teacher : teacherSet) {
            System.out.println(teacher + "--" + hashMap.get(teacher));
        }

        System.out.println("---------------------------------------");

        Set<Map.Entry<Teacher, String>> entries = hashMap.entrySet();
        for (Map.Entry<Teacher, String> entry : entries) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }

        System.out.println("---------------------------------------");

        hashMap.forEach(new BiConsumer<Teacher, String>() {
            @Override
            public void accept(Teacher teacher, String s) {
                System.out.println(teacher + "--" + s);
            }
        });

    }

    private static <K, V> HashMap<K, V> addElement(HashMap<K, V> hashMap, K k1, V v1, K k2, V v2, K k3, V v3) {
        hashMap.put(k1, v1);
        hashMap.put(k2, v2);
        hashMap.put(k3, v3);
        return hashMap;
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
