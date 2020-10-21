package Day08.Homework;

import java.util.HashSet;

public class Question3_1 {
    public static void main(String[] args) {
        Student student1 = new Student("1", 1);
        Student student2 = new Student("2", 2);
        HashSet<Student> class1 = new HashSet<>();
        class1.add(student1);
        class1.add(student2);
        Student student3 = new Student("3", 3);
        Student student4 = new Student("4", 4);
        HashSet<Student> class2 = new HashSet<>();
        class1.add(student3);
        class1.add(student4);

        HashSet<HashSet<Student>> classHashSet1 = new HashSet<>();
        classHashSet1.add(class1);
        classHashSet1.add(class2);

        for (HashSet<Student> students : classHashSet1) {
            for (Student student : students) {
                System.out.println(student.getName() + "--" + student.getAge());
            }
        }
    }
}
