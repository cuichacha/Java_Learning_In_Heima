package Day06.Code;

import java.util.Scanner;

public class TryCatchExceptionPractice {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        student.setName(scanner.nextLine());
        while (true) {
            try {
                System.out.println("请输入年龄");
                student.setAge(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("请输入一个整数");
                e.printStackTrace();
            } catch (AgeOutOfBoundsException e) {
                System.out.println("请输入范围内年龄");
                e.printStackTrace();
            }
        }
        System.out.println(student.toString());
        Student newStudent = new Student("lalala", 60);
        System.out.println(newStudent.toString());
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        judgeAge(age);
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
        judgeAge(age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private void judgeAge(int age) {
        if (age >= 18 && age <= 25) {
            this.age = age;
        } else {
            throw new AgeOutOfBoundsException("年龄超出范围");
        }
    }
}

class AgeOutOfBoundsException extends RuntimeException{
    public AgeOutOfBoundsException() {
    }

    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}
