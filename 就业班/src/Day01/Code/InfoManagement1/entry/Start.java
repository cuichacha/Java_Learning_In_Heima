package Day01.Code.InfoManagement1.entry;

import Day01.Code.InfoManagement1.controller.StudentController;
import Day01.Code.InfoManagement1.controller.TeacherController;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();

        while (true) {
            System.out.println("--------欢迎来到黑马信息管理系统--------");
            System.out.println("请输入您的选择: 1.学生管理  2.老师管理  3.退出");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    studentController.start();
                    break;
                case "2":
                    teacherController.start();
                    break;
                case "3":
                    System.out.println("感谢您的使用");
                    System.exit(0);
                default:
                    System.out.println("您的输入有误，请重新输入");
            }
        }
    }
}
