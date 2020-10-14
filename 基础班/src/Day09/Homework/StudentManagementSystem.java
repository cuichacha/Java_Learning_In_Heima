package Day09.Homework;

import Day09.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public final class StudentManagementSystem {
    private final ArrayList<Student> studentList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    // 开始界面显示
    public final void start() {
        System.out.println("-----------欢迎来到学生管理系统-----------");

        lp:
        while (true) {
            System.out.println("1-添加学生");
            System.out.println("2-删除学生");
            System.out.println("3-修改学生");
            System.out.println("4-查看所有学生");
            System.out.println("5-退出");
            int input = loop();
            switch (input) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    showStudent();
                    break;
                case 5:
                    System.out.println("谢谢使用！再见。");
                    break lp;
                default:
                    System.out.println("您输入的选项不存在，请重新输入");
            }
        }
    }

    // 检查输入字符是否为整数
    private boolean checkNumber(String str) {
        // 如果第一个字符，是数字，或者负号，开始从第二个字符遍历字符串
        if (Character.hashCode(str.charAt(0)) == 45 || Character.isDigit(str.charAt(0))) {
            // 遍历输入的字符串，如果有一个字符不是数字，就返回false
            for (int i = 1; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                } else if (i == (str.length() - 1)) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    // 输入不符合要求的死循环
    private int loop() {
        int num;
        int count = 0;

        while (true) {
            // 提示用户输入数字
            System.out.println("请输入您的选择: ");
            // 键盘录入

            String str = scanner.nextLine();
            // 如果输入的数字符合要求，转成int
            if (checkNumber(str)) {
                num = Integer.parseInt(str);
                return num;
//                if (num >= 1 && num <= 12) {
//                    return num;
//                } else {
//                    System.out.println("请输入正确数字！！");
//                }

                // 如果输入的数字不符合要求，陷入输入无限循环
            } else {
                count++;
                if (count == 10) {
                    System.out.println("别输了，滚吧！");
                    return -1;
                }
                System.out.println("请输入正确数字！！");
            }
        }
    }

    // 检查输入的学号是否已存在
    private boolean checkId(String inputId) {
        for (int i = 0; i < studentList.size(); i++) {
            String oldId = studentList.get(i).getId();
            if (inputId.equals(oldId)) {
                System.out.println("学号已存在，请重新输入");
                return true;
            }
        }
        return false;
    }

    // 添加学生
    private void addStudent() {
        System.out.println("请输入学生姓名");
        String name = scanner.nextLine();
        String id;
        while (true) {
            System.out.println("请输入学生学号");
            id = scanner.nextLine();
            if (!checkId(id)) {
                break;
            }
        }
        System.out.println("请输入学生年龄");
        String age = scanner.nextLine();
        System.out.println("请输入学生生日");
        String birthday = scanner.nextLine();
        Student newStudent = new Student(name, id, age, birthday);
        studentList.add(newStudent);
    }

    //删除学生
    private void removeStudent() {
        if (studentList.isEmpty()) {
            System.out.println("无学生信息，请先录入");
        } else {
            System.out.println("请输入需要删除的学生的学号");
            String inputId = scanner.nextLine();
            for (int i = 0; i < studentList.size(); i++) {
                String oldId = studentList.get(i).getId();
                if (oldId.equals(inputId)) {
                    studentList.remove(i);
                    System.out.println("删除成功！");
                    break;
                } else if (i == studentList.size() - 1) {
                    System.out.println("您要删除的学生不存在");
                }
            }
        }
    }

    // 修改学生信息
    private void editStudent() {
        System.out.println("请输入需要修改信息的学生学号");
        String inputId = scanner.nextLine();
        lp:
        for (int i = 0; i < studentList.size(); i++) {
            String oldId = studentList.get(i).getId();
            if (oldId.equals(inputId)) {
                System.out.println("请输入需要修改的信息项");
                System.out.println("1-修改姓名");
                System.out.println("2-修改学号");
                System.out.println("3-修改年龄");
                System.out.println("4-修改生日");
                int edit = loop();
                switch (edit) {
                    case 1:
                        System.out.println("请输入修改后的姓名");
                        String name = scanner.nextLine();
                        studentList.get(i).setName(name);
                        System.out.println("修改成功！");
                        break lp;
                    case 2:
                        String newId;
                        while (true) {
                            System.out.println("请输入修改后的学号");
                            newId = scanner.nextLine();
                            if (!checkId(newId)) {
                                break;
                            }
                        }
                        studentList.get(i).setId(newId);
                        System.out.println("修改成功！");
                        break lp;
                    case 3:
                        System.out.println("请输入修改后的年龄");
                        String age = scanner.nextLine();
                        studentList.get(i).setAge(age);
                        System.out.println("修改成功！");
                        break lp;
                    case 4:
                        System.out.println("请输入修改后的生日");
                        String birthday = scanner.nextLine();
                        studentList.get(i).setName(birthday);
                        System.out.println("修改成功！");
                        break lp;
                    default:
                        System.out.println("您输入的选项不存在，请重新输入");
                }
            } else if (i == studentList.size() - 1) {
                System.out.println("您要修改的学生不存在");
            }
        }
    }

    // 显示已录入学生信息
    private void showStudent() {
        if (studentList.isEmpty()) {
            System.out.println("系统中无学生信息，请录入");
        } else {
            System.out.println("姓名\t学号\t年龄\t生日");
            for (int i = 0; i < studentList.size(); i++) {
                String name = studentList.get(i).getName();
                String id = studentList.get(i).getId();
                String age = studentList.get(i).getAge();
                String birthday = studentList.get(i).getBirthday();
                System.out.println(name + "\t" + id + "\t" + age + "\t" + birthday);
            }
        }
    }
}
