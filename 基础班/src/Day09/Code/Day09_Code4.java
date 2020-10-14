package Day09.Code;

import Day09.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public final class Day09_Code4 {
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Day09_Code4 day09_code4 = new Day09_Code4();
        ArrayList<Student> studentArrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            studentArrayList.add(day09_code4.getStudent());
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(studentArrayList.get(i).getName() + "......" + studentArrayList.get(i).getAge());
        }
    }

    private Student getStudent() {
        System.out.println("请输入学生姓名");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄");
        String age = scanner.nextLine();

        Student student = new Student(name, null, age, null);
        return student;
    }
}
