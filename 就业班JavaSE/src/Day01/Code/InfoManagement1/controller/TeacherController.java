package Day01.Code.InfoManagement1.controller;

import Day01.Code.InfoManagement1.domain.Teacher;
import Day01.Code.InfoManagement1.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private Scanner scanner = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();

    public void start() {
        lp:
        while (true) {
            System.out.println("--------欢迎来到 <老师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTeacher();
                    break;
                case "2":
                    deleteTeacher();
                    break;
                case "3":
                    editTeacher();
                    break;
                case "4":
                    showTeacher();
                    break;
                case "5":
                    System.out.println("感谢您的使用");
                    break lp;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    private void addTeacher() {
        String id;
        System.out.println("请输入工号");
        while (true) {
            id = scanner.nextLine();
            if (teacherService.isExisted(id) != -1) {
                System.out.println("您输入的工号已被占用，请重新输入");
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
        Teacher teacher = new Teacher(id, name, age, birthday);
        if (teacherService.invokeAddTeacher(teacher)) {
            System.out.println("添加成功");
        } else {
            System.out.println("数据库已满，无法添加");
        }
    }

    private void deleteTeacher() {
        System.out.println("请输入工号");
        String id = scanner.nextLine();
        if (teacherService.invokeDeleteTeacher(id)) {
            System.out.println("删除成功");
        } else {
            System.out.println("您要删除的老师不存在");
        }
    }

    private void editTeacher() {
        System.out.println("请输入工号");
        String id = scanner.nextLine();
        if (teacherService.isExisted(id) == -1) {
            System.out.println("您要修改的老师不存在");
        } else {
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
                    if (teacherService.editTeacher(id, "1", name)) {
                        System.out.println("修改成功");
                    }
                    break;
                case "2":
                    System.out.println("请输入修改后的姓名");
                    String age = scanner.nextLine();
                    if (teacherService.editTeacher(id, "2", age)) {
                        System.out.println("修改成功");
                    }
                    break;
                case "3":
                    System.out.println("请输入修改后的姓名");
                    String birthday = scanner.nextLine();
                    if (teacherService.editTeacher(id, "3", birthday)) {
                        System.out.println("修改成功");
                    }
                    break;
                case "4":
                    break;
            }
        }
    }

    private void showTeacher() {
        if (teacherService.invokeShowTeacher()) {
            System.out.println("未录入数据");
        }
    }

}
