package Entity;

import AppConfig.AppConfig;
import com.hzheima.util.ImageUtil;

import java.util.ArrayList;

public class Boss2 extends Plane {
    int xSpeed1;
    int yspeed1;

    public Boss2() {
        img = ImageUtil.getImg("Boss1.png");
        //设置坐标
        x = 400;
        y = -height;
        //设置宽高
        width = img.getWidth() / 3;
        height = img.getHeight() / 3;
        //设置速度
        yspeed1 = 1;
        xSpeed1 = 1;
    }

    public void move() {
        x += xSpeed1;
        if (y <= 100) {
            y += yspeed1;
        }
        if (xSpeed1 < 0 && x <= 0) {
            //撞左墙
            xSpeed1 = -xSpeed1;
        } else
        if (xSpeed1 > 0 && x >= AppConfig.APP_WIDTH - width) {
            //撞右墙
            xSpeed1 = -xSpeed1;
        }

//        if (x <= 0 || speed < 0) {
//            speed = -speed;
//            x += speed;
//        } else if (x >= AppConfig.APP_WIDTH - width || speed > 0) {
//            speed = -speed;
//            x += speed;
//        }
    }

    ArrayList<BossBullet> bossBullets = new ArrayList<>();

    public ArrayList<BossBullet> getBossBullets() {
        return bossBullets;
    }

    @Override
    public void shoot() {
        count++;
        if (count % 10 == 0) {
            BossBullet bossBullet = new BossBullet(this.x, this.y);
            bossBullets.add(bossBullet);
            count = 0;
        }

        for (int i = bossBullets.size() - 1; i >= 0; i--) {
            BossBullet bossBullet = bossBullets.get(i);
            //让子弹移动
            bossBullet.move();

            //判断是否移出屏幕，如果移出了就从集合中删除
            if (bossBullet.getY() <= -bossBullet.getHeight()) {
                //说明移出屏幕了
                bossBullets.remove(i);
            }
        }
    }


    public boolean isCrash(Plane plane) {
        boolean r = collide(plane);

        return r;
    }

    //切换成炸毁的图片
    public void changeImg() {
        img = ImageUtil.getImg("boom.png");
    }

    public boolean shootBy(Bullet bullet) {
        boolean r = collide(bullet);

        return r;
    }
}
