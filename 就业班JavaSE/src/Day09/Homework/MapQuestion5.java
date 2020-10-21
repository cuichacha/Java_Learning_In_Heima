package Day09.Homework;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class MapQuestion5 {
    public static void main(String[] args) {
        HashMap<String, Student> studentsInClass = new HashMap<>();
        HashMap<String, HashMap<String, Student>> classes = new HashMap<>();

        Student student1 = new Student("001", "1", 10);
        Student student2 = new Student("002", "2", 20);
        Student student3 = new Student("003", "3", 30);
        Student student4 = new Student("001", "4", 80);

        addElement(studentsInClass, student1.getId(), student1, student2.getId(), student2, student3.getId(), student3, student4.getId(), student4);
        classes.put("1班", studentsInClass);

        classes.forEach(new BiConsumer<String, HashMap<String, Student>>() {
            @Override
            public void accept(String s, HashMap<String, Student> stringStudentHashMap) {
                stringStudentHashMap.forEach(new BiConsumer<String, Student>() {
                    @Override
                    public void accept(String s, Student student) {
                        System.out.println(student);
                    }
                });
            }
        });
    }

    private static <K, V> HashMap<K, V> addElement(HashMap<K, V> hashMap, K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        hashMap.put(k1, v1);
        hashMap.put(k2, v2);
        hashMap.put(k3, v3);
        hashMap.put(k4, v4);
        return hashMap;
    }
}

class Student {
    private String id;
    private String name;
    private double grades;

    public Student() {
    }

    public Student(String id, String name, double grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
