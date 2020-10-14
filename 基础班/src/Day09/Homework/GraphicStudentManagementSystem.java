package Day09.Homework;

import Day09.domain.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public final class GraphicStudentManagementSystem {
    private final JFrame jFrame = new JFrame("------学生管理系统------");
    private final JPanel cards = new JPanel(new CardLayout());
    private final CardLayout cardsLayout = (CardLayout) (cards.getLayout());
    private final JPanel welcomePanel = new JPanel();
    private final JPanel mainPanel = new JPanel();
    private final JPanel editPanel = new JPanel();
    private final JPanel showPanel = new JPanel();
    private JTextField jTextField1 = new JTextField(15);
    private JTextField jTextField2 = new JTextField(15);
    private String input;
    ArrayList<JLabel> jLabelArrayList = new ArrayList<>();
    private int count = -1;

    ArrayList<Student> studentArrayList = new ArrayList<>();

    public void start() {
        welcomeInterface();
    }

    // 开始界面，继续按钮进入主界面，退出按钮退出程序
    private void welcomeInterface() {
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("<html>欢迎来到学生管理系统！<br>点击【继续】进入系统。<br>点击【退出】退出系统。</html>");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(500, 500);
        Font bigFont = new Font("serif", Font.BOLD, 20);
        welcomeLabel.setFont(bigFont);
        welcomeLabel.setBounds(150, 100, 300, 100);
        welcomePanel.setLayout(null);
        welcomePanel.add(welcomeLabel);
//        jFrame.add(welcomePanel);
        JButton button1 = new JButton("继续");
        JButton button2 = new JButton("退出");
        button1.setBounds(150, 300, 100, 50);
        button2.setBounds(250, 300, 100, 50);
//        button1.setBackground(Color.BLACK);
        welcomePanel.add(button1);
        welcomePanel.add(button2);
        button1.addActionListener(new mainInterfaceListener());
        button2.addActionListener(new exitListener());
        cards.add(welcomePanel, "welcomePanel");
        cardsLayout.show(cards, "welcomePanel");
        jFrame.add(cards);
    }

    // 主界面，显示选项，以及文本框录入用户输入的选项
    private void mainInterface() {
        JLabel mainLabel = new JLabel();
        mainLabel.setText("<html>请输入您的选择<br>1-添加学生" +
                "<br>2-删除学生" +
                "<br>3-修改学生" +
                "<br>4-查看所有学生" +
                "<br>5-退出系统</html>");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(500, 500);
        Font regularFont = new Font("serif", Font.PLAIN, 14);
        mainLabel.setFont(regularFont);
        mainPanel.setLayout(null);
        mainPanel.add(mainLabel);

        mainLabel.setBounds(150, 100, 300, 100);
        jTextField1.setBounds(150, 200, 100, 50);
        JButton button = new JButton("确定");
        button.setBounds(150, 250, 100, 50);
        button.addActionListener(new confirmOptionListener());

        mainPanel.add(jTextField1);
        mainPanel.add(button);
        cards.add(mainPanel, "mainPanel");
        cardsLayout.show(cards, "mainPanel");
        jFrame.add(cards);
    }

    // 检查输入的学生ID是否已存在
    private boolean checkId(String inputId) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            String oldId = studentArrayList.get(i).getId();
            if (inputId.equals(oldId)) {
                JOptionPane.showConfirmDialog(null, "您输入的学号已存在", "重复提示", JOptionPane.YES_NO_OPTION);
                return true;
            }
        }
        return false;
    }

    // 添加学生
    private void addStudent() {
//        JOptionPane name = new JOptionPane();
        String name = JOptionPane.showInputDialog("请输入学生姓名：");
        String id;
        while (true) {
            id = JOptionPane.showInputDialog("请输入学生学号：");
            if (!checkId(id)) {
                break;
            }
        }
        String age = JOptionPane.showInputDialog("请输入学生年龄：");
        String birthday = JOptionPane.showInputDialog("请输入学生生日：");
        Student newStudent = new Student(name, id, age, birthday);
        studentArrayList.add(newStudent);
    }

    // 删除功能实现失败，删除后无法显示正确数据
    private void removeStudent() {
        if (studentArrayList.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "无学生信息，请先录入！", "操作提示", JOptionPane.YES_NO_OPTION);
        } else {
            String inputId = JOptionPane.showInputDialog("请输入需要删除的学生的学号：");
            for (int i = 0; i < studentArrayList.size(); i++) {
                String oldId = studentArrayList.get(i).getId();
                if (oldId.equals(inputId)) {
                    studentArrayList.remove(i);
                    JOptionPane.showConfirmDialog(null, "删除成功！", "操作提示", JOptionPane.YES_NO_OPTION);
                    showPanel.remove(i * 4 + 0);
                    showPanel.remove(i * 4 + 1);
                    showPanel.remove(i * 4 + 2);
                    showPanel.remove(i * 4 + 3);
                    break;
                } else if (i == studentArrayList.size() - 1) {
                    JOptionPane.showConfirmDialog(null, "您要删除的学生不存在！", "操作提示", JOptionPane.YES_NO_OPTION);
                }
            }
        }
    }

    // 修改学生数据
    private void editInterface() {
        JLabel editLabel = new JLabel();
        editLabel.setText("<html>请输入您的选择<br>1-修改姓名" +
                "<br>2-修改学号" +
                "<br>3-修改年龄" +
                "<br>4-修改生日</html>");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(500, 500);
        Font regularFont = new Font("serif", Font.PLAIN, 14);
        editLabel.setFont(regularFont);
        editPanel.setLayout(null);
        editPanel.add(editLabel);
        editLabel.setBounds(150, 100, 300, 100);
        jTextField2.setBounds(150, 200, 100, 50);
        JButton button1 = new JButton("确定");
        button1.setBounds(150, 250, 100, 50);
        button1.addActionListener(new editOptionListener());
        JButton button2 = new JButton("返回主菜单");
        button2.setBounds(150, 350, 100, 50);
        button2.addActionListener(new returnMainInterface());
        editPanel.add(jTextField2);
        editPanel.add(button1);
        editPanel.add(button2);
        cards.add(editPanel, "editPanel");
        cardsLayout.show(cards, "editPanel");
        jFrame.add(cards);
    }

    // 展示已录入的学生信息，无表头
    private void showStudent() {
        int location = -50;
        if (studentArrayList.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "无学生信息，请先录入！", "操作提示", JOptionPane.YES_NO_OPTION);
        } else {
//            System.out.println("姓名\t学号\t年龄\t生日");
            for (int i = 0; i < studentArrayList.size(); i++) {

                location += 50;
                String name = studentArrayList.get(i).getName();
                String id = studentArrayList.get(i).getId();
                String age = studentArrayList.get(i).getAge();
                String birthday = studentArrayList.get(i).getBirthday();
//                System.out.println(name + "\t" + id + "\t" + age + "\t" + birthday);

                JLabel jLabel1 = new JLabel(name);
                JLabel jLabel2 = new JLabel(id);
                JLabel jLabel3 = new JLabel(age);
                JLabel jLabel4 = new JLabel(birthday);

                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setVisible(true);
                jFrame.setSize(500, 500);
                Font regularFont = new Font("serif", Font.PLAIN, 14);
                jLabel1.setFont(regularFont);
                jLabel2.setFont(regularFont);
                jLabel3.setFont(regularFont);
                jLabel4.setFont(regularFont);
                showPanel.setLayout(null);
                showPanel.add(jLabel1);
                showPanel.add(jLabel2);
                showPanel.add(jLabel3);
                showPanel.add(jLabel4);

                jLabel1.setBounds(location, 100, 100, 50);
                jLabel2.setBounds(location, 150, 100, 50);
                jLabel3.setBounds(location, 200, 100, 50);
                jLabel4.setBounds(location, 250, 100, 50);

                jLabelArrayList.add(jLabel1);
                jLabelArrayList.add(jLabel2);
                jLabelArrayList.add(jLabel3);
                jLabelArrayList.add(jLabel4);

                JButton button2 = new JButton("返回主菜单");
                button2.setBounds(150, 400, 100, 50);
                button2.addActionListener(new returnMainInterface());

                showPanel.add(button2);
                cards.add(showPanel, "showPanel");
                cardsLayout.show(cards, "showPanel");
                jFrame.add(cards);
            }
        }
    }

    // 退出按钮功能实现
    class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.dispose();
        }
    }

    // 继续按钮功能实现
    class mainInterfaceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainInterface();
        }
    }

    // 用户选项输入功能实现
    class confirmOptionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            input = jTextField1.getText();
            switch (input) {
                case "1":
                    addStudent();
                    jTextField1.setText("");
                    break;
                case "2":
                    removeStudent();
                    jTextField1.setText("");
                    break;
                case "3":
                    editInterface();
                    jTextField1.setText("");
                    break;
                case "4":
                    showStudent();
                    jTextField1.setText("");
                    break;
                case "5":
                    jFrame.dispose();
                    break;
                default:
                    JOptionPane.showConfirmDialog(null, "您输入的选项不存在，请重新输入", "错误提示", JOptionPane.YES_NO_OPTION);
            }
        }
    }

    // 编辑学生信息界面功能实现
    class editOptionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputId = JOptionPane.showInputDialog("请输入需要修改的学生的学号：");
            lp:
            for (int i = 0; i < studentArrayList.size(); i++) {
                String oldId = studentArrayList.get(i).getId();
                if (inputId.equals(oldId)) {
                    input = jTextField2.getText();
                    switch (input) {
                        case "1":
                            String name = JOptionPane.showInputDialog("请输入修改后的学生姓名：");
                            studentArrayList.get(i).setName(name);
                            JOptionPane.showConfirmDialog(null, "修改成功！", "操作提示", JOptionPane.YES_NO_OPTION);
                            jTextField2.setText("");
//                            JLabel jLabel = jLabelArrayList.get(i * 4 + 1);
//                            jLabel.setText(name);
                            break lp;
                        case "2":
                            String newId;
                            while (true) {
                                newId = JOptionPane.showInputDialog("请输入修改后的学生学号：");
                                if (!checkId(newId)) {
                                    break;
                                }
                            }
                            studentArrayList.get(i).setId(newId);
                            JOptionPane.showConfirmDialog(null, "修改成功！", "操作提示", JOptionPane.YES_NO_OPTION);
                            jTextField2.setText("");
                            break lp;
                        case "3":
                            String age = JOptionPane.showInputDialog("请输入修改后的学生年龄：");
                            studentArrayList.get(i).setAge(age);
                            JOptionPane.showConfirmDialog(null, "修改成功！", "操作提示", JOptionPane.YES_NO_OPTION);
                            jTextField2.setText("");
                            break lp;
                        case "4":
                            String birthday = JOptionPane.showInputDialog("请输入修改后的学生生日：");
                            studentArrayList.get(i).setBirthday(birthday);
                            JOptionPane.showConfirmDialog(null, "修改成功！", "操作提示", JOptionPane.YES_NO_OPTION);
                            jTextField2.setText("");
                            break lp;
                        default:
                            JOptionPane.showConfirmDialog(null, "您输入的选项不存在，请重新输入", "错误提示", JOptionPane.YES_NO_OPTION);
                    }
                } else if (i == studentArrayList.size() - 1) {
                    JOptionPane.showConfirmDialog(null, "您要修改的学生不存在", "错误提示", JOptionPane.YES_NO_OPTION);
                }
            }
        }
    }

    // 返回主界面功能实现
    class returnMainInterface implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainInterface();
        }
    }
}