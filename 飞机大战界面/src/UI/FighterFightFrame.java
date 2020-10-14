package UI;

import com.hzheima.game.GameJFrame;

import java.awt.*;

public class FighterFightFrame extends GameJFrame {


    // 空参构造
    public FighterFightFrame() throws HeadlessException {
    }

    // 窗口创建方法
    public void drawFrame() {
        // 设置标题
        this.setTitle("飞机大战");
//        // 设置logo图标
//        this.setIconImage(ImageUtil.getImg("logo.png"));
        // 设置窗口大小
        this.setSize(512,768);
        // 设置窗口出现位置
        this.setLocation(400,0);

    }
}
