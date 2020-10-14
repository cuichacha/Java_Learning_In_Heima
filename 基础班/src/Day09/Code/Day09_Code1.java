package Day09.Code;

import Day09.domain.Student;

public final class Day09_Code1 {
    public static void main(String[] args) {
        Student[] studentList = new Student[3];

        Student stu1 = new Student("张三", "001", "23", "1999-1-1");
        Student stu2 = new Student("李四", "002", "24", "2000-1-1");
        Student stu3 = new Student("王五", "003", "25", "2001-1-1");
        
        studentList[0] = stu1;
        studentList[1] = stu2;
        studentList[2] = stu3;

        for (int i = 0; i < studentList.length; i++) {
            System.out.println(studentList[i].getName() + "......" + studentList[i].getAge());
        }
    }
}
