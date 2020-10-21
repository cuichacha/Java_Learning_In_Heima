package Day01.Code.InfoManagement1.controller;

import Day01.Code.InfoManagement1.domain.Student;
import Day01.Code.InfoManagement1.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();

    Scanner scanner = new Scanner(System.in);

    public void start() {
        lp:
        while (true) {

            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    deleteStudent();
                    break;
                case "3":
                    editStudent();
                    break;
                case "4":
                    showStudent();
                    break;
                case "5":
                    System.out.println("感谢您的使用");
                    break lp;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }

    private void addStudent() {
        String id;
        while (true) {
            System.out.println("请输入学号");
            id = scanner.nextLine();
            if (studentService.isExisted(id) != -1) {
                System.out.println("学号已被占用，请重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入姓名");
        String name = scanner.nextLine();
        System.out.println("请输入年龄");
        String age = scanner.nextLine();
        System.out.println("请输入生日");
        String birthday = scanner.nextLine();
        Student student = new Student(id, name, age, birthday);
        studentService.addStudent(student);
    }

    private void deleteStudent() {
        System.out.println("请输入学号");
        String id = scanner.nextLine();
        if (studentService.isExisted(id) != -1) {
            studentService.deleteStudent(id);
        } else {
            System.out.println("您要删除的学生不存在");
        }
    }

    private void editStudent() {
        System.out.println("请输入学号");
        String id = scanner.nextLine();
        if (studentService.isExisted(id) != -1) {
            lp:
            while (true) {
                System.out.println("请输入需要修改的项目");
                System.out.println("1.修改姓名");
                System.out.println("2.修改年龄");
                System.out.println("3.修改生日");
                System.out.println("4.回到主菜单");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("请输入修改后的姓名");
                        String name = scanner.nextLine();
                        studentService.editStudent(id, choice, name);
                        break;
                    case "2":
                        System.out.println("请输入修改后的年龄");
                        String age = scanner.nextLine();
                        studentService.editStudent(id, choice, age);
                        break;
                    case "3":
                        System.out.println("请输入修改后的生日");
                        String birthday = scanner.nextLine();
                        studentService.editStudent(id, choice, birthday);
                        break;
                    case "4":
                        break lp;
                    default:
                        System.out.println("您的输入有误");
                }
            }
        } else {
            System.out.println("您要修改的学生不存在");
        }
    }

    private void showStudent() {
        if (studentService.invokeIsEmpty()) {
            System.out.println("未添加任何数据");
        } else {
            studentService.showStudent();
        }
    }
}
