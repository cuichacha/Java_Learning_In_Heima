package UI;

import Config.GameConfig;
import com.hzheima.game.GameJPanel;
import com.hzheima.util.ImageUtil;


import java.awt.*;
import java.awt.image.BufferedImage;

public class FighterFightPanel extends GameJPanel {
    // 创建背景图片对象
    private final BufferedImage backgroundImage = ImageUtil.getImg("BG.png");

    public FighterFightPanel() {
    }

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
}
