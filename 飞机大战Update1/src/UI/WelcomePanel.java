package UI;

import com.hzheima.game.GameJPanel;
import com.hzheima.util.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WelcomePanel extends GameJPanel {
    BufferedImage img;
    //金币图标


//    Plane plane;

    public WelcomePanel() {
        //设置背景色为粉色
        setBackground(Color.PINK);

        //加载图片
        img = ImageUtil.getImg("BG1.png");


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img,0,0,1080,768,null);
        // 设置字体信息
        g.setFont(new Font("隶书", Font.BOLD, 80));
        // 设置字体颜色
        g.setColor(Color.red);
        // 画出文字
        g.drawString("飞\t机\t大\t战", 350, 250);
    }
}
