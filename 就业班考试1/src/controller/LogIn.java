package controller;

import domain.Subway;
import service.ManagerService;
import service.SubwayService;

import java.util.Scanner;

public class LogIn {
    ManagerService managerService = new ManagerService();
    SubwayService subwayService = new SubwayService();

    private void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入管理人员工号");
        String id = scanner.nextLine();
        System.out.println("请输入管理人员姓名");
        String name = scanner.nextLine();
        if (managerService.invokeFindManager(id, name)) {
            System.out.println("登陆成功！");

            lp:
            while (true) {
                System.out.println("请输入选项");
                System.out.println("1.查看地铁站");
                System.out.println("2.添加地铁站");
                System.out.println("0.退出");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        if (subwayService.invokeIsEmpty()) {
                            System.out.println("没有地铁站信息");
                        } else {
                            subwayService.invokePrintSubways();
                        }
                        break;
                    case "2":
                        System.out.println("请输入地铁站编号");
                        String number = scanner.nextLine();
                        System.out.println("请输入地铁站名称");
                        String subwayName = scanner.nextLine();
                        System.out.println("请输入所属路线");
                        String line = scanner.nextLine();
                        Subway subway = new Subway(number, subwayName, line);
                        if (subwayService.invokeAddSubway(subway)) {
                            System.out.println("添加成功");
                        } else {
                            System.out.println("该地铁已存在，请重新输入");
                        }
                        break;
                    case "0":
                        break lp;
                    default:
                        System.out.println("选项有误！！");
                }
            }
        } else {
            System.out.println("工号或姓名错误，登陆失败！");
        }
    }

    public void invokeLogIn() {
        logIn();
    }

}
