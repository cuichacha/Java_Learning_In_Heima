package UI;

import Util.MusicUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface {
    //创建游戏窗体
    BallFightFrame fightFrame1 = new BallFightFrame();
    BallFightFrame fightFrame2 = new BallFightFrame();
    BallFightPanel ballFightPanel = new BallFightPanel();
    DoublePlayerPanel doublePlayerPanel = new DoublePlayerPanel();


    Button button1 = new Button("单人游戏", 435, 300);
    Button button2 = new Button("双人游戏", 435, 400);
    Button button3 = new Button("制作人员", 435, 500);
    Button button4 = new Button("退出游戏", 435, 600);


    public void mainInterface() {
        //创建面板
        WelcomePanel welcomePanel = new WelcomePanel();


        fightFrame1.add(button1);
        fightFrame1.add(button2);
        fightFrame1.add(button3);
        fightFrame1.add(button4);
        button1.addActionListener(new SinglePlayerListener());
        button2.addActionListener(new DoublePlayerListener());
        button3.addActionListener(new StaffListener());
        button4.addActionListener(new ExitListener());
        //添加到窗体中
        fightFrame1.add(welcomePanel);
        //让窗体显示
        fightFrame1.setVisible(true);
        MusicUtil.loopPlayMusic("8553.wav");
    }

    class SinglePlayerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            //创建游戏窗体
//            BallFightFrame fightFrame = new BallFightFrame();
            //创建面板
//            BallFightPanel ballFightPanel = new BallFightPanel();
            fightFrame1.dispose();
            //添加到窗体中
            fightFrame2.add(ballFightPanel);
            //启动游戏
            ballFightPanel.action();
//            fightFrame2.add(ballFightPanel);
            fightFrame2.setVisible(true);

        }
    }
    class DoublePlayerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            //创建游戏窗体
//            BallFightFrame fightFrame = new BallFightFrame();
            //创建面板
//            BallFightPanel ballFightPanel = new BallFightPanel();
            fightFrame1.dispose();
            //添加到窗体中
            fightFrame2.add(doublePlayerPanel);
            //启动游戏
            doublePlayerPanel.action();
//            fightFrame2.add(ballFightPanel);
            fightFrame2.setVisible(true);

        }
    }

    // 退出按钮功能实现
    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // 制作人员按钮功能实现
    class StaffListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog(null, "韩孝\n单建威\n熊文忠\n崔华鑫\n倾情制作\n2020年9月5日于杭州", "制作人员", JOptionPane.YES_NO_OPTION);
        }
    }
}
