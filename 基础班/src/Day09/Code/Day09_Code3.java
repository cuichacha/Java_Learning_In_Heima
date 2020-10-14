package Day09.Code;

import Day09.domain.Student;

import java.util.ArrayList;

public final class Day09_Code3 {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();

        Student stu1 = new Student("张三", "001", "23", "1999-1-1");
        Student stu2 = new Student("李四", "002", "24", "2000-1-1");
        Student stu3 = new Student("王五", "003", "25", "2001-1-1");

        studentArrayList.add(stu1);
        studentArrayList.add(stu2);
        studentArrayList.add(stu3);

        for (int i = 0; i < studentArrayList.size(); i++) {
            System.out.println(studentArrayList.get(i).getName() + "......" + studentArrayList.get(i).getAge());
        }
    }
}
