package Entity;

import AppConfig.AppConfig;
import com.hzheima.util.ImageUtil;

import java.awt.*;
import java.util.Random;

public class Gold extends Ball {
    public Gold() {
        Random random = new Random();
        img = ImageUtil.getImg("gold.png");
        //设置宽高
        width = img.getWidth();
        height = img.getHeight();
        //随机位置
        startLoc = random.nextInt(4);
        //设置x,

        if (startLoc == AppConfig.LEFT) {
            //随机生成在左边
            x = -width;
            y = random.nextInt(100);
            //设置速度
            xSpeed = random.nextInt(10) + 5;
            ySpeed = random.nextInt(10) + 5;
        } else if (startLoc == AppConfig.RIGHT) {
            //随机生成在右边
            x = AppConfig.APP_WIDTH;
            y = random.nextInt(300) + 300;
            //设置速度
            xSpeed = -random.nextInt(10) + 5;
            ySpeed = -random.nextInt(10) + 5;
        } else if (startLoc == AppConfig.UP) {
            //随机生成在上边
            x = random.nextInt(500) + 500;
            y = -height;
            //设置速度
            xSpeed = -random.nextInt(10) + 5;
            ySpeed = random.nextInt(10) + 5;
        } else if (startLoc == AppConfig.DOWN) {
            //随机生成在下边
            x = random.nextInt(100);
            y = AppConfig.APP_HEIGHT;
            //设置速度
            xSpeed = random.nextInt(10) + 5;
            ySpeed = -random.nextInt(10) + 5;
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

    @Override
    public void move() {
//        x += xSpeed;
        //判断是否能够向下移动
//        if (startLoc == AppConfig.LEFT) {
//            //初始位置是左边
//            x += xSpeed;
//            y += ySpeed;
//        } else if (startLoc == AppConfig.RIGHT) {
//            //初始位置是右边
//            x -= xSpeed;
//            y -= ySpeed;
//        } else if (startLoc == AppConfig.UP) {
//            //初始位置是上边
//            x -= xSpeed;
//            y += ySpeed;
//        } else if (startLoc == AppConfig.DOWN) {
//            //初始位置是下边
//            x += xSpeed;
//            y -= ySpeed;
//        }

        x += xSpeed;
        y += ySpeed;

//        if (startDown) {
//            y += ySpeed;
//
//        }

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
}
