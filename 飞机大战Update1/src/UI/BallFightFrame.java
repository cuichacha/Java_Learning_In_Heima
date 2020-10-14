package UI;

import AppConfig.AppConfig;
import com.hzheima.game.GameJFrame;
import com.hzheima.util.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BallFightFrame extends GameJFrame {
    public BallFightFrame() throws HeadlessException {
        //设置标题
        setTitle("球球大作战");
        //设置图标
        BufferedImage logo = ImageUtil.getImg("logo.png");
        setIconImage(logo);
        //设置窗体大小
        setSize(AppConfig.APP_WIDTH,AppConfig.APP_HEIGHT);
        //设置初始位置
        setLocation(100,0);
    }
}
