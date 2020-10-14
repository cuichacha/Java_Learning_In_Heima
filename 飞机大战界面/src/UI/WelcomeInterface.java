package UI;

import Config.GameConfig;
import com.hzheima.game.GameJPanel;
import com.hzheima.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class WelcomeInterface extends GameJPanel {
    JButton button1 = new JButton("开始游戏");
    // 创建窗口子类对象
    FighterFightFrame fighterFightFrame = new FighterFightFrame();
    FighterFightAchievement fighterFightAchievement = new FighterFightAchievement();


    public void start() {
        button1.setBounds(200, 400, 100, 50);

        // 调用窗口创建方法
        fighterFightFrame.drawFrame();
        // 创建面板子类对象
        FighterFightPanel fighterFightPanel = new FighterFightPanel();
        WelcomeInterface welcomeInterface = new WelcomeInterface();
        fighterFightFrame.add(button1);
        button1.addActionListener(new mainInterfaceListener());
        fighterFightFrame.add(welcomeInterface);

        fighterFightFrame.setVisible(true);
    }

    // 创建背景图片对象
    private BufferedImage backgroundImage = ImageUtil.getImg("BG.png");


    @Override
    public void paint(Graphics g) {
        // 将背景图片画入面板
        g.drawImage(backgroundImage, 0, 0, GameConfig.GAME_WIDTH, GameConfig.GAME_HEIGHT, null);
        // 设置字体信息
        g.setFont(new Font("SongTi", Font.BOLD, 55));
        // 设置字体颜色
        g.setColor(Color.red);
        g.drawString("飞机大战", 150, 300);
    }

    class mainInterfaceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fighterFightFrame.add(fighterFightAchievement);
            fighterFightFrame.setVisible(true);
        }
    }
}
