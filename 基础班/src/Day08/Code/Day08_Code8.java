package Day08.Code;

import Day08.domain.Student;

import java.util.Scanner;

public final class Day08_Code8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学生信息");

        String studentInfo = scanner.nextLine();
        String[] splitedStudentInfo = studentInfo.split("，");

        Student student = new Student(splitedStudentInfo[0], splitedStudentInfo[1]);
        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}
