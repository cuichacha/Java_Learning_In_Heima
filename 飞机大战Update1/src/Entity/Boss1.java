package Entity;

import AppConfig.AppConfig;
import com.hzheima.util.ImageUtil;

import java.awt.*;

public class Boss1 extends Gold {
    public Boss1() {
        img = ImageUtil.getImg("Boss1.png");
        //设置宽高
        width = img.getWidth() / 3;
        height = img.getHeight() / 3;

        startLoc = random.nextInt(2);
        if (startLoc == AppConfig.LEFT) {
            //随机生成在左边
            x = -width;
            xSpeed = 10;
        } else if (startLoc == AppConfig.RIGHT) {
            //随机生成在右边
            x = AppConfig.APP_WIDTH;
            xSpeed = -10;
        }
        y = -height;
        ySpeed = 10;
    }

    @Override
    public void move() {
        x += xSpeed;
        y += ySpeed;
        //判断是否碰撞到墙壁
        if (xSpeed < 0 && x <= 0) {
            //撞左墙
            xSpeed = -xSpeed;
        } else
        if (xSpeed > 0 && x >= AppConfig.APP_WIDTH - width) {
            //撞右墙
            xSpeed = -xSpeed;
        } else if (ySpeed < 0 && y <= 0) {
            //撞上墙
            ySpeed = -ySpeed;
        } else if (ySpeed > 0 && y >= AppConfig.APP_HEIGHT - 40 - height) {
            //撞下墙
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    //切换成炸毁的图片
    public void changeImg() {
        img = ImageUtil.getImg("boom.png");
    }
}
